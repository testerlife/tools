package com.mytest.tools.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;

/**
 * @Create by wangzuolong on 2018/09/17.
 **/
@Configuration
@EnableTransactionManagement
@ConditionalOnBean({MasterDataSourceConfig.class,CustomDataSourceConfig.class})
public class DataSourcesAutoConfiguration  implements TransactionManagementConfigurer {

    @Resource
    private MasterDataSourceConfig masterDataSourceConfig;

    @Resource
    private CustomDataSourceConfig customDataSourceConfig;

    //  配置分布式事务管理
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {

        return  new ChainedTransactionManager(masterDataSourceConfig.masterTransactionManager(),customDataSourceConfig.customTransactionManager());
    }

}
