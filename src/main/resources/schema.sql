drop table if exists common_limits;

CREATE TABLE if not exists common_limits
(
    client_type   VARCHAR(30)  NOT NULL,
    date_begin    TIMESTAMP   NOT NULL,
    date_end    TIMESTAMP,
    amount       numeric not null
    );

------------------------------
drop table if exists personal_limits;

CREATE TABLE if not exists personal_limits
(
    inn   VARCHAR(12)  NOT NULL,
    date_begin    TIMESTAMP   NOT NULL,
    date_end    TIMESTAMP,
    amount       numeric not null
    );


drop table if exists limit_utilization;

create table if not exists limit_utilization
(
    inn varchar(12) not null,
    doc_id UUID not null,
    date_hold TIMESTAMP not null,
    date_proc TIMESTAMP,
    doc_amount numeric not null,
    currency   varchar(3) not null,
    utilization_amount numeric not null,
    income      boolean not null,
    state       int

    );

COMMENT ON COLUMN limit_utilization.state IS '0:hold,1:procesed,-1:canceled';


