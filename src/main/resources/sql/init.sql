CREATE TABLE wx_accounts (
    account_id serial NOT null primary key ,
    name CHARACTER varying(255) NOT null unique ,
    introduce CHARACTER varying(5000),
    table_prefix CHARACTER varying(255) NOT null,
    service_type_info INTEGER NOT null,
    status INTEGER NOT null,
    app_id CHARACTER varying(255) NOT null,
    secret CHARACTER varying(255) NOT null,
    aes_key CHARACTER varying(255) NOT null,
    created_at TIMESTAMP WITHOUT TIME zone,
    updated_at TIMESTAMP WITHOUT TIME zone
);

INSERT INTO wx_accounts values(1, 'hello','','wx_',1,1,'appid','secret','aes_key',now(),now())