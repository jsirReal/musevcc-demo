package com.muse.demo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.muse.demo.dto.Document;
import org.apache.commons.lang3.StringUtils;

import java.util.*;


@SuppressWarnings("all")
public class MapUtils {

    /**
     * convert JavaBean into Map
     */
    public static Map<String,Object> convert(Object obj) {
        Map<String,Object> map = JSON.parseObject(JSON.toJSONString(obj), Map.class);
        return map==null?new HashMap():map;

    }


    /**
     * convert Map into JavaBean
     */
    public static <T> T convertToObject(Map map, Class<T> clazz) {
        return JSONObject.parseObject(JSON.toJSONString(map), clazz);
    }



    /**
     * map -> k1=v1&k2=v2
     */
    public static String joinMap(Map map, List<String> excludes){
        StringBuilder sb = new StringBuilder();
        if(map == null || map.isEmpty()){
            return sb.toString();
        }
        List<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);
        for (String key : keyList){
            String value = StringUtils.EMPTY;
            if (map.get(key) instanceof JSONObject) {
                JSONObject valObj =(JSONObject) map.get(key);
                if (valObj != null && valObj.keySet().size() > 0) {
                    value = jsonSort(valObj);
                }
            } else {
                value = map.get(key).toString();
            }
            //eliminate blank value
            if(StringUtils.isBlank(value) || excludes.contains(key)){
                continue;
            }
            sb.append(key).append("=").append(value).append("&");
        }
        String result = sb.toString();
        //remove last "&"
        result = result.substring(0,result.length()-1);
        return result;
    }

    public static String jsonSort(JSONObject valObj) {
        JSONObject newObj = new JSONObject();
        for (String s : valObj.keySet()) {
            Object v = valObj.get(s);
            if (v == null) {
                continue;
            }
            if (v instanceof String && StringUtils.isBlank((String)v)) {
                continue;
            }
            newObj.put(s, v);
        }
        return JSONObject.toJSONString(newObj, SerializerFeature.MapSortField);
    }
}
