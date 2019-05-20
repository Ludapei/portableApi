--本地版本是mysql 5.7 ，建表字段不应该含有单引号
-- 数据库初始化脚本

-- 创建数据库
CREATE database seckill;
-- 使用数据库
use seckill;
show tables;
select * from seckill.seckill
drop table seckill;
-- 在下面这个表当中的字段'start_time'是一个timestamp类型的，mysql5.7可能会出现invalid default value的异常，因此我就将其添加默认值 current_timestamp
-- 创建秒杀库存表
create table seckill(
  seckill_id bigint  not null auto_increment
  comment '商品库存',
  name VARCHAR(120) NOT NULL
  COMMENT '商品名称',
  number int NOT NULL
  comment '库存数量',
  start_time TIMESTAMP NOT NULL DEFAULT current_timestamp
  COMMENT '秒杀开始时间',
  end_time   TIMESTAMP NOT NULL DEFAULT current_timestamp
  COMMENT '秒杀结束时间',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp
    COMMENT '创建时间',
  primary key (seckill_id),
  KEY idx_start_time(start_time),
  key idx_end_time(end_time),
  KEY idx_create_time(create_time)
)
  ENGINE = innoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8
  COMMENT ='秒杀库存表';
-- 初始化数据
INSERT INTO seckill(name, number,start_time,end_time)
    VALUE
  ('1000元秒杀iphone6', 100, '2018-1-8 00:00:00', '2018-1-9 00:00:00'),
  ('1800元秒杀ipad2', 200, '2018-1-8 00:00:00', '2018-1-9 00:00:00'),
  ('300元秒杀小米5', 300, '2018-1-8 00:00:00', '2018-1-9 00:00:00'),
  ('200元秒杀红米', 200, '2018-1-8 00:00:00', '2018-1-9 00:00:00'),
  ('1000元秒杀iphone8', 400, '2018-1-8 00:00:00', '2018-1-9 00:00:00');

# 添加一条不过期的信息
INSERT INTO seckill (name, number, start_time, end_time)
    VALUE ('88888元秒杀P20',100,'2018-1-8 00:00:00','2019-1-1 00:00:00');

-- 秒杀成功明细表
-- 用户登录认证相关信息
create table success_killed(
  seckll_id BIGINT not null
  COMMENT '秒杀商品id',
  user_phone BIGINT NOT NULL
  COMMENT '用户手机号',
  state TINYINT not NULL DEFAULT -1
  COMMENT '状态表示：-1 无效 0 成功 1 已经付款',
  create_time TIMESTAMP not NULL
  COMMENT '创建时间',
  primary KEY (seckll_id,user_phone),/*联合主键*/
  KEY idx_create_time (create_time)

)
  engine =innodb
  default CHARSET =utf8
  COMMENT '秒杀成功明细表';
-- 连接数据库控制台




select * from seckill

       select seckill_id,name,number,start_time,end_time,CREATE_TIME
        from seckill
        order by create_time DESC
