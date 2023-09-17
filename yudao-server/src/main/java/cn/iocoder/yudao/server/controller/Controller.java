package cn.iocoder.yudao.server.controller;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.server.dal.dataobject.*;
import cn.iocoder.yudao.server.dal.mysql.*;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.Update;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ObserveMapper observeMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private Col2019Mapper col2019Mapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private IdentMapper identMapper;
    @Autowired
    private NaturePhotoMapper naturePhotoMapper;
    @Autowired
    private ProjectTeamMemberMapper projectTeamMemberMapper;
    @Autowired
    private TeamMapper teamMapper;
    @Autowired
    private UserProfileMapper userProfileMapper;

    /**
     * cnc2020项目组织者需要的每日观测统计数据api
     *
     * @param params
     * @return {@link CommonResult}<>
     */

    @RequestMapping("cncstatis")
    public CommonResult<String> cncstatis(@RequestBody JSONObject params) {
        String s = "{" +
                "\"title\":" + "\"City Nature Challenge 2020: Nan Ning\"," +
                "\"observations\":" + observeMapper.GetObservationCount() + "," +
                "\"species\":" + observeMapper.GetSpeciesCount() + "," +
                "\"people\":" + observeMapper.GetPeopleCount() +
                "}";
        return CommonResult.success(s);
    }

    /**
     * getprojects
     *
     * @param params
     * @return {@link CommonResult}<>
     */

    @RequestMapping("getprojects")
    public CommonResult<List<ProjectDO>> getprojects(@RequestBody JSONObject params) {
        Integer offset = params.getInteger("offset");
        Integer pagesize = params.getInteger("pagesize");

        LambdaQueryWrapper<ProjectDO> lambdaQueryWrapper = new LambdaQueryWrapper<ProjectDO>()
                .orderBy(true, false, ProjectDO::getCreateTime);

        PageResult<ProjectDO> projectDOPageResult = projectMapper.selectPage(new PageParam(offset, pagesize), lambdaQueryWrapper);
        return CommonResult.success(projectDOPageResult.getList());
    }


    /**
     * userregister
     *
     * @param params
     * @return {@link CommonResult}<>
     */

    @RequestMapping("userregister")
    public CommonResult<String> userregister(@RequestBody JSONObject params) {
        String username = params.getString("username");
        String telephone = params.getString("telephone");
        String email = params.getString("email");
        if (ExistUserName(username)) {
            return CommonResult.error("用户名已存在");
        }
        if (ExistUserPhone(telephone)) {

            return CommonResult.error("手机号已存在");
        }
        String password = params.getString("password");
        String avatar = params.getString("avatar");
        String country = params.getString("country");
        String province = params.getString("province");
        String nickName = params.getString("nickName");
        String city = params.getString("city");
        String gender = params.getString("gender");

        String uid = IdUtil.fastUUID();
        String token = IdUtil.fastUUID();

        UserDO userDO = new UserDO();
        userDO.setUID(uid);
        userDO.setEditor(username);
        userDO.setUserName(username);
        userDO.setUPassword(password);
        userDO.setUSysRole(avatar);
        userDO.setUAvatar(avatar);
        userDO.setUPhone(telephone);
        userDO.setUEmail(email);
        userDO.setUSource("WeChat");
        userDO.setUType("NE");
        userDO.setLogonToken(token);

        userMapper.insert(userDO);
        FillUserProfile(uid, username, avatar, nickName, gender, country, province, city);

        return CommonResult.success(token);

    }


    /**
     * userlogin
     *
     * @param params
     * @return {@link CommonResult}<>
     */

    @RequestMapping("userlogin")
    public CommonResult<UserDO> userlogin(@RequestBody JSONObject params) {
        String username = params.getString("username");
        if (!ExistUserName(username)) {
            return CommonResult.error("用户名不存在");
        }
        LambdaQueryWrapper<UserDO> userDOLambdaQueryWrapper = new LambdaQueryWrapper<UserDO>()
                .select(UserDO::getUID, UserDO::getEditor, UserDO::getCreateTime, UserDO::getUpdateTime, UserDO::getUserName, UserDO::getUSysRole, UserDO::getUAvatar,
                        UserDO::getUPhone, UserDO::getUEmail, UserDO::getUSource, UserDO::getUType, UserDO::getLogonToken, UserDO::getAccountStatus)
                .eq(UserDO::getUserName, username)
                .eq(UserDO::getUPassword, params.getString("password"));

        UserDO userDO = userMapper.selectOne(userDOLambdaQueryWrapper);

        if (userDO == null) {
            return CommonResult.error("密码错误");
        }

        if (StringUtils.equals(userDO.getAccountStatus(), "Forbid")) {
            return CommonResult.error("此账号被禁用！");
        }

        return CommonResult.success(userDO);

    }


    /**
     * userlogin
     *
     * @param params
     * @return {@link CommonResult}<>
     */

    @RequestMapping("getuserinfo")
    public CommonResult<UserDO> getuserinfo(@RequestBody JSONObject params) {
        String toekn = params.getString("toekn");

        LambdaQueryWrapper<UserDO> userDOLambdaQueryWrapper = new LambdaQueryWrapper<UserDO>()
                .select(UserDO::getUID, UserDO::getEditor, UserDO::getCreateTime, UserDO::getUpdateTime, UserDO::getUserName, UserDO::getUSysRole, UserDO::getUAvatar,
                        UserDO::getUPhone, UserDO::getUEmail, UserDO::getUSource, UserDO::getUType, UserDO::getLogonToken, UserDO::getAccountStatus)
                .eq(UserDO::getLogonToken, toekn);
        UserDO userDO = userMapper.selectOne(userDOLambdaQueryWrapper);

        if (userDO == null) {
            return CommonResult.error("重新登陆");
        }

        if (StringUtils.equals(userDO.getAccountStatus(), "Forbid")) {
            return CommonResult.error("此账号被禁用！");
        }

        return CommonResult.success(userDO);

    }

    /**
     * 删除队伍
     *
     * @param params
     * @return {@link CommonResult}<>
     */

    @RequestMapping("delteam")
    public CommonResult<UserDO> delteam(@RequestBody JSONObject params) {

        String tid = params.getString("tid");
        teamMapper.deleteById(tid);
        return CommonResult.success();

    }

    /**
     * 删除队伍
     *
     * @param params
     * @return {@link CommonResult}<>
     */

    @RequestMapping("getproteams")
    public CommonResult<List<TeamDO>> getproteams(@RequestBody JSONObject params) {

        LambdaQueryWrapper<TeamDO> teamDOLambdaQueryWrapper = new LambdaQueryWrapper<TeamDO>()
                .eq(TeamDO::getPID, params.getString("pid"))
                .orderBy(true, false, TeamDO::getCreateTime);

        return CommonResult.success(teamMapper.selectList(teamDOLambdaQueryWrapper));

    }


    /**
     * editteaminfo
     *
     * @param params
     * @return {@link CommonResult}<>
     */

    @RequestMapping("editteaminfo")
    public CommonResult<UserDO> editteaminfo(@RequestBody JSONObject params) {
        String tid = params.getString("tid");
        if (StringUtils.isEmpty(tid)) {
            AddNewTeamInfo(params);
        } else {
            UpdateTeamInfo(params);
        }

        return CommonResult.success();

    }

    /**
     * editteaminfo
     *
     * @param params
     * @return {@link CommonResult}<>
     */

    @RequestMapping("reviewteam")
    public CommonResult<UserDO> reviewteam(@RequestBody JSONObject params) {

        TeamDO teamDO = new TeamDO();
        teamDO.setTID(params.getString("tid"));
        teamDO.setTIsApprove(params.getString("reviewinfo"));
        teamMapper.updateById(teamDO);
        ReviewTeamLeader(params);
        return CommonResult.success();
    }

    /**
     * editteaminfo
     *
     * @param params
     * @return {@link CommonResult}<>
     */

    @RequestMapping("getteaminfo")
    public CommonResult<TeamDO> getteaminfo(@RequestBody JSONObject params) {


        return CommonResult.success(teamMapper.selectById(params.getString("tid")));
    }

    protected void ReviewTeamLeader(JSONObject params) {
        ProjectTeamMemberDO teamMemberDO = new ProjectTeamMemberDO();
        teamMemberDO.setTID(params.getString("tid"));
        teamMemberDO.setPTMRole("队长");
        LambdaUpdateWrapper<ProjectTeamMemberDO> projectTeamMemberDOLambdaUpdateWrapper = new LambdaUpdateWrapper<ProjectTeamMemberDO>()
                .set(ProjectTeamMemberDO::getPTMIsApprove, params.getString("reviewinfo"));
        projectTeamMemberMapper.update(teamMemberDO, projectTeamMemberDOLambdaUpdateWrapper);
    }


    protected void AddNewTeamInfo(JSONObject params) {

        TeamDO teamDO = new TeamDO();

        teamDO.setTID(IdUtil.fastUUID());
        teamDO.setEditor(params.getString("username"));
        teamDO.setUID(params.getString("uid"));
        teamDO.setPID(params.getString("pid"));
        teamDO.setPSN((params.getString("psn")));
        teamDO.setPTitle(params.getString("ptitle"));
        teamDO.setTCreator(params.getString("username"));
        teamDO.setTAvatar(params.getString("avatar"));
        teamDO.setTSN(params.getString("tsn"));
        teamDO.setTName(params.getString("tname"));
        teamDO.setTIntro(params.getString("tintro"));
        teamDO.setTPoster(params.getString("tposter"));
        teamDO.setTTag(params.getString("ttag"));

        teamMapper.insert(teamDO);
    }


    protected void UpdateTeamInfo(JSONObject params) {
        LambdaUpdateWrapper<TeamDO> lambdaUpdateWrapper = new LambdaUpdateWrapper<TeamDO>()
                .set(TeamDO::getEditor, params.getString("username"))
                .set(TeamDO::getTIsApprove, params.getString("tapprove"))
                .set(TeamDO::getPID, params.getString("pid"))
                .set(TeamDO::getPSN, params.getString("psn"))
                .set(TeamDO::getPTitle, params.getString("ptitle"))
                .set(TeamDO::getTSN, params.getString("tsn"))
                .set(TeamDO::getTName, params.getString("tname"))
                .set(TeamDO::getTReviewDefault, params.getString("tdreview"))
                .set(TeamDO::getTIntro, params.getString("tintro"))
                .set(TeamDO::getTPoster, params.get("tposter"))
                .set(TeamDO::getTTag, params.getString("ttag"));

        TeamDO teamDO = new TeamDO();
        teamDO.setTID(params.getString("tid"));
        teamMapper.update(teamDO, lambdaUpdateWrapper);
    }


    protected void FillUserProfile(String uid, String username, String avatar, String nickName, String gender, String country, String province, String city) {

        UserProfileDO userProfileDO = new UserProfileDO();
        userProfileDO.setUPID(uid);
        userProfileDO.setEditor(uid);
        userProfileDO.setUserName(username);
        userProfileDO.setUAvatar(avatar);
        userProfileDO.setUPNickName(nickName);
        userProfileDO.setUPGender(gender);
        userProfileDO.setUPCountry(country);
        userProfileDO.setUPLocation(province + city);

        userProfileMapper.insert(userProfileDO);
    }


    protected Boolean ExistUserName(String username) {

        return userMapper.selectCount(UserDO::getUserName, username) > 0;

    }

    protected Boolean ExistUserPhone(String telephone) {

        return userMapper.selectCount(UserDO::getUPhone, telephone) > 0;

    }


}
