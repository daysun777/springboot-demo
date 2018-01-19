### 结构最好是这样的
- controller
- mapper
- model
- StartApplication

### mapper提示Could not autowire. No beans of … type found？
编译时也没有问题，运行时也能通过。就是有一个红色提示。  Dao interface上加上了@Repository注解，也算是解决了。  
sql语句使用注解方式，没有XXmapper.xml文件

另一种方式 @Autowired变为 @Resource 也不用在DAO上加@Repository
```
@Resource 
UserMapper userMapper;
```

### @Autowired与@Resource的区别 
http://bhdweb.iteye.com/blog/1663907

### Intellij IDEA 2017 debug断点调试技巧与总结详解篇
http://blog.csdn.net/qq_27093465/article/details/64124330

### Spring 4 官方文档学习（十一）Web MVC 框架之配置Spring MVC
http://www.cnblogs.com/larryzeal/p/6160762.html

### mvnrepository
http://mvnrepository.com/
