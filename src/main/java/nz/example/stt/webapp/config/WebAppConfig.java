package nz.example.stt.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.extras.tiles2.dialect.TilesDialect;
import org.thymeleaf.extras.tiles2.spring.web.configurer.ThymeleafTilesConfigurer;
import org.thymeleaf.extras.tiles2.spring.web.view.ThymeleafTilesView;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan("nz.example.stt.webapp")
public class WebAppConfig {

    @Bean
    public ThymeleafTilesConfigurer thymeleafTilesConfigurer() {
        return new ThymeleafTilesConfigurer();
    }

    @Bean
    public ViewResolver viewResolver(final SpringTemplateEngine templateEngine) {

        final ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        viewResolver.setViewClass(ThymeleafTilesView.class);

        return viewResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(final TemplateResolver templateResolver, final TilesDialect tilesDialect) {

        final SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver);
        engine.addDialect(tilesDialect);

        return engine;
    }

    @Bean
    public TilesDialect tilesDialect() {
        return new TilesDialect();
    }

    @Bean
    public TemplateResolver templateResolver() {

        final TemplateResolver resolver = new ServletContextTemplateResolver();
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");

        return resolver;
    }
}
