/**
 * 
 */
package com.cn.fd.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * <p> Description: </p>
 * @author fengda
 * @date 2017年3月23日 下午4:49:10
 */
@Configuration
public class ErrorPageConfig {
    
    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
        return new MyCustomizer();
    }
    
    private static class MyCustomizer implements EmbeddedServletContainerCustomizer {

        @SuppressWarnings("deprecation")
		@Override
        public void customize(ConfigurableEmbeddedServletContainer container) {
            container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/403"));
        }

    }

}
