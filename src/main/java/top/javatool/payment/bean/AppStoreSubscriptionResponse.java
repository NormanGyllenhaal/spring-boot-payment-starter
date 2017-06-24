package top.javatool.payment.bean;

/**
 * Created by Yang Peng on 2017/5/10.

 */
public class AppStoreSubscriptionResponse {


    /**
     * status : 0
     * environment : Production
     * latest_receipt_info : {"expires_date":"2016-01-15 17:22:53 Etc/GMT","expires_date_ms":1452878573000,"expires_date_pst":"2016-01-15 09:22:53 America/Los_Angeles","is_trial_period":true,"original_purchase_date":"2016-01-15 17:17:54 Etc/GMT","original_purchase_date_ms":1452878274000,"original_purchase_date_pst":"2016-01-15 09:17:54 America/Los_Angeles","original_transaction_id":1000000189163619,"product_id":"com.try.Free","purchase_date":"2016-01-15 17:17:53 Etc/GMT","purchase_date_ms":1452878273000,"purchase_date_pst":"2016-01-15 09:17:53 America/Los_Angeles","quantity":1,"transaction_id":1000000189163619,"web_order_line_item_id":1000000031509205}
     */

    private int status;
    private String environment;
    private LatestReceiptInfoBean latest_receipt_info;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public LatestReceiptInfoBean getLatest_receipt_info() {
        return latest_receipt_info;
    }

    public void setLatest_receipt_info(LatestReceiptInfoBean latest_receipt_info) {
        this.latest_receipt_info = latest_receipt_info;
    }

    public static class LatestReceiptInfoBean {
        /**
         * expires_date : 2016-01-15 17:22:53 Etc/GMT
         * expires_date_ms : 1452878573000
         * expires_date_pst : 2016-01-15 09:22:53 America/Los_Angeles
         * is_trial_period : true
         * original_purchase_date : 2016-01-15 17:17:54 Etc/GMT
         * original_purchase_date_ms : 1452878274000
         * original_purchase_date_pst : 2016-01-15 09:17:54 America/Los_Angeles
         * original_transaction_id : 1000000189163619
         * product_id : com.try.Free
         * purchase_date : 2016-01-15 17:17:53 Etc/GMT
         * purchase_date_ms : 1452878273000
         * purchase_date_pst : 2016-01-15 09:17:53 America/Los_Angeles
         * quantity : 1
         * transaction_id : 1000000189163619
         * web_order_line_item_id : 1000000031509205
         */

        private String expires_date;
        private long expires_date_ms;
        private String expires_date_pst;
        private boolean is_trial_period;
        private String original_purchase_date;
        private long original_purchase_date_ms;
        private String original_purchase_date_pst;
        private long original_transaction_id;
        private String product_id;
        private String purchase_date;
        private long purchase_date_ms;
        private String purchase_date_pst;
        private int quantity;
        private long transaction_id;
        private long web_order_line_item_id;

        public String getExpires_date() {
            return expires_date;
        }

        public void setExpires_date(String expires_date) {
            this.expires_date = expires_date;
        }

        public long getExpires_date_ms() {
            return expires_date_ms;
        }

        public void setExpires_date_ms(long expires_date_ms) {
            this.expires_date_ms = expires_date_ms;
        }

        public String getExpires_date_pst() {
            return expires_date_pst;
        }

        public void setExpires_date_pst(String expires_date_pst) {
            this.expires_date_pst = expires_date_pst;
        }

        public boolean isIs_trial_period() {
            return is_trial_period;
        }

        public void setIs_trial_period(boolean is_trial_period) {
            this.is_trial_period = is_trial_period;
        }

        public String getOriginal_purchase_date() {
            return original_purchase_date;
        }

        public void setOriginal_purchase_date(String original_purchase_date) {
            this.original_purchase_date = original_purchase_date;
        }

        public long getOriginal_purchase_date_ms() {
            return original_purchase_date_ms;
        }

        public void setOriginal_purchase_date_ms(long original_purchase_date_ms) {
            this.original_purchase_date_ms = original_purchase_date_ms;
        }

        public String getOriginal_purchase_date_pst() {
            return original_purchase_date_pst;
        }

        public void setOriginal_purchase_date_pst(String original_purchase_date_pst) {
            this.original_purchase_date_pst = original_purchase_date_pst;
        }

        public long getOriginal_transaction_id() {
            return original_transaction_id;
        }

        public void setOriginal_transaction_id(long original_transaction_id) {
            this.original_transaction_id = original_transaction_id;
        }

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getPurchase_date() {
            return purchase_date;
        }

        public void setPurchase_date(String purchase_date) {
            this.purchase_date = purchase_date;
        }

        public long getPurchase_date_ms() {
            return purchase_date_ms;
        }

        public void setPurchase_date_ms(long purchase_date_ms) {
            this.purchase_date_ms = purchase_date_ms;
        }

        public String getPurchase_date_pst() {
            return purchase_date_pst;
        }

        public void setPurchase_date_pst(String purchase_date_pst) {
            this.purchase_date_pst = purchase_date_pst;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public long getTransaction_id() {
            return transaction_id;
        }

        public void setTransaction_id(long transaction_id) {
            this.transaction_id = transaction_id;
        }

        public long getWeb_order_line_item_id() {
            return web_order_line_item_id;
        }

        public void setWeb_order_line_item_id(long web_order_line_item_id) {
            this.web_order_line_item_id = web_order_line_item_id;
        }
    }
}
