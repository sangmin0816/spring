CREATE DATABASE haebeop;

USE haebeop;

CREATE TABLE test(num INT AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(100) NOT NULL);

INSERT INTO test VALUES (DEFAULT, '테스트제목1');
INSERT INTO test VALUES (DEFAULT, '테스트제목2');
INSERT INTO test VALUES (DEFAULT, '테스트제목3');
INSERT INTO test VALUES (DEFAULT, '테스트제목4');
INSERT INTO test VALUES (DEFAULT, '테스트제목5');

SELECT * from test;

-- member
CREATE TABLE MEMBER(
	id VARCHAR(20) PRIMARY KEY,                             -- (아이디)
	pw VARCHAR(300) NOT NULL,                               -- (비밀번호)
	NAME VARCHAR(100) NOT NULL,                             -- (이름)
	email VARCHAR(100),                                     -- (이메일)
	tel VARCHAR(13),                                        -- (전화번호)
	addr1 VARCHAR(200),                                     -- 주소
	addr2 VARCHAR(100),                                     -- 상세 주소
	postcode VARCHAR(10),                                   -- 우편번호
	regdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- (가입일)
	birth DATE,                                             -- 생일
	POINT INT DEFAULT 0,                                    -- (포인트)
	membership varchar(30) default 'student'                -- admin 관리자, adminU 비인증 관리자, teacher 선생님, teacherU 비인증 선생님
);

INSERT INTO MEMBER(id, pw, name, email, membership) VALUES('admin', '$2a$10$oS1.3wpbnpIanIW4RoXxSOea/vGIijBMpLUBxZqurQqNjjMiJHgGa', '관리자', 'admin@edu.com', 'admin');
INSERT INTO MEMBER(id, pw, name, email, membership) VALUES('teacher', '$2a$10$oS1.3wpbnpIanIW4RoXxSOea/vGIijBMpLUBxZqurQqNjjMiJHgGa', '선생님', 'teacher@edu.com', 'teacher');
INSERT INTO MEMBER(id, pw, name, email, membership) VALUES('academy', '$2a$10$oS1.3wpbnpIanIW4RoXxSOea/vGIijBMpLUBxZqurQqNjjMiJHgGa', '원장님', 'academy@edu.com', 'academy');

-- free
CREATE TABLE free(
	fno INT PRIMARY KEY AUTO_INCREMENT,                     -- (게시글 번호) 자동 발생
	title VARCHAR(200) NOT NULL,                            -- (게시글 제목)
	content VARCHAR(1000),                                  -- (게시글 내용)
	author VARCHAR(16) NOT NULL,                            -- (작성자)
	regdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- (등록일)
	visited INT DEFAULT 0                                   -- (조회수)
);

-- comment
CREATE TABLE comment(
	cno INT PRIMARY KEY AUTO_INCREMENT,                     -- (댓글번호) 자동발생
	author VARCHAR(16) NOT NULL,                            -- (댓글 작성자)
	content VARCHAR(1000) NOT NULL,                         -- (댓글 내용)
	regdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- (댓글 등록일)
	par INT(11) NOT NULL                                    -- (해당 게시글 번호)
);

-- notice
CREATE TABLE notice(
   no INT PRIMARY KEY AUTO_INCREMENT,                       -- (게시글 번호) 자동 발생
   title VARCHAR(200) NOT NULL,                             -- (게시글 제목)
   content VARCHAR(1000),                                   -- (게시글 내용)
   regdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,    -- (등록일)
   visited INT DEFAULT 0                                    -- (조회수)
);

-- qna
CREATE TABLE qna(
	qno INT PRIMARY KEY AUTO_INCREMENT,                 -- (문의번호) 자동발생
	title VARCHAR(100) NOT NULL,                        -- (문의 제목)
	content VARCHAR(1000) NOT NULL,                     -- (문의 내용)
	author VARCHAR(16),                                 -- (문의 작성자)
	regdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),      -- (문의 등록)
	visited INT DEFAULT 0,                              -- (조회수)
	lev INT DEFAULT 0,                                  -- 질문(0), 답변(1)
	par INT DEFAULT 0	                                -- 부모 글번호 -> 질문(자신 레코드의 qno), 답변(질문의 글번호)
);

