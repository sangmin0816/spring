USE haebeop2;

-- member 회원 데이터
INSERT INTO member(id, pw, name, membership) VALUES('admin', '$2a$10$oS1.3wpbnpIanIW4RoXxSOea/vGIijBMpLUBxZqurQqNjjMiJHgGa', '관리자', 'admin');

INSERT INTO member(id, pw, name, membership, isVerify) VALUES('sam1', '$2a$10$oS1.3wpbnpIanIW4RoXxSOea/vGIijBMpLUBxZqurQqNjjMiJHgGa', '쌤1', 'teacher', TRUE);
INSERT INTO member(id, pw, name, membership, isVerify) VALUES('sam2', '$2a$10$oS1.3wpbnpIanIW4RoXxSOea/vGIijBMpLUBxZqurQqNjjMiJHgGa', '쌤2', 'teacher', TRUE);
INSERT INTO member(id, pw, name, membership, isVerify) VALUES('sam3', '$2a$10$oS1.3wpbnpIanIW4RoXxSOea/vGIijBMpLUBxZqurQqNjjMiJHgGa', '쌤3', 'teacher', TRUE);

INSERT INTO member(id, pw, name, membership, isVerify) VALUES('kim1', '$2a$10$oS1.3wpbnpIanIW4RoXxSOea/vGIijBMpLUBxZqurQqNjjMiJHgGa', '학생1', 'student', TRUE);
INSERT INTO member(id, pw, name, membership, isVerify) VALUES('kim2', '$2a$10$oS1.3wpbnpIanIW4RoXxSOea/vGIijBMpLUBxZqurQqNjjMiJHgGa', '학생2', 'student', TRUE);
INSERT INTO member(id, pw, name, membership, isVerify) VALUES('kim3', '$2a$10$oS1.3wpbnpIanIW4RoXxSOea/vGIijBMpLUBxZqurQqNjjMiJHgGa', '학생3', 'student', TRUE);


-- teacher 강사 데이터
INSERT INTO teacher(id, name) VALUES('sam1', '쌤1');
INSERT INTO teacher(id, name) VALUES('sam2', '쌤2');
INSERT INTO teacher(id, name) VALUES('sam3', '쌤3');


-- course 강좌 데이터
INSERT INTO course(teacherNo, title) VALUES(1, '국어 강좌');
INSERT INTO course(teacherNo, title) VALUES(2, '영어 강좌');
INSERT INTO course(teacherNo, title) VALUES(3, '수학 강좌');


-- register 수강 데이터
INSERT INTO register(courseNo, id) VALUES(1, 'kim1');
INSERT INTO register(courseNo, id) VALUES(2, 'kim1');
INSERT INTO register(courseNo, id) VALUES(3, 'kim1');

INSERT INTO register(courseNo, id) VALUES(1, 'kim2');
INSERT INTO register(courseNo, id) VALUES(2, 'kim2');
INSERT INTO register(courseNo, id) VALUES(3, 'kim2');

INSERT INTO register(courseNo, id) VALUES(1, 'kim3');
INSERT INTO register(courseNo, id) VALUES(2, 'kim3');
INSERT INTO register(courseNo, id) VALUES(3, 'kim3');


-- book 교재 데이터
INSERT INTO book(courseNo, title) VALUES(1, '국어 문제집');
INSERT INTO book(courseNo, title) VALUES(2, '영어 문제집');
INSERT INTO book(courseNo, title) VALUES(3, '수학 문제집');


-- free 자유 게시판 데이터
INSERT INTO free(title, content, id) VALUES('자유', '자유', 'kim1');
INSERT INTO free(title, content, id) VALUES('게시판', '게시판', 'kim2');
INSERT INTO free(title, content, id) VALUES('예시', '예시', 'kim3');


-- comment 자유게시판 댓글 데이터
INSERT INTO comment(id, content, freeNo) VALUES('kim1', '댓글', 1);
INSERT INTO comment(id, content, freeNo) VALUES('kim1', '댓글', 2);
INSERT INTO comment(id, content, freeNo) VALUES('kim1', '댓글', 3);


-- notice 학원 전체 공지사항 데이터
INSERT INTO notice(title, content) VALUES('공지사항', '공지사항');
INSERT INTO notice(title, content) VALUES('게시판', '게시판');
INSERT INTO notice(title, content) VALUES('예시', '예시');


-- event 이벤트 데이터
INSERT INTO event(title, content) VALUES('이벤트', '이벤트');
INSERT INTO event(title, content) VALUES('게시판', '게시판');
INSERT INTO event(title, content) VALUES('예시', '예시');


-- 강좌별 게시판 데이터
-- courseNotice 데이터
INSERT INTO courseNotice(courseNo, title, content) VALUES(1, '공지사항', '공지사항');
INSERT INTO courseNotice(courseNo, title, content) VALUES(1, '게시판', '게시판');

INSERT INTO courseNotice(courseNo, title, content) VALUES(2, '공지사항', '공지사항');
INSERT INTO courseNotice(courseNo, title, content) VALUES(2, '게시판', '게시판');

INSERT INTO courseNotice(courseNo, title, content) VALUES(3, '공지사항', '공지사항');
INSERT INTO courseNotice(courseNo, title, content) VALUES(3, '게시판', '게시판');


-- courseQna 데이터
INSERT INTO courseQna(courseNo, lev, title, content, id) VALUES(1, 0, '질문', '질문', 'kim1');
INSERT INTO courseQna(courseNo, lev, title, content, id) VALUES(1, 1, '답변', '답변', 'kim1');

INSERT INTO courseQna(courseNo, lev, title, content, id) VALUES(2, 0, '질문', '질문', 'kim1');
INSERT INTO courseQna(courseNo, lev, title, content, id) VALUES(2, 1, '답변', '답변', 'kim1');

INSERT INTO courseQna(courseNo, lev, title, content, id) VALUES(3, 0, '질문', '질문', 'kim1');
INSERT INTO courseQna(courseNo, lev, title, content, id) VALUES(3, 1, '답변', '답변', 'kim1');


-- courseMaterials 데이터
INSERT INTO courseMaterials(courseNo, title, content, id) VALUES(1, '자료', '자료', 'kim1');
INSERT INTO courseMaterials(courseNo, title, content, id) VALUES(2, '자료', '자료', 'kim1');
INSERT INTO courseMaterials(courseNo, title, content, id) VALUES(3, '자료', '자료', 'kim1');


-- courseAttendance 데이터
INSERT INTO courseAttendance(courseNo, id, status) VALUES(1, 'kim1', 'late');
INSERT INTO courseAttendance(courseNo, id, status) VALUES(1, 'kim2', 'absence');
INSERT INTO courseAttendance(courseNo, id, status) VALUES(1, 'kim3', 'normal');

INSERT INTO courseAttendance(courseNo, id, status) VALUES(2, 'kim1', 'late');
INSERT INTO courseAttendance(courseNo, id, status) VALUES(2, 'kim2', 'absence');
INSERT INTO courseAttendance(courseNo, id, status) VALUES(2, 'kim3', 'normal');

INSERT INTO courseAttendance(courseNo, id, status) VALUES(3, 'kim1', 'late');
INSERT INTO courseAttendance(courseNo, id, status) VALUES(3, 'kim2', 'absence');
INSERT INTO courseAttendance(courseNo, id, status) VALUES(3, 'kim3', 'normal');