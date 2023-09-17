package cn.iocoder.yudao.server.dal.mysql;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.server.dal.dataobject.TeamDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeamMapper extends BaseMapperX<TeamDO> {
}
