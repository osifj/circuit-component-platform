package com.dlyjcsppydspt.api.mapper;

import com.dlyjcsppydspt.api.domain.DlTshmdlBackup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DlTshmdlBackupMapper {
    DlTshmdlBackup selectByPrimaryKey(@Param("id") Long id);
    List<DlTshmdlBackup> selectByMap(@Param("params") Map<String, Object> params);
    int deleteByPrimaryKey(@Param("id") Long id);
    int insert(DlTshmdlBackup record);
    int insertSelective(DlTshmdlBackup record);
    int updateByPrimaryKeySelective(DlTshmdlBackup record);
    int updateByPrimaryKey(DlTshmdlBackup record);
    int insertList(List<DlTshmdlBackup> list);
}
