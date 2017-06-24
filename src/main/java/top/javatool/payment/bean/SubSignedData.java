package top.javatool.payment.bean;

/**
 * Created by Yang Peng on 2017/5/15.
 *

 */
public class SubSignedData {


    /**
     * orderId : GPA.1396-7383-9627-12383
     * packageName : com.rcplatform.livechat
     * productId : gold_300
     * purchaseTime : 1478622149406
     * purchaseState : 0
     * developerPayload : 4f94e778-c159-4dc1-a91c-ad16598ed099
     * purchaseToken : keihgajnnhojofanbgepkbnb.AO-J1OyL_F-K34kL-eKiyE6a8_qzPx1_7Zhp5CE_lj7c9j1mxPVfXfmDvW8yxrR5CLpnL0WLuBlPZshOUrIXBL5-4NnH6gmyr6XxuD0g_K0YIIrlPmecItPFVAnPKBUW5glVgOJ74W7P
     */

    private String orderId;

    private String packageName;

    private String subscriptionId;

    private long purchaseTime;

    private int purchaseState;

    private String developerPayload;

    private String purchaseToken;




    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public long getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(long purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public int getPurchaseState() {
        return purchaseState;
    }

    public void setPurchaseState(int purchaseState) {
        this.purchaseState = purchaseState;
    }

    public String getDeveloperPayload() {
        return developerPayload;
    }

    public void setDeveloperPayload(String developerPayload) {
        this.developerPayload = developerPayload;
    }

    public String getPurchaseToken() {
        return purchaseToken;
    }

    public void setPurchaseToken(String purchaseToken) {
        this.purchaseToken = purchaseToken;
    }
}
