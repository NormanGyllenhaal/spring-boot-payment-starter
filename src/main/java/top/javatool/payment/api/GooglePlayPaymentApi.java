package top.javatool.payment.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import top.javatool.payment.bean.GooglePlayProductResponse;
import top.javatool.payment.bean.GooglePlaySubscriptionResponse;

/**
 * Created by Yang Peng on 2017/5/10.
 *
 *  google pay 订单查询 api
 */
public interface GooglePlayPaymentApi {


    /**
     * google 查询google 消耗购买订单
     * consumptionState	integer	产品的消费状态。可能的值是：0 还有待消费 1 消费
     * developerPayload	string	一个开发人员指定的字符串，其中包含有关订单的补充信息。
     * kind	string	这种表示androidpublisher服务中的一个inappPurchase对象。
     * purchaseState	integer	订单的采购状态。可能的值是：0 购买 1 取消
     * purchaseTimeMillis	long	产品购买时间（自1970年1月1日起）。
     *
     * @param packageName 支付包名称
     * @param productId 产品id
     * @param token token
     * @return 验证结果
     */
    @GET("/androidpublisher/v2/applications/{packageName}/purchases/products/{productId}/tokens/{token}")
    Call<GooglePlayProductResponse> getProduct(@Path("packageName") String packageName, @Path("productId") String productId,
                                               @Path("token") String token, @Query("access_token") String accessToken);


    /**
     * 查询 google 订阅购买订单
     * <p>
     * autoRenewing	boolean	订阅是否在达到当前到期时间后自动更新。
     * cancelReason	integer	订阅被取消或不是自动更新的原因。可能的值是：0 用户取消订阅 1 订单被系统取消，例如因为计费问题
     * countryCode	string	授权时用户的ISO 3166-1 alpha-2计费国家/地区代码。
     * developerPayload	string	一个开发人员指定的字符串，其中包含有关订单的补充信息。
     * expiryTimeMillis	long	订阅期满后的时间，自时代以来的毫秒。
     * kind	string	这种类型表示androidpublisher服务中的subscriptionPurchase对象。
     * paymentState	integer	订阅的付款状态。可能的值是：0 付款等待中 1 已收到付款 2 免费试用
     * priceAmountMicros	long	认购价格，不含税。价格以微型单位表示，其中1,000,000个微单位是货币的一个单位。例如，如果认购价为1.99€，price_amount_micros是1990000。
     * priceCurrencyCode	string	订阅价格为ISO 4217货币代码。例如，如果价格是以英镑计算的，price_currency_code就是"GBP"。
     * startTimeMillis	long	授予订阅的时间，自纪元以来的毫秒。
     * userCancellationTimeMillis	long	用户取消订阅的时间，从时代开始以毫秒为单位。仅当cancelReason为0时才出现。
     *
     * @param packageName 包名称
     * @param subscriptionId 订阅产品id
     * @param token token
     * @return 验证结果
     */
    @GET("/androidpublisher/v2/applications/{packageName}/purchases/subscriptions/{subscriptionId}/tokens/{token}")
    Call<GooglePlaySubscriptionResponse> getSubscription(@Path("packageName") String packageName, @Path("subscriptionId") String subscriptionId,
                                                         @Path("token") String token, @Query("access_token") String accessToken);
}
