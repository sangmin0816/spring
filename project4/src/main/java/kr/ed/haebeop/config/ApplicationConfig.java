package kr.ed.haebeop.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.ed.haebeop.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"kr.ed.haebeop.service"})
public class ApplicationConfig {
    @Bean
    public ObjectMapper mapper() { return new ObjectMapper();}

    @Bean
    public BookService bookService() {return new BookServiceImpl();}

    @Bean
    public CommentService commentService() {return new CommentServiceImpl();}

    @Bean
    public CourseAttendanceService courseAttendanceService() {return new CourseAttendanceServiceImpl();}

    @Bean
    public CourseService courseService() {return new CourseServiceImpl();}

    @Bean
    public CourseMaterialsService courseMaterialsService() {return new CourseMaterialsServiceImpl();}

    @Bean
    public CourseNoticeService courseNoticeService() {return new CourseNoticeServiceImpl();}

    @Bean
    public CourseQnaService courseQnaService() {return new CourseQnaServiceImpl();}

    @Bean
    public FreeService freeService() {return new FreeServiceImpl();}

    @Bean
    public MemberService memberService() {return new MemberServiceImpl();}

    @Bean
    public NoticeService noticeService() {return new NoticeServiceImpl();}

    @Bean
    public RegisterService registerService() {return new RegisterServiceImpl();}

    @Bean
    public StorageService storageService() {return new StorageServiceImpl();}

    @Bean
    public TeacherService teacherService() {return new TeacherServiceImpl();}
}
