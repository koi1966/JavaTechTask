INSERT INTO users (id, name, email, password, roles, valid)
VALUES (1, 'admin','koi1966@ukr.net','$2a$10$BxpWkWlwiYSjaaUM9SZR2edMh4jGJmAylqGw4nylYYNs4n3CEF/n6','ROLE_ADMIN, ROLE_USER',true );


ALTER SEQUENCE user_seq RESTART WITH 2;