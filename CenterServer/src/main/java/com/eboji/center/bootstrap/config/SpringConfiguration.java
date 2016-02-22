package com.eboji.center.bootstrap.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
	BeanConfiguration.class 		//spring 初始化bean相关的配置
})
public class SpringConfiguration {

}
