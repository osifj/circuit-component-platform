package com.dlyjcsppydspt.api.mapper;

import com.dlyjcsppydspt.api.domain.DlCnonfbotInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DlCnonfbotInformationMapper {
    DlCnonfbotInformation selectByPrimaryKey(@Param("id") Long id);
    List<DlCnonfbotInformation> selectByMap(@Param("params") Map<String, Object> params);
    int deleteByPrimaryKey(@Param("id") Long id);
    int insert(DlCnonfbotInformation record);
    int insertSelective(DlCnonfbotInformation record);
    int updateByPrimaryKeySelective(DlCnonfbotInformation record);
    int updateByPrimaryKey(DlCnonfbotInformation record);
    int insertList(List<DlCnonfbotInformation> list);
}
