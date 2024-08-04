-- Database: SpinTop_Records

-- DROP DATABASE IF EXISTS "SpinTop_Records";

CREATE DATABASE "SpinTop_Records"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

COMMENT ON DATABASE "SpinTop_Records"
    IS 'This is the search engine for SpinTop Records.

Sprint Final FullStack and Database';