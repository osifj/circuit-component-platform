package com.dlyjcsppydspt.api.mapper;

import com.dlyjcsppydspt.api.domain.DlVrsbyluvzStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DlVrsbyluvzStatisticsMapper {
    DlVrsbyluvzStatistics selectByPrimaryKey(@Param("id") Long id);
    List<DlVrsbyluvzStatistics> selectByMap(@Param("params") Map<String, Object> params);
    int deleteByPrimaryKey(@Param("id") Long id);
    int insert(DlVrsbyluvzStatistics record);
    int insertSelective(DlVrsbyluvzStatistics record);
    int updateByPrimaryKeySelective(DlVrsbyluvzStatistics record);
    int updateByPrimaryKey(DlVrsbyluvzStatistics record);
    int insertList(List<DlVrsbyluvzStatistics> list);
}
