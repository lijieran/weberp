SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS stock_info;
DROP TABLE IF EXISTS stock_master;
DROP TABLE IF EXISTS stock_category;
DROP TABLE IF EXISTS stock_location;
DROP TABLE IF EXISTS unit;




/* Create Tables */

-- 物料组
CREATE TABLE stock_category
(
	-- 物料组编号
	categoryid varchar(20) NOT NULL COMMENT '物料组编号',
	-- 描述
	description varchar(200) COMMENT '描述',
	PRIMARY KEY (categoryid)
) COMMENT = '物料组';


-- 仓库货存详情
CREATE TABLE stock_info
(
	-- 仓库编号
	loccode varchar(20) NOT NULL COMMENT '仓库编号',
	-- 物料编号
	stockid varchar(20) NOT NULL COMMENT '物料编号',
	-- 数量
	quantity int COMMENT '数量',
	PRIMARY KEY (loccode, stockid)
) COMMENT = '仓库货存详情';


-- 仓库位置
CREATE TABLE stock_location
(
	-- 仓库编号
	loccode varchar(20) NOT NULL COMMENT '仓库编号',
	-- 库存名称
	name varchar(200) COMMENT '库存名称',
	-- 仓库地址
	address varchar(200) COMMENT '仓库地址',
	-- 电话
	telephone varchar(30) COMMENT '电话',
	-- 联系人
	linkname varchar(100) COMMENT '联系人',
	PRIMARY KEY (loccode)
) COMMENT = '仓库位置';


CREATE TABLE stock_master
(
	-- 物料编号
	stockid varchar(20) NOT NULL COMMENT '物料编号',
	-- 描述
	description varchar(200) COMMENT '描述',
	-- 物料组编号
	categoryid varchar(20) NOT NULL COMMENT '物料组编号',
	-- 合理定单数量
	eoq int COMMENT '合理定单数量',
	-- 计量单位
	units varchar(10) COMMENT '计量单位',
	PRIMARY KEY (stockid)
);


-- 计量单位
CREATE TABLE unit
(
	-- 计量编号
	unitid smallint NOT NULL COMMENT '计量编号',
	-- 单位名称
	unitname varchar(50) COMMENT '单位名称',
	PRIMARY KEY (unitid)
) COMMENT = '计量单位';



/* Create Foreign Keys */

ALTER TABLE stock_master
	ADD FOREIGN KEY (categoryid)
	REFERENCES stock_category (categoryid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE stock_info
	ADD FOREIGN KEY (loccode)
	REFERENCES stock_location (loccode)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE stock_info
	ADD FOREIGN KEY (stockid)
	REFERENCES stock_master (stockid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



