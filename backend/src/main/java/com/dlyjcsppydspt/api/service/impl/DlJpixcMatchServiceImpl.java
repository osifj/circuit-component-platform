package com.dlyjcsppydspt.api.service.impl;

import com.dlyjcsppydspt.api.domain.DlJpixcMatch;
import com.dlyjcsppydspt.api.mapper.DlJpixcMatchMapper;
import com.dlyjcsppydspt.api.service.DlJpixcMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电路元件参数匹配与调试平台
 * 参数匹配Service接口实现类
 */
@Service
public class DlJpixcMatchServiceImpl implements DlJpixcMatchService {

    @Autowired
    private DlJpixcMatchMapper dlJpixcMatchMapper;

    @Override
    public DlJpixcMatch selectByPrimaryKey(Long id) {
        return dlJpixcMatchMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DlJpixcMatch> selectByMap(Map<String, Object> params) {
        return dlJpixcMatchMapper.selectByMap(params);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return dlJpixcMatchMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DlJpixcMatch record) {
        return dlJpixcMatchMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(DlJpixcMatch record) {
        return dlJpixcMatchMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateMatchInfo(String ratedPower, String ratedVoltage, String ratedCurrent) {
        DlJpixcMatch record = new DlJpixcMatch();
        record.setDlyjcsppydsptRatedPower(ratedPower);
        record.setDlyjcsppydsptRatedVoltage(ratedVoltage);
        record.setDlyjcsppydsptRatedCurrent(ratedCurrent);
        return dlJpixcMatchMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public String saveMatch(String ratedVoltage2, String componentName, String ratedCurrent) {
        DlJpixcMatch record = new DlJpixcMatch();
        record.setDlyjcsppydsptRatedVoltage2(ratedVoltage2);
        record.setDlyjcsppydsptComponentName(componentName);
        record.setDlyjcsppydsptRatedCurrent(ratedCurrent);
        int result = dlJpixcMatchMapper.insert(record);
        return result > 0 ? null : "保存失败";
    }
}
