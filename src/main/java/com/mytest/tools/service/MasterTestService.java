package com.mytest.tools.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mytest.tools.dao.master.MasterTestMapper;
import com.mytest.tools.entity.master.MasterTest;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Create by wangzuolong on 2018/09/17.
 **/
@Service
public class MasterTestService {

    @Resource
    private MasterTestMapper masterTestMapper;


    public MasterTest getTest(){
        return masterTestMapper.selectByPrimaryKey(9);
    }

    public PageInfo getPage(){
        PageHelper.startPage(-1,3);
        List<MasterTest> list = masterTestMapper.selectAll();
        return new PageInfo<>(list);
    }


    public List<MasterTest> selectByEm(){

        Example example = new Example(MasterTest.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name","王五");
        return masterTestMapper.selectByExample(example);
    }

    public int insert(){
        MasterTest masterTest = new MasterTest();
        masterTest.setAge(15);
        masterTest.setName("小红");
        masterTest.setSex("女");
        return masterTestMapper.insert(masterTest);
    }

}
