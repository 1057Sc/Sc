package org.sc.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.Configuration;

/**
 * 手动注入bean
 */
// @Configuration
public class ConfigRegister implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

        FooEntity fooEntity = new FooEntity();
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();

        beanDefinition.setBeanClass(fooEntity.getClass());
        beanDefinition.setLazyInit(true);
        beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
        MutablePropertyValues propertyValues = new MutablePropertyValues();
/*

        propertyValues.addPropertyValue();
        propertyValues.addPropertyValue();
        propertyValues.addPropertyValue();
        propertyValues.addPropertyValue();
*/

        beanDefinition.setPropertyValues(propertyValues);

        registry.registerBeanDefinition(fooEntity.getName(), beanDefinition);

        // beanDefinitionBuilder.addConstructorArgValue()
    }


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//         beanFactory.registerSingleton();

    }
}
