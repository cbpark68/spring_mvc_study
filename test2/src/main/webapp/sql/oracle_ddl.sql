--------------------------------------------------------
--  DDL for Table MVC_BOARD
--------------------------------------------------------

  CREATE TABLE MVC_BOARD 
   (	UNQ NUMBER, 
	TITLE VARCHAR2(100 ), 
	PASS VARCHAR2(100 ), 
	NAME VARCHAR2(20 ), 
	CONTENT VARCHAR2(4000 ), 
	HITS NUMBER, 
	RDATE TIMESTAMP (6)
   ) 
  TABLESPACE ORA_DATA01 ;
--------------------------------------------------------
--  DDL for Table MVC_CODES
--------------------------------------------------------

  CREATE TABLE MVC_CODES 
   (	CODE NUMBER, 
	GID NUMBER, 
	NAME VARCHAR2(100 )
   ) 
  TABLESPACE ORA_DATA01 ;
--------------------------------------------------------
--  DDL for Table MVC_DEPT
--------------------------------------------------------

  CREATE TABLE MVC_DEPT 
   (	DEPTNO NUMBER, 
	DNAME VARCHAR2(100 ), 
	LOC VARCHAR2(100 )
   ) 
  TABLESPACE ORA_DATA01 ;
--------------------------------------------------------
--  DDL for Table MVC_MEMBER
--------------------------------------------------------

  CREATE TABLE MVC_MEMBER 
   (	USERID VARCHAR2(20 ), 
	PASS VARCHAR2(100 ), 
	NAME VARCHAR2(20 ), 
	BIRTH DATE, 
	PHONE VARCHAR2(20 ), 
	GENDER VARCHAR2(1 ), 
	ZIPCODE VARCHAR2(10 ), 
	ADDRESS VARCHAR2(100 ), 
	REG TIMESTAMP (6) DEFAULT SYSDATE
   ) 
  TABLESPACE ORA_DATA01 ;
--------------------------------------------------------
--  DDL for Table MVC_POST
--------------------------------------------------------

  CREATE TABLE MVC_POST 
   (	A1 VARCHAR2(6 ), 
	A2 VARCHAR2(100 ), 
	A3 VARCHAR2(100 ), 
	A4 VARCHAR2(100 ), 
	A5 VARCHAR2(100 ), 
	A6 VARCHAR2(100 ), 
	A7 VARCHAR2(100 ), 
	A8 VARCHAR2(200 )
   ) 
  TABLESPACE ORA_DATA01 ;
