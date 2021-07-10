# springboot-securitywithJWT(H2 database+Security with JWT)

1. Add user in DB before authentication & generating the token.

INSERT INTO USER_INFO(id, user_name, password, active, roles) values(2, 'sai', '$2y$12$ofkIpFsjpB6EkH3aq8l99.wA5Lh/6AsfJSAwrtdhm1Gqq1sAuqafq', true, 'ROLE_USER');
INSERT INTO USER_INFO(id, user_name, password, active, roles) values(1, 'virupaksha', '$2y$12$ofkIpFsjpB6EkH3aq8l99.wA5Lh/6AsfJSAwrtdhm1Gqq1sAuqafq', true, 'ROLE_ADMIN, ROLE_USER');

Password is encoded using Bcrpt Algorithm.
https://bcrypt-generator.com/
above hashed password = veeru123


2. you can change jwt secrete key in properties file if you want to change.


3. update JWT accordingly in all api invike script file