-- 학습 자료실
CREATE TABLE dataBoard(
	bno INT PRIMARY KEY AUTO_INCREMENT,                     -- (게시글 번호) 자동 발생
	title VARCHAR(200) NOT NULL,                            -- (게시글 제목)
	content VARCHAR(1000),                                  -- (게시글 내용)
	author VARCHAR(16) NOT NULL,                            -- (작성자)
	regdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- (등록일)
	visited INT DEFAULT 0,                                  -- (조회수)
	hasFile BOOLEAN DEFAULT false                           -- 프로필 사진
);

insert into dataBoard(title, content, author) values('title1', 'content1', 'admin');

CREATE TABLE dataFile(
	fno INT primary KEY AUTO_INCREMENT, -- 파일 번호
	fileName VARCHAR(100),              -- 파일 원본 이름
	saveName VARCHAR(100),              -- 파일 저장 이름
	fileType VARCHAR(100),              -- 파일 타입
	saveFolder VARCHAR(100),            -- 파일 저장 폴더
	bno INT NOT NULL,                   -- 파일을 저장한 게시글 번호
	relations VARCHAR(20)               -- 파일을 저장한 게시판 타입
);

CREATE TABLE vote(
    vno INT AUTO_INCREMENT PRIMARY KEY,								    -- 투표번호 : 자동증가
    title VARCHAR(200) NOT NULL,										-- 투표제목
    content VARCHAR(1000) NOT NULL,									    -- 투표내용
    regDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,		        -- 투표등록일
    visited INT DEFAULT 0,												-- 조회수
    startDate DATE,														-- 투표 시작일
    finishDate DATE,													-- 투표 종료일
    useYn BOOLEAN DEFAULT FALSE,										-- 투표 사용여부 - 사용자 화면에 띄울지 말지 선택
    stateYn BOOLEAN DEFAULT TRUE,										-- 투표 상태여부 - 종료, 진행 상태
    answer INT,															-- 투표 결과 lno
    addPt INT NOT NULL 													-- 완료후 등록될 포인트
);

CREATE TABLE voteAnswerList(
   lno INT AUTO_INCREMENT PRIMARY KEY,								-- 질문지 내역 번호 : 자동증가
   vno INT NOT NULL,												-- 질문지 해당 투표번호
   title VARCHAR(200) NOT NULL,										-- 질문지 제목
   colorNum VARCHAR(10) NOT NULL                                    -- 투표율 색상지정
);

CREATE TABLE voteAnswerUser(
   uno INT AUTO_INCREMENT PRIMARY KEY,		-- 질문자 번호 : 자동증가
   vno INT NOT NULL,						-- 질문지 해당 투표번호
   lno INT NOT NULL,						-- 질문지 해당 번호
   author VARCHAR(20) NOT NULL				-- 질문자 아이디
);

CREATE VIEW voteCount AS (SELECT l.lno AS lno, l.vno AS vno, l.title AS title, l.colorNum AS colorNum, COUNT(u.uno) AS cnt FROM voteanswerlist l LEFT JOIN voteansweruser u ON l.lno = u.lno GROUP BY l.lno);

CREATE TABLE attendance (
    seq INT AUTO_INCREMENT PRIMARY KEY,			-- 출석 번호 : 자동증가
    author VARCHAR(20) NOT NULL,				-- 출석 해당 멤버
    dateYearMonth VARCHAR(6) NOT NULL,			-- 해당 년월
    nowDay VARCHAR(2) NOT NULL					-- 출석 날짜
);

