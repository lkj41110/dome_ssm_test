## 项目

1. spring mvc配置
2. swagger前后端分离，api文档生成
3. maven 多模块应用()
4. slf4j和logback的日志配置方式,具体logback的配置[`说明`](http://blog.csdn.net/qq_25673113/article/details/74571574)
5. [前端使用说明](https://github.com/lkj41110/dome_ssm_test/blob/master/dome_admin/page/README.md)



## 项目的最佳实践约定
1. api层：
做单值校验，调用service获取DTO，捕获处理异常信息，组成VO对象，返回到前端
2. service层：
处理业务，有关业务逻辑的校验
3. dao层:
只与数据库层交互
