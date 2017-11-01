### 1. java Spring MVC: 
`siege -c100 -t60s -b http://127.0.0.1:8080`
```
Lifting the server siege...
Transactions:		      153319 hits
Availability:		      100.00 %
Elapsed time:		       59.76 secs
Data transferred:	        0.73 MB
Response time:		        0.03 secs
Transaction rate:	     2565.58 trans/sec
Throughput:		        0.01 MB/sec
Concurrency:		       74.70
Successful transactions:      153384
Failed transactions:	           0
Longest transaction:	        0.27
Shortest transaction:	        0.00
```

### 2. nodejs http
`siege -c100 -t60s -b http://127.0.0.1:3000/`
```
Lifting the server siege...
Transactions:		      498218 hits
Availability:		      100.00 %
Elapsed time:		       59.45 secs
Data transferred:	        2.38 MB
Response time:		        0.01 secs
Transaction rate:	     8380.45 trans/sec
Throughput:		        0.04 MB/sec
Concurrency:		       99.48
Successful transactions:      498220
Failed transactions:	           0
Longest transaction:	        0.05
Shortest transaction:	        0.00
```
` siege -c100 -t60s -b http://127.0.0.1:8080/webAsyncHello`
### 3. java WebAsyncTask
```
Transactions:		      204930 hits
Availability:		      100.00 %
Elapsed time:		       59.07 secs
Data transferred:	        0.98 MB
Response time:		        0.03 secs
Transaction rate:	     3469.27 trans/sec
Throughput:		        0.02 MB/sec
Concurrency:		       98.89
Successful transactions:      204931
Failed transactions:	           0
Longest transaction:	        0.37
Shortest transaction:	        0.00
```

siege 参数
```
-c 200 指定并发数200
-r 5 指定测试的次数5
-f urls.txt 制定url的文件
-i internet系统，随机发送url
-b 请求无需等待 delay=0
-t 5 持续测试5分钟
# -r和-t一般不同时使用
```
siege 结果说明
```
Transactions: 总共测试次数
Availability: 成功次数百分比
Elapsed time: 总共耗时多少秒
Data transferred: 总共数据传输
Response time: 等到响应耗时
Transaction rate: 平均每秒处理请求数
Throughput: 吞吐率
Concurrency: 最高并发
Successful transactions: 成功的请求数
Failed transactions: 失败的请求数
```
