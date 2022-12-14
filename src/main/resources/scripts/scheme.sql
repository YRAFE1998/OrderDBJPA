DROP DATABASE IF EXISTS orderdb;
            DROP USER IF EXISTS 'orderuser'@'%';
            DROP USER IF EXISTS 'orderadmin'@'%';

            CREATE DATABASE IF NOT EXISTS orderdb;

            CREATE USER IF NOT EXISTS 'orderadmin'@'%' IDENTIFIED WITH mysql_native_password BY 'password';

            GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE,CREATE VIEW,
            SHOW VIEW , CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON orderdb.* TO 'orderadmin'@'%';

            CREATE USER IF NOT EXISTS `orderuser`@`%` IDENTIFIED WITH mysql_native_password BY 'password';

            GRANT SELECT, INSERT, UPDATE, DELETE ON orderdb.* TO 'orderuser'@'%';