/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.boot.nacos.discovery.natives;//package com.alibaba.nacos.spring.context.annotation.discovery;

import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import com.alibaba.nacos.spring.util.PropertiesPlaceholderResolver;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Role;
import org.springframework.core.env.Environment;
import java.util.Properties;

import static com.alibaba.nacos.spring.util.NacosBeanUtils.DISCOVERY_GLOBAL_NACOS_PROPERTIES_BEAN_NAME;
import static com.alibaba.nacos.spring.util.NacosBeanUtils.MAINTAIN_GLOBAL_NACOS_PROPERTIES_BEAN_NAME;

/**
 * Nacos discovery features.
 *
 * @author <a href="mailto:510830970qq.com">hujun</a>
 */
public class NacosDiscoveryBeanConfiguration {

    @Bean(name = DISCOVERY_GLOBAL_NACOS_PROPERTIES_BEAN_NAME)
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public Properties globalDiscoveryProperties(Environment environment) {
        return getGlobalProperties(environment);
    }

    @Bean(name = MAINTAIN_GLOBAL_NACOS_PROPERTIES_BEAN_NAME)
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public Properties globalDiscoveryPropertiesMaintain(Environment environment) {
        return getGlobalProperties(environment);
    }

    private static Properties getGlobalProperties(Environment environment) {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.USERNAME, EnableNacosDiscovery.USERNAME_PLACEHOLDER);
        properties.put(PropertyKeyConst.PASSWORD, EnableNacosDiscovery.PASSWORD_PLACEHOLDER);
        properties.put(PropertyKeyConst.ENDPOINT, EnableNacosDiscovery.ENDPOINT_PLACEHOLDER);
        properties.put(PropertyKeyConst.ACCESS_KEY, EnableNacosDiscovery.ACCESS_KEY_PLACEHOLDER);
        properties.put(PropertyKeyConst.SECRET_KEY, EnableNacosDiscovery.SECRET_KEY_PLACEHOLDER);
        properties.put(PropertyKeyConst.SERVER_ADDR, EnableNacosDiscovery.SERVER_ADDR_PLACEHOLDER);
        properties.put(PropertyKeyConst.CONTEXT_PATH, EnableNacosDiscovery.CONTEXT_PATH_PLACEHOLDER);
        properties.put(PropertyKeyConst.CLUSTER_NAME, EnableNacosDiscovery.CLUSTER_NAME_PLACEHOLDER);
        properties.put(PropertyKeyConst.ENCODE, EnableNacosDiscovery.ENCODE_PLACEHOLDER);
        PropertiesPlaceholderResolver propertiesPlaceholderResolver = new PropertiesPlaceholderResolver(environment);
        return propertiesPlaceholderResolver.resolve(properties);
    }

}
