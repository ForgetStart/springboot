package com.cn.fd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * <p> Description:
 * 		Spring Boot项目总入口 
 *  </p>
 * @author fengda
 * @date 2017年3月10日 下午5:41:08
 */
@Configuration
@EnableAutoConfiguration		//自动载入应用程序所需的所有Bean
@EnableAsync		//开启异步任务的支持(多线程)
//@MapperScan(basePackages = {"com.shawearn.demo.persistence"})
@ComponentScan(basePackages = {"com.cn.fd"})

//在spring 3.2中，允许支持多个properties了， 
//@PropertySource({  
//    "classpath:config.properties",  
//    "classpath:db.properties" //如果是相同的key，则最后一个起作用  
//}) 

//spring 4.1中，支持@PropertySources 
//@PropertySources({  
//@PropertySource("classpath:config.properties"),  
//@PropertySource("classpath:db.properties")  
//})  
@PropertySource({"classpath:application.properties"})	
@EnableScheduling		//开启定时任务
//Spring Boot 默认的配置文件位于根路径下，之所以默认扫描那个文件，是在父工程中配置的
//叫 application.properties,可以直接使用@Value("${host}")，在类中取出里面的配置

//@ImportResource(locations={"classpath:application-bean.xml"})	引入xml的配置
public class Application extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(Application.class);
	}
//    // 用于处理编码问题
//    @Bean
//    public Filter characterEncodingFilter() {
//        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//        characterEncodingFilter.setEncoding("UTF-8");
//        characterEncodingFilter.setForceEncoding(true);
//        return characterEncodingFilter;
//    }
}
