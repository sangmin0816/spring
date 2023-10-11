package kr.ed.haebeop.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.ed.haebeop.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"kr.ed.haebeop.repository", "kr.ed.haebeop.service"})
public class ApplicationConfig {
    @Bean
    public ObjectMapper mapper() { return new ObjectMapper(); }

    @Bean
    public AttendanceService attendanceService() {return new AttendanceServiceImpl();}

    @Bean
    public DataBoardService dataBoardService() {return new DataBoardServiceImpl();}

    @Bean
    public CommentService commentService() {return new CommentServiceImpl();}

    @Bean
    public DataFileService dataFileService() {return new DataFileServiceImpl();}

    @Bean
    public FreeService freeService() {return new FreeServiceImpl();}

    @Bean
    public NoticeService noticeService() {return new NoticeServiceImpl();}

    @Bean
    public QnaService qnaService() {return new QnaServiceImpl();}

    @Bean
    public MemberService memberService() {return new MemberServiceImpl();}

    @Bean
    public VoteService voteService() {return new VoteServiceImpl();}


    @Bean
    public TestService testService(){return new TestServiceImpl();}
}
