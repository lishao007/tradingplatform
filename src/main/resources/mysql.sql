drop Table if exists `shop`;
drop Table if exists `order`;
drop Table if exists `user`;

create Table `user`(
                       `id`            varchar(32) not null comment '用户id',
                       `user_name`     varchar(20)          comment '用户名称',
                       `user_number`   varchar(11) not null comment '用户账号',
                       `user_password` varchar(20) not null comment '用户密码',
                       `user_photo`    mediumtext           comment '用户头像',
                       `user_sex`      varchar(1)           comment '用户性别',
                       `user_age`      int                  comment '用户年龄',
                       primary key (`id`)
);

create Table `shop`(
                       `product_id`     int           not null comment '商品id' auto_increment,
                       `product_name`   varchar(20)   not null comment '商品名称',
                       `product_price`  decimal(6, 2) not null comment '商品价格',
                       `product_photo`  mediumtext    not null comment '商品图片',
                       `product_detial` varchar(255)  not null comment '商品描述',
                       `product_count`  int                    comment '商品数量',
                       `user_id`        varchar(32)   not null,
                       primary key (`product_id`),
                       foreign key (`user_id`) references `user` (`id`) on delete cascade
);

create Table `order`(
                      `product_id`    int           not null comment '商品id' auto_increment,
                      `product_name`  varchar(20)   not null comment '商品名称',
                      `product_price` decimal(6, 2) not null comment '商品价格',
                      `product_photo` mediumtext    not null comment '商品图片',
                      `create_time`   datetime      not null comment '下单时间',
                      `product_count` int                    comment '订单数量',
                      `user_id`       varchar(32)   not null,
                      primary key (`product_id`),
                      foreign key (`user_id`) references `user` (`id`) on delete cascade
);
