package kr.ed.haebeop.util;

import kr.ed.haebeop.domain.Days365;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DatePicker {
   //달력 구하기
   public List<String[]> getDatePicker(String yyyymm) throws Exception {
       int year = Integer.parseInt(yyyymm.substring(0, 4));       //해당 년도 추출
       int month = Integer.parseInt(yyyymm.substring(4));    //해당 월 추출

       Calendar cal = Calendar.getInstance();

       //입력 받은 년도, 월, 일
       cal.set(Calendar.YEAR, year); //입력받은 년도로 세팅
       cal.set(Calendar.MONTH, month); //입력받은 월로 세팅
       cal.set(year,month-1,1); //입력받은 월의 1일로 세팅

       int end = cal.getActualMaximum(Calendar.DATE); //해당 월 마지막 날짜
       int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //해당 날짜의 요일(1:일요일 … 7:토요일)

       List<String[]> calList = new ArrayList<>();
       int n = 1;
       for(int i=1;i<=5;i++){
           String[] week = {"  ", "  ", "  ","  ","  ","  ","  "};
           for(int j=0;j<7;j++){
               if(i!=1 || j+1>=dayOfWeek) {
                   if(n<=9){
                       // week[j] = " "+n;
                       week[j] = Integer.toString(n);
                   } else {
                       week[j] = Integer.toString(n);
                   }
                   n++;
               } else {
                   week[j] = "  ";
               }
               if(n>end) break;
           }
           calList.add(week);
       }
       return calList;
   }

   //국경일 생성 - 명절 및 석탄일 제외
   public List<Days365> generatorHoliday(String yyyy){
       List<Days365> daysList = new ArrayList<>();

       String[][] daysArray = {{"0101","신정"}, {"0301","삼일절"}, {"0505","어린이날"}, {"0606", "현충일"},
               {"0815","광복절"}, {"1003","개천절"}, {"1009","한글날"}, {"1225","성탄절"}};

       for(String[] days:daysArray) {
           Days365 day365 = new Days365();
           Calendar cal = Calendar.getInstance();
           String month = days[0].substring(0, 2);
           String day = days[0].substring(2, 4);
           cal.set(Integer.parseInt(yyyy),Integer.parseInt(month)-1,Integer.parseInt(day));
           day365.setCal(cal);
           day365.setName(days[1]);
           daysList.add(day365);
       }

       return daysList;
   }
   //요일 구하기
   public String generateWeekDay(Calendar cal){
       String wk = "";
       int weekday = cal.get(Calendar.DAY_OF_WEEK);
       switch(weekday) {
           case 1:
               wk = "일요일";               break;
           case 2:
               wk = "월요일";               break;
           case 3:
               wk = "화요일";               break;
           case 4:
               wk = "수요일";               break;
           case 5:
               wk = "목요일";               break;
           case 6:
               wk = "금요일";               break;
           case 7:
               wk = "토요일";               break;
       }
       return wk;
   }
   //요일 생성2
    public String generateWeekDay2(Calendar cal) {
        String[] week = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
        int d = cal.get(Calendar.DAY_OF_WEEK);
        return week[d-1];
    }
    //Calendar를 String으로 변환
    public String CalendarParseString(Calendar cal) {
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       String data = sdf.format(cal.getTime());
       return data;
    }
    //Date를 String으로 변환
    public String DateParseString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String data = sdf.format(date);
        return data;
    }
    //String을 Date로 변환
    public Date stringParseDate(String data) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date =  sdf.parse(data);
        return date;
    }
    //String을 Calendar로 변환
    public Calendar stringParseCalendar(String data) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(data);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
    //Date를 Calendar로 변환
    public Calendar dateParseCalendar(Date date) {
       Calendar cal = Calendar.getInstance();
       cal.setTime(date);
       return cal;
    }
    //Calendar를 Date로 변환
    public Date calendarParseDate(Calendar cal){
       Date date = cal.getTime();
       return date;
    }
}
