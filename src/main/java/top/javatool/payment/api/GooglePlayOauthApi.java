package top.javatool.payment.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import top.javatool.payment.bean.GooglePlayOauthResponse;

/**
 * Created by Yang Peng on 2017/5/11.
 *
 * @Description: ${todo} 这里用一句话描述这个类的作用
 */
public interface GooglePlayOauthApi {


    /**
     * grant_type=authorization_code
     * code=<the code from the previous step>
     * client_id=<the client ID token created in the APIs Console>
     * client_secret=<the client secret corresponding to the client ID>
     * redirect_uri=<the URI registered with the client ID>
     *
     * @return
     */
    @FormUrlEncoded
    @POST("https://accounts.google.com/o/oauth2/token")
    Call<GooglePlayOauthResponse> oauth(@Field("grant_type") String grantType, @Field("code") String code,
                                        @Field("client_id") String clientId, @Field("client_secret") String clientSecret,
                                        @Field("redirect_uri") String redirectUri);


    /**
     * Using the refresh token
     * <p>
     * Each access token is only valid for a short time. Once the current access token expires, the server will need to use the refresh token to get a new one. To do this, send a POST request to https://accounts.google.com/o/oauth2/token with the following fields set:
     * <p>
     * grant_type=refresh_token
     * client_id=<the client ID token created in the APIs Console>
     * client_secret=<the client secret corresponding to the client ID>
     * refresh_token=<the refresh token from the previous step>
     *
     * @param grantType
     * @param refreshToken
     * @param clientId
     * @param clientSecret
     * @return
     */
    @FormUrlEncoded
    @POST("https://accounts.google.com/o/oauth2/token")
    Call<GooglePlayOauthResponse> refreshToken(@Field("grant_type") String grantType, @Field("refresh_token") String refreshToken,
                                               @Field("client_id") String clientId, @Field("client_secret") String clientSecret);


}
