package com.muse.demo.utils;

import okhttp3.*;

import java.io.IOException;
import java.util.Map;


public class OkHttpUtils {

    /**
     * okHttp  get
     * @param url
     * @return
     */
    public static String doGet(OkHttpClient client, String url){
        return doGet(client, url, null);
    }


    /**
     * okHttp  get
     * @param url
     * @param headers
     * @return
     */
    public static String doGet(OkHttpClient client, String url, Map<String, String> headers){
        Request.Builder builder = new Request.Builder();
        if(headers != null){
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builder.addHeader(entry.getKey(), entry.getValue());
            }
        }

        Request request = builder.url(url).get().build();
        return getRespString(client, request);
    }



    /**
     * okHttp post
     * @param url
     * @param jsonBody
     * @return
     */
    public static String doPost(OkHttpClient client, String url, String jsonBody){
        return doPost(client, url, jsonBody, null);
    }


    /**
     * okHttp post
     * @param url
     * @param jsonBody
     * @param mediaTypeValue
     * @return
     */
    public static String doPost(OkHttpClient client, String url, String jsonBody, String mediaTypeValue){
        if(mediaTypeValue == null){
            mediaTypeValue = "application/json;charset=UTF-8";
        }
        MediaType mediaType = MediaType.parse(mediaTypeValue);
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(mediaType, jsonBody))
                .build();

        return getRespString(client, request);
    }

    private static String getRespString(OkHttpClient client, Request request) {
        String result = null;
        try {
            try (Response response = client.newCall(request).execute()) {
                if (response != null && response.body() != null) {
                    result = response.body().string();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
