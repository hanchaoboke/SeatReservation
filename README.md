# 自习室座位预定系统

* 业务逻辑介绍：  
&emsp; 后端：添加位置、查看位置列表、查看位置预约历史。  
&emsp; 前端：查看位置的预约情况、预约占座、查看个人预约历史、取消预约。    
&emsp; 规则：位置 24小时开放，预约只能按整点预约，至少1小时；一次预约只能占一个座且时间连续。  

* 技术栈： jquery+bootstrap、thymeleaf、springboot全家桶、mybatis、redis（可选）等。

## 组织结构

```
SeatReservation
    ├── docs -- SQL文件
    ├── src 
         └── main 
                ├── java -- 源代码
                └──  resource -- 资源文件
                        └── templates -- 视图
    ├── pom.xml -- Maven依赖
    └── README.md -- 项目说明

```

## 数据库表结构

&emsp; docs/seat_reservation.sql