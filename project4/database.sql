CREATE DATABASE haebeop2;
USE haebeop2;

-- member 회원
CREATE TABLE member(
	id VARCHAR(20) PRIMARY KEY,                             -- (아이디)
	pw VARCHAR(300) NOT NULL,                               -- (비밀번호)
	name VARCHAR(100) NOT NULL,                             -- (이름)
	email VARCHAR(320),                                     -- (이메일)
	tel VARCHAR(13),                                        -- (전화번호)
	addr1 VARCHAR(100),                                     -- (주소)
	addr2 VARCHAR(100),                                     -- (상세 주소)
	postcode VARCHAR(10),                                   -- (우편번호)
	regdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- (가입일)
	birth DATE,                                             -- (생년월일)
	point INT DEFAULT 0,                                    -- (포인트)
	imageFile INT DEFAULT 0,                                -- (프로필 이미지) storage 테이블 번호
	membership varchar(30) default 'student',               -- (회원 유형) admin 관리자, teacher 선생님, student 학생
	isVerify BOOLEAN DEFAULT FALSE                          -- (인증 여부)
);


-- teacher 강사
CREATE TABLE teacher(
    teacherNo INT PRIMARY KEY AUTO_INCREMENT,   -- (강사 번호)
    id VARCHAR(20) NOT NULL ,                   -- (회원 id)
    name VARCHAR(100) NOT NULL,                 -- (강사 이름)
    tel VARCHAR(13),                            -- (강사 연락처)
    email VARCHAR(320),                         -- (강사 이메일)
    imageFile INT DEFAULT 0,                    -- (강사 프로필 이미지, 강좌의 썸네일) storage 테이블 번호
    career VARCHAR(1000)                        -- (강사 약력)
);


-- course 강좌
CREATE TABLE course(
    courseNo INT PRIMARY KEY AUTO_INCREMENT,    -- (강좌 번호)
    teacherNo INT,                              -- (강좌 담당 강사)
    categoryNo INT,                             -- (강좌 분류) 생략 가능. 일단 만들어 둠.
    title VARCHAR(200) NOT NULL,                -- (강좌 이름)
    content VARCHAR(2000),                      -- (강좌 소개)
    videoFile INT DEFAULT 0,                    -- (강좌 맛보기 영상) storage 테이블 번호
    isOngoing BOOLEAN DEFAULT TRUE,             -- (강좌 진행 여부)
    price INT DEFAULT 0,                        -- (강좌 가격)
    capcity INT DEFAULT 1                       -- (강좌 수용 인원)
);

-- register 수강
CREATE TABLE register(
    registerNo INT PRIMARY KEY AUTO_INCREMENT,  -- (수강 번호)
    courseNo INT NOT NULL,                      -- (수강 강좌)
    id VARCHAR(20) NOT NULL                     -- (회원 id)
);


-- book 교재
CREATE TABLE book(
    bookNo INT PRIMARY KEY AUTO_INCREMENT,  -- (교재 번호)
    courseNo INT,                           -- (관련 강좌 번호)
    title VARCHAR(200) NOT NULL,            -- (교재 이름)
    content VARCHAR(2000),                  -- (교재 소개)
    publish VARCHAR(200),                   -- (출판사)
    publishDate DATE,                       -- (출판일)
    author VARCHAR(100),                    -- (저자)
    imageFile INT DEFAULT 0,                -- (교재 표지) storage 테이블 번호
    price INT DEFAULT 0                     -- (가격)
);


-- free 자유게시판
CREATE TABLE free(
	freeNo INT PRIMARY KEY AUTO_INCREMENT,                  -- (게시글 번호)
	title VARCHAR(200) NOT NULL,                            -- (게시글 제목)
	content VARCHAR(2000),                                  -- (게시글 내용)
	id VARCHAR(20) NOT NULL,                                -- (게시글 작성 회원 id)
	regdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- (등록일)
	visited INT DEFAULT 0                                   -- (조회수)
);


-- comment 자유게시판의 댓글
CREATE TABLE comment(
	commentNo INT PRIMARY KEY AUTO_INCREMENT,               -- (댓글 번호)
	id VARCHAR(20) NOT NULL,                                -- (댓글 작성 회원 id)
	content VARCHAR(300) NOT NULL,                          -- (댓글 내용)
	regdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- (댓글 등록일)
	freeNo INT NOT NULL                                     -- (자유게시판 게시글 번호)
);


