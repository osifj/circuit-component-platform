package com.dlyjcsppydspt.api.mapper;

import com.dlyjcsppydspt.api.domain.DlEkjaudInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DlEkjaudInformationMapper {
    DlEkjaudInformation selectByPrimaryKey(@Param("id") Long id);
    List<DlEkjaudInformation> selectByMap(@Param("params") Map<String, Object> params);
    int deleteByPrimaryKey(@Param("id") Long id);
    int insert(DlEkjaudInformation record);
    int insertSelective(DlEkjaudInformation record);
    int updateByPrimaryKeySelective(DlEkjaudInformation record);
    int updateByPrimaryKey(DlEkjaudInformation record);
    int insertList(List<DlEkjaudInformation> list);
}
