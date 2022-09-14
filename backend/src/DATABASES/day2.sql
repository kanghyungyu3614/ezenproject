/* 1. 데이터베이스 생성 */
create database shop_db3;
/* 
	한줄 실행 : ctrl+엔터
	명령어 ; 끝마침 
*/
/* 2. 테이블 생성*/
use shop_db3; /* DB 선택 */
create table member( 
	member_id char(8) primary key not null , 
    member_name char(5) not null  ,
    member_addr char(20) 
);
/*3. 테이블 확인 */
select * from member;