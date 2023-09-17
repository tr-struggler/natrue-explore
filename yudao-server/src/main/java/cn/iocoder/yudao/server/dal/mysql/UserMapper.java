package cn.iocoder.yudao.server.dal.mysql;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.server.dal.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper extends BaseMapperX<UserDO> {

    /**
     * @param OID
     * @param UID
     */
    @Update("UPDATE iconserve.observe a,iconserve.user b SET a.`IdentStatus`=#{IdentStatus},\" +\n" +
            "            \"a.OSNameLa='',a.OSNameZh='',a.OSKingdomLa='',a.OSKingdomZh='',a.IdentType='',a.OIID='',\" +\n" +
            "            \"a.OSPhylumLa='',a.OSPhylumZh='',a.OSClassLa='',a.OSClassZh='',a.Auditor=?UID,a.AuditTime=?OITime,\" +\n" +
            "            \"a.OSOrderLa='',a.OSOrderZh='',a.OSFamilyLa='',a.OSFamilyZh='',\" +\n" +
            "            \"a.OSGenusLa='',a.OSGenusZh='',\" +\n" +
            "            \"a.OSTaxaLevel='',a.OIUID = b.UID,a.OIUserName = b.UserName,a.OIAvatar = b.UAvatar,\" +\n" +
            "            \"a.OISysRole = b.USysRole,a.OITime =?OITime \" +\n" +
            "            \" WHERE a.`IdentStatus`='PendingIdent' and a.`OID`=#{OID} and b.UID=#{UID};\"")
    void updateUser(String OID, String UID, String IdentStatus,String OITime);

}
