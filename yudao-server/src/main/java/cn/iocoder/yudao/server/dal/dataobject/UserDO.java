package cn.iocoder.yudao.server.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

@TableName("user")
@Data
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDO {
    @TableId(type = IdType.INPUT)
    private String UID;


    private String Editor;

    private Date CreateTime;

    private Date UpdateTime;

    private String UserName;

    private String UPassword;

    private String USysRole;

    private String UAvatar;

    private String UPhone;

    private String UEmail;

    private String USource;

    private String UType;

    private String LogonToken;

    private String AccountStatus;

    private String WxOID;

}
