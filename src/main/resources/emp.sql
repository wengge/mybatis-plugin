CREATE TABLE `emp` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(255) DEFAULT '' COMMENT '名字',
  `sex` tinyint(1) DEFAULT '0' COMMENT '0:男，1：女',
  `idcard` varchar(20) DEFAULT '' COMMENT '身份证号',
  `salary` decimal(10,2) DEFAULT NULL,
  `mobile` varchar(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `emp` VALUES (1, '张三', 0, '123451', 500.00, '11111111111', '11qq1111@qq.com');
INSERT INTO `emp` VALUES (2, '李四', 1, '123452', 1000.00, '2222222222', '11qq1111@qq.com');
INSERT INTO `emp` VALUES (3, '王五', 0, '123453', 1000.00, '3333333333', '11qq1111@qq.com');
INSERT INTO `emp` VALUES (4, '赵六', 0, '123454', 1000.00, '44444444444', '11qq1111@qq.com');
INSERT INTO `emp` VALUES (5, '李琦', 1, '123455', 2000.00, '5555555555', '11qq1111@qq.com');
INSERT INTO `emp` VALUES (6, '王八', 1, '123456', 1000.00, '6666666666', '11qq1111@qq.com');
INSERT INTO `emp` VALUES (7, '李久', 0, '123457', 1000.00, '7777777777', '11qq1111@qq.com');



