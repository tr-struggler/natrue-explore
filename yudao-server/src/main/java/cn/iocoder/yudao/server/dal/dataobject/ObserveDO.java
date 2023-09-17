package cn.iocoder.yudao.server.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

@TableName("observe")
@Data
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObserveDO {


    @TableId(type = IdType.INPUT)
    private String OID;

    private String Editor;

    private Date CreateTime;

    private Date UpdateTime;

    private String OSN;

    private String PID;

    private String PSN;

    private String PTitle;

    private String TID;

    private String TSN;

    private String TName;

    private String UID;

    private String UserName;

    private String UAvatar;

    private String OTitle;

    private String ObserveDatetime;

    private String OShareLevel;

    private String OIsWild;

    private String ORemark;


    private String OPoster;

    private String OTag;

    private String OCountry;

    private String OProvince;

    private String OCity;

    private String OPlace;

    private String OLocation;

    private String OLongitude;

    private String OLatitude;

    private String OAltitude;

    private String OCoordinateSys;

    private String OSNameLa;

    private String OSNameZh;

    private String OSKingdomLa;

    private String OSKingdomZh;

    private String OSPhylumLa;

    private String OSPhylumZh;

    private String OSClassLa;

    private String OSClassZh;

    private String OSOrderLa;

    private String OSOrderZh;

    private String OSFamilyLa;

    private String OSFamilyZh;

    private String OSGenusLa;

    private String OSGenusZh;

    private String OSTaxaGroupLa;

    private String OSTaxaGroupZh;

    private String OSTaxaLevel;

    private String OSRemark;

    private String OIUID;

    private String OIUserName;

    private String OIAvatar;

    private String OISysRole;

    private String OITime;

    private String OIID;

    private String IdentType;
    private String IdentStatus;


    private String OBiologyCount;

    private int OIdentCount;

    private int OImageCount;

    private int OCommentCount;

    private int OLocateCount;

    private String ExistRecord;

    private String OType;

    private String GreenLand;

    private String Auditor;

    private String AuditName;

    private String AuditSysRole;

    private String AuditTime;

    private String canEdit;


}
