package cn.iocoder.yudao.server.dal.mysql;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.server.dal.dataobject.ObserveDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ObserveMapper extends BaseMapperX<ObserveDO> {

    @Select("SELECT COUNT(*) From iconserve.observe WHERE `PID`='291307d6-6d17-11ea-81e6-00163e022f98';")
    int GetObservationCount();


    @Select("SELECT COUNT(DISTINCT(OSNameZh)) FROM iconserve.observe WHERE `PID`='291307d6-6d17-11ea-81e6-00163e022f98';")
    int GetSpeciesCount();


    @Select("SELECT COUNT(*) FROM iconserve.project_team_member WHERE `PID`='291307d6-6d17-11ea-81e6-00163e022f98' AND `PTMIsApprove`='Yes';")
    int GetPeopleCount();


}