-- notice 학원 전체 공지사항
CREATE TABLE notice(
   noticeNo INT PRIMARY KEY AUTO_INCREMENT,                 -- (게시글 번호)
   title VARCHAR(200) NOT NULL,                             -- (게시글 제목)
   content VARCHAR(1000),                                   -- (게시글 내용)
   regdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,    -- (등록일)
   visited INT DEFAULT 0                                    -- (조회수)
);


-- event 이벤트
CREATE TABLE event(
    eventNo INT PRIMARY KEY AUTO_INCREMENT,                 -- (이벤트 번호)
    title VARCHAR(200) NOT NULL,                            -- (이벤트 제목)
    content VARCHAR(2000),                                  -- (이벤트 내용)
    imageFile INT,                                          -- (썸네일 이미지) storage 테이블 번호
    startdate DATE,                                         -- (시작일)
    enddate DATE,                                           -- (종료일)
    isOngoing BOOLEAN default TRUE,                         -- (진행 여부)
    regdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- (등록일)
    visited INT DEFAULT 0                                   -- (조회수)
);


-- storage 파일 저장소
CREATE TABLE storage(
    fileNo INT PRIMARY KEY AUTO_INCREMENT,                  -- (파일 번호)
    originName VARCHAR(300),                                -- (파일 원본 이름) 업로드 시 이름
    saveName VARCHAR(300),                                  -- (저장된 이름)
    savePath VARCHAR(1000),                                 -- (저장 경로)
    boardName VARCHAR(50),                                  -- (관련 게시판)
    boardNo INT,                                            -- (관련 게시판의 게시글) 자료실과 같이 여러 파일을 업로드하는 경우 지정
    regdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP    -- (파일 등록일)
);


-- 강좌별 게시판
-- courseNotice 강좌 공지사항
CREATE TABLE courseNotice(
    noticeNo INT PRIMARY KEY AUTO_INCREMENT,                -- (게시글 번호)
    courseNo INT NOT NULL,                                  -- (강좌 번호)
    title VARCHAR(200) NOT NULL ,                           -- (제목)
    content VARCHAR(1000) NOT NULL,                         -- (내용)
    regdate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),  -- (등록일)
    visited INT DEFAULT 0                                   -- (조회수)
);

-- courseQna 강좌 문의 게시판
CREATE TABLE courseQna(
	qnaNo INT PRIMARY KEY AUTO_INCREMENT,                       -- (게시글 번호)
	courseNo INT NOT NULL,                                      -- (강좌 번호)
    lev INT DEFAULT 0,                                          -- (게시글 종류) 질문글(0), 답변글(1)
    par INT DEFAULT 0,                                          -- (부모글 번호)
    title VARCHAR(200) NOT NULL,                                -- (제목)
	content VARCHAR(1000) NOT NULL,                             -- (내용)
	id VARCHAR(20) NOT NULL,                                    -- (작성자)
    regdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),     -- (등록일)
	visited INT DEFAULT 0                                       -- (조회수)
);


-- courseMaterials 강좌 자료실
CREATE TABLE courseMaterials(
    materialNo INT PRIMARY KEY AUTO_INCREMENT,                  -- (게시글 번호)
    courseNo INT NOT NULL,                                      -- (강좌 번호)
    hasFile BOOLEAN DEFAULT FALSE,                              -- (첨부 파일 여부)
    title VARCHAR(200) NOT NULL,                                -- (제목)
    content VARCHAR(1000) NOT NULL,                             -- (내용)
    id VARCHAR(20) NOT NULL,                                    -- (작성자)
    regdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),     -- (등록일)
    visited INT DEFAULT 0                                       -- (조회수)
);


-- courseAttendance 강좌 출석
CREATE TABLE courseAttendance(
    attendanceNo INT PRIMARY KEY AUTO_INCREMENT,                -- (출석 번호)
    courseNo INT NOT NULL,                                      -- (강좌 번호)
    id VARCHAR(20) NOT NULL,                                    -- (수강생 id)
    attdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),     -- (출석 일시)
    status VARCHAR(30)                                          -- (출석 상태) late 지각 / absence 무단결석 / normal 정상 출석 / leave 조퇴 / dayoff 공결
);