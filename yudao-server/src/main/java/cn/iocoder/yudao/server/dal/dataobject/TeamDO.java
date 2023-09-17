package cn.iocoder.yudao.server.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

@TableName("team")
@Data
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamDO {

    @TableId(type = IdType.INPUT)
    private String TID;

    private String Editor;


    private Date CreateTime;

    private Date UpdateTime;

    private String PID;

    private String PSN;

    private String PTitle;

    private String UID;

    private String TCreator;

    private String TAvatar;

    private String TSN;

    private String TName;

    private String TIntro;

    private String TPoster;

    private String TTag;

    private String TIsApprove;

    private String TReviewDefault;

    private int TObserveCount;

    private int TSpeciesCount;

    private int TIdentCount;

    private int TImageCount;

    private int TMemberCount;

    private int TCommentCount;

    private int TLocateCount;

}
