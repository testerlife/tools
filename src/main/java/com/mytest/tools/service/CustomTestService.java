package com.mytest.tools.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mytest.tools.dao.custom.CustomTestMapper;
import com.mytest.tools.entity.custom.CustomTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Create by wangzuolong on 2018/09/17.
 **/
@Service
public class CustomTestService {

    @Autowired
    private CustomTestMapper customTestMapper;

    public CustomTest getTest(){
        return customTestMapper.selectByPrimaryKey(1);
    }

    @SuppressWarnings("unchecked")
    public PageInfo getPage(){
        PageHelper.startPage(0,3);
        List list = customTestMapper.selectAll();
        return new PageInfo(list);
    }


    public List<CustomTest> selectByEm(){

        Example example = new Example(CustomTest.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name","赵六");
        return customTestMapper.selectByExample(example);
    }


    public int insert(){
        CustomTest customTest = new CustomTest();
        customTest.setAge(15);
        customTest.setName("小张");
        customTest.setSex("男");
        return customTestMapper.insert(customTest);
    }


}