package kr.ed.haebeop.config;


import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"kr.ed.haebeop.service"})
@MapperScan(basePackages = {"kr.ed.haebeop.persistence"})
public class RootConfig {
    @Autowired
    ApplicationContext applicationContext;


    // 드라이버매니저 연결
    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mariadb://localhost:3306/haebeop");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("1234");
        return basicDataSource;
    }

    // sql을 대신할 my-batis 설정
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:/mybatis-config.xml"));
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:/mappers/**/*Mapper.xml"));
        sqlSessionFactoryBean.setDataSource(dataSource());
        return (SqlSessionFactory) sqlSessionFactoryBean.getObject();
    }

    // sqlsession 객체 주입
    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception{
        return new SqlSessionTemplate((SqlSessionFactory) sqlSessionFactoryBean());
    }



    // 트랜잭션 및 DB 패키비지 방안 및 각종 로깅과 보안 설정
    @Bean
    public DataSourceTransactionManager transactionManager(){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

    // 멀티파트 리졸버
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("UTF-8");
        multipartResolver.setMaxUploadSize(52428800); // 파일 사이즈
        multipartResolver.setMaxInMemorySize(1048576); // 메모리 사이즈 1MB
        return multipartResolver;
    }
    // 멀티파트 업로드 디렉토리
    @Bean
    public String uploadPath() {return "D:\\sangmin0816\\spring\\springframwork2\\src\\main\\webapp\\resources\\upload";}


    // 로케일 설정
    @Bean
    public SessionLocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("ko", "KR"));
        return localeResolver;
    }

    // 다국어 처리
    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
