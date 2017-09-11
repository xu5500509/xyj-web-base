package cn.xyj.ssm.base;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tengen on 2016/1/7.
 */
public abstract class BaseParam<T> implements Serializable {

    /**
     *字段常量——主键ID
     */
    public static final String F_ID="id";
    private static final long serialVersionUID = 1L;
    private T id;
    public T getId() {
        return this.id;
    }

    public void setId(T id) {
        this.id = id;
    }

    /**
     * 转换为普通Map（空值属性不作转换）
     *
     * @return Map
     */
    public  Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(this.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (!key.equals("class")) {
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(this);
                    if (value == null)
                        continue;
                    map.put(key, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
