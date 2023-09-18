package com.itany.corejava.code17_设计模式.工厂模式;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 石小俊
 * @date 2023年09月18日 15:40
 * 工厂模式
 * 根据类加载路径下的objs.properties文件中的配置信息来创建对应的对象
 * 每一行数据的格式为:key=value
 * value表示需要创建的对象的类所在的包名.类名
 * 每个对象只创建一次
 * 如果配置的对象之间存在依赖关系,则在配置文件中进行配置时必须按照加载的顺序进行配置
 */
public class ObjectFactory {

    private static Map<String, Object> objs;

    static {
        objs = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            ObjectFactory
                                    .class
                                    .getClassLoader()
                                    .getResourceAsStream("objs.properties")));
            // 按行进行读取,每一行内容表示一个对象
            String line = null;
            while ((line = br.readLine()) != null) {
                // 考虑空行问题,如果是空行则不进行解析
                // 只有不为空行,才需要创建对应的对象
                if (!"".equals(line)) {
                    // 配置文件中的内容格式:key=value
                    // 根据等号进行分割,左边是key右边是value
                    String[] arr = line.split("=");
                    String key = arr[0];
                    String value = arr[1];
                    // 此时的value是对应类的包名.类名
                    // 需要通过反射创建出对应的对象
                    // 并将创建出的对象保存到集合中
                    objs.put(key, Class.forName(value).newInstance());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object getObject(String key) {
        Object obj = objs.get(key);
        if (obj == null) {
            throw new ObjectNotFoundException("根据对应的key:" + key + "在配置文件中没有找到对应的配置");
        }
        return obj;
    }
}
