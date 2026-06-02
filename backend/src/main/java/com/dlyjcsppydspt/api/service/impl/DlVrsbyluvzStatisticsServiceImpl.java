package com.dlyjcsppydspt.api.service.impl;

import com.dlyjcsppydspt.api.domain.DlVrsbyluvzStatistics;
import com.dlyjcsppydspt.api.mapper.DlVrsbyluvzStatisticsMapper;
import com.dlyjcsppydspt.api.mapper.*;
import com.dlyjcsppydspt.api.service.DlVrsbyluvzStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DlVrsbyluvzStatisticsServiceImpl implements DlVrsbyluvzStatisticsService {

    @Autowired
    private DlVrsbyluvzStatisticsMapper dlVrsbyluvzStatisticsMapper;

    @Autowired
    private DlPeyugrjzInformationMapper dlPeyugrjzInformationMapper;

    @Autowired
    private DlJpixcMatchMapper dlJpixcMatchMapper;

    @Autowired
    private DlEkjaudInformationMapper dlEkjaudInformationMapper;

    @Override
    public DlVrsbyluvzStatistics selectByPrimaryKey(Long id) {
        return dlVrsbyluvzStatisticsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DlVrsbyluvzStatistics> selectByMap(Map<String, Object> params) {
        return dlVrsbyluvzStatisticsMapper.selectByMap(params);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return dlVrsbyluvzStatisticsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DlVrsbyluvzStatistics record) {
        return dlVrsbyluvzStatisticsMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(DlVrsbyluvzStatistics record) {
        return dlVrsbyluvzStatisticsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Map<String, Object> getStatisticsSummary() {
        Map<String, Object> summary = new HashMap<>();
        summary.put("totalComponents", dlVrsbyluvzStatisticsMapper.selectByMap(new HashMap<>()).size());
        return summary;
    }
}
