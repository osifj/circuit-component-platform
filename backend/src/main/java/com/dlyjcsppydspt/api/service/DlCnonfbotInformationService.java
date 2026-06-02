package com.dlyjcsppydspt.api.service;

import com.dlyjcsppydspt.api.domain.DlCnonfbotInformation;

import java.util.List;
import java.util.Map;

public interface DlCnonfbotInformationService {
    DlCnonfbotInformation selectByPrimaryKey(Long id);
    List<DlCnonfbotInformation> selectByMap(Map<String, Object> params);
    int deleteByPrimaryKey(Long id);
    int insert(DlCnonfbotInformation record);
    int updateByPrimaryKeySelective(DlCnonfbotInformation record);
}
