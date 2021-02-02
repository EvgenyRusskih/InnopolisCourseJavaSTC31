---- Postgres v13 ----
--- SQL создание бд Shop для онлаин магазина ----
--- User/password dafault postgres ----

CREATE DATABASE "Shop"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;