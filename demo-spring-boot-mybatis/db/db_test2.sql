CREATE DATABASE `test2` DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_car` (
  `id` char(32) NOT NULL COMMENT 'ID',
  `name` varchar(32) NOT NULL COMMENT '名称',
  `color` varchar(32) NOT NULL COMMENT '颜色',
  `create_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
