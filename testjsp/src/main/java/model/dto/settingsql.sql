drop database if exists jsptestdb;
create database jsptestdb; 
use jsptestdb;
create table member(
   testno    int auto_increment primary key,     -- 회원번호[PK, AUTOKEY]
   testid    varchar(50),                        -- 회원아이디
   testpassword    varchar(50),                  -- 회원 패스워드
   testname  varchar(50),                        -- 회원명
   testtitle varchar(50),
   testcontent varchar(100),
   testwriter varchar(50),
   testdate    datetime default now() ,
   testpoint int default 0
   -- default 레코드 추가시 기본으로 들어간느 값 설정
   -- datetime default now() : 현재 시스템(DB)의 자동날짜 
);