package kr.ed.haebeop.util;

import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.ChineseCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LunarCalendar {
    //음력 구하기
    public String getLunar(String today) {

        ChineseCalendar chinaCal = new ChineseCalendar();
        Calendar cal = Calendar.getInstance() ;

        cal.set(Calendar.YEAR, Integer.parseInt(today.substring(0, 4)));
        cal.set(Calendar.MONTH, Integer.parseInt(today.substring(5, 7)) - 1);
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(today.substring(8, 10)));
        chinaCal.setTimeInMillis(cal.getTimeInMillis());

        int chinaYY = chinaCal.get(ChineseCalendar.EXTENDED_YEAR) - 2637 ;
        int chinaMM = chinaCal.get(ChineseCalendar.MONTH) + 1;
        int chinaDD = chinaCal.get(ChineseCalendar.DAY_OF_MONTH);

        String chinaDate = "" ;     // 음력 날짜

        chinaDate += chinaYY ;      // 년
        chinaDate += "-" ;          // 연도 구분자

        if(chinaMM < 10) {         // 월
            chinaDate += "0" + Integer.toString(chinaMM);
        } else {
            chinaDate += Integer.toString(chinaMM);
        }

        chinaDate += "-" ;          // 날짜 구분자

        if(chinaDD < 10) {        // 일
            chinaDate += "0" + Integer.toString(chinaDD);
        } else {
            chinaDate += Integer.toString(chinaDD);
        }
        return chinaDate;
    }
    
    //문자열(String)을 Calendar로 변환
    public java.util.Calendar parseCalendar(String data){
        java.util.Calendar cal = java.util.Calendar.getInstance();
        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
        try {
            Date date = sdf.parse(data);
            cal.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cal;
    }
    //Calendar를 문자열(String)으로 변환
    public String parseString(java.util.Calendar cal){
        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
        String str = sdf.format(cal);
        return str;
    }
    //요일 구하기
    public String getWeekday(java.util.Calendar cal){
        String wk = "";
        int weekday = cal.get(java.util.Calendar.DAY_OF_WEEK);
        switch(weekday) {
            case 1:
                wk = "일";               break;
            case 2:
                wk = "월";               break;
            case 3:
                wk = "화";               break;
            case 4:
                wk = "수";               break;
            case 5:
                wk = "목";               break;
            case 6:
                wk = "금";               break;
            case 7:
                wk = "토";               break;
        }
        return wk;
    }
}
