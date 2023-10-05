package kr.ed.haebeop.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.*;
/*
데이터베이스에서 DTO나 VO와 데이터베이스 테이블과 연동하는 JPA 같은 경우에 활용
import javax.persistence.*;
*/

@NoArgsConstructor
@AllArgsConstructor
public class CheckVO {

    @Id
    @Size(min = 5, max=12, message="아이디는 5~10자로 작성해야 합니다.")
    @Pattern(regexp="^[a-z0-9]+$", message="영문 소문자와 숫자 입력이 가능합니다.")
    String id;

    @NotNull
    @Size(min = 8, max= 12, message="비밀번호는 8~20자로 작성해야 합니다.")
    @Pattern(regexp="^[a-zA-Z0-9]+$", message="영문 대소문자와 숫자 입력이 가능합니다.")
    String pw;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }
}
/*
	 	javax.validation 패키지에서 지정 가능한 애노테이션 및 옵션

		@AssertTrue 참이면
		@AssertFalse 거짓이면
		@DecimalMax 지정 값 이하의 실수
		@DecimalMin 지정 값 이상의 실수
		@Digits(integer=, fraction=) 정수 여부
		@Pattern(regexp="()") 원하는 패턴 여부
		@Future 현재 날짜/시간보다 미래 날짜/시간이면
		@Past 현재 날짜/시간보다 과거 날짜/시간이면
		@Max 지정 값 이상
		@Min 지정 값 이하
		@NotNull : Null이 아니면
		@Null : Null이면
		@Size(min=,max=)  문자열 또는 배열등의 길이
 */