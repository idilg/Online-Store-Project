# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table address (
  id                        bigint auto_increment not null,
  address                   varchar(255),
  user_email                varchar(255),
  constraint pk_address primary key (id))
;

create table user (
  email                     varchar(255) not null,
  name                      varchar(255),
  lastname                  varchar(255),
  password                  varchar(255),
  phonenumber               varchar(255),
  gender                    varchar(255),
  constraint pk_user primary key (email))
;

alter table address add constraint fk_address_user_1 foreign key (user_email) references user (email) on delete restrict on update restrict;
create index ix_address_user_1 on address (user_email);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table address;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

