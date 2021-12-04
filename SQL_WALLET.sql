-- -----------------------------------------------------
-- walletNetwork Schema
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS WalletNetwork;
CREATE SCHEMA IF NOT EXISTS WalletNetwork DEFAULT CHARACTER SET utf8;
USE WalletNetwork;
-- -----------------------------------------------------
-- BANK_ACCOUNT Table
-- -----------------------------------------------------
DROP TABLE IF EXISTS BANK_ACCOUNT;
CREATE TABLE BANK_ACCOUNT
(
BankID int auto_increment ,
BANumber varchar(50) ,
PRIMARY KEY(BankID,BANumber)
);
-- -----------------------------------------------------
-- ELEC_ADDRESS Table
-- -----------------------------------------------------
DROP TABLE IF EXISTS ELEC_ADDRESS;
CREATE TABLE ELEC_ADDRESS
(
Identifier varchar(50),
Verified varchar(50),
Type varchar(50),
PRIMARY KEY (Identifier)
);
-- -----------------------------------------------------
-- USER_ACCOUNT TABLE
-- -----------------------------------------------------
DROP TABLE IF EXISTS USER_ACCOUNT;
CREATE TABLE USER_ACCOUNT
(
SSN int,
Name varchar(50),
PhoneNo varchar(50),
Balance int,
BankID int auto_increment,
BANumber varchar(50),
PBAVerified varchar(50),
PRIMARY KEY (SSN),
FOREIGN KEY (BankID,BANumber) REFERENCES BANK_ACCOUNT(BankID,BANumber),
FOREIGN KEY (PhoneNo) REFERENCES ELEC_ADDRESS(Identifier)
);
-- -----------------------------------------------------
-- HAS_ADDITIONAL TABLE
-- -----------------------------------------------------
DROP TABLE IF EXISTS HAS_ADDITIONAL;
CREATE TABLE HAS_ADDITIONAL
(
SSN int ,
BankID int auto_increment  ,
BANumber varchar(50)  ,
Verified varchar(50),
FOREIGN KEY (SSN) REFERENCES USER_ACCOUNT(SSN),
FOREIGN KEY (BankID,BANumber) REFERENCES BANK_ACCOUNT(BankID,BANumber),
PRIMARY KEY (SSN,BankID,BANumber)
);
-- -----------------------------------------------------
-- REQUEST_TRANSACTION Table
-- -----------------------------------------------------
DROP TABLE IF EXISTS REQUEST_TRANSACTION;
CREATE TABLE REQUEST_TRANSACTION
(
RTid int auto_increment,
Amount int,
Date_Time datetime,
Memo varchar(50),
SSN int,
FOREIGN KEY (SSN) REFERENCES USER_ACCOUNT(SSN),
PRIMARY KEY (RTid)
);
-- -----------------------------------------------------
-- TRANS_FROM Table
-- -----------------------------------------------------
DROP TABLE IF EXISTS TRANS_FROM;
CREATE TABLE TRANS_FROM
(
RTId int auto_increment ,
Identifier varchar(50) ,
Percentage int,
FOREIGN KEY (RTid) REFERENCES REQUEST_TRANSACTION(RTid),
FOREIGN KEY (Identifier) REFERENCES ELEC_ADDRESS(Identifier),
PRIMARY KEY(RTId,Identifier)
);
-- -----------------------------------------------------
-- EMAIL Table
-- -----------------------------------------------------
DROP TABLE IF EXISTS EMAIL;
CREATE TABLE EMAIL
(
EmailAdd varchar(50),
SSN int,
FOREIGN KEY (SSN) REFERENCES USER_ACCOUNT(SSN),
FOREIGN KEY(EmailAdd) REFERENCES ELEC_ADDRESS(Identifier),
PRIMARY KEY (EmailAdd)
);

-- -----------------------------------------------------
-- SEND_TRANSACTION Table
-- -----------------------------------------------------
DROP TABLE IF EXISTS SEND_TRANSACTION;
CREATE TABLE SEND_TRANSACTION
(
STid int auto_increment,
Amount int,
Date_Time datetime,
Memo varchar(50),
Cancel_Reason varchar(50),
Identifier varchar(50),
SSN int,
PRIMARY KEY (STid),
FOREIGN KEY (Identifier) REFERENCES ELEC_ADDRESS(Identifier),
FOREIGN KEY (SSN) REFERENCES USER_ACCOUNT(SSN)
);