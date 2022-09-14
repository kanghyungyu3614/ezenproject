/* 설치 */
/*
1. mysql-installer-community-8.0.30.0
	1. mysql server		DB서버 
	2. workbench		mysql 에디터
	3. connector-j		JAVA 연결 드라이버
	- 설치 설정 
	1.  port : 3306		DB 로 접속할수 있는 네트워크 번호 
	2.  비밀번호 : 1234		DB서버 접속 비밀번호
	- DB 접속
	1. workbench
2. mysql-connector-java-8.0.30
	- JDBC 드라이버 
	- mysql-connector-java-8.0.30.jar
*/

show databases;
-- 한줄 주석
# 한줄 주석 
/* 여러줄 주석 */
-- 화면 확대/축소 : ctrl + 마우스휠   / ctrl + (+/-) 
-- SQL 한줄 실행 : 해당 SQL 커서에서 ctrl + 엔터 

/*
	컴퓨터 
		1. 0,1 : 기계어 , 2진코드 , 2진수 
		2. 자료[데이터] : 01010101 이용한 데이터 저장
        3. 데이터 정리 저장소[표] --> 데이터베이스 : 자료들의 모임 
        4. DB 조작 --> DBMS : 데이터베이스 관리 시스템
		5. DBMS 관리자 --> DBA : 데이터베이스 관리자 
        
        컴퓨터[0,1]	<------ DBMS <----------------- DBA
			DB[ 표 ]				1. MYSQL			1. 관리자 [본인]
        
        6. 용어 
			table 테이블 = 표 
            record 레코드 = 행 , 가로 , 튜플 
            field 필드 = 열 , 세로 , 속성
		
		7. 목적 
			1. 영구저장 [ 
				컴퓨터 저장소 [ 메모리 ] 
					1. RAM : 주기억장치 
						* 현재 실행중인 메모리 [ 휘발성 ]
						1. JVM
                    2. ROM : 보조기억장치 
						* 영구 저장 [ 비휘발성 ] 
						1. 데이터베이스 
				* 바둑 게임 설치 
					1. 설치 한 모든파일은 C드라이브 [ 보조기억장치 5GB ]
                    2. 바둑 게임 실행 [ 보조기억장치에서 실행한 만큼 필요한 데이터 -> 주기억장치 ] 
			
            2. 공시 동유 
            3. 관리가 편한다. [ 빅데이터 , 통계 등 ]
				- 가계부[ 사람 기준 ] 
					날짜		내용		가격
					9/13	커피		2000
                    9/20	스무디	1500
				- 가계부[ 컴퓨터 기준 ]
					9/13				2000
							커피			9/20		1500
					1500				스무디
				- 가계부[ 컴퓨터 기준 -> DB 적용해보자 ]
					날짜		내용		가격
					9/13	커피		2000
                    9/20	스무디	1500
*/

