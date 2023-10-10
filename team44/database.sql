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
	id VARCHAR(20) PRIMARY KEY,   -- (아이디)
	pw VARCHAR(300) NOT NULL,   -- (비밀번호)
	NAME VARCHAR(100) NOT NULL,   -- (이름)
	email VARCHAR(100) NOT NULL,   -- (이메일)
	tel VARCHAR(13),   -- (전화번호)
	addr1 VARCHAR(200), -- 주소
	addr2 VARCHAR(100), -- 상세 주소
	postcode VARCHAR(10), -- 우편번호
	regdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- (가입일)
	birth DATE, -- 생일
	POINT INT DEFAULT 0,   -- (포인트)
	grade INT DEFAULT 1 -- 등급: 0 관리자, 1 학부모, 2 선생님, 3 학생
);

INSERT INTO MEMBER VALUES('admin', '$2a$10$oS1.3wpbnpIanIW4RoXxSOea/vGIijBMpLUBxZqurQqNjjMiJHgGa', '관리자', 'admin@tspoon.co.kr', '010-1234-5678', '', '', '', DEFAULT, NULL, DEFAULT, 0);

-- free
CREATE TABLE free(
	fno INT PRIMARY KEY AUTO_INCREMENT,   -- (게시글 번호) 자동 발생
	title VARCHAR(200) NOT NULL,   -- (게시글 제목)
	content VARCHAR(1000),   -- (게시글 내용)
	author VARCHAR(16) NOT NULL,   -- (작성자)
	regdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- (등록일)
	visited INT DEFAULT 0   -- (조회수)
);

-- comment
CREATE TABLE comment(
	cno INT PRIMARY KEY AUTO_INCREMENT,   -- (댓글번호) 자동발생
	author VARCHAR(16) NOT NULL,   -- (댓글 작성자)
	content VARCHAR(1000) NOT NULL,   -- (댓글 내용)
	regdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- (댓글 등록일)
	par INT(11) NOT NULL   -- (해당 게시글 번호)
);

-- notice
CREATE TABLE notice(
   no INT PRIMARY KEY AUTO_INCREMENT,   -- (게시글 번호) 자동 발생
   title VARCHAR(200) NOT NULL,   -- (게시글 제목)
   content VARCHAR(1000),   -- (게시글 내용)
   regdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- (등록일)
   visited INT DEFAULT 0   -- (조회수)
);

-- qna
CREATE TABLE qna(
	qno INT PRIMARY KEY AUTO_INCREMENT,   -- (문의번호) 자동발생
	title VARCHAR(100) NOT NULL,   -- (문의 제목)
	content VARCHAR(1000) NOT NULL,   -- (문의 내용)
	author VARCHAR(16),   -- (문의 작성자)
	regdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),   -- (문의 등록)
	visited INT DEFAULT 0,   -- (조회수)
	lev INT DEFAULT 0, -- 질문(0), 답변(1)
	par INT DEFAULT 0	-- 부모 글번호 -> 질문(자신 레코드의 qno), 답변(질문의 글번호)
);

-- 학습 자료실
CREATE TABLE dataBoard(
	bno INT PRIMARY KEY AUTO_INCREMENT,   -- (게시글 번호) 자동 발생
	title VARCHAR(200) NOT NULL,   -- (게시글 제목)
	content VARCHAR(1000),   -- (게시글 내용)
	author VARCHAR(16) NOT NULL,   -- (작성자)
	regdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- (등록일)
	visited INT DEFAULT 0,   -- (조회수)
	isFile BOOLEAN DEFAULT false
);

CREATE TABLE dataFile(
	fno INT primary KEY AUTO_INCREMENT,
	fileName VARCHAR(100),
	saveName VARCHAR(100),
	fileType VARCHAR(100),
	saveFolder VARCHAR(100),
	bno INT NOT NULL,
	relations VARCHAR(20)
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
   uno INT AUTO_INCREMENT PRIMARY KEY,								-- 질문자 번호 : 자동증가
   vno INT NOT NULL,												-- 질문지 해당 투표번호
   lno INT NOT NULL,												-- 질문지 해당 번호
   author VARCHAR(20) NOT NULL										-- 질문자 아이디
);

CREATE VIEW voteCount AS (SELECT l.lno AS lno, l.vno AS vno, l.title AS title, l.colorNum AS colorNum, COUNT(u.uno) AS cnt FROM voteanswerlist l LEFT JOIN voteansweruser u ON l.lno = u.lno GROUP BY l.lno);

CREATE TABLE attendance (
    seq INT AUTO_INCREMENT PRIMARY KEY,								-- 출석 번호 : 자동증가
    author VARCHAR(20) NOT NULL,									-- 출석 해당 멤버
    dateYearMonth VARCHAR(6) NOT NULL,								-- 해당 년월
    nowDay VARCHAR(2) NOT NULL										-- 출석 날짜
);

CREATE TABLE course(
	cno INT AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(100) NOT NULL, -- 제목
	content VARCHAR(2000), -- 내용
	teacher VARCHAR(20), -- 강사 아이디
	maxStudent INT DEFAULT 0, -- 수강생 최대 정원
	price INT DEFAULT 0
);

CREATE TABLE lecture(
	lno INT AUTO_INCREMENT PRIMARY KEY,
	course INT NOT NULL,
	title VARCHAR(100) NOT NULL,
	content VARCHAR(2000),
	isFile BOOLEAN DEFAULT false
);

CREATE TABLE classroom(
	cno INT AUTO_INCREMENT PRIMARY KEY,
	course INT NOT NULL, -- 강의코드
	id VARCHAR(20) NOT NULL, -- 수강생 아이디
	totalTime INT DEFAULT 0,
	state BOOLEAN DEFAULT FALSE -- 수강 완료 여부
);

CREATE TABLE wishlist(
	wno INT AUTO_INCREMENT PRIMARY KEY,
	course INT NOT NULL -- 강의 코드
);

CREATE TABLE pay(
    payNo INT AUTO_INCREMENT PRIMARY KEY,
    memId VARCHAR(20),
    course INT NOT NULL,
    payPrice INT,
    amount INT DEFAULT 1,
    method VARCHAR(50),
    pcom VARCHAR(100),
    paccount VARCHAR(100)
);