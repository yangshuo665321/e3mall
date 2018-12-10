# SSM 构建网上商城

![](https://img.shields.io/badge/Windows-10-green.svg) 
![](https://img.shields.io/badge/IDEA-2018.2.1-green.svg) 
![](https://img.shields.io/badge/Java-1.8-blue.svg) 
![](https://img.shields.io/badge/Tomcat-8.5-blue.svg) 
![](https://img.shields.io/badge/Maven-3.3.9-blue.svg) 

   | 工程名                |    IP               |                     地址                         |
   | --------------------- | ------------------- | ------------------------------------------------ |
   | e3-manager-service    |   后台商品服务层    | [http://localhost:8080/](http://localhost:8080/) |
   | e3-manager-web        |   后台商品表现层    | [http://localhost:8082/](http://localhost:8082/) |
   | e3-portal-web         |   首页              | [http://localhost:8083/](http://localhost:8083/) |


为了检验作者的学习情况，故记录本项目的详细步骤

项目的详细步骤请看博客：
https://blog.csdn.net/weixin_42112635/article/category/8488010

## 1、后台工程搭建
    e3-parent：父工程，打包方式pom，管理jar包的版本号。
        |           项目中所有工程都应该继承父工程。
        |--e3-common：通用的工具类通用的pojo ， 打包方式jar
        |--e3-manager：服务层工程。聚合工程 ， Pom工程
            |--e3-manager-dao：             打包方式ja           Maven模块
            |--e3-manager-pojo：            打包方式jar          Maven模块
            |--e3-manager-interface：       打包方式jar ，       Maven模块
            |--e3-manager-service：         打包方式：jar ，     Maven模块
            |--e3-manager-web：表现层工程 ， 打包方式war  ，      Maven模块


## 2、SSM 框架整合
![整合思路](https://img-blog.csdnimg.cn/20181129222714386.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjExMjYzNQ==,size_16,color_FFFFFF,t_70)


