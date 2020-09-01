package com.example.and.RAS;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author and
 * @desc 请求数据加密
 * @date 2020-04-01
 */
@ControllerAdvice(basePackages = {"com.sxxd.sxxdapi.controller.bankapi"})
public class RsaDecodeResponseBodyAdvice implements ResponseBodyAdvice {
    @Value("${spring.sxscyedbdk.publicKey}")
    private  String  PUBLIC_KEY;
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        boolean encode = false;
        if (methodParameter.getMethod().isAnnotationPresent(RsaSecurityParameter.class)) {
            //获取注解配置的包含和去除字段
            RsaSecurityParameter serializedField = methodParameter.getMethodAnnotation(RsaSecurityParameter.class);
            //出参是否需要加密
            encode = serializedField.outEncode();
        }

        if (encode) {
            System.out.println("对方法method :【" + methodParameter.getMethod().getName() + "】返回数据进行加密");
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                String result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
                return APIRSAUtils.encryptedDataOnJava(result,PUBLIC_KEY);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("对方法method :【" + methodParameter.getMethod().getName() + "】返回数据进行加密出现异常："+e.getMessage());
            }
        }
        return o;
    }
}
