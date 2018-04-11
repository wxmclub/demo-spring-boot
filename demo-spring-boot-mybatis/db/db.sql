CREATE DATABASE `test` DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_user` (
  `id` char(32) NOT NULL COMMENT 'ID',
  `login_name` varchar(32) NOT NULL COMMENT '登录名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `create_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