create table academy(
    ano INT AUTO_INCREMENT PRIMARY KEY,     -- 가맹점 번호
    id varchar(20),                         -- 가맹점 관리자 아이디
    name varchar(100),                      -- 가맹점 이름
    address varchar(100),                   -- 가맹점 주소
    tel varchar(15),                        -- 가맹점 번호
    email varchar(50),                      -- 가맹점 이메일
    city varchar(20),                       -- 가맹점 시/도
    district varchar(30),                   -- 가맹점 구/군
    opentime TIME DEFAULT '13:00:00',       -- 개점 시간
    closetime TIME DEFAULT '20:00:00',      -- 폐점 시간
    capacity int default 2                  -- 예약 최대 인원
);

insert into academy(name) values('academy example');

create table reservation(
    rno INT AUTO_INCREMENT PRIMARY KEY,     -- 예약 번호
    id varchar(20),                         -- 예약자 아이디
    ano INT,                                -- 가맹점 번호
    rdate DATE,                             -- 예약 날짜
    rtime TIME,                             -- 예약 시간
    status varchar(20) default 'pending'    -- 예약 확정 여부
);

create table unavailable(
    uno INT AUTO_INCREMENT PRIMARY KEY,     -- 휴일 번호
    academy INT,                            -- 가맹점 번호
    rdate DATE,                             -- 예약 불가 날짜
    reason varchar(50)                      -- 예약 불가 사유
);

CREATE TABLE category(
    categoryNo INT AUTO_INCREMENT PRIMARY KEY,  -- 카테고리 번호
    main varchar(100),                          -- 카테고리 대분류
    sub varchar(100)                            -- 카테고리 소분류
);

CREATE TABLE course(
	courseNo INT AUTO_INCREMENT PRIMARY KEY,    -- 과정 이름
    category INT NOT NULL,                      -- 카테고리 번호
	title VARCHAR(100) NOT NULL,                -- 제목
	content VARCHAR(2000),                      -- 내용
	teacher VARCHAR(20),                        -- 강사 아이디
	price INT DEFAULT 0                         -- 과정 가격
);

CREATE TABLE lecture(
	lno INT AUTO_INCREMENT PRIMARY KEY,     -- 강의 번호
	course INT NOT NULL,                    -- 강의가 속한 과정의 번호
	title VARCHAR(100) NOT NULL,            -- 제목
	content VARCHAR(2000),                  -- 내용
	hasFile BOOLEAN DEFAULT false           -- 강의 파일
);

CREATE TABLE myCourse(
	mno INT AUTO_INCREMENT PRIMARY KEY,     -- 내가 구매한 과정 번호
	course INT NOT NULL,                    -- 과정 번호
	id VARCHAR(20) NOT NULL,                -- 수강생 아이디
	totalTime INT DEFAULT 0,                -- 총 수강 시간
	state BOOLEAN DEFAULT FALSE             -- 수강 완료 여부
);

-- 교재(교재코드, 교재명, 교재목차, 출판사, 출판일, 저자, 가격, 교재파일, 기타메모)
CREATE TABLE book(
    bno INT AUTO_INCREMENT PRIMARY KEY,     -- 교재 번호
    title varchar(100) not null,            -- 교재 이름
    content varchar(1000),                  -- 교재 소개
    writer varchar(100),                    -- 교재 저자
    bindex varchar(500),                    -- 교재 목차
    publisher varchar(100),                 -- 교재 출판사
    pubdate DATE,                           -- 교재 출판일
    price int default 0,                    -- 교재 가격
    hasFile boolean default false           -- 교재 관련 파일
);

CREATE TABLE wishlist(
	wno INT AUTO_INCREMENT PRIMARY KEY,     -- 찜 번호
	course INT NOT NULL                     -- 과정 코드
);

CREATE TABLE pay(
    payNo INT AUTO_INCREMENT PRIMARY KEY,   -- 결제 번호
    memId VARCHAR(20),                      -- 결제한 아이디
    course INT NOT NULL,                    -- 과정 번호
    payPrice INT,                           -- 과정 가격
    amount INT DEFAULT 1,                   -- 수량
    method VARCHAR(50),
    pcom VARCHAR(100),
    paccount VARCHAR(100)
);