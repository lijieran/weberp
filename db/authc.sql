SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS authc_dict;
DROP TABLE IF EXISTS authc_log;
DROP TABLE IF EXISTS authc_role_menu;
DROP TABLE IF EXISTS authc_menu;
DROP TABLE IF EXISTS authc_office;
DROP TABLE IF EXISTS authc_user_role;
DROP TABLE IF EXISTS authc_role;
DROP TABLE IF EXISTS authc_user;
DROP TABLE IF EXISTS meta;
DROP TABLE IF EXISTS meta_type;




/* Create Tables */

-- 字典表
CREATE TABLE authc_dict
(
	-- 编号
	id bigint NOT NULL COMMENT '编号',
	-- 数据值
	value varchar(100) NOT NULL COMMENT '数据值',
	-- 标签名
	label varchar(100) NOT NULL COMMENT '标签名',
	-- 类型
	type varchar(100) NOT NULL COMMENT '类型',
	-- 描述
	description varchar(100) NOT NULL COMMENT '描述',
	-- 排序（升序）
	sort decimal(10,0) NOT NULL COMMENT '排序（升序）',
	-- 父级编号
	parent_id varchar(64) DEFAULT '0' COMMENT '父级编号',
	PRIMARY KEY (id)
) COMMENT = '字典表';


-- 日志表
CREATE TABLE authc_log
(
	-- 编号
	id bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
	-- 日志类型（1：接入日志；2：异常日志）
	type char(1) DEFAULT '1' COMMENT '日志类型（1：接入日志；2：异常日志）',
	title varchar(500),
	-- 创建者
	create_by varchar(64) COMMENT '创建者',
	-- 创建时间
	create_time datetime COMMENT '创建时间',
	-- 操作IP地址
	remote_addr varchar(255) COMMENT '操作IP地址',
	-- 用户代理
	user_agent varchar(255) COMMENT '用户代理',
	-- 请求URI
	request_uri varchar(255) COMMENT '请求URI',
	-- 操作方式
	method varchar(5) COMMENT '操作方式',
	-- 操作提交的数据
	params text COMMENT '操作提交的数据',
	-- 异常信息
	exception text COMMENT '异常信息',
	PRIMARY KEY (id)
) COMMENT = '日志表';


-- 菜单表
CREATE TABLE authc_menu
(
	-- 编号
	id bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
	-- 链接
	href varchar(2000) COMMENT '链接',
	-- 图标
	icon varchar(100) COMMENT '图标',
	-- 权限标识
	permission varchar(200) COMMENT '权限标识',
	-- 菜单状态：0=停用，1=虚拟，2=启用，3=启用并停靠菜单
	status char(1) DEFAULT '3' COMMENT '菜单状态：0=停用，1=虚拟，2=启用，3=启用并停靠菜单',
	-- 父级编号
	parent_id varchar(64) COMMENT '父级编号',
	-- 名称
	name varchar(100) COMMENT '名称',
	-- 排序
	sort decimal(10,0) DEFAULT 0 COMMENT '排序',
	PRIMARY KEY (id)
) COMMENT = '菜单表';


-- 部门表
CREATE TABLE authc_office
(
	-- 编号
	id bigint NOT NULL COMMENT '编号',
	-- 机构类型（1：公司；2：部门；3：小组）
	type char(1) DEFAULT '1' NOT NULL COMMENT '机构类型（1：公司；2：部门；3：小组）',
	-- 机构等级（1：一级；2：二级；3：三级；4：四级）
	grade char(1) DEFAULT '1' NOT NULL COMMENT '机构等级（1：一级；2：二级；3：三级；4：四级）',
	-- 联系地址
	address varchar(255) COMMENT '联系地址',
	-- 邮政编码
	zip_code varchar(100) COMMENT '邮政编码',
	-- 负责人
	master varchar(100) COMMENT '负责人',
	-- 电话
	phone varchar(200) COMMENT '电话',
	-- 传真
	fax varchar(200) COMMENT '传真',
	-- 邮箱
	email varchar(200) COMMENT '邮箱',
	-- 是否启用:1=启用;0=停用
	useable varchar(64) DEFAULT '1' COMMENT '是否启用:1=启用;0=停用',
	primary_person varchar(64),
	deputy_person varchar(64),
	-- 父级编号
	parent_id varchar(64) COMMENT '父级编号',
	-- 名称
	name varchar(100) COMMENT '名称',
	-- 排序
	sort decimal(10,0) DEFAULT 0 COMMENT '排序',
	PRIMARY KEY (id)
) COMMENT = '部门表';


