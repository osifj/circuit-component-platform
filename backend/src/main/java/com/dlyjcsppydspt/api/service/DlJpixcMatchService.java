package com.dlyjcsppydspt.api.service;

import com.dlyjcsppydspt.api.domain.DlJpixcMatch;

import java.util.List;
import java.util.Map;

public interface DlJpixcMatchService {
    DlJpixcMatch selectByPrimaryKey(Long id);
    List<DlJpixcMatch> selectByMap(Map<String, Object> params);
    int deleteByPrimaryKey(Long id);
    int insert(DlJpixcMatch record);
    int updateByPrimaryKeySelective(DlJpixcMatch record);
    int updateMatchInfo(String ratedPower, String ratedVoltage, String ratedCurrent);
    String saveMatch(String ratedVoltage2, String componentName, String ratedCurrent);
}
