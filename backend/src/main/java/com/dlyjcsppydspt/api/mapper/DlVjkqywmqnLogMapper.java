package com.dlyjcsppydspt.api.mapper;

import com.dlyjcsppydspt.api.domain.DlVjkqywmqnLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DlVjkqywmqnLogMapper {
    DlVjkqywmqnLog selectByPrimaryKey(@Param("id") Long id);
    List<DlVjkqywmqnLog> selectByMap(@Param("params") Map<String, Object> params);
    int deleteByPrimaryKey(@Param("id") Long id);
    int insert(DlVjkqywmqnLog record);
    int insertSelective(DlVjkqywmqnLog record);
    int updateByPrimaryKeySelective(DlVjkqywmqnLog record);
    int updateByPrimaryKey(DlVjkqywmqnLog record);
    int insertList(List<DlVjkqywmqnLog> list);
}
