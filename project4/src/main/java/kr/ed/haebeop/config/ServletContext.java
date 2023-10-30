package kr.ed.haebeop.config;

import kr.ed.haebeop.util.AdminInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"kr.ed.haebeop"})
public class ServletContext implements WebMvcConfigurer {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        registry.viewResolver(bean);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resource/**").addResourceLocations("/resource/");
        registry.addResourceHandler("/admin/**").addResourceLocations("/WEB-INF/views/admin");
        registry.addResourceHandler("/course/**").addResourceLocations("/WEB-INF/views/course");
        registry.addResourceHandler("/community/**").addResourceLocations("/WEB-INF/views/community");
        registry.addResourceHandler("/courseRegister/**").addResourceLocations("/WEB-INF/views/courseRegister");
        registry.addResourceHandler("/include/**").addResourceLocations("/WEB-INF/views/include");
        registry.addResourceHandler("/member/**").addResourceLocations("/WEB-INF/views/member");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin/**");
    }
}
