## Output:
```text
Add a customer:
2023-01-25T00:14:21.294+03:00 DEBUG 23912 --- [nio-8080-exec-2] c.e.o.controller.CustomerController      : /customer/api/add request received
```
```text
Get all customers:
2023-01-25T00:14:27.151+03:00 DEBUG 23912 --- [nio-8080-exec-3] c.e.o.controller.CustomerController      : /customer/api/all request received
2023-01-25T00:14:27.152+03:00 TRACE 23912 --- [nio-8080-exec-3] c.e.o.s.implementation.CustomerService   : Getting all customers
2023-01-25T00:14:27.209+03:00  INFO 23912 --- [nio-8080-exec-3] c.e.o.s.implementation.CustomerService   : All customers: [
{
"id" : "1",
"fullName" : "Macaulay Brennan",
"createdDate" : "2018-06-04 00:04:48"
}, {
"id" : "51",
"fullName" : "Lamar Levy",
"createdDate" : "2021-11-27 20:13:01"
}, {
"id" : "101",
"fullName" : "Finn Moreno",
"createdDate" : "2020-05-23 12:23:48"
}, {
"id" : "151",
"fullName" : "Jameson Graves",
"createdDate" : "2022-04-26 01:55:25"
}, {
"id" : "201",
"fullName" : "Scarlet Merrill",
"createdDate" : "2023-06-14 22:48:04"
}, {
"id" : "252",
"fullName" : "emin c testing",
"createdDate" : "2023-01-25 00:14:21"
} ]
2023-01-25T00:14:37.769+03:00 DEBUG 23912 --- [nio-8080-exec-4] c.e.o.controller.CustomerController      : /customer/api/getC request received
2023-01-25T00:14:37.769+03:00 TRACE 23912 --- [nio-8080-exec-4] c.e.o.s.implementation.CustomerService   : Getting customers that contains 'c'/'C' in their name
2023-01-25T00:14:37.774+03:00  INFO 23912 --- [nio-8080-exec-4] c.e.o.s.implementation.CustomerService   : Customers containing 'C' in their name: [ {
"id" : "1",
"fullName" : "Macaulay Brennan",
"createdDate" : "2018-06-04 00:04:48"
}, {
"id" : "201",
"fullName" : "Scarlet Merrill",
"createdDate" : "2023-06-14 22:48:04"
}, {
"id" : "252",
"fullName" : "emin c testing",
"createdDate" : "2023-01-25 00:14:21"
} ]
```
```text
Customer names who have bills where the cost is below 500:
2023-01-25T00:14:43.733+03:00  INFO 23912 --- [nio-8080-exec-5] c.e.o.s.implementation.CustomerService   : Customer names who have bills where the cost is below 50000: ["Lamar Levy","Finn Moreno","Scarlet Merrill","Jameson Graves"]
```        
```text
Create a new bill by order:
2023-01-25T00:14:53.060+03:00 DEBUG 23912 --- [nio-8080-exec-8] c.e.orderhw.controller.BillController    : /bill/api/order request received
2023-01-25T00:14:53.061+03:00 TRACE 23912 --- [nio-8080-exec-8] c.e.o.s.implementation.BillService       : Creating bill for order: {"cost":1578.0,"customerId":"252","companyId":"103"}
2023-01-25T00:14:53.085+03:00 DEBUG 23912 --- [nio-8080-exec-8] c.e.o.s.implementation.BillService       : Bill saved to the database: {"id":1211,"cost":157800,"customer":{"id":252,"fullName":"emin c testing","createdDate":"2023-01-25T00:14:21","bills":null},"company":{"id":103,"industry":"FASHION","name":"Vel Quam Dignissim Corporation"},"createdDate":"2023-01-25T00:14:53.0707182"}
```
```text
Get all bills: 
2023-01-25T00:15:11.956+03:00  INFO 23912 --- [nio-8080-exec-6] c.e.o.s.implementation.BillService       : All bills: [ {
"id" : 1000,
"amount" : "$2,587.00",
"customerId" : "1",
"customerName" : "Macaulay Brennan",
"companyName" : "Lacus Limited",
"companyIndustry" : "COSMETIC",
"createdDate" : "2021-06-10 19:10:42"
}, {
"id" : 1007,
"amount" : "$1,080.00",
"customerId" : "1",
"customerName" : "Macaulay Brennan",
"companyName" : "Lacus Limited",
"companyIndustry" : "COSMETIC",
"createdDate" : "2021-06-09 14:59:36"
}, {
"id" : 1014,
"amount" : "$1,720.00",
"customerId" : "51",
"customerName" : "Lamar Levy",
"companyName" : "Lacus Limited",
"companyIndustry" : "COSMETIC",
"createdDate" : "2023-06-28 09:03:38"
}, {
"id" : 1021,
"amount" : "$22.45",
"customerId" : "51",
"customerName" : "Lamar Levy",
"companyName" : "Vel Quam Dignissim Corporation",
"companyIndustry" : "FASHION",
"createdDate" : "2023-06-03 22:54:10"
}, {
"id" : 1028,
"amount" : "$18.86",
"customerId" : "101",
"customerName" : "Finn Moreno",
"companyName" : "Vel Quam Dignissim Corporation",
"companyIndustry" : "FASHION",
"createdDate" : "2023-06-19 23:38:55"
}, {
"id" : 1035,
"amount" : "$25.68",
"customerId" : "101",
"customerName" : "Finn Moreno",
"companyName" : "Vel Quam Dignissim Corporation",
"companyIndustry" : "FASHION",
"createdDate" : "2023-06-14 03:41:17"
}, {
"id" : 1042,
"amount" : "$2,606.00",
"customerId" : "151",
"customerName" : "Jameson Graves",
"companyName" : "Aenean Euismod Company",
"companyIndustry" : "FINANCE",
"createdDate" : "2023-06-08 00:03:59"
}, {
"id" : 1049,
"amount" : "$2,798.00",
"customerId" : "151",
"customerName" : "Jameson Graves",
"companyName" : "Aenean Euismod Company",
"companyIndustry" : "FINANCE",
"createdDate" : "2021-06-05 04:19:55"
}, {
"id" : 1056,
"amount" : "$267.00",
"customerId" : "201",
"customerName" : "Scarlet Merrill",
"companyName" : "Aenean Euismod Company",
"companyIndustry" : "FINANCE",
"createdDate" : "2023-06-09 14:11:04"
}, {
"id" : 1063,
"amount" : "$569.00",
"customerId" : "201",
"customerName" : "Scarlet Merrill",
"companyName" : "Molestie Sed PC",
"companyIndustry" : "TECH",
"createdDate" : "2022-06-24 22:27:06"
}, {
"id" : 1084,
"amount" : "$1,963.00",
"customerId" : "51",
"customerName" : "Lamar Levy",
"companyName" : "Aliquet Proin PC",
"companyIndustry" : "OTHER",
"createdDate" : "2023-10-19 00:49:23"
}, {
"id" : 1091,
"amount" : "$2,338.00",
"customerId" : "51",
"customerName" : "Lamar Levy",
"companyName" : "Aliquet Proin PC",
"companyIndustry" : "OTHER",
"createdDate" : "2020-10-27 11:54:53"
}, {
"id" : 1098,
"amount" : "$1,927.00",
"customerId" : "101",
"customerName" : "Finn Moreno",
"companyName" : "Aliquet Proin PC",
"companyIndustry" : "OTHER",
"createdDate" : "2023-05-22 21:59:09"
}, {
"id" : 1112,
"amount" : "$1,946.00",
"customerId" : "151",
"customerName" : "Jameson Graves",
"companyName" : "Lacus Limited",
"companyIndustry" : "COSMETIC",
"createdDate" : "2021-08-08 20:30:58"
}, {
"id" : 1119,
"amount" : "$2,675.00",
"customerId" : "151",
"customerName" : "Jameson Graves",
"companyName" : "Lacus Limited",
"companyIndustry" : "COSMETIC",
"createdDate" : "2023-10-10 23:50:38"
}, {
"id" : 1126,
"amount" : "$1,182.00",
"customerId" : "201",
"customerName" : "Scarlet Merrill",
"companyName" : "Vel Quam Dignissim Corporation",
"companyIndustry" : "FASHION",
"createdDate" : "2022-08-31 09:43:25"
}, {
"id" : 1133,
"amount" : "$830.00",
"customerId" : "201",
"customerName" : "Scarlet Merrill",
"companyName" : "Vel Quam Dignissim Corporation",
"companyIndustry" : "FASHION",
"createdDate" : "2021-06-02 01:15:22"
}, {
"id" : 1154,
"amount" : "$851.00",
"customerId" : "51",
"customerName" : "Lamar Levy",
"companyName" : "Aenean Euismod Company",
"companyIndustry" : "FINANCE",
"createdDate" : "2020-07-28 18:39:31"
}, {
"id" : 1161,
"amount" : "$593.00",
"customerId" : "51",
"customerName" : "Lamar Levy",
"companyName" : "Aenean Euismod Company",
"companyIndustry" : "FINANCE",
"createdDate" : "2021-06-12 04:19:28"
}, {
"id" : 1168,
"amount" : "$2,742.00",
"customerId" : "101",
"customerName" : "Finn Moreno",
"companyName" : "Molestie Sed PC",
"companyIndustry" : "TECH",
"createdDate" : "2021-04-08 15:20:31"
}, {
"id" : 1175,
"amount" : "$893.00",
"customerId" : "101",
"customerName" : "Finn Moreno",
"companyName" : "Molestie Sed PC",
"companyIndustry" : "TECH",
"createdDate" : "2021-10-18 02:27:21"
}, {
"id" : 1182,
"amount" : "$2,046.00",
"customerId" : "151",
"customerName" : "Jameson Graves",
"companyName" : "Molestie Sed PC",
"companyIndustry" : "TECH",
"createdDate" : "2022-07-02 01:16:48"
}, {
"id" : 1189,
"amount" : "$393.00",
"customerId" : "151",
"customerName" : "Jameson Graves",
"companyName" : "Aliquet Proin PC",
"companyIndustry" : "OTHER",
"createdDate" : "2023-04-15 12:14:55"
}, {
"id" : 1196,
"amount" : "$1,075.00",
"customerId" : "201",
"customerName" : "Scarlet Merrill",
"companyName" : "Aliquet Proin PC",
"companyIndustry" : "OTHER",
"createdDate" : "2021-11-07 21:15:01"
}, {
"id" : 1203,
"amount" : "$1,720.00",
"customerId" : "201",
"customerName" : "Scarlet Merrill",
"companyName" : "Aliquet Proin PC",
"companyIndustry" : "OTHER",
"createdDate" : "2023-10-08 10:09:54"
}, {
"id" : 1211,
"amount" : "$1,578.00",
"customerId" : "252",
"customerName" : "emin c testing",
"companyName" : "Vel Quam Dignissim Corporation",
"companyIndustry" : "FASHION",
"createdDate" : "2023-01-25 00:14:53"
} ] 
```
```text
Get bills created in June:
2023-01-25T00:15:21.448+03:00 DEBUG 23912 --- [nio-8080-exec-7] c.e.orderhw.controller.BillController    : /bill/api/getJune request received
2023-01-25T00:15:21.448+03:00 TRACE 23912 --- [nio-8080-exec-7] c.e.o.s.implementation.CustomerService   : Getting customers created in June
2023-01-25T00:15:21.497+03:00  INFO 23912 --- [nio-8080-exec-7] c.e.o.s.implementation.BillService       : Bill information of customers created in June: [ {
"id" : 1000,
"amount" : "$2,587.00",
"customerId" : "1",
"customerName" : "Macaulay Brennan",
"companyName" : "Lacus Limited",
"companyIndustry" : "COSMETIC",
"createdDate" : "2021-06-10 19:10:42"
}, {
"id" : 1007,
"amount" : "$1,080.00",
"customerId" : "1",
"customerName" : "Macaulay Brennan",
"companyName" : "Lacus Limited",
"companyIndustry" : "COSMETIC",
"createdDate" : "2021-06-09 14:59:36"
}, {
"id" : 1056,
"amount" : "$267.00",
"customerId" : "201",
"customerName" : "Scarlet Merrill",
"companyName" : "Aenean Euismod Company",
"companyIndustry" : "FINANCE",
"createdDate" : "2023-06-09 14:11:04"
}, {
"id" : 1063,
"amount" : "$569.00",
"customerId" : "201",
"customerName" : "Scarlet Merrill",
"companyName" : "Molestie Sed PC",
"companyIndustry" : "TECH",
"createdDate" : "2022-06-24 22:27:06"
}, {
"id" : 1126,
"amount" : "$1,182.00",
"customerId" : "201",
"customerName" : "Scarlet Merrill",
"companyName" : "Vel Quam Dignissim Corporation",
"companyIndustry" : "FASHION",
"createdDate" : "2022-08-31 09:43:25"
}, {
"id" : 1133,
"amount" : "$830.00",
"customerId" : "201",
"customerName" : "Scarlet Merrill",
"companyName" : "Vel Quam Dignissim Corporation",
"companyIndustry" : "FASHION",
"createdDate" : "2021-06-02 01:15:22"
}, {
"id" : 1196,
"amount" : "$1,075.00",
"customerId" : "201",
"customerName" : "Scarlet Merrill",
"companyName" : "Aliquet Proin PC",
"companyIndustry" : "OTHER",
"createdDate" : "2021-11-07 21:15:01"
}, {
"id" : 1203,
"amount" : "$1,720.00",
"customerId" : "201",
"customerName" : "Scarlet Merrill",
"companyName" : "Aliquet Proin PC",
"companyIndustry" : "OTHER",
"createdDate" : "2023-10-08 10:09:54"
} ]
```
```text
Total value of bills of customers created in June:
2023-01-25T00:15:29.023+03:00 DEBUG 23912 --- [nio-8080-exec-9] c.e.orderhw.controller.BillController    : /bill/api/getJune request received
2023-01-25T00:15:29.023+03:00 TRACE 23912 --- [nio-8080-exec-9] c.e.o.s.implementation.CustomerService   : Getting customers created in June
2023-01-25T00:15:29.036+03:00  INFO 23912 --- [nio-8080-exec-9] c.e.o.s.implementation.BillService       : Total value of bills of customers created in June: 931000
```
```text
Get all bills where the cost is above 1500:
2023-01-25T00:15:35.122+03:00 DEBUG 23912 --- [io-8080-exec-10] c.e.orderhw.controller.BillController    : /bill/api/above request received
2023-01-25T00:15:35.135+03:00  INFO 23912 --- [io-8080-exec-10] c.e.o.s.implementation.BillService       : All bills where the cost is above 150000: [ {
"id" : 1000,
"amount" : "$2,587.00",
"customerId" : "1",
"customerName" : "Macaulay Brennan",
"companyName" : "Lacus Limited",
"companyIndustry" : "COSMETIC",
"createdDate" : "2021-06-10 19:10:42"
}, {
"id" : 1014,
"amount" : "$1,720.00",
"customerId" : "51",
"customerName" : "Lamar Levy",
"companyName" : "Lacus Limited",
"companyIndustry" : "COSMETIC",
"createdDate" : "2023-06-28 09:03:38"
}, {
"id" : 1042,
"amount" : "$2,606.00",
"customerId" : "151",
"customerName" : "Jameson Graves",
"companyName" : "Aenean Euismod Company",
"companyIndustry" : "FINANCE",
"createdDate" : "2023-06-08 00:03:59"
}, {
"id" : 1049,
"amount" : "$2,798.00",
"customerId" : "151",
"customerName" : "Jameson Graves",
"companyName" : "Aenean Euismod Company",
"companyIndustry" : "FINANCE",
"createdDate" : "2021-06-05 04:19:55"
}, {
"id" : 1084,
"amount" : "$1,963.00",
"customerId" : "51",
"customerName" : "Lamar Levy",
"companyName" : "Aliquet Proin PC",
"companyIndustry" : "OTHER",
"createdDate" : "2023-10-19 00:49:23"
}, {
"id" : 1091,
"amount" : "$2,338.00",
"customerId" : "51",
"customerName" : "Lamar Levy",
"companyName" : "Aliquet Proin PC",
"companyIndustry" : "OTHER",
"createdDate" : "2020-10-27 11:54:53"
}, {
"id" : 1098,
"amount" : "$1,927.00",
"customerId" : "101",
"customerName" : "Finn Moreno",
"companyName" : "Aliquet Proin PC",
"companyIndustry" : "OTHER",
"createdDate" : "2023-05-22 21:59:09"
}, {
"id" : 1112,
"amount" : "$1,946.00",
"customerId" : "151",
"customerName" : "Jameson Graves",
"companyName" : "Lacus Limited",
"companyIndustry" : "COSMETIC",
"createdDate" : "2021-08-08 20:30:58"
}, {
"id" : 1119,
"amount" : "$2,675.00",
"customerId" : "151",
"customerName" : "Jameson Graves",
"companyName" : "Lacus Limited",
"companyIndustry" : "COSMETIC",
"createdDate" : "2023-10-10 23:50:38"
}, {
"id" : 1168,
"amount" : "$2,742.00",
"customerId" : "101",
"customerName" : "Finn Moreno",
"companyName" : "Molestie Sed PC",
"companyIndustry" : "TECH",
"createdDate" : "2021-04-08 15:20:31"
}, {
"id" : 1182,
"amount" : "$2,046.00",
"customerId" : "151",
"customerName" : "Jameson Graves",
"companyName" : "Molestie Sed PC",
"companyIndustry" : "TECH",
"createdDate" : "2022-07-02 01:16:48"
}, {
"id" : 1203,
"amount" : "$1,720.00",
"customerId" : "201",
"customerName" : "Scarlet Merrill",
"companyName" : "Aliquet Proin PC",
"companyIndustry" : "OTHER",
"createdDate" : "2023-10-08 10:09:54"
}, {
"id" : 1211,
"amount" : "$1,578.00",
"customerId" : "252",
"customerName" : "emin c testing",
"companyName" : "Vel Quam Dignissim Corporation",
"companyIndustry" : "FASHION",
"createdDate" : "2023-01-25 00:14:53"
} ]
```
```text
Get industries whose average bill was below 750 in June:
2023-01-25T00:15:40.457+03:00 DEBUG 23912 --- [nio-8080-exec-1] c.e.orderhw.controller.BillController    : /bill/api/getAverageAbove request received
2023-01-25T00:15:46.064+03:00  INFO 23912 --- [nio-8080-exec-2] c.e.o.s.implementation.BillService       : All industries whose average bill was below 75000 in June: [ "FASHION", "TECH" ]
```
