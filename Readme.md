# SSM 构建网上商城

![](https://img.shields.io/badge/Windows-10-green.svg) 
![](https://img.shields.io/badge/IDEA-2018.2.1-green.svg) 
![](https://img.shields.io/badge/Java-1.8-blue.svg) 
![](https://img.shields.io/badge/Tomcat-8.5-blue.svg) 
![](https://img.shields.io/badge/Maven-3.3.9-blue.svg) 


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




