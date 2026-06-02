package com.dlyjcsppydspt.api.service.impl;

import com.dlyjcsppydspt.api.domain.DlJrlqmxdInformation;
import com.dlyjcsppydspt.api.mapper.DlJrlqmxdInformationMapper;
import com.dlyjcsppydspt.api.service.DlJrlqmxdInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电路元件参数匹配与调试平台
 * 元件信息Service接口实现类
 */
@Service
public class DlJrlqmxdInformationServiceImpl implements DlJrlqmxdInformationService {

    @Autowired
    private DlJrlqmxdInformationMapper dlJrlqmxdInformationMapper;

    @Override
    public DlJrlqmxdInformation selectByPrimaryKey(Long id) {
        return dlJrlqmxdInformationMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DlJrlqmxdInformation> selectByMap(Map<String, Object> params) {
        return dlJrlqmxdInformationMapper.selectByMap(params);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return dlJrlqmxdInformationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DlJrlqmxdInformation record) {
        return dlJrlqmxdInformationMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(DlJrlqmxdInformation record) {
        return dlJrlqmxdInformationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<DlJrlqmxdInformation> queryByDebuggingResults(String debuggingResults) {
        Map<String, Object> params = new HashMap<>();
        params.put("debuggingResults", debuggingResults);
        return dlJrlqmxdInformationMapper.selectByMap(params);
    }

    @Override
    public String saveByDebug(String debuggingPersonnel, String installationPosition) {
        DlJrlqmxdInformation record = new DlJrlqmxdInformation();
        record.setDlyjcsppydsptDebuggingPersonnel(debuggingPersonnel);
        record.setDlyjcsppydsptInstallationPosition(installationPosition);
        int result = dlJrlqmxdInformationMapper.insert(record);
        return result > 0 ? null : "保存失败";
    }

    @Override
    public String saveBy(String specifications, String debuggingPersonnel, String manufacturer) {
        DlJrlqmxdInformation record = new DlJrlqmxdInformation();
        record.setDlyjcsppydsptSpecifications(specifications);
        record.setDlyjcsppydsptDebuggingPersonnel(debuggingPersonnel);
        record.setDlyjcsppydsptManufacturer(manufacturer);
        int result = dlJrlqmxdInformationMapper.insert(record);
        return result > 0 ? null : "保存失败";
    }
}
