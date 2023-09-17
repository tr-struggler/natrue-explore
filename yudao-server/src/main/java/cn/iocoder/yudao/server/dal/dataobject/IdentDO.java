package cn.iocoder.yudao.server.dal.dataobject;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

@TableName("ident")
@Data
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdentDO {

    @TableId(type = IdType.INPUT)
    private String IID;


    private String Editor;


    private Date  CreateTime;

    private Date  UpdateTime;

    private String HostID;

    private String HostPoster;

    private String UID;

    private String UserName;

    private String UAvatar;

    private String USysRole;

    private String ISNameLa;

    private String ISNameZh;

    private String ISKingdomLa;

    private String ISKingdomZh;

    private String ISPhylumLa;

    private String ISPhylumZh;

    private String ISClassLa;

    private String ISClassZh;

    private String ISOrderLa;

    private String ISOrderZh;

    private String ISFamilyLa;

    private String ISFamilyZh;

    private String ISGenusLa;

    private String ISGenusZh;

    private String ISTaxaGroupLa;

    private String ISTaxaGroupZh;

    private String IRemark;

    private String ITaxaLevel;

    private String IdentType;

}
