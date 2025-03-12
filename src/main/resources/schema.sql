drop schema if exists "limits" cascade;
create schema if not exists "limits";


--set currentSchema="limit";
drop table if exists utilization_items CASCADE;
drop table if exists utilization_doc CASCADE;
drop table if EXISTS unfriendly_currencies CASCADE;
drop table if exists client_limits CASCADE;
drop table if exists common_limits CASCADE;

drop sequence if exists common_limits_id_seq CASCADE;
drop sequence if exists client_limits_id_seq CASCADE;
drop sequence if exists utilization_doc_id_seq CASCADE;
drop sequence if exists utilization_items_id_seq CASCADE;

----------

CREATE TABLE if not exists common_limits
(
    id          SERIAL PRIMARY KEY,
    client_type VARCHAR(30) NOT NULL,
    date_begin  TIMESTAMP   NOT NULL,
    date_end    TIMESTAMP,
    amount      numeric     not null
);

------------------------------


CREATE TABLE if not exists client_limits
(
    id               SERIAL PRIMARY KEY,
    client_id        VARCHAR(12)       NOT NULL,
    date_begin       TIMESTAMP         NOT NULL,
    date_end         TIMESTAMP,
    amount           numeric           not null,
    used             numeric default 0 not null,
    hold             numeric default 0 not null,
    common_limit_ref int REFERENCES common_limits (id)
--,   common_limit_order INTEGER
);

------------------


create table if not exists unfriendly_currencies
(
    value varchar(3) not null PRIMARY KEY
);

insert into unfriendly_currencies
values ('USD'),
       ('EUR'),
       ('GPB'),
       ('JPY');

create table if not exists utilization_doc
(
    id                 SERIAL PRIMARY KEY,
    --  client_id          varchar(12) not null, --TODO нужно ли ? Вроде как клиент определяется принадлежность к утилизации
    doc_id             UUID       not null,
    date_hold          TIMESTAMP  not null,
    date_proc          TIMESTAMP,
    doc_amount         numeric    not null,
    currency           varchar(3) not null REFERENCES unfriendly_currencies (value),
    utilization_amount numeric    not null,
    income             boolean    not null,
    state              varchar    not null CHECK (state in ('HOLD', 'PROCESSED', 'CANCELED'))
);

COMMENT ON COLUMN utilization_doc.state IS '0:hold,1:procesed,-1:canceled';
----------------------

create table if not exists utilization_items
(
    id                  SERIAL PRIMARY KEY,
    limit_ref           int     not null REFERENCES client_limits (id),
    utilization_doc_ref int     not null REFERENCES utilization_doc (id),
    amount              numeric not null
    -- ,utilization_order bigint  NOT NULL /* defaut taco_key*/
);
---------
ALTER SEQUENCE common_limits_id_seq
    START 100
        RESTART 100;


ALTER SEQUENCE client_limits_id_seq
    START 200
        RESTART 200;



ALTER SEQUENCE utilization_doc_id_seq
    START 300
        restart 300;

ALTER SEQUENCE utilization_items_id_seq
    START 400
        restart 400;

/*
CREATE TABLE if not exists personal_limits
(
    id          SERIAL PRIMARY KEY,
    client_id        VARCHAR(12)       NOT NULL,
    client_type VARCHAR(30) NOT NULL,
    date_begin  TIMESTAMP   NOT NULL,
    date_end    TIMESTAMP,
    amount      numeric     not null
);*/