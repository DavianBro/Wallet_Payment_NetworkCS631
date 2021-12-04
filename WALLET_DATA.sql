-- -----------------------------------------------------
-- BANK_ACCOUNT DATA
-- -----------------------------------------------------
INSERT INTO BANK_ACCOUNT
(BankID,BANumber)
VALUES
    (1,"IT467FCFKI74388251558265983"),
    (2,"MC9590783472653325337235623"),
    (3,"DE19599363263921327434"),
    (4,"KW9231360193105875603245213329"),
    (5,"MU8578443393101355542658117775"),
    (6,"PL05184588437595188363679116"),
    (7,"IS753641538798850285486524"),
    (8,"BE78109153276911"),
    (9,"LU817177173270642344"),
    (10,"GI36NPFM714466182104194"),
    (11,"BA123456789"),
    (12, "BA98765654"),
    (13, "BA54645454"),
    (14, "BA34902345");

 -- ------------------------------------------------------
-- ELEC_ADDRESS DATA
-- ------------------------------------------------------
INSERT INTO ELEC_ADDRESS
(Identifier,Verified,Type)
VALUES
    ("8276363451","TRUE","Phone"),
    ("4750846326","TRUE","Phone"),
    ("9335647766","TRUE","Phone"),
    ("0312847677","TRUE","Phone"),
    ("3123868775","TRUE","Phone"),
    ("5442388368","TRUE","Phone"),
    ("9558231666","TRUE","Phone"),
    ("4500474431","TRUE","Phone"),
    ("2437051953","TRUE","Phone"),
    ("6870554390","TRUE","Phone"),
    ("amet@hotmail.ca","TRUE","Email"),
    ("non@aol.org","TRUE","Email"),
    ("leo.morbi@outlook.couk","TRUE","Email"),
    ("tempus.mauris.erat@icloud.net","TRUE","Email"),
    ("velit.eu.sem@hotmail.couk","TRUE","Email"),
    ("ipsum.suspendisse@aol.org","TRUE","Email"),
    ("lorem.vehicula@hotmail.couk","TRUE","Email"),
    ("nulla@google.couk","TRUE","Email"),
    ("urna.vivamus@yahoo.com","TRUE","Email"),
    ("vulputate.dui@protonmail.couk","TRUE","Email");

-- ------------------------------------------------------
-- USER_ACCOUNT DATA
-- ------------------------------------------------------
INSERT INTO USER_ACCOUNT (SSN,Name,PhoneNo,Balance,BankID,BANumber,PBAVerified)
VALUES
  (186176564,"Yardley Maynard","8276363451","18183",1,"IT467FCFKI74388251558265983","TRUE"),
  (519770016,"Marny Keith","4750846326","9238",2,"MC9590783472653325337235623","FALSE"),
  (779257597,"Barbara Holmes","9335647766","95736",3,"DE19599363263921327434","TRUE"),
  (658862941,"Caryn Poole","0312847677","70778",4,"KW9231360193105875603245213329","FALSE"),
  (428017212,"Julian Steele","3123868775","53039",5,"MU8578443393101355542658117775","TRUE"),
  (335629970,"Carl Shepherd","5442388368","55284",6,"PL05184588437595188363679116","FALSE"),
  (879647753,"Laith Mathis","9558231666","43097",7,"IS753641538798850285486524","TRUE"),
  (661496961,"Reece Swanson","4500474431","97450",8,"BE78109153276911","FALSE"),
  (271490729,"Desiree Russell","2437051953","99564",9,"LU817177173270642344","TRUE"),
  (647200058,"Porter Mosley","6870554390","94522",10,"GI36NPFM714466182104194","FALSE");
  
-- ------------------------------------------------------
-- HAS_ADDITIONAL DATA
-- ------------------------------------------------------
INSERT INTO HAS_ADDITIONAL
(SSN,BankID,BANumber,Verified)
VALUES
    (186176564,11,"BA123456789", "TRUE"),
    (519770016,12, "BA98765654", "TRUE"),
    (779257597,13, "BA54645454", "TRUE"),
    (658862941,14, "BA34902345", "TRUE");
    
-- ------------------------------------------------------
-- REQUEST_TRANSACTION DATA
-- ------------------------------------------------------
INSERT INTO REQUEST_TRANSACTION
(RTId,Amount,Date_Time,Memo,SSN)
VALUES
  (1,"29","2020-12-04 00:06:22","Bread","186176564"),
  (2,"87","2020-12-07 00:21:20","Car","519770016"),
  (3,"39","2020-12-03 07:38:02","Utilities","779257597"),
  (4,"50","2020-12-03 21:36:24","Car","658862941"),
  (5,"96","2020-12-06 23:52:53","Phone","428017212");

 -- ------------------------------------------------------
-- TRANS_FROM DATA
-- ------------------------------------------------------
INSERT INTO TRANS_FROM
(RTId,Identifier,Percentage)
VALUES
  (1,"ipsum.suspendisse@aol.org",'100'),
  (2,"lorem.vehicula@hotmail.couk",'100'),
  (3,"nulla@google.couk",'100'),
  (4,"urna.vivamus@yahoo.com",'100'),
  (5,"vulputate.dui@protonmail.couk",'100');
-- ------------------------------------------------------
-- EMAIL DATA
-- ------------------------------------------------------
INSERT INTO EMAIL
(EmailAdd,SSN)
VALUES
    ("amet@hotmail.ca",186176564),
    ("non@aol.org",519770016),
    ("leo.morbi@outlook.couk",779257597),
    ("tempus.mauris.erat@icloud.net",658862941),
    ("velit.eu.sem@hotmail.couk",428017212),
    ("ipsum.suspendisse@aol.org",335629970),
    ("lorem.vehicula@hotmail.couk",879647753),
    ("nulla@google.couk",661496961),
    ("urna.vivamus@yahoo.com",271490729),
    ("vulputate.dui@protonmail.couk",647200058);
-- ------------------------------------------------------
-- SEND_TRANSACTION DATA
-- ------------------------------------------------------
INSERT INTO SEND_TRANSACTION
(STId,Amount,Date_Time,Memo,Cancel_Reason,Identifier,SSN)
VALUES 
(1,"29","2020-12-04 00:06:22","Bread",'None',"8276363451",335629970),
(2,"87","2020-12-07 00:21:20","Car",'None',"4750846326",879647753),
(3,"39","2020-12-03 07:38:02","Utilities",'None',"9335647766",661496961),
(4,"50","2020-12-03 21:36:24","Car",'None',"0312847677",271490729),
(5,"96","2020-12-06 23:52:53","Phone",'None',"3123868775",647200058);
  