package top.javatool.payment.converter;

import com.alibaba.fastjson.JSON;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.Converter;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 *
 * Created by apple on 2017/4/9.
 */
public class FastJsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {


    private final Type type;

    public FastJsonResponseBodyConverter(Type type) {
        this.type = type;
    }

    public T convert(ResponseBody value) throws IOException  {
        BufferedSource bufferedSource = Okio.buffer(value.source());
        String tempStr = bufferedSource.readUtf8();
        bufferedSource.close();
        return JSON.parseObject(tempStr, type);
    }
}
