package top.javatool.payment.service;


import org.apache.commons.collections.CollectionUtils;
import retrofit2.Call;
import retrofit2.Response;
import top.javatool.payment.api.AppStorePaymentApi;
import top.javatool.payment.bean.AppStoreRequest;
import top.javatool.payment.bean.AppStoreResponse;
import top.javatool.payment.bean.AppStoreSubscriptionResponse;
import top.javatool.payment.client.RetrofitClient;

import java.io.IOException;
import java.util.List;

/**
 *
 *  app store 订单查询服务
 * Created by Yang Peng on 2017/5/10.
 *
 */
public class AppStorePaymentService {


    /**
     * app store 订单查询api
     */
    private AppStorePaymentApi appStorePaymentApi;


    /**
     *  ituns 查询密码
     */
    private String password;


    /**
     * 查询地址
     *  沙盒 https://sandbox.itunes.apple.com/verifyReceipt/
     *  正式 https://buy.itunes.apple.com/verifyReceipt/
     */
    private String baseUrl;


    public AppStorePaymentService(String password, String baseUrl) {
        this.password = password;
        this.baseUrl = baseUrl;
        RetrofitClient retrofitClient = new RetrofitClient(baseUrl);
        appStorePaymentApi = retrofitClient.getRetrofit().create(AppStorePaymentApi.class);
    }


    /**
     * app store 消耗内购订单查询
     * <p>
     * <p>
     * 21000App Store无法读取你提供的JSON数据
     * 21002 收据数据不符合格式
     * 21003 收据无法被验证
     * 21004 你提供的共享密钥和账户的共享密钥不一致
     * 21005 收据服务器当前不可用
     * 21006 收据是有效的，但订阅服务已经过期。当收到这个信息时，解码后的收据信息也包含在返回内容中
     * 21007 收据信息是测试用（sandbox），但却被发送到产品环境中验证
     * 21008 收据信息是产品环境中使用，但却被发送到测试环境中验证
     *
     * @param receiptData app store 收据
     * @return 订单信息
     * @throws IOException 异常
     */
    public AppStoreResponse consumeVerify(String receiptData) throws IOException {
        Call<AppStoreResponse> call = appStorePaymentApi.verifyReceipt(new AppStoreRequest(password, receiptData));
        Response<AppStoreResponse> response = call.execute();
        return response.body();
    }




    /**
     * app store 订阅内购校验
     *
     * @param receiptData app store 收据
     * @return 验证结果
     */
    public boolean subscriptionVerify(String receiptData) throws IOException {
        Call<AppStoreSubscriptionResponse> call = appStorePaymentApi.subscriptionVerifyReceipt(new AppStoreRequest(password, receiptData));
        Response<AppStoreSubscriptionResponse> response = call.execute();
        AppStoreSubscriptionResponse subscriptionResponse = response.body();
        if (subscriptionResponse.getStatus() == 0) {
            long expiresDateMs = subscriptionResponse.getLatest_receipt_info().getExpires_date_ms();
            long originalPurchaseDateMs = subscriptionResponse.getLatest_receipt_info().getOriginal_purchase_date_ms();
            long timeMillis = System.currentTimeMillis();
            if (timeMillis >= originalPurchaseDateMs && timeMillis <= expiresDateMs) {
                return true;
            }
        }
        return false;
    }


    /**
     * 检查app store 校验数据体，判断是否是一个成功订单
     * @param body app store 返回的订单信息
     * @param transactionId 事务id
     * @return 验证结果
     */
    public boolean checkResponse(AppStoreResponse body,String transactionId){
        if (body.getStatus() == 0) {
            List<AppStoreResponse.ReceiptBean.InAppBean> in_app = body.getReceipt().getIn_app();
            if (CollectionUtils.isNotEmpty(in_app)) {
                for (AppStoreResponse.ReceiptBean.InAppBean inAppBean : in_app) {
                    if (inAppBean.getTransaction_id().equals(transactionId)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
