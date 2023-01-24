DROP TABLE IF EXISTS bills;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS companies;

create table customer
(
    id           bigint not null
        primary key,
    created_date timestamp(0) default now(),
    full_name    varchar(255)
);

create table companies
(
    id       bigint not null
        primary key,
    industry varchar(255),
    name     varchar(255)
);

create table bills
(
    id           bigint not null
        primary key,
    cost         bigint       default 0,
    created_date timestamp(0) default now(),
    company_id   bigint not null
        constraint fkmc8qb35eisapddot20lo4hduk
            references companies,
    customer_id  bigint not null
        constraint fklkabkclsjjwtdg6nr3rjndt8x
            references customer
);

INSERT INTO customer (id,full_name,created_date)
VALUES
  (1,'Macaulay Brennan','2018-06-04 00:04:48'),
  (51,'Lamar Levy','2021-11-27 20:13:01'),
  (101,'Finn Moreno','2020-05-23 12:23:48'),
  (151,'Jameson Graves','2022-04-26 01:55:25'),
  (201,'Scarlet Merrill','2023-11-14 22:48:04');

SELECT setval('customer_seq', 251, true);

INSERT INTO companies (id,name,industry)
VALUES
  (3,'Lacus Limited','COSMETIC'),
  (103,'Vel Quam Dignissim Corporation','FASHION'),
  (203,'Aenean Euismod Company','FINANCE'),
  (303,'Molestie Sed PC','TECH'),
  (403,'Aliquet Proin PC','OTHER');

SELECT setval('companies_seq', 503, true);

INSERT INTO bills (id,cost,created_date,customer_id,company_id)
VALUES
  (1000,2587,'2021-03-10 19:10:42',1,3),
  (1007,1080,'2021-01-09 14:59:36',1,3),
  (1014,1720,'2023-05-28 09:03:38',51,3),
  (1021,2245,'2023-04-03 22:54:10',51,103),
  (1028,1886,'2023-09-19 23:38:55',101,103),
  (1035,2568,'2023-08-14 03:41:17',101,103),
  (1042,2606,'2023-12-08 00:03:59',151,203),
  (1049,2798,'2021-05-05 04:19:55',151,203),
  (1056,267,'2023-11-09 14:11:04',201,203),
  (1063,569,'2022-08-24 22:27:06',201,303);
INSERT INTO bills (id,cost,created_date,customer_id,company_id)
VALUES
  (1070,354,'2023-03-03 14:30:29',1,303),
  (1077,2297,'2022-01-17 12:25:45',1,303),
  (1084,1963,'2023-10-19 00:49:23',51,403),
  (1091,2338,'2020-10-27 11:54:53',51,403),
  (1098,1927,'2023-05-22 21:59:09',101,403),
  (1105,318,'2023-05-27 13:10:34',101,3),
  (1112,1946,'2021-08-08 20:30:58',151,3),
  (1119,2675,'2023-10-10 23:50:38',151,3),
  (1126,1182,'2022-08-31 09:43:25',201,103),
  (1133,830,'2021-06-02 01:15:22',201,103);
INSERT INTO bills (id,cost,created_date,customer_id,company_id)
VALUES
  (1140,1029,'2023-09-20 03:03:56',1,103),
  (1147,1520,'2022-03-31 08:39:28',1,203),
  (1154,851,'2020-07-28 18:39:31',51,203),
  (1161,593,'2021-06-12 04:19:28',51,203),
  (1168,2742,'2021-04-08 15:20:31',101,303),
  (1175,893,'2021-10-18 02:27:21',101,303),
  (1182,2046,'2022-07-02 01:16:48',151,303),
  (1189,393,'2023-04-15 12:14:55',151,403),
  (1196,1075,'2021-11-07 21:15:01',201,403),
  (1203,1720,'2023-10-08 10:09:54',201,403);

SELECT setval('bills_seq', 1210, true);
