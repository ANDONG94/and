package com.example.and.RAS;



import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

/**
 * @author and
 * @desc 请求数据解密
 * @date 2020-04-01
 */
@ControllerAdvice(basePackages = {"com.sxxd.sxxdapi.controller.bankapi"})

public class RsaDecodeRequestBodyAdvice implements RequestBodyAdvice {

    @Value("${spring.sxscyedbdk.yh.privateKey}")
    private  String  PRIVATE_KEY;

    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return body;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) throws IOException {
        try {
            boolean encode = false;
            if (methodParameter.getMethod().isAnnotationPresent(RsaSecurityParameter.class)) {
                //获取注解配置的包含和去除字段
                RsaSecurityParameter serializedField = methodParameter.getMethodAnnotation(RsaSecurityParameter.class);
                //入参是否需要解密
                encode = serializedField.inDecode();
            }
            if (encode) {
                System.out.println("对方法method :【" + methodParameter.getMethod().getName() + "】返回数据进行解密");
                return new MyHttpInputMessage(inputMessage);
            }else{
                return inputMessage;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("对方法method :【" + methodParameter.getMethod().getName() + "】返回数据进行解密出现异常："+e.getMessage());
            return inputMessage;
        }
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return body;
    }

    class MyHttpInputMessage implements HttpInputMessage {
        private HttpHeaders headers;

        private InputStream body;

        public MyHttpInputMessage(HttpInputMessage inputMessage) throws Exception {
            this.headers = inputMessage.getHeaders();
            String content = easpString(IOUtils.toString(inputMessage.getBody(),"utf-8"));
            this.body = IOUtils.toInputStream(APIRSAUtils.decryptDataOnJava(content,PRIVATE_KEY),"utf-8");
        }

        @Override
        public InputStream getBody() throws IOException {
            return body;
        }

        @Override
        public HttpHeaders getHeaders() {
            return headers;
        }

        /**
         *
         * @param requestData
         * @return
         */
        public String easpString(String requestData){
            if(requestData != null && !requestData.equals("")){
                /*String s = "{\"requestData\":";
                if(!requestData.startsWith(s)){
                    throw new RuntimeException("参数【requestData】缺失异常！");
                }else{
                    int closeLen = requestData.length()-1;
                    int openLen = "{\"requestData\":".length();
                    String substring = StringUtils.substring(requestData, openLen, closeLen);
                    return substring;
                }*/
                return requestData;
            }
            return "";
        }
    }
}