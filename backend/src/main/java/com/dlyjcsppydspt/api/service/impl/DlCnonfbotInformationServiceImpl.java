package com.dlyjcsppydspt.api.service.impl;

import com.dlyjcsppydspt.api.domain.DlCnonfbotInformation;
import com.dlyjcsppydspt.api.mapper.DlCnonfbotInformationMapper;
import com.dlyjcsppydspt.api.service.DlCnonfbotInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DlCnonfbotInformationServiceImpl implements DlCnonfbotInformationService {

    @Autowired
    private DlCnonfbotInformationMapper dlCnonfbotInformationMapper;

    @Override
    public DlCnonfbotInformation selectByPrimaryKey(Long id) {
        return dlCnonfbotInformationMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DlCnonfbotInformation> selectByMap(Map<String, Object> params) {
        return dlCnonfbotInformationMapper.selectByMap(params);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return dlCnonfbotInformationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DlCnonfbotInformation record) {
        return dlCnonfbotInformationMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(DlCnonfbotInformation record) {
        return dlCnonfbotInformationMapper.updateByPrimaryKeySelective(record);
    }
}
