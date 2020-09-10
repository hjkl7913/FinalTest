### 스프링 파이널 테스트

![10](https://postfiles.pstatic.net/MjAyMDA5MTBfMTM2/MDAxNTk5NzIyMjE0NDIy.RWIeeFCYZgzwiZLVHUBB8JTm95Oza682YE2fDnjWAFMg.ujnj0uDevvDDn5KP29uA_X6hKRsceT7Ri9N2c7UBYOkg.PNG.hjkl7913/Screenshot_1473.png?type=w773)
![11](https://postfiles.pstatic.net/MjAyMDA5MTBfMTg0/MDAxNTk5NzIyMjE0NDE5.jNmnfw56lYJZGnN9Q222yNdFMgbAodpqG7yjRahBvBEg.2WXGi22A3GEZJ2HgxJnU02DmQZN2DWzDNtRL3EAjuW8g.PNG.hjkl7913/Screenshot_1474.png?type=w773)
![12](https://postfiles.pstatic.net/MjAyMDA5MTBfOTMg/MDAxNTk5NzIyMjE0NDI1.iaMCuM0KZNLX8CZujcbun9MynkNeK827ouAe40T6ujAg.yyWMGVsEuJ3Y5q08en0_ExKyyMR9zRECbuCRTUIVUgYg.PNG.hjkl7913/Screenshot_1475.png?type=w773)
![13](https://postfiles.pstatic.net/MjAyMDA5MTBfMTgy/MDAxNTk5NzIyMjE0NDMw.BYThG9-EYH_-pJVZ4Kaz428MPc1F-Ce0eKvulf0E7kog.sQBL8mXwWAqFmziPJW4fuVy6VkON8HDrFcqlIaJhSsUg.PNG.hjkl7913/Screenshot_1476.png?type=w773)
![14](https://postfiles.pstatic.net/MjAyMDA5MTBfMTQ0/MDAxNTk5NzIyMjE0NDI1.axn2wiFVwDwA4IsQPwoHHlcPnHTzLLZ345A6EoDZU1Mg.qlt8bx6tRr62pEIV4E_nRk9UdvsM4sR_a2xuYVUQk8Eg.PNG.hjkl7913/Screenshot_1478.png?type=w773)
![15](https://postfiles.pstatic.net/MjAyMDA5MTBfMTg1/MDAxNTk5NzIyMjE0NDI4.z6fdx_ep2nopGvufb-T4vofkA36Lfj3K_xHoWOzbFgcg.T1QYryB9ihnRV8qTmvFfI4I5ZOQHiMS-kCZ9s2gnyHgg.PNG.hjkl7913/Screenshot_1479.png?type=w773)
![16](https://postfiles.pstatic.net/MjAyMDA5MTBfMTMy/MDAxNTk5NzIyMjE0NzEz.yQuZHP4bHaVjmQa_w8zObVwSASujaKuqvOXxFiIw3ukg.oWOAlb_EBFd4JTVgvQItt1drvdoxbvkjgATdrbE8-MAg.PNG.hjkl7913/Screenshot_1480.png?type=w773)
![17](https://postfiles.pstatic.net/MjAyMDA5MTBfMTIz/MDAxNTk5NzIyMjE0NzM2.1E4NKXiOjPa0K5W34Is3SocliIdVGrdUOAfduAn7upog.4mt0WgxwUmf3hTr9vBybbixJIVTC_xUUOUHdxTm6kVgg.PNG.hjkl7913/Screenshot_1481.png?type=w773)
![18](https://postfiles.pstatic.net/MjAyMDA5MTBfMTY3/MDAxNTk5NzIyMjE0NzE1.5dBdj_AyD5mRL8Y_A22vm6r5AuxbgQ0AGcPehrB3e24g.SS9tj1JnKI7i4AMuDfSoD-UA_YtS_2aPzPrqH_7_pCsg.PNG.hjkl7913/Screenshot_1482.png?type=w773)
![19](https://postfiles.pstatic.net/MjAyMDA5MTBfMTA4/MDAxNTk5NzIyMjE0NzI1.Jl_unLhXaQNgfPZXk-GFB145p9Pgi3Ppf_SBo6cavS4g.um3WnAROjR-cHeDuBTrrsTWiT2P7t9AeGIlH-Abw9cEg.PNG.hjkl7913/Screenshot_1483.png?type=w773)

# 의존성

- Spring Boot DevTools
- Lombok
- Mybatis Framework
- MySQL Driver
- Thymeleaf
- Spring Web

# MYSQL 셋팅

```sql
create user 'baseball'@'%' identified by 'bitc5600';
GRANT ALL PRIVILEGES ON *.* TO 'baseball'@'%';
create database baseball;
use baseball;


select * from playground;
select * from team;
select * from player;
select * from outplayer;

drop table playground;
drop table team;
drop table player;
drop table outplayer;


##야구장
create table playground(
	id int auto_increment primary key,
    groundName varchar(100),
    create_date timestamp
) engine=InnoDB default charset=utf8;


##팀
create table team(
	id int auto_increment primary key,
    groundId int,
    teamName varchar(100),
    create_date timestamp
) engine=InnoDB default charset=utf8;

##선수
create table player(
	id int auto_increment primary key,
    teamId int,
	teamName varchar(100),
	playerName varchar(100),
    position varchar(100),
    create_date timestamp
) engine=InnoDB default charset=utf8;


#퇴출
create table outplayer(
	id int auto_increment primary key,
    playerId int,
    playerName varchar(100),
    reason varchar(100),
    out_date varchar(100)
) engine=InnoDB default charset=utf8;


##

```

# 더미 데이터

```sql
INSERT INTO playground
 VALUES
 (1,'잠실 야구장','2020-09-09 07:00:23')
 ,(2,'사직 야구장','2020-09-09 07:00:30')
 ,(3,'창원NC파크','2020-09-09 07:00:37');


INSERT INTO team
VALUES
(1,1,'LG','2020-09-09 07:00:25'),
(2,2,'롯데','2020-09-09 07:00:32'),
(3,3,'NC','2020-09-09 07:00:44');

INSERT INTO player
 VALUES
(1,2,'롯데','정태승','투수','2020-09-09 07:38:45'),
 (2,2,'롯데','이대호','내야수','2020-09-09 07:38:53'),
 (3,2,'롯데','김재유','외야수','2020-09-09 07:39:11'),
 (4,2,'롯데','강태율','포수','2020-09-09 07:39:31'),
 (5,1,'LG','남호','투수','2020-09-09 07:40:03'),
 (6,1,'LG','오지환','내야수','2020-09-09 07:40:11'),
 (7,1,'LG','전민수','외야수','2020-09-09 07:40:22'),
 (8,1,'LG','김재성','포수','2020-09-09 07:40:31'),
 (9,3,'NC','안인산','투수','2020-09-09 07:40:55'),
 (10,3,'NC','지석훈','내야수','2020-09-09 07:41:04'),
 (11,3,'NC','김준완','외야수','2020-09-09 07:41:14'),
 (12,3,'NC','김형준','포수','2020-09-09 07:41:26');

```
