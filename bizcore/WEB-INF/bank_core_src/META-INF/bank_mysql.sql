-- BUILD WITH MODEL TIME 190824T2242





drop database  if exists bank;
create database bank;
-- alter  database bank  character set = utf8mb4  collate = utf8mb4_unicode_ci; -- ??????
use bank;

drop table  if exists platform_data;
create table platform_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(24)                              comment '??',
	founded                       	datetime                                 comment '??',
	version                       	int                                      comment '??',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "??";

drop table  if exists change_request_data;
create table change_request_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(50)                              comment '??',
	create_time                   	datetime                                 comment '????',
	remote_ip                     	varchar(40)                              comment '??Ip',
	platform                      	varchar(48)                              comment '??',
	version                       	int                                      comment '??',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "????";

drop table  if exists transaction_data;
create table transaction_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(50)                              comment '??',
	from_account                  	varchar(48)                              comment '???',
	to_account                    	varchar(48)                              comment '????',
	amount                        	numeric(7,2)                             comment '??',
	type                          	varchar(8)                               comment '??',
	change_request                	varchar(48)                              comment '????',
	version                       	int                                      comment '??',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "??";

drop table  if exists name_change_event_data;
create table name_change_event_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(50)                              comment '??',
	account                       	varchar(48)                              comment '??',
	change_request                	varchar(48)                              comment '????',
	version                       	int                                      comment '??',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "??????";

drop table  if exists account_data;
create table account_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(50)                              comment '??',
	balance                       	numeric(7,2)                             comment '??',
	create_time                   	datetime                                 comment '????',
	update_time                   	datetime                                 comment '????',
	platform                      	varchar(48)                              comment '??',
	version                       	int                                      comment '??',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "??";

drop table  if exists account_change_data;
create table account_change_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(50)                              comment '??',
	account                       	varchar(48)                              comment '??',
	previous_balance              	numeric(8,2)                             comment '????',
	type                          	varchar(8)                               comment '??',
	amount                        	numeric(7,2)                             comment '??',
	current_balance               	numeric(8,2)                             comment '????',
	change_request                	varchar(48)                              comment '????',
	version                       	int                                      comment '??',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "????";

drop table  if exists user_domain_data;
create table user_domain_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(16)                              comment '??',
	version                       	int                                      comment '??',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "???";

