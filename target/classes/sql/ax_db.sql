SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ax_app
-- ----------------------------
DROP TABLE IF EXISTS `ax_app`;
CREATE TABLE `ax_app`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '应用名称',
  `app_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '应用地址',
  `create_time` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '创建时间',
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '图片地址',
  `app_introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '应用介绍',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ax_app
-- ----------------------------
INSERT INTO `ax_app` VALUES (10, '蓝鲸智云', 'http://paas.bk.com', '2020-06-06 09:12:14', '/image/20200720151912.png', '蓝鲸CMDB');

-- ----------------------------
-- Table structure for base_admin_permission
-- ----------------------------
DROP TABLE IF EXISTS `base_admin_permission`;
CREATE TABLE `base_admin_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单名称',
  `pid` int(11) DEFAULT NULL COMMENT '父菜单id',
  `descpt` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单url',
  `create_time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '添加时间',
  `update_time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新时间',
  `del_flag` int(1) DEFAULT NULL COMMENT '删除标志（0:删除 1：存在）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of base_admin_permission
-- ----------------------------
INSERT INTO `base_admin_permission` VALUES (1, '系统管理', 0, '系统管理', '', '2018-11-30 10:27:34', '2018-11-30 10:27:34', 1);
INSERT INTO `base_admin_permission` VALUES (2, '账号管理', 1, '账号管理', '/user/userManage', '2018-11-30 11:44:41', '2018-11-30 11:56:34', 1);
INSERT INTO `base_admin_permission` VALUES (3, '角色管理', 1, '角色管理', '/role/roleManage', '2018-11-30 11:45:27', '2018-11-30 11:45:27', 1);
INSERT INTO `base_admin_permission` VALUES (7, '权限管理', 1, '权限管理', '/permission/permissionManage', '2018-11-30 11:48:35', '2018-11-30 15:13:38', 1);
INSERT INTO `base_admin_permission` VALUES (9, '基本设置', 0, '基本设置', '', '2018-11-30 12:10:32', '2018-11-30 12:10:32', 1);
INSERT INTO `base_admin_permission` VALUES (15, '应用管理', 0, '应用管理', '', '2020-05-28 10:54:10', '2020-05-28 10:54:10', 1);
INSERT INTO `base_admin_permission` VALUES (16, '应用注册', 15, '应用注册', '/app/appRegister', '2020-05-28 10:56:33', '2020-05-28 10:56:33', 1);
INSERT INTO `base_admin_permission` VALUES (18, '公众管理', 0, '公众管理', '', '2020-05-28 16:37:17', '2020-05-28 16:37:17', 1);
INSERT INTO `base_admin_permission` VALUES (19, '公众用户管理', 18, '公众用户管理', '/public/publicUser', '2020-05-28 16:38:21', '2020-05-28 16:38:21', 1);

-- ----------------------------
-- Table structure for base_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `base_admin_role`;
CREATE TABLE `base_admin_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限角色ID',
  `role_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_desc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色描述',
  `permissions` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限',
  `create_time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新时间',
  `role_status` int(1) NOT NULL DEFAULT 1 COMMENT '1：有效 \r\n            0：无效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of base_admin_role
-- ----------------------------
INSERT INTO `base_admin_role` VALUES (1, '系统管理员', '系统管理员', '1,9,15,18', '2018-11-21 15:54:07', '2020-05-28 16:39:16', 1);
INSERT INTO `base_admin_role` VALUES (2, '普通管理员', '普通管理员', '9', '2018-11-21 15:11:44', '2018-12-03 19:09:57', 1);

-- ----------------------------
-- Table structure for base_admin_user
-- ----------------------------
DROP TABLE IF EXISTS `base_admin_user`;
CREATE TABLE `base_admin_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `sys_user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统用户名称',
  `sys_user_pwd` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '系统用户密码',
  `role_id` int(255) DEFAULT NULL COMMENT '角色',
  `user_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `reg_time` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登记时间',
  `user_status` int(1) NOT NULL DEFAULT 0 COMMENT '状态（0：无效；1：有效）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统管理员帐号' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of base_admin_user
-- ----------------------------
INSERT INTO `base_admin_user` VALUES (1, 'root', '32e58d413c76a38debeb3e4af7ce46b9', 1, '18801296887', '2018-11-22 10:57:33', 1);
INSERT INTO `base_admin_user` VALUES (2, 'admin', '43442676c74ae59f219c2d87fd6bad52', 2, '18801296887', '2020-05-28 22:29:11', 1);

SET FOREIGN_KEY_CHECKS = 1;
