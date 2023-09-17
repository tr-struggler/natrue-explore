package cn.iocoder.yudao.server.dal.dataobject;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

@TableName("project_team_member")
@Data
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectTeamMemberDO {

    @TableId(type = IdType.INPUT)
    private String PTMID;

    private String Editor;


    private Date CreateTime;

    private Date UpdateTime;


    private String PID;

    private String PSN;

    private String PTitle;

    private String TID;

    private String TSN;

    private String TName;

    private String UID;

    private String UserName;

    private String UAvatar;

    private String PTMIsApprove;

    private String PTMRole;

    private int PTMObserveCount;

    private int PTMSpeciesCount;

    private int PTMIdentCount;

    private int PTMImageCount;

    private int PTMLocateCount;

    private int PTMCommentCount;

}
