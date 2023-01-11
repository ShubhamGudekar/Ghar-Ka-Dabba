CREATE DATABASE gharKaDabba;

use gharKaDabba;

-- Customer/User Table
CREATE TABLE customer (
cId int PRIMARY KEY AUTO_INCREMENT,
cFirstName varchar(50) NOT NULL,
cLastName varchar(50) NOT NULL,
cEmail varchar(50) UNIQUE NOT NULL,
cPassword varchar(50) NOT NULL,
cMobile varchar(15) UNIQUE NOT NULL,
cRegisterDate timestamp default (CURRENT_TIMESTAMP)
);

-- insert into customer values(default,"abc","xyz","abc@gmail.com",MD5("abc"),"8087226422",default);

-- One Customer can have multiple Delivery Address
CREATE TABLE deliveryAddress(
dAId int PRIMARY KEY AUTO_INCREMENT,
cId int,
dALine1 varchar(255),
dALine2 varchar(255),
dACity varchar(25),
dAPincode int,
dAState varchar(50),
CONSTRAINT fk_deliveryCId FOREIGN KEY(cId) REFERENCES customer(cId) ON DELETE CASCADE
);

-- vendor/seller table 
CREATE TABLE vendor (
vId int PRIMARY KEY AUTO_INCREMENT,
vFirstName varchar(50) NOT NULL,
vLastName varchar(50) NOT NULL,
vEmail varchar(50) UNIQUE NOT NULL,
vPassword varchar(50) NOT NULL,
vMobile varchar(15) UNIQUE NOT NULL,
vAddress varchar(255),
vRegisterDate timestamp default (CURRENT_TIMESTAMP),
vStatus enum('NOT_VERIFIED','VERIFIED') NOT NULL DEFAULT 'NOT_VERIFIED'
);

-- insert into VENDOR values(default,"abc","xyz","abc@gmail.com",MD5("abc"),"8087226422","abcxyz",default,default);
-- stored procedure for approving vendor
delimiter $$
CREATE PROCEDURE verifyVendor(in pVId int)
BEGIN
  UPDATE vendor
  SET vStatus="VERIFIED"
  WHERE vId=pVID;
END $$
delimiter ;


-- menu table
CREATE TABLE menu (
mId int PRIMARY KEY AUTO_INCREMENT,
vId int,
mItemName varchar(50) NOT NULL,
mItemPrice decimal(7,2) NOT NULL,
mItemCategory enum('VEG','NONVEG'),
mItemStatus enum('OUT_OF_STOCK','AVALIABLE','REMOVED') NOT NULL DEFAULT 'AVALIABLE',
mDescription varchar(255),
mImagePath varchar(255),
CONSTRAINT fk_menuVId FOREIGN KEY(vId) REFERENCES vendor(vId) ON DELETE CASCADE
);
  
-- insert into menu values(default,1,"chapati",10,"veg","round and fluffy","");
  
-- order table
CREATE TABLE orderDetails (
oId int PRIMARY KEY AUTO_INCREMENT,
cId int,
dAId int,
oTime timestamp default (CURRENT_TIMESTAMP),
oStatus enum('PENDING','CONFIRMED','REJECTED','OUT_FOR_DELIVERY','DELIVERED','CANCELED') NOT NULL DEFAULT 'PENDING',
oAmount decimal(7,2) NOT NULL,
oReview varchar(255),
CONSTRAINT fk_orderCId FOREIGN KEY(cId) REFERENCES customer(cId),
CONSTRAINT fk_orderDAId FOREIGN KEY(dAId) REFERENCES deliveryAddress(dAId)
);

-- one order can contain multiple dishes
CREATE TABLE orderDescription (
oDid int PRIMARY KEY AUTO_INCREMENT,
oId int,
mId int,
quantity int,
CONSTRAINT fk_orderDescOId FOREIGN KEY(oId) REFERENCES orderDetails(oId),
CONSTRAINT fk_orderDescmId FOREIGN KEY(mId) REFERENCES menu(mId)
);




