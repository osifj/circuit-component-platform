package com.dlyjcsppydspt.api.service;

import com.dlyjcsppydspt.api.domain.DlTshmdlBackup;

import java.util.List;
import java.util.Map;

public interface DlTshmdlBackupService {
    DlTshmdlBackup selectByPrimaryKey(Long id);
    List<DlTshmdlBackup> selectByMap(Map<String, Object> params);
    int deleteByPrimaryKey(Long id);
    int insert(DlTshmdlBackup record);
    int updateByPrimaryKeySelective(DlTshmdlBackup record);
}
