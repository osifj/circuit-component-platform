package com.dlyjcsppydspt.api.mapper;

import com.dlyjcsppydspt.api.domain.DlPeyugrjzInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DlPeyugrjzInformationMapper {
    DlPeyugrjzInformation selectByPrimaryKey(@Param("id") Long id);
    List<DlPeyugrjzInformation> selectByMap(@Param("params") Map<String, Object> params);
    List<DlPeyugrjzInformation> selectByAll(Map<String, Object> params);
    int deleteByPrimaryKey(@Param("id") Long id);
    int insert(DlPeyugrjzInformation record);
    int insertSelective(DlPeyugrjzInformation record);
    int updateByPrimaryKeySelective(DlPeyugrjzInformation record);
    int updateByPrimaryKey(DlPeyugrjzInformation record);
    int insertList(List<DlPeyugrjzInformation> list);
    int updateStatus(@Param("id") Long id, @Param("status") Integer status);
}
