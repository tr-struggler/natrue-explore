package cn.iocoder.yudao.server.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

@TableName("user_profile")
@Data
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDO {

    @TableId(type = IdType.INPUT)
    private String UPID;

    private String Editor;

    private Date CreateTime;

    private Date UpdateTime;

    private String UserName;

    private String UAvatar;

    private String UPNickName;

    private String UPTrueName;

    private String UPGender;

    private String UPBirthDate;

    private String UPCountry;

    private String UPLocation;

    private String UPLicenceNum;

    private String UPInstitute;

    private String UPJob;

    private String UPEducation;

    private int UPObserveCount;

    private int UPSpeciesCount;

    private int UPIdentCount;

    private int UPImageCount;

    private int UPProjectCount;

    private int UPTeamCount;

    private int UPCommentCount;
    private int UPLocateCount;

    private String UPTaxaGroup;

    private String UPTaxaRole;

}
