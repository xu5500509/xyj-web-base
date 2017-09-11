package cn.xyj.ssm.base.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * 重写FastJsonHttpMessageConverter的writeInternal方法（@ResponseBody）
 * @Author: xuyangjian
 * @Date: 2017/9/11 15:04
 */
public class XyjFastJsonHttpMessageConverter extends FastJsonHttpMessageConverter {


    public final static Charset UTF8 = Charset.forName("UTF-8");

    private Charset charset  = UTF8;

    private SerializerFeature[] features = new SerializerFeature[0];

    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        //自定义返回结果
        Result  result = ResultUtil.success(obj);

        OutputStream out = outputMessage.getBody();
        String text = JSON.toJSONString(result, this.features);
        byte[] bytes = text.getBytes(this.charset);
        out.write(bytes);
    }
}