/*
	1. 데이터베이스 생성  [ p.70 ]
		1. MYSQL 
			1. 왼쪽 메뉴 -> Schemas
            2. 메뉴 빈 공간 오른쪽 클릭 -> CREATE SCHEMAS
			3. db 이름 작성후 -> APPLY
		2. 코드 작성 
			CREATE DATABASE db이름정의;
	2. 테이블 생성 [ p.71 ]
		1. MYSQL
			1. 왼쪽 메뉴 -> 해당 스키마의 TANLES 오른쪽 클릭 -> CREATE TABLE 
			2. 테이블 이름 과 필드명과 속성 설정후에 Apply
		2. 코드 작성 
			CREATE TABLE DB명.테이블명정의( 
				필드명1 자료형[데이터타입] 속성 , 
				필드명2 자료형 속성 , 
				필드명3 자료형 속성 
            ); 
	3. 테이블 확인
		1. MYSQL 
			1. 해당 테이블을 오른쪽 클릭 -> SELECT ROWS
		2. 코드 작성 
			SELECT * FROM DB명.테이블명;
	4. 테이블에 데이터 입력하기 [ p.76 ]
		1. MYSQL
			1. 해당 테이블을 오른쪽 클릭 -> SELECT ROWS
            2. 테이블에 직접 입력 -> apply 
		2. 코드 작성 
			1. INSERT INTO DB명.테이블명 VALUES( 값1 , 값2 , 값3 );
	5. 테이블에 데이터 수정하기 [ p.78 ]
		1. MYSQL
			1. 해당 테이블을 오른쪽 클릭 -> SELECT ROWS 
            2. 테이블에 직접 수정 -> apply 
		2. 코드 작성 
			UPDATE DB명.테이블명 SET 필드명 = 새로운값 WHERE 조건[필드명=값] 
	6. 테이블내 데이터 삭제하기 [ p.79 ]
		1. MYSQL
			1. 해당 테이블을 오른쪽 클릭 -> SELECT ROWS
            2. 테이블내 삭제할 행[레코드]를 오른쪽 클릭 -> DELETE ROWS 클릭 -> apply
		2. 코드 작성
			DELETE FROM DB명.테이블명 WHERE 조건[필드명=값]
*/
CREATE DATABASE shop_db2;			-- 데이터베이스 생성 
CREATE TABLE shop_db2.member( 		-- 테이블 생성 
	member_id char(8) PRIMARY KEY not null , 
    member_name char(5) not null ,
    member_addr char(20) 
);
SELECT * FROM shop_db2.member;		-- 테이블 확인[검색]
-- 데이터 추가 
INSERT INTO shop_db2.member values( 'tess' , '나훈아' , '경기 부천시 중동');
INSERT INTO shop_db2.member values( 'hero' , '임영웅' , '서울 은평구 증산동');
INSERT INTO shop_db2.member values( 'iyou' , '아이유' , '인천 남구 주안동');
INSERT INTO shop_db2.member values( 'jyp' , '박진영' , '경기 고양시 장항동');
SELECT * FROM shop_db2.member;		-- 테이블 확인[검색]
-- 데이터 수정 
UPDATE shop_db2.member SET member_addr ='경기 안산시 상록구 이동' where member_id = 'tess';
SELECT * FROM shop_db2.member;		-- 테이블 확인[검색]
-- 데이터 삭제 
DELETE FROM shop_db2.member where member_id = 'iyou';
SELECT * FROM shop_db2.member;		-- 테이블 확인[검색]

/*
SQL [ 질의어 : 컴퓨터에게 명령어(대화) ]
	1. DDL : Data Definition L : 데이터베이스 정의어[ 만들기 ]
		1. CREATE : 데이터베이스 DB,테이블,뷰 등 생성 만들기 
			CREATE TABLE 가계부( );
		2. ALTER : 데이터베이스 DB,테이블,뷰 등 수정
			ALTER TABLE 가계부( ) ;
		3. DROP : 데이터베이스 DB,테이블,뷰 등 삭제 
			DTOP TABLE 가계부;
		4. RENAME : 데이터베이스 DB,테이블,뷰 등 이름 변경 
		5. TRUNCATE : 데이터베이스 DB,테이블,뷰 내 데이터 초기화 		
	2. DML : Data Manipulation L : 데이터베이스 조작어[ 테이블내 데이터 가공/조작]
		1. SELECT	 : 데이터 검색 	
			- SELECT 필드명 FROM 테이블명 
		2. INSERT : 데이터( 레코드=행) 추가 
			- INSERT INTO 테이블명 VALUES( 데이터1 , 데이터2 , 데이터3 )
		3. UPDATE : 데이터 수정 
			- UPDATE 테이블명 SET 필드명 = 수정할데이터
		4. DELETE  : 데이터( 레코드=행) 삭제 
			- DELETE FROM 테이블명
	3. DCL : Data Control L : 데이터베이스 제어어 
		1. GRANT	: 데이터베이스 계정에 권한 부여 [ ROLE 부여 ]
		2. REVOKE : 데이터베이스 계정에 권한 해제 [ ROLE 제거 ]
	4. TCL : Transation Control L : 트랜잭션 제어어 [ DML 에서만 사용  ] 
		1. COMMIT 	: 작성된 SQL 실행 [ apply ] : 워크벤치 자동
		2. ROLLBACK 	: 작성된 SQL 취소 
		3. SAVEPOINT 	: 작성된 SQL 이름 지정
* SQL 끝에 ;(세미콜론) SQL 끝마침 알림  ( JAVA 동일 )
* DML 사용시 최종적으로 실행 -> COMMIT [ 워크벤치 자동 커밋 ]
*/

