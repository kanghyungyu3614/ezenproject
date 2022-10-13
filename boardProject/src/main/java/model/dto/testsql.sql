drop database if exists jspboard;
create database jspboard; 
use jspboard;
create table member(
   boardno    int auto_increment primary key,     -- 회원번호[PK, AUTOKEY]
   boardid    varchar(50),                        -- 회원아이디
   boardpassword varchar(50),                  -- 회원 패스워드
   boardname  varchar(50),                        -- 회원명
   boardtitle varchar(50),
   boardcontent varchar(100),
   boardwriter varchar(50),
   boarddate    datetime default now() ,
   boardpoint int default 0
   -- default 레코드 추가시 기본으로 들어간느 값 설정
   -- datetime default now() : 현재 시스템(DB)의 자동날짜 
);