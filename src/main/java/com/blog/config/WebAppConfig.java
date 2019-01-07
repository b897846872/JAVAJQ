package com.blog.config;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {
	// 获取配置文件中图片的路径
	@Value("${imagesPath}")
	private String mImagesPath;

	// 访问图片方法
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if (mImagesPath.equals("") || mImagesPath.equals("${imagesPath}")) {
			String imagesPath = WebAppConfig.class.getClassLoader().getResource("").getPath();
			if (imagesPath.indexOf(".jar") > 0) {
				imagesPath = imagesPath.substring(0, imagesPath.indexOf(".jar"));
			} else if (imagesPath.indexOf("classes") > 0) {
				imagesPath = "file:" + imagesPath.substring(0, imagesPath.indexOf("classes"));
			}
			imagesPath = imagesPath.substring(0, imagesPath.lastIndexOf("/")) + "/images/";
			mImagesPath = imagesPath;
		}
		LoggerFactory.getLogger(WebAppConfig.class).info("imagesPath=" + mImagesPath);
		registry.addResourceHandler("/images/**").addResourceLocations("file:/home/images/");
		super.addResourceHandlers(registry);
	}
}
