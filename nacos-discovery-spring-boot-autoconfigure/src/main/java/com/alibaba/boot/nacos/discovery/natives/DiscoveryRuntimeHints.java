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

package com.alibaba.boot.nacos.discovery.natives;

import com.alibaba.boot.nacos.discovery.autoconfigure.NacosDiscoveryAutoRegister;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;
/**
 * DiscoveryRuntimeHints
 *
 * @author <a href="mailto:510830970@qq.com">hujun</a>
 */
public class DiscoveryRuntimeHints implements RuntimeHintsRegistrar {
    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        Optional<Field> namingService = Arrays.stream(NacosDiscoveryAutoRegister.class.getDeclaredFields())
                .filter(m -> m.getName().equals("namingService")).findFirst();
        namingService.ifPresent(field -> hints.reflection().registerField(field));
    }
}
