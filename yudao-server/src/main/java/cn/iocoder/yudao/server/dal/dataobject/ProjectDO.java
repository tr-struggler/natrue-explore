package cn.iocoder.yudao.server.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

@TableName("project")
@Data
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDO {
    @TableId(type = IdType.INPUT)
    private String PID;

    private String Editor;

    private Date CreateTime;

    private Date UpdateTime;

    private String UID;

    private String PCreator;

    private String PAvatar;

    private String PSN;

    private String PCategory;

    private String PTitle;

    private String PLocation;

    private String PStartTime;

    private String PEndTime;

    private String PIntro;

    private String PPoster;

    private String PTag;

    private String PIsApprove;

    private String PReviewDefault;

    private String JoinMoreTeamsStatus;

    private int PObserveCount;

    private int PSpeciesCount;

    private int PIdentCount;

    private int PImageCount;

    private int PTeamCount;

    private int PMemberCount;

    private int PCommentCount;

    private int PLocateCount;

}
