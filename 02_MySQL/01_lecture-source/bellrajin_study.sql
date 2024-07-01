select * from TB_DEPARTMENT; --  학과테이블
select * from TB_STUDENT; -- 학생테이블
select * from TB_PROFESSOR; -- 교수테이블
select * from TB_CLASS; -- 수업테이블
select * from TB_CLASS_PROFESSOR; -- 수업교수테이블
select * from TB_GRADE; -- 학점테이블


-- 춘 기술대학교의 학과 이름과 계열을 표시하시오. 단, 출력 헤더는 "학과 명", "계열"으로 표시하도록 한다.
select
    DEPARTMENT_NAME AS '학과명'
  , CATEGORY AS '계열'
from
    tb_department;

-- 학과의 학과 정원을 다음과 같은 형태로 화면에 출력한다.

select
    CONCAT(DEPARTMENT_NAME, '의 ', '정원은 ', CAPACITY, '명 입니다.') as '학과별정원'
from
    tb_department;


select
    STUDENT_NAME
from
    tb_department
join
    tb_student
on
  tb_student.DEPARTMENT_NO = tb_department.DEPARTMENT_NO
where
    ABSENCE_YN = 'Y' and DEPARTMENT_NAME = '국어국문학과' and SUBSTR(STUDENT_SSN, 8, 1) = 2;

-- 1. 도서관에서 대출 도서 장기 연체자 들을 찾아 이름을 게시하고자 한다. 그 대상자들의 학번이 다음과 같을 때 대상자들을 찾는 적 SQL 구문을 작성하시오.
select
    STUDENT_NAME
from
    tb_student
where
    STUDENT_NO in('A513079', 'A513090', 'A513091', 'A513110', 'A513119');