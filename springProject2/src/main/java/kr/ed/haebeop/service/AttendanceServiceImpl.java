package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Attendance;
import kr.ed.haebeop.domain.Member;
import kr.ed.haebeop.persistence.AttendanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceMapper attendanceMapper;

    @Autowired
    private MemberService memberService;

    @Override
    public List<Attendance> attendanceAllList(String dateYearMonth) throws Exception {
        return attendanceMapper.attendanceAllList(dateYearMonth);
    }

    @Override
    public List<Attendance> attendanceList(Attendance attendance) throws Exception {
        Member member = new Member();
        member.setId(attendance.getAuthor());
        member.setPoint(10);
        memberService.memberUpdatePoint(member);
        return attendanceMapper.attendanceList(attendance);
    }

    @Override
    public int attendanceListCount(Attendance attendance) throws Exception {
        return attendanceMapper.attendanceListCount(attendance);
    }

    @Override
    public void attendanceUserInsert(Attendance attendance) throws Exception {
        attendanceMapper.attendanceUserInsert(attendance);
    }

    // 종료시 한달 다채웠으면 + 1000pt
    @Scheduled(cron = "59 59 23 L * *")
    public void autoUpdateNewMonth() throws Exception {

        LocalDate now = LocalDate.now();
        DateTimeFormatter dateYearMonth = DateTimeFormatter.ofPattern("yyyyMM");
        String yearMonth = now.format(dateYearMonth);
        int day = now.lengthOfMonth();

        List<Member> memberList = memberService.getMemberId();
        for(Member mem : memberList) {
            Attendance attend = new Attendance();
            attend.setAuthor(mem.getId());
            attend.setDateYearMonth(yearMonth);
            int cnt = this.attendanceListCount(attend);
            if(day == cnt) {
                Member member = new Member();
                member.setId(mem.getId());
                member.setPoint(20);
                memberService.memberUpdatePoint(member);
            }
        }

    }

}