-- is this really needed
-- creating trigger for menu item add ,remove or update;
/*
CREATE TABLE menuManagement(
mId int,
vId int,
mOldItemName varchar(50),
mNewItemName varchar(50),
mOldItemPrice decimal(7,2),
mNewItemPrice decimal(7,2),
mOldItemCategory varchar(10),
mNewItemCategory varchar(10),
mOldItemStatus varchar(20),
mNewItemStatus varchar(20),
mOldDescription varchar(255),
mNewDescription varchar(255),
mOldImagePath varchar(255),
mNewImagePath varchar(255),
mMDate timestamp default (CURRENT_TIMESTAMP),
mMStatus enum('INSERT','DELETE','UPDATE')
);

delimiter $$
create trigger insertItem after insert on menu for each row
begin
insert into menuManagement(mId,vId,mNewItemName,mNewItemPrice,mNewItemCategory,mNewItemStatus,mNewDescription,mNewImagePath,mMDate,mMStatus)
values(new.mId,new.vId,new.mItemName,new.mItemPrice,new.mItemCategory,new.mItemStatus,new.mDescription,new.mImagePath,now(),'Insert');
end$$

create trigger deleteItem before delete on menu for each row
begin
insert into menuManagement(mId,vId,mOldItemName,mOldItemPrice,mOldItemCategory,mOldItemStatus,mOldDescription,mOldImagePath,mMDate,mMStatus)
values(old.mId,old.vId,old.mItemName,old.mItemPrice,old.mItemCategory,old.mOldItemStatus,old.mDescription,old.mImagePath,now(),'Delete');
end$$

create trigger updateItem before update on menu for each row
begin
insert into menuManagement values(old.mId,new.vId,old.mItemName,new.mItemName,old.mItemPrice,new.mItemPrice,
old.mItemCategory,new.mItemCategory,old.mDescription,new.mDescription,old.mImagePath,new.mImagePath,now(),'Update');
end$$
delimiter ;
*/

cId int PRIMARY KEY AUTO_INCREMENT,
cFirstName varchar(50) NOT NULL,
cLastName varchar(50) NOT NULL,
cEmail varchar(50) UNIQUE NOT NULL,
cPassword varchar(50) NOT NULL,
cMobile varchar(15) UNIQUE NOT NULL,
cRegisterDate timestamp default (CURRENT_TIMESTAMP)

INSERT INTO customer VALUES
(default,'Rishal','Mehta','rishalMehta@gmail.com',MD5('rishal'),'0123456789',DEFAULT),
(default,'Shubham','Gudekar','shubhamgudekar@gmail.com',MD5('shubham'),'1234567890',DEFAULT),
(default,'Sagar','Satav','sagarsatav@gmail.com',MD5('sagar'),'2345678901',DEFAULT),
(default,'Sourav','Patil','souravpatil@gmail.com',MD5('sourav'),'3456789012',DEFAULT),
(default,'Ram','Manjare','rammanjare@gmail.com',MD5('ram'),'4567890123',DEFAULT),
(default,'Abhishek','Shinde','abhishekshinde@gmail.com',MD5('abhishek'),'567890123',DEFAULT),
(default,'Runesh','Gazane','runeshgazane@gmail.com',MD5('runesh'),'6789012345',DEFAULT),
(default,'Athrava','Jadhav','athravajadhav@gmail.com',MD5('sakshi'),'7890123456',DEFAULT),
(default,'Sujit','Singh','sujitsingh@gmail.com',MD5('sujit'),'8901234567',DEFAULT),
(default,'Abhishek','Saswade','abhisheksaswade@gmail.com',MD5('saswade'),'9012345678',DEFAULT);
	
	
DELIMITER $$
CREATE PROCEDURE signIn (in pEmail varchar(50),in pPassword varchar(50))
BEGIN
	SELECT *
	FROM customer
	WHERE pEmail=cEmail && MD5(pPassword)=cPassword;
END $$
DELIMITER ;

