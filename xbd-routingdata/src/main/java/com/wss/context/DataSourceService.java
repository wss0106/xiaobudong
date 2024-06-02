package com.wss.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import javax.sql.DataSource;

public class DataSourceService {
    @Autowired
    private BeanDefinitionRegistry beanDefinitionRegistry;

    public void registerNewDataSource(String beanName, DataSource dataSource) {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DataSource.class);
        beanDefinition.setInstanceSupplier(() -> dataSource);
        beanDefinitionRegistry.registerBeanDefinition(beanName, beanDefinition);
    }

}
