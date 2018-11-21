package no.amedia.appnexus.appnexusrest;

import no.amedia.appnexus.appnexusrest.service.AppnexusAuth;
import no.amedia.appnexus.appnexusrest.service.AppnexusReporting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@SpringBootApplication
@EnableAsync
public class AppnexusRestApplication {

	public static void main(String[] args) {

		SpringApplication.run(AppnexusRestApplication.class, args);
	}

	@Bean
	public AppnexusAuth appnexusAuth() {
		return new AppnexusAuth();
	}

	@Bean
	public AppnexusReporting appnexusReporting() {return new AppnexusReporting();}

	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setCacheable(false);
		templateResolver.setPrefix("classpath:/templates/");
		templateResolver.setSuffix(".html");
		return templateResolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
		springTemplateEngine.addTemplateResolver(templateResolver());
		return springTemplateEngine;
	}

	@Bean
	public ThymeleafViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setOrder(1);
		return viewResolver;
	}

}
