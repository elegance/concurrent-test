## 并发测试

#### 问题
1. BIO `ServerSocket`实现的服务, 服务端一个线程服务一个Client, 即一个`Socket`, 无多线程时只能服务一个Client, 其他连接均被阻塞, 配合多线程可以实现异步,但是客户端可能突破jvm能创建的线程上限
即使调优`Xss`, 使用线程池处理,可以限定最高线程数资源,其他Client连接进入队列等待处理?

    Q1: Client网络请求连接 ---> jvm Thread, TCP 状态变化? 已接入应用层 `ESTABLISHED`, TCP连接保持? 内核,JVM线程
    

2. Nodejs 单线程就能支持高并发

    Q1. 线程模型 与 Java NIO 2.0 对比, 连接

    Q2. 异步,线程 栈的处理? 事件?
    
测试结果: [result-report](src/test/rest-result-report.md)
    
#### 异步提高吞吐量
CallableController/DeferredController/WebAsyncTaskController


#### 缓存,让数据更接近要使用它的地方
浏览器缓存--> CDN --> 反向代理缓存 --> 应用缓存(堆内/堆外/磁盘)
线程工作内存 --> JVM主内存

#### 连接池化
数据库连接池/HttpClient连接池/Java线程池
