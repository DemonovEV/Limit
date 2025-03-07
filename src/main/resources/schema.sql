create schema if not exists "limits";

--set currentSchema="limit";
drop table if exists limit_to_utilization;
drop table if exists utilization;

drop table if exists client_limits;

drop table if exists common_limits;


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
    id                SERIAL PRIMARY KEY,
    client_id         VARCHAR(12)       NOT NULL,
    date_begin        TIMESTAMP         NOT NULL,
    date_end          TIMESTAMP,
    amount            numeric           not null,
    used              numeric default 0 not null,
    hold              numeric default 0 not null,
    common_limit_ref int                REFERENCES common_limits (id)
,   common_limit_order INTEGER
);
--COMMENT ON COLUMN utilization.state IS 'В DATA-JPA ';
------------------


create table if not exists utilization
(
    id                 SERIAL PRIMARY KEY,
    --  client_id          varchar(12) not null, --TODO нужно ли ? Вроде как клиент определяется принадлежность к утилизации
    doc_id             UUID       not null,
    date_hold          TIMESTAMP  not null,
    date_proc          TIMESTAMP,
    doc_amount         numeric    not null,
    currency           varchar(3) not null,
    utilization_amount numeric    not null,
    income             boolean    not null,
    state              varchar    not null CHECK (state in ('HOLD', 'PROCESSED', 'CANCELED'))
);

COMMENT ON COLUMN utilization.state IS '0:hold,1:procesed,-1:canceled';

-----------------------


ALTER SEQUENCE client_limits_id_seq
    START 15
    RESTART 15;


ALTER SEQUENCE common_limits_id_seq
    START 50
    RESTART 50;

ALTER SEQUENCE utilization_id_seq
    START 110
    restart 110;
