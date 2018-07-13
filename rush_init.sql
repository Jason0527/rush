create table lol_user(
id varchar2(64) primary key,  --主键id
login_no varchar2(12),  --登录账号（理解为QQ号）
nickname varchar2(24),  --昵称
password varchar2(100), --密码
account number(7),      --账户余额
unique (login_no));     --设置登录账号唯一性约束

alter table lol_user add CONSTRAINT account_check CHECK(account>=0);	--余额大于0

insert into lol_user (ID, LOGIN_NO, NICKNAME, PASSWORD, ACCOUNT)
values ('6b5c3ac767ea4aef9e94f8337558fdce', '321999836', '叵测', 'Q0RBQjNCRjdBRTREQTYxQ0E0NUM1Mjk3QUZGOEI2QkY=', 100000);

insert into lol_user (ID, LOGIN_NO, NICKNAME, PASSWORD, ACCOUNT)
values ('464e4398be2e4240b64267abaec6a02e', '1784129196', '紫禁之巅一珠莲', 'Q0RBQjNCRjdBRTREQTYxQ0E0NUM1Mjk3QUZGOEI2QkY=', 3000);

insert into lol_user (ID, LOGIN_NO, NICKNAME, PASSWORD, ACCOUNT)
values ('02ba30e890a94fc9817508ac9c588bcc', '1209596850', '最最亲爱的森哥', 'Q0RBQjNCRjdBRTREQTYxQ0E0NUM1Mjk3QUZGOEI2QkY=', 10000);

create table rush_hero(   --半价折扣英雄表
id varchar2(64) primary key,  --主键id
hero_name varchar2(24), --英雄名
rush_price number(7),   --促销价格
start_time date,        --促销开始时间
end_time date,          --促销结束时间
surplus number(8),
unique(hero_name));     --设置英雄名唯一（业务主键）

alter table rush_hero add CONSTRAINT surplus_check CHECK(surplus>=0) ;--库存大于0

insert into rush_hero (ID, HERO_NAME, RUSH_PRICE, START_TIME, END_TIME)
values ('f4bf1f9e4084464bb312fcb478685324', 'riven', 3150, to_date('12-07-2018 09:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('13-07-2018', 'dd-mm-yyyy'),100);

insert into rush_hero (ID, HERO_NAME, RUSH_PRICE, START_TIME, END_TIME)
values ('c01b3488c6e249e4bc45894454d3e56f', 'vayen', 2400, to_date('12-07-2018 09:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('13-07-2018', 'dd-mm-yyyy'),100);

insert into rush_hero (ID, HERO_NAME, RUSH_PRICE, START_TIME, END_TIME)
values ('35136445648c407ca998270492b2710d', 'jhin', 3150, to_date('12-07-2018 09:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('13-07-2018', 'dd-mm-yyyy'),100);

create table user_asset(  --用户所拥有的英雄
id varchar2(64) primary key,
login_no varchar2(12),
hero_name varchar2(24)
); 
ALTER TABLE user_asset
ADD CONSTRAINT user_asset_unique
UNIQUE (login_no,hero_name);


create table rush_record( --抢购记录表
id varchar2(64) primary key,
login_no varchar2(12),
hero_name varchar2(24),
create_time date);