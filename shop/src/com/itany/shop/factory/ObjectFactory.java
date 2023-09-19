package com.itany.shop.factory;

import com.itany.shop.exception.ObjectNotFoundException;
import com.itany.shop.util.ParameterUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 石小俊
 * @date 2023年09月19日 14:06
 */
public class ObjectFactory {

    private static Map<String, Object> objs;

    static {
        objs = new HashMap<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new InputStreamReader(
                            ObjectFactory
                                    .class
                                    .getClassLoader()
                                    .getResourceAsStream("beans.properties")));
            String line = null;
            while ((line = br.readLine()) != null) {
                // 只处理不为空的行
                if (!ParameterUtil.isNull(line)) {
                    String[] arr = line.split("=");
                    objs.put(arr[0], Class.forName(arr[1]).newInstance());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("ObjectFactory初始化失败");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new ExceptionInInitializerError("释放资源出错");
                }
            }
        }
    }

    public static Object getObject(String key) {
        Object obj = objs.get(key);
        if (null == obj) {
            throw new ObjectNotFoundException("根据指定的key:" + key + "在配置文件中没有找到对应的配置");
        }
        return obj;
    }
}
