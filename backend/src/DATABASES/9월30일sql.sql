SQL
	- DDL 	[ 데이터베이스 정의 어 ]
		1. CREATE	: 테이블/데이터베이스/뷰 생성 

			1. CREATE DATABASE 데이베이스명
			2. CREATE TABLE 테이블명( 필드명 데이터타입 제약조건 , 필드명2 데이터타입 제약조건  )

		2. ALTER		: 테이블/데이터베이스/뷰 수정

			[ 테이블내 필드 수정 ] 
			1. ALTER TABLE 테이블명 ADD 		COLUMN 	필드명 데이터타입 제약조건;
			2. ALTER TABLE 테이블명 MODIFY 	COLUMN 	필드명 새로운타입 새로운제약조건;
			3. ALTER TABLE 테이블명 CHANGE 	COLUMN 	기존필드명 새로운필드명 새로운타입 새로운제약조건 ;
			4. ALTER TABLE 테이블명 RENAME 	COLUMN 	기존필드명 TO 새로운필드명;
			5. ALTER TABLE 테이블명 DROP 	COLUMN 	필드명
			
			[ 테이블내 제약조건  ]
			[추가] 1. ALTER TABLE 테이블명 ADD CONSTRAINT [제약조건명] PRIMARY KEY ( PK로 설정할필드명 ) 
			[삭제] 2. ALTER TABLE 테이블명 DROP CONSTRAINT [제약조건명]

		3. DROP		: 테이블/데이터베이스/뷰 삭제
		4. RANAME	: 테이블/뷰 이름수정
		5. TRUNCATE	: 테이블/뷰 모든삭제

	- DML	[ 데이터베이스 조작 어 ]
		1. SELECT		: 테이블내 레코드 검색 
			
			1. SELECT * FROM 테이블명
			2. SELECT 필드명1 , 필드명2 FROM 테이블명
			3. SELECT * FROM 테이블명 [WHERE 조건]
			4. SELECT * FROM 테이블명 [WHERE 조건] [ORDER BY 정렬필드 ASC/DESC]
			5. SELECT * FROM 테이블명 [WHERE 조건] [GROUP BY 그룹필드] [ORDER BY 정렬필드 ASC/DESC]
			6. SELECT * FROM 테이블명 [WHERE 조건] [GROUP BY 그룹필드] [HAVING 그룹조건] [ORDER BY 정렬필드 ASC/DESC]
			7. SELECT * FROM 테이블명 [WHERE 조건][GROUP BY 그룹필드][HAVING 그룹조건][ORDER BY 정렬필드 ASC/DESC][Limit 시작점,개수]

			-------------------------------------------------------------------------------------------------
			x . 테이블 2개이상 검색 
				1. SELECT * FROM 테이블명1 , 테이블명2	[ 테이블명1레코드 X 테이블명2레코드 ]
				
				2. SELECT * FROM 테이블명1 , 테이블명2 WHERE 테이블명1.PK필드명 = 테이블명2.FK필드명 

				3. SELECT * FROM 테이블명1 별칭1 , 테이블명2 별칭2 WHERE 별칭.PK필드명 = 별칭2.FK필드명 

		2. INSERT		: 테이블내 레코드 삽입
			1. INSERT INTO 테이블명 VALUES( 값1, 값2 ,값2 )
			2. INSERT INTO 테이블명 ( 필드명1 , 필드명2 ) VALUES( 값1 , 값2 )

		3. UPDATE 	: 테이블내 레코드 수정 
			1. UPDATE 테이블명 SET 필드명 = 새로운값 , 필드명 = 새로운값 [ 졷WHERE 조건 ] 

		4. DELETE	: 테이블내 레코드 삭제 
			1. DELETE FROM 테이블명 [ WHERE 조건 ] 


	- DCL	[ 데이터베이스 제어 어 ]
		1. GRANT		: 계정내 권한 부여 
		2. REVOKE	: 계정내 권한 취소 

	- TCL 	[  트랜잭션 제어 어 ]
		1. COMMIT	: 트랜잭션 
		2. ROLLBACK	: 트랜잭션 취소 
	- 그외
		1. USE		
		2. DESCRIBE
----------------------------------------------------------------------------------------------------------------------------------
- 데이터타입  [ p.172 ]  : DBMS 마다 상이
	1. 정수형
		TINYINT
		SMALLINT
		INT
		BIGINT
	2. 문자형
		CHAR(길이) 
		VARCHAR(길이)
	3. 대용량
		TEXT
		LONGTEXT
		BLOB
		LONGBLOB
	4. 실수형
		FLOAT
		DOUBLE
	5. 날짜형
		DATE
		TIME
		DATETIME
- 제약조건
	1. AUTO INCREMENT	: 자동번호 [ * PRIMARY KEY ]
	2. NOT NULL 		: NULL 저장 불가 
	3. DEFAULT 값 		: 레코드 삽입 기본값 
	4. UNIQUE		: 중복불가
	5. PRIMARY KEY		: 기본키 [   NOT NULL + UNIQUE ] 
	6. FOREIGN KEY		: 외래키 [ 중복가능 ] 
		- CONSTRAINT PRIMARY KEY 제약조건명(  PK로설정할필드명 )
		- CONSTRAINT [제약조건명] FOREIGN KEY FK로설정할필드명 REFERENCES 기준테이블( PK필드명 )