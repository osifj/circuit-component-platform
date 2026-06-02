package com.dlyjcsppydspt.api.service.impl;

import com.dlyjcsppydspt.api.domain.DlEkjaudInformation;
import com.dlyjcsppydspt.api.mapper.DlEkjaudInformationMapper;
import com.dlyjcsppydspt.api.service.DlEkjaudInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电路元件参数匹配与调试平台
 * 调试信息Service接口实现类
 */
@Service
public class DlEkjaudInformationServiceImpl implements DlEkjaudInformationService {

    @Autowired
    private DlEkjaudInformationMapper dlEkjaudInformationMapper;

    @Override
    public DlEkjaudInformation selectByPrimaryKey(Long id) {
        return dlEkjaudInformationMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DlEkjaudInformation> selectByMap(Map<String, Object> params) {
        return dlEkjaudInformationMapper.selectByMap(params);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return dlEkjaudInformationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DlEkjaudInformation record) {
        return dlEkjaudInformationMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(DlEkjaudInformation record) {
        return dlEkjaudInformationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<DlEkjaudInformation> queryByInstallationPosition(String installationPosition) {
        Map<String, Object> params = new HashMap<>();
        params.put("installationPosition", installationPosition);
        return dlEkjaudInformationMapper.selectByMap(params);
    }

    @Override
    public int updateInfo(String ratedCurrent, String componentType) {
        DlEkjaudInformation record = new DlEkjaudInformation();
        record.setDlyjcsppydsptRatedCurrent(ratedCurrent);
        record.setDlyjcsppydsptComponentType(componentType);
        return dlEkjaudInformationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public String saveDebugInfo(String debuggingResults, String installationPosition, String ratedCurrent) {
        DlEkjaudInformation record = new DlEkjaudInformation();
        record.setDlyjcsppydsptDebuggingResults(debuggingResults);
        record.setDlyjcsppydsptInstallationPosition(installationPosition);
        record.setDlyjcsppydsptRatedCurrent(ratedCurrent);
        int result = dlEkjaudInformationMapper.insert(record);
        return result > 0 ? null : "保存失败";
    }
}
