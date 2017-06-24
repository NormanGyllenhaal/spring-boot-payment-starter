package top.javatool.payment.service;


import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import top.javatool.payment.api.GooglePlayOauthApi;
import top.javatool.payment.api.GooglePlayPaymentApi;
import top.javatool.payment.bean.GooglePlayOauthResponse;
import top.javatool.payment.bean.GooglePlayProductResponse;
import top.javatool.payment.bean.GooglePlaySubscriptionResponse;
import top.javatool.payment.client.RetrofitClient;
import top.javatool.payment.exception.TokenExpireException;
import top.javatool.payment.util.Base64;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by Yang Peng on 2017/5/11.
 *
 * @Description: ${todo} 这里用一句话描述这个类的作用
 */
public class GooglePlayPaymentService {


    private static final String base64PublicKey = "";

    private static final String KEY_FACTORY_ALGORITHM = "RSA";

    private static final String SIGNATURE_ALGORITHM = "SHA1withRSA";

    private GooglePlayPaymentApi googlePlayPaymentApi;


    private GooglePlayOauthApi googlePlayOauthApi;


    private String baseUrl;


    public GooglePlayPaymentService(String baseUrl) {
        this.baseUrl = baseUrl;
        Retrofit retrofit = new RetrofitClient(baseUrl).getRetrofit();
        googlePlayPaymentApi = retrofit.create(GooglePlayPaymentApi.class);
        googlePlayOauthApi = retrofit.create(GooglePlayOauthApi.class);
    }


    /**
     * 消耗购买验证
     *
     * @param packageName
     * @param productId
     * @param token
     * @param accessToken
     * @return
     * @throws IOException
     */
    public GooglePlayProductResponse productVerify(String packageName, String productId, String token, String accessToken) throws IOException, TokenExpireException {
        Call<GooglePlayProductResponse> call = googlePlayPaymentApi.getProduct(packageName, productId, token, accessToken);
        Response<GooglePlayProductResponse> response = call.execute();
        if (response.code() == 401) {
            throw new TokenExpireException();
        }
        return response.body();
    }


    public Response<GooglePlaySubscriptionResponse> subscriptionVerify(String packageName, String subscriptionId, String token, String accessToken) throws IOException {
        Call<GooglePlaySubscriptionResponse> call = googlePlayPaymentApi.getSubscription(packageName, subscriptionId, token, accessToken);
        try {
            return call.execute();
        } catch (IOException e) {
            e.printStackTrace();
            return call.execute();
        }
    }


    public boolean checkSubPaymentState(Response<GooglePlaySubscriptionResponse> response) throws TokenExpireException {
        if (response.code() == 401) {
            throw new TokenExpireException();
        }
        GooglePlaySubscriptionResponse body = response.body();
        if (body.getPaymentState() == 1) {
            return true;
        }
        return false;
    }


    /**
     * 获取 access_token
     *
     * @param code
     * @param clientId
     * @param clientSecret
     * @param redirectUri
     * @return
     * @throws IOException
     */
    public GooglePlayOauthResponse getToken(String code, String clientId, String clientSecret, String redirectUri) throws IOException {
        Call<GooglePlayOauthResponse> call = googlePlayOauthApi.oauth("authorization_code", code, clientId, clientSecret, redirectUri);
        Response<GooglePlayOauthResponse> execute = call.execute();
        return execute.body();
    }


    /**
     * 刷新 access_token
     *
     * @param clientId
     * @param clientSecret
     * @param refreshToken
     * @return
     * @throws IOException
     */
    public GooglePlayOauthResponse freshToken(String clientId, String clientSecret, String refreshToken) throws IOException {
        Call<GooglePlayOauthResponse> call = googlePlayOauthApi.refreshToken("refresh_token", refreshToken, clientId, clientSecret);
        Response<GooglePlayOauthResponse> execute = call.execute();
        return execute.body();
    }


    /**
     * 验证签名数据体
     *
     * @param signedData
     * @param signature
     * @return
     * @throws Exception
     */
    public boolean verifyData(String signedData, String signature) throws Exception {
        PublicKey key = generatePublicKey(base64PublicKey);
        return verify(key, signedData, signature);
    }


    private PublicKey generatePublicKey(String encodedPublicKey) throws Exception {
        byte[] decodedKey = Base64.decode(encodedPublicKey, Base64.DEFAULT);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_FACTORY_ALGORITHM);
        return keyFactory.generatePublic(new X509EncodedKeySpec(decodedKey));
    }


    private boolean verify(PublicKey publicKey, String signedData, String signature) throws Exception {
        byte[] signatureBytes = Base64.decode(signature, Base64.DEFAULT);
        Signature sig = Signature.getInstance(SIGNATURE_ALGORITHM);
        sig.initVerify(publicKey);
        sig.update(signedData.getBytes());
        if (sig.verify(signatureBytes)) {
            return true;
        }
        return false;
    }




}
