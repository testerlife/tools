package com.mytest.tools.controller;

import com.github.pagehelper.PageInfo;
import com.mytest.tools.service.CustomTestService;
import com.mytest.tools.service.MasterTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Create by wangzuolong on 2018/09/17.
 **/
@RestController
public class TestApi {
    @Autowired
    private MasterTestService masterTestService;

    @Autowired
    private CustomTestService customTestService;

    @RequestMapping("/master/select")
    public Object selectMaster(){
        return masterTestService.getTest();
    }


    @RequestMapping("/custom/select")
    public Object selectCustom(){
        return customTestService.getTest();
    }

    @RequestMapping("/master/page")
    public PageInfo masterSelectPage(){
        return masterTestService.getPage();
    }


    @RequestMapping("/custom/page")
    public PageInfo selectPage(){
        return customTestService.getPage();
    }

    @RequestMapping("/master/example")
    public List getMasterlist(){
        return masterTestService.selectByEm();
    }

    @RequestMapping("/custom/example")
    public List getlist(){
        return customTestService.selectByEm();
    }


    @RequestMapping("/master/inster")
    public int masterInsert(){
        return masterTestService.insert();
    }

    @RequestMapping("/custom/inster")
    public int customInsert(){
        return customTestService.insert();
    }


    @RequestMapping("/master/ex")
    @Transactional
    public int masterEx(){
        masterTestService.insert();
        int m = 1000/0;
        return m;
    }

    @RequestMapping("/custom/ex")
    @Transactional
    public int customEx(){
        customTestService.insert();
        int m = 1000/0;
        return m;
    }



}
