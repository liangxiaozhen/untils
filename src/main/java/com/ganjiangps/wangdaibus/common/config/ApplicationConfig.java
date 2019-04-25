package com.ganjiangps.wangdaibus.common.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.mobile.device.DeviceHandlerMethodArgumentResolver;
import org.springframework.mobile.device.DeviceResolverHandlerInterceptor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.ganjiangps.wangdaibus.common.interceptor.JumpH5Interceptor;
import com.ganjiangps.wangdaibus.common.interceptor.User406Interceptor;
import com.ganjiangps.wangdaibus.common.interceptor.UserApiInterceptor;
import com.ganjiangps.wangdaibus.common.interceptor.UserHTMLInterceptor;
import com.ganjiangps.wangdaibus.common.interceptor.UserPcInterceptor;

@Configuration
public class ApplicationConfig extends WebMvcConfigurationSupport {
	
	/** spring-mobile配置 Start   具体请看  https://projects.spring.io/spring-mobile/ **/
	@Bean
	public DeviceResolverHandlerInterceptor deviceResolverHandlerInterceptor() {
	    return new DeviceResolverHandlerInterceptor();
	}

	@Bean
	public DeviceHandlerMethodArgumentResolver deviceHandlerMethodArgumentResolver() {
	    return new DeviceHandlerMethodArgumentResolver();
	}
 	
	@Bean
	public JumpH5Interceptor jumpH5Interceptor(){
		//特别注意：拦截器是默认是不被spring context控制的
		return new JumpH5Interceptor();
	}
	
	@Bean
	public UserApiInterceptor userApiInterceptor(){
		//特别注意：拦截器是默认是不被spring context控制的
		return new UserApiInterceptor();
	}
	
	@Bean
	public UserPcInterceptor userPcInterceptor(){
		//特别注意：拦截器是默认是不被spring context控制的
		return new UserPcInterceptor();
	}
	
	@Bean
	public UserHTMLInterceptor userHTMLInterceptor(){
		//特别注意：拦截器是默认是不被spring context控制的
		return new UserHTMLInterceptor();
	}
	
	@Bean
	public User406Interceptor user406Interceptor(){
		//特别注意：拦截器是默认是不被spring context控制的
		return new User406Interceptor();
	}
	  
	@Bean
    public FilterRegistrationBean urlRewrite(){
        UrlRewriteFilter rewriteFilter = new UrlRewriteFilterConfig();
        FilterRegistrationBean registration = new FilterRegistrationBean(rewriteFilter);
        registration.setUrlPatterns(Arrays.asList("/*"));
        Map initParam=new HashMap();
         initParam.put("confPath","urlrewirte.xml");
         initParam.put("infoLevel","INFO");
        registration.setInitParameters(initParam);
        return  registration;
    }
   
	/**
     * 文件上传配置
     * 
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        factory.setMaxFileSize("10MB"); // KB,MB
        /// 总上传数据大小
        factory.setMaxRequestSize("100MB");
        return factory.createMultipartConfig();
    }
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(deviceResolverHandlerInterceptor());
	    
	    //官网跳转h5 实现 返回拦截器
//	    registry.addInterceptor(jumpH5Interceptor())
//	    		.addPathPatterns("/**")
//	    		.excludePathPatterns("/api/**")
// 	    		.excludePathPatterns("/htmluser/**");
	    
	    //api 返回拦截器
	    registry.addInterceptor(userApiInterceptor())
	    		.addPathPatterns("/api/**")
	    		.excludePathPatterns("/api/login")
	    		.excludePathPatterns("/api/register")
	    		.excludePathPatterns("/api/ssmRegCode")
	    		.excludePathPatterns("/api/generateUserName")
 	    		.excludePathPatterns("/api/refreshToken");
	    //PC 返回拦截器
	    registry.addInterceptor(userPcInterceptor())
	    		.addPathPatterns("/user/**")
	    		.addPathPatterns("/product/productDeclareRecord/members");//会员申报
	    //html5 返回拦截器
	    registry.addInterceptor(userHTMLInterceptor())
		    		.addPathPatterns("/htmluser/**");
	    
	    //406 返回拦截器
	    registry.addInterceptor(user406Interceptor())
		    		.addPathPatterns("/406/**")
		    		.addPathPatterns("/userBankCard/**")
		    		.addPathPatterns("/userMessage/**");
	    		 
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
	    argumentResolvers.add(deviceHandlerMethodArgumentResolver());
	}
 	/** spring-mobile配置 end **/
	
	//配置JSP视图解析器
	@Bean
	public ViewResolver viewResolver() {  
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	//配置静态资源
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/robots.txt").addResourceLocations("/");
		registry.addResourceHandler("/sitemap.xml").addResourceLocations("/");
		registry.addResourceHandler("/sitemap_article.xml").addResourceLocations("/");
		registry.addResourceHandler("/sitemap_thread_1.xml").addResourceLocations("/");
		registry.addResourceHandler("/sitemap_thread_2.xml").addResourceLocations("/");
		registry.addResourceHandler("/sitemap_thread_3.xml").addResourceLocations("/");
		registry.addResourceHandler("/sitemap_thread_4.xml").addResourceLocations("/");
		registry.addResourceHandler("/sitemap_thread_5.xml").addResourceLocations("/");
		registry.addResourceHandler("/data/**").addResourceLocations("/data/");
 		registry.addResourceHandler("/portal/**").addResourceLocations("/portal/");
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
		registry.addResourceHandler("/html5/**").addResourceLocations("/html5/");
		registry.addResourceHandler("/xiaomifeng/**").addResourceLocations("/xiaomifeng/");
  		registry.addResourceHandler("/waterimages/**").addResourceLocations("/waterimages/");
		registry.addResourceHandler("/uc_server/**").addResourceLocations("/uc_server/");
		registry.addResourceHandler("/source/**").addResourceLocations("/source/");
 		registry.addResourceHandler("/frontContent/image/**").addResourceLocations("file:F:/upload/frontContent/");
 		
 		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
 		registry.addResourceHandler("/font/**").addResourceLocations("/font/");
 		registry.addResourceHandler("/img/**").addResourceLocations("/img/");
 		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
 		registry.addResourceHandler("/laydate/**").addResourceLocations("/laydate/");
 		registry.addResourceHandler("/layer/**").addResourceLocations("/layer/");
 		
  		super.addResourceHandlers(registry);
	}
 	
	//配置fastjson 中文乱码
  	@Override
	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		  // 1、需要先定义一个 convert 转换消息的对象;  
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();  
          
        //2、添加fastJson 的配置信息，比如：是否要格式化返回的json数据;  
        FastJsonConfig fastJsonConfig = new FastJsonConfig();  
           
        //2-1 处理中文乱码问题  
        List<MediaType> fastMediaTypes = new ArrayList<>();  
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);  
        fastConverter.setSupportedMediaTypes(fastMediaTypes);  
          
        //3、在convert中添加配置信息.  
        fastConverter.setFastJsonConfig(fastJsonConfig);  
		converters.add(fastConverter);
	}
 }
