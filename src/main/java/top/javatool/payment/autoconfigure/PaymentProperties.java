package top.javatool.payment.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Yang Peng on 2017/5/11.
 *
 */
@ConfigurationProperties(prefix = PaymentProperties.PAYMENT)
public class PaymentProperties {


    static final String PAYMENT = "payment";


    private String appStorePassword;


    private String appStoreUrl;


    private String googlePlayUrl;


    private String base64PublicKey;



    public String getBase64PublicKey() {
        return base64PublicKey;
    }

    public void setBase64PublicKey(String base64PublicKey) {
        this.base64PublicKey = base64PublicKey;
    }

    public String getAppStorePassword() {
        return appStorePassword;
    }

    public void setAppStorePassword(String appStorePassword) {
        this.appStorePassword = appStorePassword;
    }

    public String getAppStoreUrl() {
        return appStoreUrl;
    }

    public void setAppStoreUrl(String appStoreUrl) {
        this.appStoreUrl = appStoreUrl;
    }

    public String getGooglePlayUrl() {
        return googlePlayUrl;
    }

    public void setGooglePlayUrl(String googlePlayUrl) {
        this.googlePlayUrl = googlePlayUrl;
    }
}
