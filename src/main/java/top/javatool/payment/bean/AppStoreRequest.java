package top.javatool.payment.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Yang Peng on 2017/5/10.
 *
 */
public class AppStoreRequest {


    public AppStoreRequest() {
    }

    public AppStoreRequest(String password, String receiptData) {
        this.password = password;
        this.receiptData = receiptData;
    }

    private String password;


    @JSONField(name = "receipt-data")
    private String receiptData;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReceiptData() {
        return receiptData;
    }

    public void setReceiptData(String receiptData) {
        this.receiptData = receiptData;
    }
}
