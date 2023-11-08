package com.yh.service.impl;

import com.yh.mapper.SysLogMapper;
import com.yh.pojo.SysLog;
import com.yh.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    SysLogMapper sysLogMapper;
    @Override
    public List<SysLog> findAllSysLog() {
        return sysLogMapper.findAllSysLog();
    }
}
