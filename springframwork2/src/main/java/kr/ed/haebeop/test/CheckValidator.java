package kr.ed.haebeop.test;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

public class CheckValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Check.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors error) {
        System.out.println("Springframework Validation");
        Check check = (Check) obj;
        ValidationUtils.rejectIfEmpty(error, "id", "check.id.empty", "아이디를 입력해주세요");
        ValidationUtils.rejectIfEmpty(error, "pw", "check.pw.empty", "비밀번호를 입력해주세요");
        //아이디 패턴 - 영문 소문자와 숫자 조합 글자 길이 5~12 글자 사이의 유효성 패턴
        Pattern pat1 = Pattern.compile("^[a-z0-9]{5,12}$", Pattern.CASE_INSENSITIVE);
        //비밀번호 패턴 - 영문 소문자 대문자, 숫자 조합 8~12 글자 사이의 유효성 패턴
        Pattern pat2 = Pattern.compile("^[a-zA-Z0-9]{8,12}$", Pattern.CASE_INSENSITIVE);
        if(!(pat1.matcher(check.getId()).matches())){
            error.rejectValue("id", "check.id.invalid");
        }
        if(!(pat2.matcher(check.getPw()).matches())){
            error.rejectValue("pw", "check.pw.invalid");
        }
    }
}
