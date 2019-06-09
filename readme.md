### google play 和 ios 支付校验sdk

[![Build Status](https://travis-ci.org/NormanGyllenhaal/spring-boot-payment-starter.svg?branch=master)](https://travis-ci.org/NormanGyllenhaal/spring-boot-payment-starter)

使用retrofit2 封装google play 和 app store 支付验证api

已提交到maven中央仓库
```xml
<dependency>
    <groupId>top.javatool</groupId>
    <artifactId>spring-boot-payment-starter</artifactId>
    <version>1.1</version>
</dependency>
```
```java
//app store 消耗购买验证
AppStorePaymentService.consumeVerify();
//app store 订阅购买验证
AppStorePaymentService.subscriptionVerify();
//google play 消耗购买验证
GooglePlayPaymentService.productVerify();
//google   play 订阅购买验证
GooglePlayPaymentService.subscriptionVerify();

```

- 使用方法
application.yml 文件配置
```yaml
payment:
      appStorePassword: appstore 的验证密码
      # app store 的验证地址  正式和测试环境不同
      appStoreUrl: https://buy.itunes.apple.com/verifyReceipt/
      # google play 的验证地址 正式和测试环境相同
      googlePlayUrl: https://www.googleapis.com/
      base64PublicKey: google play 本地验证的ras公钥
```

  