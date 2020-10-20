select * from accounts;

select sum(accountBalance) from accounts where accountStatus = '수입' && category = '에고...';

drop table accounts;

create table accounts (
	accountId int not null auto_increment,
    categoryId int not null default 1,
    accountTitle varchar(255) not null,
    accountContent varchar(255) not null,
    accountBalance int default 0 not null,
    accountStatus varchar(255) not null,
    accountDate timestamp not null default current_timestamp,
    primary key(accountId),
    foreign key (categoryId) references category (categoryId)
);

insert into accounts (
	categoryId, 
    accountTitle, 
    accountContent, 
    accountBalance,
    accountStatus
) values (
	1, 
    "미지정 제목", 
    "미지정 내용", 
    1,
    (select accountStatus from category where categoryId = 1)
);
create table category (
	categoryId int not null auto_increment,
    categoryName varchar(255),
    AccountStatus varchar(255),
    primary key(categoryId)
);

insert into category (
categoryName, AccountStatus
) select 
	"비상금", "수입"
     from category where not exists(
	select categoryName from category where categoryName = "비상금"
) limit 1;


select categoryName from category where categoryName = "급여";

insert into category (categoryName, AccountStatus) values ("미지정", "미지정");

insert into category (categoryName, AccountStatus) values ("용돈", "수입");
insert into category (categoryName, AccountStatus) values ("보너스", "수입");
insert into category (categoryName, AccountStatus) values ("부업", "수입");
insert into category (categoryName, AccountStatus) values ("투자", "수입");

insert into category (categoryName, AccountStatus) values ("식사", "소비");
insert into category (categoryName, AccountStatus) values ("일용품", "소비");
insert into category (categoryName, AccountStatus) values ("의복", "소비");
insert into category (categoryName, AccountStatus) values ("미용", "소비");
insert into category (categoryName, AccountStatus) values ("교제비", "소비");
insert into category (categoryName, AccountStatus) values ("의료비", "소비");
insert into category (categoryName, AccountStatus) values ("교육비", "소비");
insert into category (categoryName, AccountStatus) values ("공공요금", "소비");
insert into category (categoryName, AccountStatus) values ("교통", "소비");

select * from category;
select * from accounts;

drop table category;
drop table accounts;