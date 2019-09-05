package xy.commer.cloud.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import xy.commer.cloud.entity.User;
import xy.commer.cloud.service.UserService;

@SpringBootApplication
@ImportResource(locations = { "classpath:dubbo-consumer.xml" })
public class CustMain {
	public static void main(String[] args) {
		ApplicationContext tc = SpringApplication.run(CustMain.class, args);
		UserService userService = (UserService) tc.getBean("userService");
		User user = userService.findUserById(1l);
		System.err.println(user.toString());
	}

	/*
	 * @Configuration static class WebMvcConfigurer extends
	 * WebMvcConfigurerAdapter {
	 * 
	 * public void addInterceptors(InterceptorRegistry registry) {
	 * registry.addInterceptor(new HandlerInterceptorAdapter() {
	 * 
	 * @Override public boolean preHandle(HttpServletRequest request,
	 * HttpServletResponse response, Object handler) throws Exception {
	 * 
	 * HttpSession userVo = request.getSession(); String uVo =
	 * request.getSession().getId(); request.getContextPath();
	 * System.out.println("interceptor===="); return true; }
	 * }).addPathPatterns("/*"); } }
	 */

	/*
	 * @Bean public EmbeddedServletContainerCustomizer containerCustomizer() {
	 * 
	 * return (container -> { ErrorPage error401Page = new
	 * ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html"); ErrorPage error404Page =
	 * new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"); ErrorPage error500Page
	 * = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
	 * 
	 * container.addErrorPages(error401Page, error404Page, error500Page); }); }
	 */
}
