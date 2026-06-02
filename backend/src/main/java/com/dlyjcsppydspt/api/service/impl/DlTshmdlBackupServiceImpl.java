package com.dlyjcsppydspt.api.service.impl;

import com.dlyjcsppydspt.api.domain.DlTshmdlBackup;
import com.dlyjcsppydspt.api.mapper.DlTshmdlBackupMapper;
import com.dlyjcsppydspt.api.service.DlTshmdlBackupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DlTshmdlBackupServiceImpl implements DlTshmdlBackupService {

    @Autowired
    private DlTshmdlBackupMapper dlTshmdlBackupMapper;

    @Override
    public DlTshmdlBackup selectByPrimaryKey(Long id) {
        return dlTshmdlBackupMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DlTshmdlBackup> selectByMap(Map<String, Object> params) {
        return dlTshmdlBackupMapper.selectByMap(params);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return dlTshmdlBackupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DlTshmdlBackup record) {
        return dlTshmdlBackupMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(DlTshmdlBackup record) {
        return dlTshmdlBackupMapper.updateByPrimaryKeySelective(record);
    }
}
