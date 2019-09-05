package xy.commer.cloud.main;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * 
 * service 服务 springboot 核心启动类
 * 
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.commer.app.service.impl" }, includeFilters = {
		@Filter(classes = { Service.class }) })
@ImportResource(locations = { "classpath:dubboprovider.xml" })
@MapperScan("xy.commer.cloud.main.mapper")
public class ServiceMian {

	@Bean(initMethod = "init", destroyMethod = "close")
	//数据源以spring.datasource大头
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return new DruidDataSource();
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		//加载mybatis的映射文件
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:/mybatis-mapping/*Mapper.xml"));
		return sqlSessionFactoryBean.getObject();
	}

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ServiceMian.class, args);
		System.out.println("xy-commer-service-服务运行中...");
		System.in.read();
	}
}
