### google play 和 ios 支付校验sdk

[![Build Status](https://travis-ci.org/NormanGyllenhaal/spring-boot-payment-starter.svg?branch=master)](https://travis-ci.org/NormanGyllenhaal/spring-boot-payment-starter)

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
  