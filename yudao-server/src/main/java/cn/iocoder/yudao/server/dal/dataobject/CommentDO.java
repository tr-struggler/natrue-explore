package cn.iocoder.yudao.server.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

@TableName("comment")
@Data
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDO {


    /**
     * CID
     */
    @TableId(type = IdType.INPUT)
    private String nameCode;

    private String Editor;

    private Date CreateTime;

    private Date UpdateTime;

    private String HostID;

    private String CTag;

    private String UID;

    private String UserName;

    private String UAvatar;

    private String CContent;


}
