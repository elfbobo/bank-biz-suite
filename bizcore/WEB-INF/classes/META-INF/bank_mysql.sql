<<<<<<< HEAD
-- BUILD WITH MODEL TIME 190824T2242

create database if not exists bank_190824T224314;
use bank_190824T224314
=======
-- BUILD WITH MODEL TIME 190826T1611

create database if not exists bank_190830T163509;
use bank_190830T163509
>>>>>>> 8c1580262f63aadc12e1024abc0444ec92345e2c
-- use table_name as parameter does not work :(-, changed to t_name then works
drop PROCEDURE if exists  BACKUP;
DELIMITER $$  
CREATE PROCEDURE BACKUP()  
BEGIN  
	DECLARE t_name varchar(160);
	DECLARE done INT DEFAULT FALSE;
	DECLARE cur CURSOR FOR SELECT TABLE_NAME  FROM information_schema.tables  WHERE table_schema='bank';
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done=TRUE;
	OPEN cur;
	read_loop: LOOP
 		FETCH cur INTO t_name;
 		IF done THEN
      		LEAVE read_loop;
    	END IF;
<<<<<<< HEAD
 		set @renamestat=concat("rename table bank.",t_name," to bank_190824T224314.",t_name);
=======
 		set @renamestat=concat("rename table bank.",t_name," to bank_190830T163509.",t_name);
>>>>>>> 8c1580262f63aadc12e1024abc0444ec92345e2c
 		PREPARE stmt FROM @renamestat; 
 		execute stmt;
 	END LOOP;
 	CLOSE cur;
END$$  
DELIMITER ;

call BACKUP;

drop database  if exists bank;
create database bank;
-- alter  database bank  character set = utf8mb4  collate = utf8mb4_unicode_ci; -- 支持表情符号
use bank;

drop table  if exists platform_data;
create table platform_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(24)                              comment 'Name',
	founded                       	datetime                                 comment 'Founded',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Platform";

drop table  if exists change_request_data;
create table change_request_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(50)                              comment '名称',
	create_time                   	datetime                                 comment '创建时间',
	remote_ip                     	varchar(40)                              comment '远程Ip',
	platform                      	varchar(48)                              comment '平台',
	version                       	int                                      comment '版本',
=======
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(50)                              comment 'Name',
	create_time                   	datetime                                 comment 'Create Time',
	remote_ip                     	varchar(40)                              comment 'Remote Ip',
	platform                      	varchar(48)                              comment 'Platform',
	version                       	int                                      comment 'Version',
>>>>>>> 8c1580262f63aadc12e1024abc0444ec92345e2c
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Change Request";

drop table  if exists transaction_data;
create table transaction_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(50)                              comment '名称',
	from_account                  	varchar(48)                              comment '从账户',
	to_account                    	varchar(48)                              comment '承担责任',
	amount                        	numeric(7,2)                             comment '金额',
	type                          	varchar(8)                               comment '类型',
	change_request                	varchar(48)                              comment '变更请求',
	version                       	int                                      comment '版本',
=======
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(50)                              comment 'Name',
	from_account                  	varchar(48)                              comment 'From Account',
	to_account                    	varchar(48)                              comment 'To Account',
	amount                        	numeric(7,2)                             comment 'Amount',
	type                          	varchar(8)                               comment 'Type',
	change_request                	varchar(48)                              comment 'Change Request',
	version                       	int                                      comment 'Version',
>>>>>>> 8c1580262f63aadc12e1024abc0444ec92345e2c
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Transaction";

drop table  if exists name_change_event_data;
create table name_change_event_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(50)                              comment '名称',
	account                       	varchar(48)                              comment '账户',
	change_request                	varchar(48)                              comment '变更请求',
	version                       	int                                      comment '版本',
=======
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(50)                              comment 'Name',
	account                       	varchar(48)                              comment 'Account',
	change_request                	varchar(48)                              comment 'Change Request',
	version                       	int                                      comment 'Version',
>>>>>>> 8c1580262f63aadc12e1024abc0444ec92345e2c
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Name Change Event";

drop table  if exists account_data;
create table account_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(50)                              comment '名称',
	balance                       	numeric(7,2)                             comment '余额',
	create_time                   	datetime                                 comment '创建时间',
	update_time                   	datetime                                 comment '更新时间',
	platform                      	varchar(48)                              comment '平台',
	version                       	int                                      comment '版本',
=======
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(50)                              comment 'Name',
	balance                       	numeric(7,2)                             comment 'Balance',
	create_time                   	datetime                                 comment 'Create Time',
	update_time                   	datetime                                 comment 'Update Time',
	platform                      	varchar(48)                              comment 'Platform',
	version                       	int                                      comment 'Version',
>>>>>>> 8c1580262f63aadc12e1024abc0444ec92345e2c
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Account";

drop table  if exists account_change_data;
create table account_change_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(50)                              comment '名称',
	account                       	varchar(48)                              comment '账户',
	previous_balance              	numeric(8,2)                             comment '初期余额',
	type                          	varchar(8)                               comment '类型',
	amount                        	numeric(7,2)                             comment '金额',
	current_balance               	numeric(8,2)                             comment '当前余额',
	change_request                	varchar(48)                              comment '变更请求',
	version                       	int                                      comment '版本',
=======
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(50)                              comment 'Name',
	account                       	varchar(48)                              comment 'Account',
	previous_balance              	numeric(8,2)                             comment 'Previous Balance',
	type                          	varchar(8)                               comment 'Type',
	amount                        	numeric(7,2)                             comment 'Amount',
	current_balance               	numeric(8,2)                             comment 'Current Balance',
	change_request                	varchar(48)                              comment 'Change Request',
	version                       	int                                      comment 'Version',
>>>>>>> 8c1580262f63aadc12e1024abc0444ec92345e2c
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Account Change";

drop table  if exists user_domain_data;
create table user_domain_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(16)                              comment 'Name',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "User Domain";

drop table  if exists user_white_list_data;
create table user_white_list_data (
	id                            	varchar(48)          not null            comment 'Id',
	user_identity                 	varchar(40)                              comment 'User Identity',
	user_special_functions        	varchar(200)                             comment 'User Special Functions',
	domain                        	varchar(48)                              comment 'Domain',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "User White List";

drop table  if exists sec_user_data;
create table sec_user_data (
	id                            	varchar(48)          not null            comment 'Id',
	login                         	varchar(20)                              comment 'Login',
	mobile                        	varchar(11)                              comment 'Mobile',
	email                         	varchar(76)                              comment 'Email',
	pwd                           	varchar(64)                              comment 'Pwd',
	weixin_openid                 	varchar(128)                             comment 'Weixin Openid',
	weixin_appid                  	varchar(128)                             comment 'Weixin Appid',
	access_token                  	varchar(128)                             comment 'Access Token',
	verification_code             	int                                      comment 'Verification Code',
	verification_code_expire      	datetime                                 comment 'Verification Code Expire',
	last_login_time               	datetime                                 comment 'Last Login Time',
	domain                        	varchar(48)                              comment 'Domain',
	blocking                      	varchar(48)                              comment 'Blocking',
	current_status                	varchar(28)                              comment 'Current Status',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Sec User";

drop table  if exists sec_user_blocking_data;
create table sec_user_blocking_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(52)                              comment 'Who',
	block_time                    	datetime                                 comment 'Block Time',
	comments                      	varchar(96)                              comment 'Comments',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Sec User Blocking";

drop table  if exists user_app_data;
create table user_app_data (
	id                            	varchar(48)          not null            comment 'Id',
	title                         	varchar(300)                             comment 'Title',
	sec_user                      	varchar(48)                              comment 'Sec User',
	app_icon                      	varchar(36)                              comment 'App Icon',
	full_access                   	tinyint                                  comment 'Full Access',
	permission                    	varchar(16)                              comment 'Permission',
	object_type                   	varchar(100)                             comment 'Object Type',
	object_id                     	varchar(40)                              comment 'Object Id',
	location                      	varchar(48)                              comment 'Location',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "User App";

drop table  if exists quick_link_data;
create table quick_link_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(200)                             comment 'Name',
	icon                          	varchar(200)                             comment 'Icon',
	image_path                    	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment 'Image Path',
	link_target                   	varchar(200)                             comment 'Link Target',
	create_time                   	datetime                                 comment 'Create Time',
	app                           	varchar(48)                              comment 'App',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Quick Link";

drop table  if exists list_access_data;
create table list_access_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(200)                             comment 'Name',
	internal_name                 	varchar(200)                             comment 'Internal Name',
	read_permission               	tinyint                                  comment 'Read Permission',
	create_permission             	tinyint                                  comment 'Create Permission',
	delete_permission             	tinyint                                  comment 'Delete Permission',
	update_permission             	tinyint                                  comment 'Update Permission',
	execution_permission          	tinyint                                  comment 'Execution Permission',
	app                           	varchar(48)                              comment 'App',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "List Access";

drop table  if exists object_access_data;
create table object_access_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(28)                              comment 'Name',
	object_type                   	varchar(112)                             comment 'Object Type',
	list1                         	varchar(80)                              comment 'List1',
	list2                         	varchar(80)                              comment 'List2',
	list3                         	varchar(80)                              comment 'List3',
	list4                         	varchar(80)                              comment 'List4',
	list5                         	varchar(80)                              comment 'List5',
	list6                         	varchar(80)                              comment 'List6',
	list7                         	varchar(80)                              comment 'List7',
	list8                         	varchar(80)                              comment 'List8',
	list9                         	varchar(80)                              comment 'List9',
	app                           	varchar(48)                              comment 'App',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Object Access";

drop table  if exists login_history_data;
create table login_history_data (
	id                            	varchar(48)          not null            comment 'Id',
	login_time                    	datetime                                 comment 'Login Time',
	from_ip                       	varchar(44)                              comment 'From Ip',
	description                   	varchar(16)                              comment 'Description',
	sec_user                      	varchar(48)                              comment 'Sec User',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Login History";

drop table  if exists generic_form_data;
create table generic_form_data (
	id                            	varchar(48)          not null            comment 'Id',
	title                         	varchar(20)                              comment 'Title',
	description                   	varchar(48)                              comment 'Description',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Generic Form";

drop table  if exists form_message_data;
create table form_message_data (
	id                            	varchar(48)          not null            comment 'Id',
	title                         	varchar(24)                              comment 'Title',
	form                          	varchar(48)                              comment 'Form',
	level                         	varchar(28)                              comment 'Level',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Form Message";

drop table  if exists form_field_message_data;
create table form_field_message_data (
	id                            	varchar(48)          not null            comment 'Id',
	title                         	varchar(16)                              comment 'Title',
	parameter_name                	varchar(16)                              comment 'Parameter Name',
	form                          	varchar(48)                              comment 'Form',
	level                         	varchar(28)                              comment 'Level',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Form Field Message";

drop table  if exists form_field_data;
create table form_field_data (
	id                            	varchar(48)          not null            comment 'Id',
	label                         	varchar(12)                              comment 'Label',
	locale_key                    	varchar(44)                              comment 'Locale Key',
	parameter_name                	varchar(16)                              comment 'Parameter Name',
	type                          	varchar(36)                              comment 'Type',
	form                          	varchar(48)                              comment 'Form',
	placeholder                   	varchar(48)                              comment 'Placeholder',
	default_value                 	varchar(12)                              comment 'Default Value',
	description                   	varchar(48)                              comment 'Description',
	field_group                   	varchar(16)                              comment 'Field Group',
	minimum_value                 	varchar(60)                              comment 'Minimum Value',
	maximum_value                 	varchar(72)                              comment 'Maximum Value',
	required                      	tinyint                                  comment 'Required',
	disabled                      	tinyint                                  comment 'Disabled',
	custom_rendering              	tinyint                                  comment 'Custom Rendering',
	candidate_values              	varchar(12)                              comment 'Candidate Values',
	suggest_values                	varchar(12)                              comment 'Suggest Values',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Form Field";

drop table  if exists form_action_data;
create table form_action_data (
	id                            	varchar(48)          not null            comment 'Id',
	label                         	varchar(8)                               comment 'Label',
	locale_key                    	varchar(16)                              comment 'Locale Key',
	action_key                    	varchar(24)                              comment 'Action Key',
	level                         	varchar(28)                              comment 'Level',
	url                           	varchar(168)                             comment 'Url',
	form                          	varchar(48)                              comment 'Form',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Form Action";

drop table  if exists candidate_container_data;
create table candidate_container_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(28)                              comment 'Name',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Candidate Container";

drop table  if exists candidate_element_data;
create table candidate_element_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(200)                             comment 'Name',
	type                          	varchar(200)                             comment 'Type',
	image                         	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment 'Image',
	container                     	varchar(48)                              comment 'Container',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Candidate Element";

drop table  if exists candidate_container_data;
create table candidate_container_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(28)                              comment '名称',
	version                       	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "候选人容器";

drop table  if exists candidate_element_data;
create table candidate_element_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '名称',
	type                          	varchar(200)                             comment '类型',
	image                         	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment '图片',
	container                     	varchar(48)                              comment '容器',
	version                       	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "候选人元素";




insert into platform_data values
<<<<<<< HEAD
	('P000001','银行模拟平台','2019-08-03 07:40:09','1');

insert into change_request_data values
	('CR000001','存款','2019-08-22 07:59:27','8.8.8.8','P000001','1'),
	('CR000002','转账','2019-08-07 00:45:36','8.8.8.8','P000001','1');

insert into transaction_data values
	('T000001','存款交易','A000001','A000001','105.64','存款','CR000001','1'),
	('T000002','存款交易','A000001','A000001','100.86','存款','CR000001','1'),
	('T000003','取款交易','A000002','A000002','101.19','取款','CR000002','1'),
	('T000004','存款交易','A000002','A000002','87.84','存款','CR000002','1');
=======
	('P000001','银行模拟平台','2019-08-20 15:35:07','1');

insert into change_request_data values
	('CR000001','存款','2019-08-23 15:36:29','8.8.8.8','P000001','1'),
	('CR000002','转账','2019-08-28 11:33:36','8.8.8.8','P000001','1');

insert into transaction_data values
	('T000001','存款交易','A000001','A000001','107.10','存款','CR000001','1'),
	('T000002','存款交易','A000001','A000001','103.13','存款','CR000001','1'),
	('T000003','取款交易','A000002','A000002','119.47','取款','CR000002','1'),
	('T000004','存款交易','A000002','A000002','113.28','存款','CR000002','1');
>>>>>>> 8c1580262f63aadc12e1024abc0444ec92345e2c

insert into name_change_event_data values
	('NCE000001','new name','A000001','CR000001','1'),
	('NCE000002','new name0002','A000001','CR000001','1'),
	('NCE000003','new name0003','A000002','CR000002','1'),
	('NCE000004','new name0004','A000002','CR000002','1');

insert into account_data values
<<<<<<< HEAD
	('A000001','张三账户','108.56','2019-08-20 01:03:06','2019-08-17 07:28:40','P000001','1'),
	('A000002','李四账户','120.42','2019-08-06 00:28:50','2019-08-14 15:38:49','P000001','1');

insert into account_change_data values
	('AC000001','存款交易','A000001','1237.58','存款','96.74','961.79','CR000001','1'),
	('AC000002','存款交易','A000001','1220.36','存款','104.76','924.86','CR000001','1'),
	('AC000003','取款交易','A000002','1305.83','取款','102.44','960.00','CR000002','1'),
	('AC000004','存款交易','A000002','1263.01','存款','88.80','1087.28','CR000002','1');
=======
	('A000001','张三账户','103.94','2019-08-29 05:32:11','2019-08-24 08:54:48','P000001','1'),
	('A000002','李四账户','105.91','2019-08-14 09:14:50','2019-08-09 14:55:38','P000001','1');

insert into account_change_data values
	('AC000001','存款交易','A000001','1280.59','存款','107.01','1018.75','CR000001','1'),
	('AC000002','存款交易','A000001','1261.00','存款','86.28','1055.39','CR000001','1'),
	('AC000003','取款交易','A000002','1024.81','取款','120.69','1185.24','CR000002','1'),
	('AC000004','存款交易','A000002','1306.02','存款','90.11','1227.58','CR000002','1');
>>>>>>> 8c1580262f63aadc12e1024abc0444ec92345e2c

insert into user_domain_data values
	('UD000001','用户区域','1');

insert into user_white_list_data values
	('UWL000001','clariones','tester;ios-spokesperson','UD000001','1'),
	('UWL000002','13808188512','tester;ios-spokesperson0002','UD000001','1');

insert into sec_user_data values
<<<<<<< HEAD
	('SU000001','login','13900000001','','C183EC89F92A462CF45B95504792EC4625E847C90536EEFE512D1C9DB8602E95','wx123456789abcdefghijklmn','wxapp12098410239840','jwt_token_12345678','0','2019-08-24 18:47:04','2019-08-10 15:34:50','UD000001',NULL,'BLOCKED','1'),
	('SU000002','login0002','13900000002','suddy_chang@163.com','AC2F95628244C6975EB2C36942EA879ED93D93F5895EF3157733E4629FA86B92','wx123456789abcdefghijklmn0002','wxapp120984102398400002','jwt_token_123456780002','9999999','2019-08-04 00:11:05','2019-08-13 08:36:43','UD000001',NULL,'BLOCKED0002','1');

insert into sec_user_blocking_data values
	('SUB000001','currentUser()','2019-08-06 15:34:26','这个用户多次发送违反社区的帖子，现在把他给屏蔽了','1');
=======
	('SU000001','login','13900000001','','C183EC89F92A462CF45B95504792EC4625E847C90536EEFE512D1C9DB8602E95','wx123456789abcdefghijklmn','wxapp12098410239840','jwt_token_12345678','0','2019-08-30 12:46:32','2019-08-17 14:33:37','UD000001',NULL,'BLOCKED','1'),
	('SU000002','login0002','13900000002','suddy_chang@163.com','AC2F95628244C6975EB2C36942EA879ED93D93F5895EF3157733E4629FA86B92','wx123456789abcdefghijklmn0002','wxapp120984102398400002','jwt_token_123456780002','9999999','2019-08-20 23:42:43','2019-08-13 16:13:30','UD000001',NULL,'BLOCKED0002','1');

insert into sec_user_blocking_data values
	('SUB000001','currentUser()','2019-08-19 00:27:28','这个用户多次发送违反社区的帖子，现在把他给屏蔽了','1');
>>>>>>> 8c1580262f63aadc12e1024abc0444ec92345e2c

insert into user_app_data values
	('UA000001','审车平台','SU000001','users','1','MXWR','CarInspectionPlatform','CIP000001','/link/to/app','1'),
	('UA000002','账户管理','SU000001','bank','1','MXWR','UserDomain','UD000001','/link/to/app0002','1'),
	('UA000003','接车公司','SU000002','wechat','1','MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0003','1'),
	('UA000004','审车公司','SU000002','bar-chart','1','MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0004','1');
<<<<<<< HEAD
=======

insert into quick_link_data values
	('QL000001','列表','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表','2019-08-10 03:52:43','UA000001','1'),
	('QL000002','列表0002','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0002','2019-08-12 14:44:49','UA000001','1'),
	('QL000003','列表0003','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0003','2019-08-19 11:51:40','UA000002','1'),
	('QL000004','列表0004','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0004','2019-08-15 03:44:58','UA000002','1'),
	('QL000005','列表0005','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0005','2019-08-17 23:16:11','UA000003','1'),
	('QL000006','列表0006','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0006','2019-08-15 19:23:09','UA000003','1'),
	('QL000007','列表0007','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0007','2019-08-10 12:48:31','UA000004','1'),
	('QL000008','列表0008','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0008','2019-08-11 10:18:25','UA000004','1');
>>>>>>> 8c1580262f63aadc12e1024abc0444ec92345e2c

insert into list_access_data values
	('LA000001','列表','levelOneCategoryList','1','1','1','1','1','UA000001','1'),
	('LA000002','列表0002','levelOneCategoryList0002','1','1','1','1','1','UA000001','1'),
	('LA000003','列表0003','levelOneCategoryList0003','1','1','1','1','1','UA000002','1'),
	('LA000004','列表0004','levelOneCategoryList0004','1','1','1','1','1','UA000002','1'),
	('LA000005','列表0005','levelOneCategoryList0005','1','1','1','1','1','UA000003','1'),
	('LA000006','列表0006','levelOneCategoryList0006','1','1','1','1','1','UA000003','1'),
	('LA000007','列表0007','levelOneCategoryList0007','1','1','1','1','1','UA000004','1'),
	('LA000008','列表0008','levelOneCategoryList0008','1','1','1','1','1','UA000004','1');

insert into object_access_data values
	('OA000001','控制访问列表1','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000001','1'),
	('OA000002','控制访问列表10002','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000001','1'),
	('OA000003','控制访问列表10003','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000002','1'),
	('OA000004','控制访问列表10004','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000002','1'),
	('OA000005','控制访问列表10005','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000003','1'),
	('OA000006','控制访问列表10006','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000003','1'),
	('OA000007','控制访问列表10007','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000004','1'),
	('OA000008','控制访问列表10008','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000004','1');

insert into login_history_data values
<<<<<<< HEAD
	('LH000001','2019-08-24 02:48:47','192.168.1.1','登陆成功','SU000001','1'),
	('LH000002','2019-08-22 13:09:36','192.168.1.2','登陆成功0002','SU000001','1'),
	('LH000003','2019-08-14 21:12:37','192.168.1.1','登陆成功0003','SU000002','1'),
	('LH000004','2019-08-05 08:19:28','192.168.1.2','登陆成功0004','SU000002','1');
=======
	('LH000001','2019-08-09 04:28:18','192.168.1.1','登陆成功','SU000001','1'),
	('LH000002','2019-08-15 18:08:33','192.168.1.2','登陆成功0002','SU000001','1'),
	('LH000003','2019-08-19 21:06:50','192.168.1.1','登陆成功0003','SU000002','1'),
	('LH000004','2019-08-24 20:45:40','192.168.1.2','登陆成功0004','SU000002','1');
>>>>>>> 8c1580262f63aadc12e1024abc0444ec92345e2c

insert into generic_form_data values
	('GF000001','登记输入单','姓名就是你身份证上的名字','1');

insert into form_message_data values
	('FM000001','字段组合错误','GF000001','success','1'),
	('FM000002','字段组合错误0002','GF000001','info','1');

insert into form_field_message_data values
	('FFM000001','输入错误','name','GF000001','success','1'),
	('FFM000002','输入错误0002','name0002','GF000001','info','1');

insert into form_field_data values
	('FF000001','姓名','name','name','text','GF000001','姓名就是你身份证上的名字','李一一','姓名就是你身份证上的名字','基础信息','maybe any value','a value expression','1','1','1','','','1'),
	('FF000002','年龄','age','name0002','longtext','GF000001','姓名就是你身份证上的名字0002','李一一0002','姓名就是你身份证上的名字0002','扩展信息','maybe any value0002','a value expression0002','1','1','1','','','1');

insert into form_action_data values
	('FA000001','功能','name','save','default','genericFormManager/name/name0002/name0003/','GF000001','1'),
	('FA000002','功能0002','name0002','update','warning','genericFormManager/name/name0002/name0003/0002','GF000001','1');

insert into candidate_container_data values
	('CC000001','我只是一个容器','1');

insert into candidate_element_data values
	('CE000001','搜索到的匹配字段','类型描述','https://demo.doublechaintech.com/demodata/imageManager/genImage/100/400/200/grey/','CC000001','1'),
	('CE000002','搜索到的匹配字段0002','类型描述0002','https://demo.doublechaintech.com/demodata/imageManager/genImage/100/400/200/grey/','CC000001','1');



/*
Mysql innodb's foreign key has index automatically

*/

create unique index idx_platform_version on platform_data(id, version);

create unique index idx_change_request_version on change_request_data(id, version);

alter table change_request_data add constraint change_request4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_transaction_version on transaction_data(id, version);

alter table transaction_data add constraint transaction4from_account_fk
	foreign key(from_account) references account_data(id) on delete cascade on update cascade;
alter table transaction_data add constraint transaction4to_account_fk
	foreign key(to_account) references account_data(id) on delete cascade on update cascade;
alter table transaction_data add constraint transaction4change_request_fk
	foreign key(change_request) references change_request_data(id) on delete cascade on update cascade;
create unique index idx_name_change_event_version on name_change_event_data(id, version);

alter table name_change_event_data add constraint name_change_event4account_fk
	foreign key(account) references account_data(id) on delete cascade on update cascade;
alter table name_change_event_data add constraint name_change_event4change_request_fk
	foreign key(change_request) references change_request_data(id) on delete cascade on update cascade;
create unique index idx_account_version on account_data(id, version);

alter table account_data add constraint account4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_account_change_version on account_change_data(id, version);

alter table account_change_data add constraint account_change4account_fk
	foreign key(account) references account_data(id) on delete cascade on update cascade;
alter table account_change_data add constraint account_change4change_request_fk
	foreign key(change_request) references change_request_data(id) on delete cascade on update cascade;
create unique index idx_user_domain_version on user_domain_data(id, version);

create unique index idx_user_white_list_version on user_white_list_data(id, version);

alter table user_white_list_data add constraint user_white_list4domain_fk
	foreign key(domain) references user_domain_data(id) on delete cascade on update cascade;
create unique index idx_sec_user_version on sec_user_data(id, version);

alter table sec_user_data add constraint sec_user4domain_fk
	foreign key(domain) references user_domain_data(id) on delete cascade on update cascade;
alter table sec_user_data add constraint sec_user4blocking_fk
	foreign key(blocking) references sec_user_blocking_data(id) on delete cascade on update cascade;
create unique index idx_sec_user_blocking_version on sec_user_blocking_data(id, version);

create unique index idx_user_app_version on user_app_data(id, version);

alter table user_app_data add constraint user_app4sec_user_fk
	foreign key(sec_user) references sec_user_data(id) on delete cascade on update cascade;
create unique index idx_quick_link_version on quick_link_data(id, version);

alter table quick_link_data add constraint quick_link4app_fk
	foreign key(app) references user_app_data(id) on delete cascade on update cascade;
create unique index idx_list_access_version on list_access_data(id, version);

alter table list_access_data add constraint list_access4app_fk
	foreign key(app) references user_app_data(id) on delete cascade on update cascade;
create unique index idx_object_access_version on object_access_data(id, version);

alter table object_access_data add constraint object_access4app_fk
	foreign key(app) references user_app_data(id) on delete cascade on update cascade;
create unique index idx_login_history_version on login_history_data(id, version);

alter table login_history_data add constraint login_history4sec_user_fk
	foreign key(sec_user) references sec_user_data(id) on delete cascade on update cascade;
create unique index idx_generic_form_version on generic_form_data(id, version);

create unique index idx_form_message_version on form_message_data(id, version);

alter table form_message_data add constraint form_message4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_field_message_version on form_field_message_data(id, version);

alter table form_field_message_data add constraint form_field_message4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_field_version on form_field_data(id, version);

alter table form_field_data add constraint form_field4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_action_version on form_action_data(id, version);

alter table form_action_data add constraint form_action4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_candidate_container_version on candidate_container_data(id, version);

create unique index idx_candidate_element_version on candidate_element_data(id, version);

alter table candidate_element_data add constraint candidate_element4container_fk
	foreign key(container) references candidate_container_data(id) on delete cascade on update cascade;
-- create extra index for time, number and mobile phone

create index platform4founded_idx on platform_data(founded);
create index platform4version_idx on platform_data(version);
create index change_request4create_time_idx on change_request_data(create_time);
create index change_request4version_idx on change_request_data(version);
create index transaction4amount_idx on transaction_data(amount);
create index transaction4version_idx on transaction_data(version);
create index name_change_event4version_idx on name_change_event_data(version);
create index account4balance_idx on account_data(balance);
create index account4create_time_idx on account_data(create_time);
create index account4update_time_idx on account_data(update_time);
create index account4version_idx on account_data(version);
create index account_change4previous_balance_idx on account_change_data(previous_balance);
create index account_change4amount_idx on account_change_data(amount);
create index account_change4current_balance_idx on account_change_data(current_balance);
create index account_change4version_idx on account_change_data(version);
create index user_domain4version_idx on user_domain_data(version);
create index user_white_list4version_idx on user_white_list_data(version);
create index sec_user4mobile_idx on sec_user_data(mobile);
create index sec_user4verification_code_idx on sec_user_data(verification_code);
create index sec_user4verification_code_expire_idx on sec_user_data(verification_code_expire);
create index sec_user4last_login_time_idx on sec_user_data(last_login_time);
create index sec_user4version_idx on sec_user_data(version);
create index sec_user_blocking4block_time_idx on sec_user_blocking_data(block_time);
create index sec_user_blocking4version_idx on sec_user_blocking_data(version);
create index user_app4object_id_idx on user_app_data(object_id);
create index user_app4version_idx on user_app_data(version);
create index quick_link4create_time_idx on quick_link_data(create_time);
create index quick_link4version_idx on quick_link_data(version);
create index list_access4version_idx on list_access_data(version);
create index object_access4version_idx on object_access_data(version);
create index login_history4login_time_idx on login_history_data(login_time);
create index login_history4version_idx on login_history_data(version);
create index generic_form4version_idx on generic_form_data(version);
create index form_message4version_idx on form_message_data(version);
create index form_field_message4version_idx on form_field_message_data(version);
create index form_field4version_idx on form_field_data(version);
create index form_action4version_idx on form_action_data(version);
create index candidate_container4version_idx on candidate_container_data(version);
create index candidate_element4version_idx on candidate_element_data(version);










delete from list_access_data ;
delete from object_access_data ;
delete from user_app_data ;
delete from login_history_data ;
delete from sec_user_data ;
delete from user_domain_data ;
insert into user_domain_data values ('UD000001','用户区域','1');



insert into sec_user_data values('SU000001','User000001','13900000001','1000001@qq.com','24327F1C00D22210298A18D0DB9AA6C4C22DEAC4BEAE7C02E616442CA7764246', 'weixin_openid_000001', 'weixin_appid_000001', 'jwt_token_000001' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000001','Platform','SU000001','at',1,'MXWR','Platform','P000001','/link/to/app','1');
insert into user_app_data values('UA000002','我的账户','SU000001','lock',1,'MXWR','SecUser','SU000001','/link/to/app','1');
insert into sec_user_data values('SU000002','User000002','13900000002','1000002@qq.com','BB5210DAE99659C7164D7DBCFC51FB2D167D0DA372D58EF26A9F8533EEA2967C', 'weixin_openid_000002', 'weixin_appid_000002', 'jwt_token_000002' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000003','Change Request','SU000002','exchange-alt',1,'MXWR','ChangeRequest','CR000001','/link/to/app','1');
insert into user_app_data values('UA000004','我的账户','SU000002','lock',1,'MXWR','SecUser','SU000002','/link/to/app','1');
insert into sec_user_data values('SU000003','User000003','13900000003','1000003@qq.com','9D4104DF2774FDEAAE074CA35B052D8F664F4F99064C7BEAB0B589C2605C4EDA', 'weixin_openid_000003', 'weixin_appid_000003', 'jwt_token_000003' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000005','Account','SU000003','address-book',1,'MXWR','Account','A000001','/link/to/app','1');
insert into user_app_data values('UA000006','我的账户','SU000003','lock',1,'MXWR','SecUser','SU000003','/link/to/app','1');
insert into sec_user_data values('SU000004','User000004','13900000004','1000004@qq.com','9B223EBD008D7B544A3A640739EBE47459D3A4C5296DDA00F594FAF60FE88B28', 'weixin_openid_000004', 'weixin_appid_000004', 'jwt_token_000004' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000007','User Domain','SU000004','user',1,'MXWR','UserDomain','UD000001','/link/to/app','1');
insert into user_app_data values('UA000008','我的账户','SU000004','lock',1,'MXWR','SecUser','SU000004','/link/to/app','1');
insert into sec_user_data values('SU000005','User000005','13900000005','1000005@qq.com','AE5F93F319636A96963C06D035B97F004D18E61D80129EFEA331784A6E21DC5C', 'weixin_openid_000005', 'weixin_appid_000005', 'jwt_token_000005' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000009','Sec User','SU000005','user',1,'MXWR','SecUser','SU000001','/link/to/app','1');
insert into user_app_data values('UA000010','我的账户','SU000005','lock',1,'MXWR','SecUser','SU000005','/link/to/app','1');
insert into sec_user_data values('SU000006','User000006','13900000006','1000006@qq.com','5FBBDBEAD9F84D599E8819CEEA167854CDA0FFD8D297D17D12E4619CE76F3B55', 'weixin_openid_000006', 'weixin_appid_000006', 'jwt_token_000006' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000011','User App','SU000006','user',1,'MXWR','UserApp','UA000001','/link/to/app','1');
insert into user_app_data values('UA000012','我的账户','SU000006','lock',1,'MXWR','SecUser','SU000006','/link/to/app','1');
insert into sec_user_data values('SU000007','User000007','13900000007','1000007@qq.com','A9652F0D7C1ACCB421BAF55EB3E7286AFA8F591897F1AE4CEB6A76402CCBE803', 'weixin_openid_000007', 'weixin_appid_000007', 'jwt_token_000007' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
<<<<<<< HEAD
insert into user_app_data values('UA000013','候选人容器','SU000007','at',1,'MXWR','CandidateContainer','CC000001','/link/to/app','1');
=======
insert into user_app_data values('UA000013','Candidate Container','SU000007','at',1,'MXWR','CandidateContainer','CC000001','/link/to/app','1');
>>>>>>> 8c1580262f63aadc12e1024abc0444ec92345e2c
insert into user_app_data values('UA000014','我的账户','SU000007','lock',1,'MXWR','SecUser','SU000007','/link/to/app','1');

/* ------------------------------------------------------------------------ */


select id,pwd from sec_user_data;

/*
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
<<<<<<< HEAD
|平台|13900000001|DoubleChain!y1|
|变更请求|13900000002|DoubleChain!y1|
|账户|13900000003|DoubleChain!y1|
|用户域|13900000004|DoubleChain!y1|
|安全用户|13900000005|DoubleChain!y1|
|用户应用程序|13900000006|DoubleChain!y1|
|候选人容器|13900000007|DoubleChain!y1|
=======
|Platform|13900000001|DoubleChain!y1|
|Change Request|13900000002|DoubleChain!y1|
|Account|13900000003|DoubleChain!y1|
|User Domain|13900000004|DoubleChain!y1|
|Sec User|13900000005|DoubleChain!y1|
|User App|13900000006|DoubleChain!y1|
|Candidate Container|13900000007|DoubleChain!y1|
>>>>>>> 8c1580262f63aadc12e1024abc0444ec92345e2c


*/



/* start with data patch */
delete from account_change_data;
delete from change_request_data;
delete from transaction_data;
delete from name_change_event_data;





/*

+----------+---------------------------------+---------------------+--------+
| Charset  | Description                     | Default collation   | Maxlen |
+----------+---------------------------------+---------------------+--------+
| gb2312   | GB2312 Simplified Chinese       | gb2312_chinese_ci   |      2 |
| gbk      | GBK Simplified Chinese          | gbk_chinese_ci      |      2 |
| utf8mb4  | UTF-8 Unicode                   | utf8mb4_general_ci  |      4 |
| utf32    | UTF-32 Unicode                  | utf32_general_ci    |      4 |
| gb18030  | China National Standard GB18030 | gb18030_chinese_ci  |      4 |
+----------+---------------------------------+---------------------+--------+

*/