-- 角色表
CREATE TABLE authc_role
(
	-- 编号
	id bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
	-- 角色名称
	name varchar(100) NOT NULL COMMENT '角色名称',
	-- 是否可用。1=可用，0=不可用
	useable varchar(1) DEFAULT '1' COMMENT '是否可用。1=可用，0=不可用',
	-- 描述
	description varchar(255) DEFAULT '' COMMENT '描述',
	PRIMARY KEY (id)
) COMMENT = '角色表';


-- 角色-菜单
CREATE TABLE authc_role_menu
(
	-- 角色编号
	role_id bigint NOT NULL COMMENT '角色编号',
	-- 菜单编号
	menu_id bigint NOT NULL COMMENT '菜单编号',
	PRIMARY KEY (role_id, menu_id)
) COMMENT = '角色-菜单';


-- 用户表
CREATE TABLE authc_user
(
	-- 编号
	id bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
	-- 登录名
	username varchar(100) NOT NULL COMMENT '登录名',
	-- 密码
	password varchar(100) NOT NULL COMMENT '密码',
	-- 工号
	no varchar(100) COMMENT '工号',
	-- 姓名
	name varchar(100) NOT NULL COMMENT '姓名',
	-- 邮箱
	email varchar(200) DEFAULT '' COMMENT '邮箱',
	-- 电话
	phone varchar(200) COMMENT '电话',
	-- 手机
	mobile varchar(200) DEFAULT '' COMMENT '手机',
	photo varchar(1000) DEFAULT '',
	-- 最后登陆IP
	login_ip varchar(100) COMMENT '最后登陆IP',
	-- 最后登陆时间
	login_time datetime COMMENT '最后登陆时间',
	-- 是否可登录.0=禁用，1=可以
	useable varchar(64) DEFAULT '1' COMMENT '是否可登录.0=禁用，1=可以',
	PRIMARY KEY (id)
) COMMENT = '用户表';


-- 用户-角色
CREATE TABLE authc_user_role
(
	-- 用户编号
	user_id bigint NOT NULL COMMENT '用户编号',
	-- 角色编号
	role_id bigint NOT NULL COMMENT '角色编号',
	PRIMARY KEY (user_id, role_id)
) COMMENT = '用户-角色';


CREATE TABLE meta
(
	-- 编号
	id bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
	-- 文本
	label varchar(255) COMMENT '文本',
	-- 值
	value varchar(255) COMMENT '值',
	-- 是否启用:1=启用;0=停用
	useable varchar(64) DEFAULT '1' COMMENT '是否启用:1=启用;0=停用',
	-- 代码
	code varchar(255) NOT NULL COMMENT '代码',
	PRIMARY KEY (id),
	UNIQUE (code)
);


CREATE TABLE meta_type
(
	-- 代码
	code varchar(255) NOT NULL COMMENT '代码',
	-- 名称
	name varchar(255) COMMENT '名称',
	PRIMARY KEY (code),
	UNIQUE (code)
);



/* Create Foreign Keys */

ALTER TABLE authc_role_menu
	ADD FOREIGN KEY (menu_id)
	REFERENCES authc_menu (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE authc_role_menu
	ADD FOREIGN KEY (role_id)
	REFERENCES authc_role (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE authc_user_role
	ADD FOREIGN KEY (role_id)
	REFERENCES authc_role (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE authc_user_role
	ADD FOREIGN KEY (user_id)
	REFERENCES authc_user (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE meta
	ADD FOREIGN KEY (code)
	REFERENCES meta_type (code)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



