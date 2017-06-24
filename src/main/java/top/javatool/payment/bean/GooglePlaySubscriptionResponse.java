package top.javatool.payment.bean;

/**
 * Created by Yang Peng on 2017/5/11.
 *
 *  google 订阅支付返回数据对象
 */
public class GooglePlaySubscriptionResponse {


    /**
     * kind : androidpublisher#subscriptionPurchase
     * startTimeMillis : long
     * expiryTimeMillis : long
     * autoRenewing : boolean
     * priceCurrencyCode : string
     * priceAmountMicros : long
     * countryCode : string
     * developerPayload : string
     * paymentState : integer
     * cancelReason : integer
     * userCancellationTimeMillis : long
     */

    private String kind;
    private long startTimeMillis;
    private long expiryTimeMillis;
    private boolean autoRenewing;
    private String priceCurrencyCode;
    private long priceAmountMicros;
    private String countryCode;
    private String developerPayload;
    private int paymentState;
    private int cancelReason;
    private long userCancellationTimeMillis;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDeveloperPayload() {
        return developerPayload;
    }

    public void setDeveloperPayload(String developerPayload) {
        this.developerPayload = developerPayload;
    }


    public long getStartTimeMillis() {
        return startTimeMillis;
    }

    public void setStartTimeMillis(long startTimeMillis) {
        this.startTimeMillis = startTimeMillis;
    }

    public long getExpiryTimeMillis() {
        return expiryTimeMillis;
    }

    public void setExpiryTimeMillis(long expiryTimeMillis) {
        this.expiryTimeMillis = expiryTimeMillis;
    }

    public boolean isAutoRenewing() {
        return autoRenewing;
    }

    public void setAutoRenewing(boolean autoRenewing) {
        this.autoRenewing = autoRenewing;
    }

    public String getPriceCurrencyCode() {
        return priceCurrencyCode;
    }

    public void setPriceCurrencyCode(String priceCurrencyCode) {
        this.priceCurrencyCode = priceCurrencyCode;
    }

    public long getPriceAmountMicros() {
        return priceAmountMicros;
    }

    public void setPriceAmountMicros(long priceAmountMicros) {
        this.priceAmountMicros = priceAmountMicros;
    }

    public int getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(int paymentState) {
        this.paymentState = paymentState;
    }

    public int getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(int cancelReason) {
        this.cancelReason = cancelReason;
    }

    public long getUserCancellationTimeMillis() {
        return userCancellationTimeMillis;
    }

    public void setUserCancellationTimeMillis(long userCancellationTimeMillis) {
        this.userCancellationTimeMillis = userCancellationTimeMillis;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GooglePlaySubscriptionResponse{");
        sb.append("kind='").append(kind).append('\'');
        sb.append(", startTimeMillis=").append(startTimeMillis);
        sb.append(", expiryTimeMillis=").append(expiryTimeMillis);
        sb.append(", autoRenewing=").append(autoRenewing);
        sb.append(", priceCurrencyCode='").append(priceCurrencyCode).append('\'');
        sb.append(", priceAmountMicros=").append(priceAmountMicros);
        sb.append(", countryCode='").append(countryCode).append('\'');
        sb.append(", developerPayload='").append(developerPayload).append('\'');
        sb.append(", paymentState=").append(paymentState);
        sb.append(", cancelReason=").append(cancelReason);
        sb.append(", userCancellationTimeMillis=").append(userCancellationTimeMillis);
        sb.append('}');
        return sb.toString();
    }
}
