package com.dlyjcsppydspt.api.service;

import com.dlyjcsppydspt.api.domain.DlVrsbyluvzStatistics;

import java.util.List;
import java.util.Map;

public interface DlVrsbyluvzStatisticsService {
    DlVrsbyluvzStatistics selectByPrimaryKey(Long id);
    List<DlVrsbyluvzStatistics> selectByMap(Map<String, Object> params);
    int deleteByPrimaryKey(Long id);
    int insert(DlVrsbyluvzStatistics record);
    int updateByPrimaryKeySelective(DlVrsbyluvzStatistics record);
    Map<String, Object> getStatisticsSummary();
}
