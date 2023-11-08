package com.yh.mapper;

import com.yh.pojo.SysLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysLogMapper {
    void save(SysLog sysLog);
    List<SysLog> findAllSysLog();
}
