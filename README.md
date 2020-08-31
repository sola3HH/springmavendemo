# springmavendemo

这是个人用于学习和研究spring boot的目录。
目前已有的内容：
  - 管理员登录的身份验证
  - 异常处理
    - controller层的aop切面@Aspect
    - ExceptionHandler统一异常处理@ControllerAdvice (二选一)
  - Dao层的数据库处理
  - 通过mybatis generator自动根据实体类生成的mapper
  - 适配swagger作为接口测试工具
  - 基于html, js(jquery,ajax), css, 的前端欢迎页面
  - 通过基于RestTemplate的单元测试对启动的接口进行测试
  - travis CI 持续集成服务
    - www.travis-ci.org用于集成public repository
    - www.travis-ci.com用于集成private repository
  - 通过flyway实现数据库迁移
  - 集成redis，通过缓存功能应付高并发
  - 配置Thread Pool实现多线程
  - 添加restTemplate工具类实现发送http请求
  