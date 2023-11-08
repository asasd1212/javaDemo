package com.yh.web;

import com.yh.pojo.SysLog;
import com.yh.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/syslog")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/findAll")
    public String findAllSysLog(Model model) {
        List<SysLog> sysLogList =  sysLogService.findAllSysLog();
        model.addAttribute("sysLogList", sysLogList);
        return "syslog-list";
    }
}
