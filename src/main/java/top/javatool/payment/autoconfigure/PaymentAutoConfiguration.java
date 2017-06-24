package top.javatool.payment.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.javatool.payment.service.AppStorePaymentService;
import top.javatool.payment.service.GooglePlayPaymentService;

/**
 *
 * spring boot 自动依赖注入
 * Created by Yang Peng on 2017/5/10.
 *
 */
@Configuration
@EnableConfigurationProperties(PaymentProperties.class)
public class PaymentAutoConfiguration {


    private PaymentProperties paymentProperties;


    public PaymentAutoConfiguration(PaymentProperties paymentProperties) {
        this.paymentProperties = paymentProperties;
    }


    @Bean
    @ConditionalOnMissingBean
    public AppStorePaymentService appStorePaymentService(){
        return  new AppStorePaymentService(paymentProperties.getAppStorePassword(),paymentProperties.getAppStoreUrl());
    }


    @Bean
    @ConditionalOnMissingBean
    public GooglePlayPaymentService googlePlayPaymentService(){
        return  new GooglePlayPaymentService(paymentProperties.getGooglePlayUrl(),paymentProperties.getBase64PublicKey());
    }


}
