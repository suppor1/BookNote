#1.设计模式类型
##1.适配器模式
##2.装饰着模式
##3.访问者模式
##4.门面设计模式，（可以基于tomcat serverlt 理解）
##5.观察者模式 （可以基于tomcat LifeCycle 理解）
##6.命令模式 （可以基于tomcat Connector container 理解）
##7.责任链模式 (可以基于tomcat container 理解 Engine -> Host -> Context ->Wrapper 就是一个责任链)
##8.工厂模式 （可以基于Spring Bean 的创建立即，BeanFactory）
##9.代理模式 （可以基于Spring AOP理解 JDK动态代理和CGLIB代理）
##10.策略模式 （可以基于sparing 代理模式的选择，JDK动态代理和CGLIB代理，代理模式的选择使用了策略模式
##11.模板模式 （可以基于Spring MVC VIEW 学习理解）
##12.简单工程模式 (可以基于IBatis DataExchangeFactory 理解学习)
##13.工程模式（可以基于IBatis DataSourceFactory 理解学习）
##14.合成模式 (可以基于VeloCity AST（抽象语法树） 理解学习)
##15.解释器模式（可以基于VeloCity 解析 AST（抽象语法树） 理解学习）

![图片名称](http://gitcafe.com/image.png)  
链接  
[链接名称](http://gitcafe.com) 
~~在文字上添加删除线~~~ 

```puml
A -> B
```

引用  
> 第一行引用文字  
> 第二行引用文字 
水平线  
***
代码  
`<hello world>`  
代码块高亮  
```ruby  
  def add(a, b)  
    return a + b  
  end  
```  
表格  
  表头  | 表头  
  ------------- | -------------  
 单元格内容  | 单元格内容  
 单元格内容l  | 单元格内容
 
 # **`**基础后台架构**`**
 
 spring mybatis maven
 工程创建 com.jsk
 basic_tools
 basic_service  api
 basic_support
 
 基础架构服务框架 Dubbo 选型为RPC框架
 1:部署zookeeper
 2:部署dubbo的admin 注意修改
 <!-- 修改了两点。
     1. 原本的version是${project.parent.version}，其值在pom.xml上方有配置，实际上就是2.5.4-SNAPSHOT，但是经过查看发现在MAVEN库中，Dubbo团队只更新到了2.5.3。这个2.5.4-SNAPSHOT实际上是当前我们下载的这个源码的版本，我们不想自己打包使用这个版本。所以就使用MAVEN上的2.5.3.
     2. 另一个是增加了<exclusions>spring，这是因为dubbo缺省会依赖Spring，版本为2.5.6.SEC03。但是下面一个依赖配置com.alibaba.citrus.citrus-webx-all却也缺省依赖Spring，版本为3.2.16.RELEASE。    
 -->
 
 [<dependency>
     <groupId>com.alibaba</groupId>
     <artifactId>dubbo</artifactId>
     <version>2.5.3</version>
     <exclusions>
         <exclusion>
             <groupId>org.springframework</groupId>
             <artifactId>spring</artifactId>
         </exclusion>
     </exclusions> </dependency>](http://blog.csdn.net/u010297957/article/details/51702076)
 
 接着，如果此项目你不打算部署到与任意一个Zookeeper一个机器的话，就需要修改/dubbo-admin/src/main/webapp/WEB-INF/dubbo.properties文件，在其中指定你的Zookeeper地址（要保证这些机器能互相通讯）。
 
 没有要修改的了。可以使用Maven的package命令打包了。之后部署war项目，可以按照官网的部署方式，也就是将之部署为ROOT应用，
 
 部署项目到tomcat --成功
 
 服务提供者
 dubbo-practice-provider-api：暴漏接口和JavaBeans，让实现项目引用然后去实现、让消费者引用然后调用。这个比较简单，一看就懂就不展开讲了。
 dubbo-practice-provider-impl：上面api项目的实现项目，是一个普通Java项目；
 实现者项目dubbo-practice-provider-impl的主要内容就是Dubbo如何暴漏一个服务的使用了，说一下：
 
 
 

 

