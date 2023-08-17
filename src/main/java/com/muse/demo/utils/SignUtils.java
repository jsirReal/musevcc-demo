package com.muse.demo.utils;

import com.muse.demo.dto.CommonRequest;
import com.muse.demo.dto.SignRequest;
import com.muse.demo.dto.VerifySignRequest;
import com.muse.demo.dto.VerifySignResponse;
import com.muse.demo.dto.SignResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * sign steps：
 *   1、assemble content to sign
 *   2、build sign
 * verify steps：
 *   1、assemble content to sign
 *   2、verify sign

 */
public class SignUtils {

    public static <T> String assembleContent(T request){
        Map<String, Object> map = MapUtils.convert(request);
        List<String> excludes = new ArrayList<>();
        excludes.add("sign");
        return MapUtils.joinMap(map,excludes);
    }

    public static SignResponse sign(SignRequest request){
        String sign = RSAUtils.sign(request.getContent(), request.getPrivateKey(), request.getCharset());
        SignResponse response = new SignResponse();
        response.setSign(sign);
        response.setKeyType(request.getKeyType());
        return response;
    }

    public static VerifySignResponse verifySign(VerifySignRequest request){
        Boolean signOk = RSAUtils.verify(request.getContent(), request.getSign(), request.getPublicKey(), request.getCharset());
        VerifySignResponse response = new VerifySignResponse();
        response.setSignOk(signOk);
        response.setKeyType(request.getKeyType());
        return response;
    }

    public static void sign(CommonRequest commonRequest, String privateKey) {
        String content = SignUtils.assembleContent(commonRequest);

        SignRequest request = new SignRequest();
        request.setContent(content);
        request.setCharset("utf-8");
        request.setPrivateKey(privateKey);
        request.setKeyType("RSA");

        SignResponse signResponse = SignUtils.sign(request);
        commonRequest.setSign(signResponse.getSign());
    }

}
