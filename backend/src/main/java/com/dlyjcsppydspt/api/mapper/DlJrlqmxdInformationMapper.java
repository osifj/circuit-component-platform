package com.dlyjcsppydspt.api.mapper;

import com.dlyjcsppydspt.api.domain.DlJrlqmxdInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DlJrlqmxdInformationMapper {
    DlJrlqmxdInformation selectByPrimaryKey(@Param("id") Long id);
    List<DlJrlqmxdInformation> selectByMap(@Param("params") Map<String, Object> params);
    int deleteByPrimaryKey(@Param("id") Long id);
    int insert(DlJrlqmxdInformation record);
    int insertSelective(DlJrlqmxdInformation record);
    int updateByPrimaryKeySelective(DlJrlqmxdInformation record);
    int updateByPrimaryKey(DlJrlqmxdInformation record);
    int insertList(List<DlJrlqmxdInformation> list);
}
