package top.javatool.payment.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import top.javatool.payment.bean.AppStoreRequest;
import top.javatool.payment.bean.AppStoreResponse;
import top.javatool.payment.bean.AppStoreSubscriptionResponse;

/**
 * Created by Yang Peng on 2017/5/10.
 *
 * app store 支付验证接口
 */
public interface AppStorePaymentApi {


     /**
      * app store 内购支付验证
      * @param appStoreRequest 收据对象 password receipt-data
      * @return 验证结果
      */
     @POST("/verifyReceipt")
     Call<AppStoreResponse> verifyReceipt(@Body AppStoreRequest appStoreRequest);


     /**
      *  app store 订阅支付验证
      * @param appStoreRequest 收据对象 password receipt-data
      * @return 验证结果
      */
     @POST("/verifyReceipt")
     Call<AppStoreSubscriptionResponse> subscriptionVerifyReceipt(@Body AppStoreRequest appStoreRequest);
}
