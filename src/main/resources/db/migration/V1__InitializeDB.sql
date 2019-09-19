drop table if exists `t_user`;

create table `t_user`
(
    `id`       int(10) unsigned auto_increment,
    `username` varchar(50),
    `password` varchar(100),
    primary key (`id`)
) engine = innoDB
  default charset = utf8;