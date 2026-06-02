package com.dlyjcsppydspt.api.service;

import com.dlyjcsppydspt.api.domain.DlJrlqmxdInformation;

import java.util.List;
import java.util.Map;

public interface DlJrlqmxdInformationService {
    DlJrlqmxdInformation selectByPrimaryKey(Long id);
    List<DlJrlqmxdInformation> selectByMap(Map<String, Object> params);
    int deleteByPrimaryKey(Long id);
    int insert(DlJrlqmxdInformation record);
    int updateByPrimaryKeySelective(DlJrlqmxdInformation record);
    List<DlJrlqmxdInformation> queryByDebuggingResults(String debuggingResults);
    String saveByDebug(String debuggingPersonnel, String installationPosition);
    String saveBy(String specifications, String debuggingPersonnel, String manufacturer);
}
