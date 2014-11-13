package com.sprhib.init;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Configuration
@Order(value = 1)
public class SpringSecurityInitializer extends
		AbstractSecurityWebApplicationInitializer {

}
