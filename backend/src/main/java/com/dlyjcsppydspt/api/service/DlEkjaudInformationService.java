package com.dlyjcsppydspt.api.service;

import com.dlyjcsppydspt.api.domain.DlEkjaudInformation;

import java.util.List;
import java.util.Map;

public interface DlEkjaudInformationService {
    DlEkjaudInformation selectByPrimaryKey(Long id);
    List<DlEkjaudInformation> selectByMap(Map<String, Object> params);
    int deleteByPrimaryKey(Long id);
    int insert(DlEkjaudInformation record);
    int updateByPrimaryKeySelective(DlEkjaudInformation record);
    List<DlEkjaudInformation> queryByInstallationPosition(String installationPosition);
    int updateInfo(String ratedCurrent, String componentType);
    String saveDebugInfo(String debuggingResults, String installationPosition, String ratedCurrent);
}
