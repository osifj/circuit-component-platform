package com.dlyjcsppydspt.api.service.impl;

import com.dlyjcsppydspt.api.domain.DlVjkqywmqnLog;
import com.dlyjcsppydspt.api.mapper.DlVjkqywmqnLogMapper;
import com.dlyjcsppydspt.api.service.DlVjkqywmqnLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DlVjkqywmqnLogServiceImpl implements DlVjkqywmqnLogService {

    @Autowired
    private DlVjkqywmqnLogMapper dlVjkqywmqnLogMapper;

    @Override
    public DlVjkqywmqnLog selectByPrimaryKey(Long id) {
        return dlVjkqywmqnLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DlVjkqywmqnLog> selectByMap(Map<String, Object> params) {
        return dlVjkqywmqnLogMapper.selectByMap(params);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return dlVjkqywmqnLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DlVjkqywmqnLog record) {
        return dlVjkqywmqnLogMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(DlVjkqywmqnLog record) {
        return dlVjkqywmqnLogMapper.updateByPrimaryKeySelective(record);
    }
}
