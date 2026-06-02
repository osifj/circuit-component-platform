package com.dlyjcsppydspt.api.service;

import com.dlyjcsppydspt.api.domain.DlVjkqywmqnLog;

import java.util.List;
import java.util.Map;

public interface DlVjkqywmqnLogService {
    DlVjkqywmqnLog selectByPrimaryKey(Long id);
    List<DlVjkqywmqnLog> selectByMap(Map<String, Object> params);
    int deleteByPrimaryKey(Long id);
    int insert(DlVjkqywmqnLog record);
    int updateByPrimaryKeySelective(DlVjkqywmqnLog record);
}
