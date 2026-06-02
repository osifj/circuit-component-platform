package com.dlyjcsppydspt.api.service.impl;

import com.dlyjcsppydspt.api.domain.DlPeyugrjzInformation;
import com.dlyjcsppydspt.api.mapper.DlPeyugrjzInformationMapper;
import com.dlyjcsppydspt.api.service.DlPeyugrjzInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 电路元件参数匹配与调试平台
 * 用户信息Service接口实现类
 */
@Service
public class DlPeyugrjzInformationServiceImpl implements DlPeyugrjzInformationService {

    @Autowired
    private DlPeyugrjzInformationMapper dlPeyugrjzInformationMapper;

    @Override
    public DlPeyugrjzInformation selectByPrimaryKey(Long id) {
        return dlPeyugrjzInformationMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DlPeyugrjzInformation> selectByAll(Map<String, Object> params) {
        return dlPeyugrjzInformationMapper.selectByAll(params);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return dlPeyugrjzInformationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DlPeyugrjzInformation record) {
        return dlPeyugrjzInformationMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(DlPeyugrjzInformation record) {
        return dlPeyugrjzInformationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateStatus(Long id, Integer status) {
        return dlPeyugrjzInformationMapper.updateStatus(id, status);
    }
}
