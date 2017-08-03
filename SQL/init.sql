/* 构建普通用户数据表*/
create table if not exists users(
id bigint primary key AUTO_INCREMENT,
account varchar(100) unique not NULL,
password varchar(100) not NULL,
mail varchar(100) not NULL, 
phone varchar(100),
address varchar(200),
postCode varchar(30),
validateCode varchar(200) not NULL,
mailStatus int not NULL
)character set =utf8;

/*构建管理员用户数据表*/
create table if not exists managers(
id bigint primary key AUTO_INCREMENT,
account varchar(100) unique not NULL,
password varchar(100) not NULL,
mail varchar(30) not NULL,
name varchar(20),
phone varchar(20),
validateCode varchar(100) not NULL,
mailStatus int not NULL
)character set = utf8;

/*构建商店管理表*/
create table if not exists shops(
id bigint primary key AUTO_INCREMENT,
name varchar(30) not NULL,
description text,
managerId bigint not NULL
) character set=utf8;


/*构建商店中商品的评论数据表*/
create table if not exists remarks(
id bigint primary key AUTO_INCREMENT,
productId bigint not NULL,
time_ varchar(30) not NULL,
content text not NULL,
userId bigint not NULL,
state int not NULL
)character set=utf8;

/*构建购物车管理表*/
create table if not exists carts(
  id bigint primary key AUTO_INCREMENT,
  userId bigint not null,
  cost double not NULL
)character set = utf8;


/*订单管理*/
create table if not exists orders(
id bigint primary key AUTO_INCREMENT,
order_num varchar(100) not NULL,
status int not NULL,
cost double not NULL,
userId bigint not NULL,
managerId bigint not NULL
)character set =utf8;

/*商品数据表*/
create table if not exists products(
id bigint primary key AUTO_INCREMENT,
name varchar(30) not NULL,
description text,
num int not NULL,
img_id bigint not NULL,
price double not NULL,
good_rate double not NULL,
sale_num int not NULL,
type_ varchar(30) not NULL,
shopId bigint not NULL,
cartId bigint not NULL,
orderId bigint not NULL,
sql_type int not NULL
)character set = utf8;

create table if not exists imgs(
img_id bigint not NULL,
productId bigint not NULL
);

