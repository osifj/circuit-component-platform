package com.dlyjcsppydspt.api.mapper;

import com.dlyjcsppydspt.api.domain.DlJpixcMatch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DlJpixcMatchMapper {
    DlJpixcMatch selectByPrimaryKey(@Param("id") Long id);
    List<DlJpixcMatch> selectByMap(@Param("params") Map<String, Object> params);
    int deleteByPrimaryKey(@Param("id") Long id);
    int insert(DlJpixcMatch record);
    int insertSelective(DlJpixcMatch record);
    int updateByPrimaryKeySelective(DlJpixcMatch record);
    int updateByPrimaryKey(DlJpixcMatch record);
    int insertList(List<DlJpixcMatch> list);
}
