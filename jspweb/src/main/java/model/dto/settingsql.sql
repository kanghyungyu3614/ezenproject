drop database if exists jspweb;
create database jspweb; 
use jspweb;
create table member(
   mno    int auto_increment primary key,     -- 회원번호[PK, AUTOKEY]
   mid    varchar(50),                        -- 회원아이디
   mpassword    varchar(50),                  -- 회원 패스워드
   mname  varchar(50),                        -- 회원명
   mphone varchar(15),                        -- 회원 전화번호
   memail varchar(100),                       -- 회원 이메일
   maddress varchar(100),                     -- 회원 주소
   mdate    datetime default now() ,
   mpoint int default 0
   -- default 레코드 추가시 기본으로 들어간느 값 설정
   -- datetime default now() : 현재 시스템(DB)의 자동날짜 
);
