package com.dlyjcsppydspt.api.service;

import com.dlyjcsppydspt.api.domain.DlPeyugrjzInformation;

import java.util.List;
import java.util.Map;

public interface DlPeyugrjzInformationService {
    DlPeyugrjzInformation selectByPrimaryKey(Long id);
    List<DlPeyugrjzInformation> selectByAll(Map<String, Object> params);
    int deleteByPrimaryKey(Long id);
    int insert(DlPeyugrjzInformation record);
    int updateByPrimaryKeySelective(DlPeyugrjzInformation record);
    int updateStatus(Long id, Integer status);
}
