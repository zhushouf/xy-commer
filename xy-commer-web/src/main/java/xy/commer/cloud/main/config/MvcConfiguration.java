package xy.commer.cloud.main.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * 使用此类是为了让 springboot支持jsp页面
 */
@Configuration
@EnableWebMvc
@ComponentScan
public class MvcConfiguration extends WebMvcConfigurerAdapter {
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/templates/*/*");
		resolver.setSuffix(".html");
		resolver.setViewClass(JstlView.class);
		registry.viewResolver(resolver);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("/");
	}
}
