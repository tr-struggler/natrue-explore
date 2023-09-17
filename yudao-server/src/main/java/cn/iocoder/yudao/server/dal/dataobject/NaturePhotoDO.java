package cn.iocoder.yudao.server.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

@TableName("nature_photo")
@Data
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NaturePhotoDO {

    @TableId(type = IdType.INPUT)
    private String NPID;


    private String Editor;

    private Date CreateTime;

    private Date UpdateTime;

    private String HostID;

    private String NPOriginPath;

    private String NPNormalPath;

    private String NPOThumbPath;

    private String NPShareLevel;

    private String NPFileName;

    private String NPFileExt;

    private String NPFileSize;

    private String NPTakeTime;

    private String NPTag;

    private String NPWidth;

    private String NPHeight;

    private String NPRemark;

    private String PID;

    private String PSN;

    private String PTitle;

    private String TID;

    private String TName;

    private String UID;

    private String UserName;

    private String UAvatar;

    private String USysRole;

    private String NPIsWild;

    private String NPCountry;

    private String NPProvince;

    private String NPCity;

    private String NPPlace;

    private String NPLocation;

    private String NPLongitude;

    private String NPLatitude;

    private String NPAltitude;

    private String NPSNameLa;

    private String NPSNameZh;

    private String NPSKingdomLa;

    private String NPSKingdomZh;

    private String NPPhylumLa;

    private String NPPhylumZh;

    private String NPClassLa;

    private String NPClassZh;

    private String NPOrderLa;

    private String NPOrderZh;

    private String NPSFamilyLa;

    private String NPSFamilyZh;

    private String NPSGenusLa;

    private String NPSGenusZh;

    private String NPSTaxaGroupLa;

    private String NPSTaxaGroupZh;

    private String NPTaxaLevel;

    private String NPSRemark;

    private String NPIUID;

    private String NPIUserName;

    private String NPIAvatar;

    private String NPISysRole;

    private String NPITime;

    private int NPBiologyCount;

    private int NPIdentCount;

    private int NPCommentCount;

    private String ExistRecord;

    private String IdentType;


}
