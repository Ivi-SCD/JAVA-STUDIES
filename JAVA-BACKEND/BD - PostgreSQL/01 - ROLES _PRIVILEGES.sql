-- Administrando users/roles/groups

-- CREATE ROLE name [[WITH] option [...]]

-- SUPERUSER | NOSUPERUSER
-- CREATEDB | NOCREATEDB
-- CREATEROLE | NOCREATEROLE
-- INHERIT | NOINHERIT
-- LOGIN | NOLOGIN
-- BYPASSRLS | NOBYPASSRLS
-- REPLICATION | NOREPLICATION
-- CONNECTION LIMIT connlimit
-- [ENCRYPTED] PASSWORD 'password' | PASSWORD null
-- IN ROLE role_name [,...]
-- IN GROUP role_name [,...]
-- ROLE role_name
-- ADMIN role_name
-- USER role_name
-- SYSID uid

CREATE ROLE administradores 
CREATEDB
CREATEROLE
INHERIT
NOLOGIN
BYPASSRLS
REPLICATION
CONNECTION LIMIT 1;

CREATE ROLE ivi INHERIT LOGIN PASSWORD 'ivi' IN ROLE administradores CONNECTION LIMIT 1;

-- PRIVILEGIOS
-- table | database| schema | function 
-- column | domain | foreign data wrapper
-- foreign server | sequence | language
-- large object | type | tablespace

-- DATABASE
-- GRANT {{CREATE | CONNECT | TEMPORARY | TEMP} [, ...] | ALL [PRIVILEGES]}
--     ON DATABASE database_name
--     TO role_specification

-- SCHEMA
-- GRANT {{CREATE | USAGE} [, ...] | ALL [PRIVILEGES]}
--     ON SCHEMA schema_name
--     TO role_specification


-- TABLE
-- GRANT {{SELECT | INSERT | UPDATE | DELETE | TRUNCATE | REFERENCES | TRIGGER}}
-- [, ...] | ALL [PRIVILEGES]}
--    ON {[TABLE] table_name [, ...]}
--   |ALL TABLES IN SCHEMA schema_name [, ...]}
--    TO role_specification

-- REVOKE (RETIRA AS PERMISSÕES))

-- REVOKE [GRANT OPTION FOR]
-- ON x(schema, database, table) | FROM role_name;

CREATE TABLE test (nome varchar);
GRANT ALL ON TABLE test TO administradores;

CREATE DATABASE auldadb02;