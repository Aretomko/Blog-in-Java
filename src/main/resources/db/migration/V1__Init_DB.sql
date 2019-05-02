drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start 1 increment 1;
create table front (id int8 not null, date_of_posting varchar(255), filename varchar(255), heading varchar(255), link varchar(255), order_number int4, short_description varchar(255), status varchar(255), technology varchar(255), primary key (id));
create table module (id int8 not null, code boolean not null, filename varchar(255), image boolean not null, order_number int4, short_text varchar(2048), text boolean not null, front_id int8, primary key (id));
create table user_role (user_id int8 not null, roles varchar(255));
create table usr (id int8 not null, activation_code varchar(255), active boolean not null, email varchar(255), member_since date, password varchar(255), username varchar(255), primary key (id));
alter table if exists module add constraint FK85sxlmtwl7wdge44ycgqhgiov foreign key (front_id) references front;
alter table if exists user_role add constraint FKfpm8swft53ulq2hl11yplpr5 foreign key (user_id) references usr;