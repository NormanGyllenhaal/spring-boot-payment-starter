package top.javatool.payment.bean;

/**
 * Created by Yang Peng on 2017/5/11.
 *
 *  google play 订单查询响应数据对象
 */
public class GooglePlayProductResponse {


    /**
     * kind : androidpublisher#productPurchase
     * purchaseTimeMillis : 1494473887610
     * purchaseState : 0
     * consumptionState : 0
     * developerPayload : 73ca6eb4-8df6-4c44-bd29-6a1e5551e657
     */

    private String kind;

    private Long purchaseTimeMillis;

    private int purchaseState;

    private int consumptionState;

    private String developerPayload;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Long getPurchaseTimeMillis() {
        return purchaseTimeMillis;
    }

    public void setPurchaseTimeMillis(Long purchaseTimeMillis) {
        this.purchaseTimeMillis = purchaseTimeMillis;
    }

    public int getPurchaseState() {
        return purchaseState;
    }

    public void setPurchaseState(int purchaseState) {
        this.purchaseState = purchaseState;
    }

    public int getConsumptionState() {
        return consumptionState;
    }

    public void setConsumptionState(int consumptionState) {
        this.consumptionState = consumptionState;
    }

    public String getDeveloperPayload() {
        return developerPayload;
    }

    public void setDeveloperPayload(String developerPayload) {
        this.developerPayload = developerPayload;
    }
}