REM INSERTING into MVC_BOARD
SET DEFINE OFF;
Insert into MVC_BOARD (UNQ,TITLE,PASS,NAME,CONTENT,HITS,RDATE) values (1,'오늘 주사 맞았다.','1234','박철범','오늘 주사 맞았어요. 졸라 아파요',1,to_timestamp('22/02/22 11:55:16.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into MVC_BOARD (UNQ,TITLE,PASS,NAME,CONTENT,HITS,RDATE) values (3,'제목입력1','1234','박철범','알망니ㅓ림ㄴ얾ㄴㅇ',0,to_timestamp('22/02/22 12:28:26.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into MVC_BOARD (UNQ,TITLE,PASS,NAME,CONTENT,HITS,RDATE) values (4,'제목입력2','1234','박철범','알망니ㅓ림ㄴ얾ㄴㅇ',0,to_timestamp('22/02/22 12:28:32.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into MVC_BOARD (UNQ,TITLE,PASS,NAME,CONTENT,HITS,RDATE) values (5,'제목입력2','1234','박철범','알망니ㅓ림ㄴ얾ㄴㅇ',0,to_timestamp('22/02/22 12:28:36.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into MVC_BOARD (UNQ,TITLE,PASS,NAME,CONTENT,HITS,RDATE) values (6,'제목입력2','1234','박철범','알망니ㅓ림ㄴ얾ㄴㅇ',0,to_timestamp('22/02/22 12:28:39.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into MVC_BOARD (UNQ,TITLE,PASS,NAME,CONTENT,HITS,RDATE) values (7,'제목입력2','1234','박철범','알망니ㅓ림ㄴ얾ㄴㅇ',0,to_timestamp('22/02/22 12:28:41.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into MVC_BOARD (UNQ,TITLE,PASS,NAME,CONTENT,HITS,RDATE) values (8,'제목입력2','1234','박철범','알망니ㅓ림ㄴ얾ㄴㅇ',0,to_timestamp('22/02/22 12:28:43.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into MVC_BOARD (UNQ,TITLE,PASS,NAME,CONTENT,HITS,RDATE) values (9,'제목입력2','1234','박철범','알망니ㅓ림ㄴ얾ㄴㅇ',0,to_timestamp('22/02/22 12:28:46.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into MVC_BOARD (UNQ,TITLE,PASS,NAME,CONTENT,HITS,RDATE) values (10,'제목입력2','1234','박철범','알망니ㅓ림ㄴ얾ㄴㅇ',0,to_timestamp('22/02/22 12:28:48.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into MVC_BOARD (UNQ,TITLE,PASS,NAME,CONTENT,HITS,RDATE) values (11,'제목입력2','1234','박철범','알망니ㅓ림ㄴ얾ㄴㅇ',0,to_timestamp('22/02/22 12:28:50.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into MVC_BOARD (UNQ,TITLE,PASS,NAME,CONTENT,HITS,RDATE) values (12,'제목입력2','1234','박철범','알망니ㅓ림ㄴ얾ㄴㅇ',0,to_timestamp('22/02/22 12:28:51.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into MVC_BOARD (UNQ,TITLE,PASS,NAME,CONTENT,HITS,RDATE) values (13,'제목입력2','1234','박철범','알망니ㅓ림ㄴ얾ㄴㅇ',1,to_timestamp('22/02/22 12:29:31.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into MVC_BOARD (UNQ,TITLE,PASS,NAME,CONTENT,HITS,RDATE) values (14,'제목입력','비번입력','작성자입력','vbvbdv',4,to_timestamp('22/02/22 12:29:39.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into MVC_BOARD (UNQ,TITLE,PASS,NAME,CONTENT,HITS,RDATE) values (15,'줄바꿈','1234','박철범','첫둘
둘째줄
세째줄',2,to_timestamp('22/02/22 19:02:11.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into MVC_BOARD (UNQ,TITLE,PASS,NAME,CONTENT,HITS,RDATE) values (2,'졸리다.','1234','타이거','주사맞았더니 졸리다.',0,to_timestamp('22/02/22 11:55:16.000000000','RR/MM/DD HH24:MI:SSXFF'));
REM INSERTING into MVC_CODES
SET DEFINE OFF;
Insert into MVC_CODES (CODE,GID,NAME) values (1,1,'개발자');
Insert into MVC_CODES (CODE,GID,NAME) values (2,1,'디자이너');
Insert into MVC_CODES (CODE,GID,NAME) values (3,2,'축구');
Insert into MVC_CODES (CODE,GID,NAME) values (4,2,'농구');
Insert into MVC_CODES (CODE,GID,NAME) values (5,2,'야구');
Insert into MVC_CODES (CODE,GID,NAME) values (6,1,'철범');
Insert into MVC_CODES (CODE,GID,NAME) values (7,1,'박철범');
Insert into MVC_CODES (CODE,GID,NAME) values (8,2,'조효미');
REM INSERTING into MVC_DEPT
SET DEFINE OFF;
Insert into MVC_DEPT (DEPTNO,DNAME,LOC) values (1,'개발팀','2층');
REM INSERTING into MVC_MEMBER
SET DEFINE OFF;
Insert into MVC_MEMBER (USERID,PASS,NAME,BIRTH,PHONE,GENDER,ZIPCODE,ADDRESS,REG) values (','1234','박철범',to_date('68/07/28','RR/MM/DD'),'010-3174-2195','M',null,null,null);
REM INSERTING into MVC_POST
SET DEFINE OFF;
Insert into MVC_POST (A1,A2,A3,A4,A5,A6,A7,A8) values ('1','경기도','광명시','하안동','12단지',null,null,null);
Insert into MVC_POST (A1,A2,A3,A4,A5,A6,A7,A8) values ('2','경기도','광명시','하안동','6단지',null,null,null);
--------------------------------------------------------
--  DDL for Index SYS_C007244
--------------------------------------------------------

  CREATE UNIQUE INDEX SYS_C007244 ON MVC_BOARD (UNQ) 
  TABLESPACE ORA_DATA01 ;
--------------------------------------------------------
--  DDL for Index SYS_C007243
--------------------------------------------------------

  CREATE UNIQUE INDEX SYS_C007243 ON MVC_CODES (CODE) 
  TABLESPACE ORA_DATA01 ;
--------------------------------------------------------
--  DDL for Index MVC_DEPT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX MVC_DEPT_PK ON MVC_DEPT (DEPTNO) 
  TABLESPACE ORA_DATA01 ;
--------------------------------------------------------
--  DDL for Index SYS_C007252
--------------------------------------------------------

  CREATE UNIQUE INDEX SYS_C007252 ON MVC_MEMBER (USERID) 
  TABLESPACE ORA_DATA01 ;
--------------------------------------------------------
--  Constraints for Table MVC_BOARD
--------------------------------------------------------

  ALTER TABLE MVC_BOARD ADD PRIMARY KEY (UNQ)
  TABLESPACE ORA_DATA01  ENABLE;
  ALTER TABLE MVC_BOARD MODIFY (PASS NOT NULL ENABLE);
  ALTER TABLE MVC_BOARD MODIFY (TITLE NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MVC_CODES
--------------------------------------------------------

  ALTER TABLE MVC_CODES ADD PRIMARY KEY (CODE)
  TABLESPACE ORA_DATA01  ENABLE;
--------------------------------------------------------
--  Constraints for Table MVC_DEPT
--------------------------------------------------------

  ALTER TABLE MVC_DEPT ADD CONSTRAINT MVC_DEPT_PK PRIMARY KEY (DEPTNO)
  TABLESPACE ORA_DATA01  ENABLE;
--------------------------------------------------------
--  Constraints for Table MVC_MEMBER
--------------------------------------------------------

  ALTER TABLE MVC_MEMBER ADD PRIMARY KEY (USERID)
  TABLESPACE ORA_DATA01  ENABLE;
  ALTER TABLE MVC_MEMBER ADD CHECK (GENDER IN ('M','F')) ENABLE;
  ALTER TABLE MVC_MEMBER MODIFY (NAME NOT NULL ENABLE);
  ALTER TABLE MVC_MEMBER MODIFY (PASS NOT NULL ENABLE);