drop table  if exists user_white_list_data;
create table user_white_list_data (
	id                            	varchar(48)          not null            comment 'ID',
	user_identity                 	varchar(40)                              comment '????',
	user_special_functions        	varchar(200)                             comment '??????',
	domain                        	varchar(48)                              comment '?',
	version                       	int                                      comment '??',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "?????";

drop table  if exists sec_user_data;
create table sec_user_data (
	id                            	varchar(48)          not null            comment 'ID',
	login                         	varchar(20)                              comment '??',
	mobile                        	varchar(11)                              comment '????',
	email                         	varchar(76)                              comment '????',
	pwd                           	varchar(64)                              comment '??',
	weixin_openid                 	varchar(128)                             comment '??openid',
	weixin_appid                  	varchar(128)                             comment '??Appid',
	access_token                  	varchar(128)                             comment '????',
	verification_code             	int                                      comment '???',
	verification_code_expire      	datetime                                 comment '?????',
	last_login_time               	datetime                                 comment '??????',
	domain                        	varchar(48)                              comment '?',
	blocking                      	varchar(48)                              comment '??',
	current_status                	varchar(28)                              comment '????',
	version                       	int                                      comment '??',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "????";

drop table  if exists sec_user_blocking_data;
create table sec_user_blocking_data (
	id                            	varchar(48)          not null            comment 'ID',
	who                           	varchar(52)                              comment '?',
	block_time                    	datetime                                 comment '???',
	comments                      	varchar(96)                              comment '??',
	version                       	int                                      comment '??',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "????";

drop table  if exists user_app_data;
create table user_app_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(300)                             comment '??',
	sec_user                      	varchar(48)                              comment '????',
	app_icon                      	varchar(36)                              comment '??????',
	full_access                   	tinyint                                  comment '????',
	permission                    	varchar(16)                              comment '??',
	object_type                   	varchar(100)                             comment '??????',
	object_id                     	varchar(40)                              comment '??ID',
	location                      	varchar(48)                              comment '??',
	version                       	int                                      comment '??',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "??????";

drop table  if exists quick_link_data;
create table quick_link_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '??',
	icon                          	varchar(200)                             comment '??',
	image_path                    	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment '????',
	link_target                   	varchar(200)                             comment '?????',
	create_time                   	datetime                                 comment '????',
	app                           	varchar(48)                              comment '????',
	version                       	int                                      comment '??',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "????";

drop table  if exists list_access_data;
create table list_access_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '??',
	internal_name                 	varchar(200)                             comment '????',
	read_permission               	tinyint                                  comment '???',
	create_permission             	tinyint                                  comment '????',
	delete_permission             	tinyint                                  comment '????',
	update_permission             	tinyint                                  comment '????',
	execution_permission          	tinyint                                  comment '????',
	app                           	varchar(48)                              comment '????',
	version                       	int                                      comment '??',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "????";

drop table  if exists object_access_data;
create table object_access_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(28)                              comment '??',
	object_type                   	varchar(112)                             comment '??????',
	list1                         	varchar(80)                              comment '??1',
	list2                         	varchar(80)                              comment '??2',
	list3                         	varchar(80)                              comment '??3',
	list4                         	varchar(80)                              comment '??4',
	list5                         	varchar(80)                              comment '??5',
	list6                         	varchar(80)                              comment '??6',
	list7                         	varchar(80)                              comment '??7',
	list8                         	varchar(80)                              comment '??8',
	list9                         	varchar(80)                              comment '??9',
	app                           	varchar(48)                              comment '????',
	version                       	int                                      comment '??',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "????";

drop table  if exists login_history_data;
create table login_history_data (
	id                            	varchar(48)          not null            comment 'ID',
	login_time                    	datetime                                 comment '????',
	from_ip                       	varchar(44)                              comment '??IP',
	description                   	varchar(16)                              comment '??',
	sec_user                      	varchar(48)                              comment '????',
	version                       	int                                      comment '??',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "????";

drop table  if exists generic_form_data;
create table generic_form_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(20)                              comment '??',
	description                   	varchar(48)                              comment '??',
	version                       	int                                      comment '??',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "?????";

drop table  if exists form_message_data;
create table form_message_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(24)                              comment '??',
	form                          	varchar(48)                              comment '??',
	level                         	varchar(28)                              comment '??',
	version                       	int                                      comment '??',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "????";

drop table  if exists form_field_message_data;
create table form_field_message_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(16)                              comment '??',
	parameter_name                	varchar(16)                              comment '????',
	form                          	varchar(48)                              comment '??',
	level                         	varchar(28)                              comment '??',
	version                       	int                                      comment '??',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "???????";

drop table  if exists form_field_data;
create table form_field_data (
	id                            	varchar(48)          not null            comment 'ID',
	label                         	varchar(12)                              comment '??',
	locale_key                    	varchar(44)                              comment '???????',
	parameter_name                	varchar(16)                              comment '????',
	type                          	varchar(36)                              comment '??',
	form                          	varchar(48)                              comment '??',
	placeholder                   	varchar(48)                              comment '???',
	default_value                 	varchar(12)                              comment '???',
	description                   	varchar(48)                              comment '??',
	field_group                   	varchar(16)                              comment '???',
	minimum_value                 	varchar(60)                              comment '???',
	maximum_value                 	varchar(72)                              comment '???',
	required                      	tinyint                                  comment '??',
	disabled                      	tinyint                                  comment '??',
	custom_rendering              	tinyint                                  comment '?????',
	candidate_values              	varchar(12)                              comment '???????',
	suggest_values                	varchar(12)                              comment '???',
	version                       	int                                      comment '??',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "????";

drop table  if exists form_action_data;
create table form_action_data (
	id                            	varchar(48)          not null            comment 'ID',
	label                         	varchar(8)                               comment '??',
	locale_key                    	varchar(16)                              comment '???????',
	action_key                    	varchar(24)                              comment '?????',
	level                         	varchar(28)                              comment '??',
	url                           	varchar(168)                             comment 'url',
	form                          	varchar(48)                              comment '??',
	version                       	int                                      comment '??',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "????";

drop table  if exists candidate_container_data;
create table candidate_container_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(28)                              comment '??',
	version                       	int                                      comment '??',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "?????";

drop table  if exists candidate_element_data;
create table candidate_element_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '??',
	type                          	varchar(200)                             comment '??',
	image                         	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment '??',
	container                     	varchar(48)                              comment '??',
	version                       	int                                      comment '??',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "?????";




insert into platform_data values
	('P000001','??????','2019-09-10 23:22:40','1');

insert into change_request_data values
	('CR000001','??','2019-09-01 17:59:20','8.8.8.8','P000001','1'),
	('CR000002','??','2019-08-28 00:47:57','8.8.8.8','P000001','1');

insert into transaction_data values
	('T000001','????','A000001','A000001','89.21','??','CR000001','1'),
	('T000002','????','A000001','A000001','104.58','??','CR000001','1'),
	('T000003','????','A000002','A000002','98.28','??','CR000002','1'),
	('T000004','????','A000002','A000002','86.87','??','CR000002','1');

insert into name_change_event_data values
	('NCE000001','new name','A000001','CR000001','1'),
	('NCE000002','new name0002','A000001','CR000001','1'),
	('NCE000003','new name0003','A000002','CR000002','1'),
	('NCE000004','new name0004','A000002','CR000002','1');

insert into account_data values
	('A000001','????','92.03','2019-09-01 21:59:12','2019-09-01 05:24:40','P000001','1'),
	('A000002','????','90.52','2019-09-06 08:16:08','2019-09-16 21:18:46','P000001','1');

insert into account_change_data values
	('AC000001','????','A000001','1093.31','??','88.66','1255.06','CR000001','1'),
	('AC000002','????','A000001','1049.62','??','96.98','1020.96','CR000001','1'),
	('AC000003','????','A000002','1227.43','??','118.02','1292.09','CR000002','1'),
	('AC000004','????','A000002','1168.90','??','102.98','996.46','CR000002','1');

insert into user_domain_data values
	('UD000001','????','1');

insert into user_white_list_data values
	('UWL000001','clariones','tester;ios-spokesperson','UD000001','1'),
	('UWL000002','13808188512','tester;ios-spokesperson0002','UD000001','1');

insert into sec_user_data values
	('SU000001','login','13900000001','','C183EC89F92A462CF45B95504792EC4625E847C90536EEFE512D1C9DB8602E95','wx123456789abcdefghijklmn','wxapp12098410239840','jwt_token_12345678','0','2019-09-14 05:21:37','2019-09-15 08:36:26','UD000001',NULL,'BLOCKED','1'),
	('SU000002','login0002','13900000002','suddy_chang@163.com','AC2F95628244C6975EB2C36942EA879ED93D93F5895EF3157733E4629FA86B92','wx123456789abcdefghijklmn0002','wxapp120984102398400002','jwt_token_123456780002','9999999','2019-09-16 08:16:19','2019-09-16 17:27:18','UD000001',NULL,'BLOCKED0002','1');

insert into sec_user_blocking_data values
	('SUB000001','currentUser()','2019-09-16 07:33:22','????????????????????????','1');

insert into user_app_data values
	('UA000001','????','SU000001','users','1','MXWR','CarInspectionPlatform','CIP000001','/link/to/app','1'),
	('UA000002','????','SU000001','bank','1','MXWR','UserDomain','UD000001','/link/to/app0002','1'),
	('UA000003','????','SU000002','wechat','1','MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0003','1'),
	('UA000004','????','SU000002','bar-chart','1','MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0004','1');

insert into quick_link_data values
	('QL000001','??','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','??','2019-09-02 02:50:20','UA000001','1'),
	('QL000002','??0002','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','??0002','2019-09-12 16:54:13','UA000001','1'),
	('QL000003','??0003','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','??0003','2019-08-27 21:08:28','UA000002','1'),
	('QL000004','??0004','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','??0004','2019-09-08 17:25:19','UA000002','1'),
	('QL000005','??0005','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','??0005','2019-09-13 08:09:50','UA000003','1'),
	('QL000006','??0006','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','??0006','2019-09-01 08:02:53','UA000003','1'),
	('QL000007','??0007','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','??0007','2019-09-05 22:15:05','UA000004','1'),
	('QL000008','??0008','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','??0008','2019-09-15 23:09:33','UA000004','1');

insert into list_access_data values
	('LA000001','??','levelOneCategoryList','1','1','1','1','1','UA000001','1'),
	('LA000002','??0002','levelOneCategoryList0002','1','1','1','1','1','UA000001','1'),
	('LA000003','??0003','levelOneCategoryList0003','1','1','1','1','1','UA000002','1'),
	('LA000004','??0004','levelOneCategoryList0004','1','1','1','1','1','UA000002','1'),
	('LA000005','??0005','levelOneCategoryList0005','1','1','1','1','1','UA000003','1'),
	('LA000006','??0006','levelOneCategoryList0006','1','1','1','1','1','UA000003','1'),
	('LA000007','??0007','levelOneCategoryList0007','1','1','1','1','1','UA000004','1'),
	('LA000008','??0008','levelOneCategoryList0008','1','1','1','1','1','UA000004','1');

insert into object_access_data values
	('OA000001','??????1','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000001','1'),
	('OA000002','??????10002','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000001','1'),
	('OA000003','??????10003','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000002','1'),
	('OA000004','??????10004','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000002','1'),
	('OA000005','??????10005','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000003','1'),
	('OA000006','??????10006','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000003','1'),
	('OA000007','??????10007','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000004','1'),
	('OA000008','??????10008','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000004','1');

insert into login_history_data values
	('LH000001','2019-09-10 22:48:59','192.168.1.1','????','SU000001','1'),
	('LH000002','2019-09-11 12:52:37','192.168.1.2','????0002','SU000001','1'),
	('LH000003','2019-09-04 22:47:29','192.168.1.1','????0003','SU000002','1'),
	('LH000004','2019-08-30 00:37:05','192.168.1.2','????0004','SU000002','1');

insert into generic_form_data values
	('GF000001','?????','????????????','1');

insert into form_message_data values
	('FM000001','??????','GF000001','success','1'),
	('FM000002','??????0002','GF000001','info','1');

insert into form_field_message_data values
	('FFM000001','????','name','GF000001','success','1'),
	('FFM000002','????0002','name0002','GF000001','info','1');

insert into form_field_data values
	('FF000001','??','name','name','text','GF000001','????????????','???','????????????','????','maybe any value','a value expression','1','1','1','','','1'),
	('FF000002','??','age','name0002','longtext','GF000001','????????????0002','???0002','????????????0002','????','maybe any value0002','a value expression0002','1','1','1','','','1');

insert into form_action_data values
	('FA000001','??','name','save','default','genericFormManager/name/name0002/name0003/','GF000001','1'),
	('FA000002','??0002','name0002','update','warning','genericFormManager/name/name0002/name0003/0002','GF000001','1');

insert into candidate_container_data values
	('CC000001','???????','1');

insert into candidate_element_data values
	('CE000001','????????','????','https://demo.doublechaintech.com/demodata/imageManager/genImage/100/400/200/grey/','CC000001','1'),
	('CE000002','????????0002','????0002','https://demo.doublechaintech.com/demodata/imageManager/genImage/100/400/200/grey/','CC000001','1');



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
insert into user_domain_data values ('UD000001','????','1');



insert into sec_user_data values('SU000001','User000001','13900000001','1000001@qq.com','24327F1C00D22210298A18D0DB9AA6C4C22DEAC4BEAE7C02E616442CA7764246', 'weixin_openid_000001', 'weixin_appid_000001', 'jwt_token_000001' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000001','??','SU000001','at',1,'MXWR','Platform','P000001','/link/to/app','1');
insert into user_app_data values('UA000002','????','SU000001','lock',1,'MXWR','SecUser','SU000001','/link/to/app','1');
insert into sec_user_data values('SU000002','User000002','13900000002','1000002@qq.com','BB5210DAE99659C7164D7DBCFC51FB2D167D0DA372D58EF26A9F8533EEA2967C', 'weixin_openid_000002', 'weixin_appid_000002', 'jwt_token_000002' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000003','????','SU000002','exchange-alt',1,'MXWR','ChangeRequest','CR000001','/link/to/app','1');
insert into user_app_data values('UA000004','????','SU000002','lock',1,'MXWR','SecUser','SU000002','/link/to/app','1');
insert into sec_user_data values('SU000003','User000003','13900000003','1000003@qq.com','9D4104DF2774FDEAAE074CA35B052D8F664F4F99064C7BEAB0B589C2605C4EDA', 'weixin_openid_000003', 'weixin_appid_000003', 'jwt_token_000003' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000005','??','SU000003','address-book',1,'MXWR','Account','A000001','/link/to/app','1');
insert into user_app_data values('UA000006','????','SU000003','lock',1,'MXWR','SecUser','SU000003','/link/to/app','1');
insert into sec_user_data values('SU000004','User000004','13900000004','1000004@qq.com','9B223EBD008D7B544A3A640739EBE47459D3A4C5296DDA00F594FAF60FE88B28', 'weixin_openid_000004', 'weixin_appid_000004', 'jwt_token_000004' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000007','???','SU000004','user',1,'MXWR','UserDomain','UD000001','/link/to/app','1');
insert into user_app_data values('UA000008','????','SU000004','lock',1,'MXWR','SecUser','SU000004','/link/to/app','1');
insert into sec_user_data values('SU000005','User000005','13900000005','1000005@qq.com','AE5F93F319636A96963C06D035B97F004D18E61D80129EFEA331784A6E21DC5C', 'weixin_openid_000005', 'weixin_appid_000005', 'jwt_token_000005' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000009','????','SU000005','user',1,'MXWR','SecUser','SU000001','/link/to/app','1');
insert into user_app_data values('UA000010','????','SU000005','lock',1,'MXWR','SecUser','SU000005','/link/to/app','1');
insert into sec_user_data values('SU000006','User000006','13900000006','1000006@qq.com','5FBBDBEAD9F84D599E8819CEEA167854CDA0FFD8D297D17D12E4619CE76F3B55', 'weixin_openid_000006', 'weixin_appid_000006', 'jwt_token_000006' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000011','??????','SU000006','user',1,'MXWR','UserApp','UA000001','/link/to/app','1');
insert into user_app_data values('UA000012','????','SU000006','lock',1,'MXWR','SecUser','SU000006','/link/to/app','1');
insert into sec_user_data values('SU000007','User000007','13900000007','1000007@qq.com','A9652F0D7C1ACCB421BAF55EB3E7286AFA8F591897F1AE4CEB6A76402CCBE803', 'weixin_openid_000007', 'weixin_appid_000007', 'jwt_token_000007' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000013','?????','SU000007','at',1,'MXWR','CandidateContainer','CC000001','/link/to/app','1');
insert into user_app_data values('UA000014','????','SU000007','lock',1,'MXWR','SecUser','SU000007','/link/to/app','1');

/* ------------------------------------------------------------------------ */


select id,pwd from sec_user_data;

/*
| ??        | ???           | ??         |
| ------------- |:-------------:|:-------------------:|
|??|13900000001|DoubleChain!y1|
|????|13900000002|DoubleChain!y1|
|??|13900000003|DoubleChain!y1|
|???|13900000004|DoubleChain!y1|
|????|13900000005|DoubleChain!y1|
|??????|13900000006|DoubleChain!y1|
|?????|13900000007|DoubleChain!y1|


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

