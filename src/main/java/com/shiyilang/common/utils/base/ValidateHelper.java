package com.shiyilang.common.utils.base;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * @Destription:Determine whether an object, string, collection is empty or not
 * @Auther:shiyilang
 * @Date:2018/11/29 21:27
 * @Version:1.0
 */
public final class ValidateHelper {

    /**
     * @Description:判断数组是否为空
     * @Date 2018/11/29 22:32
     * @Param [array]
     * @return boolean
     */
    @SuppressWarnings("unused")
    private static <T> boolean isEmptyArray(T[] array){
        if (array == null || array.length == 0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @Description:判断数组是否不为空
     * @Date 2018/11/29 22:32
     * @Param [array]
     * @return boolean
     */
    public static <T> boolean isNotEmptyArray(T[] array){
        if (array != null && array.length > 0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @Description:判断字符串是否为空
     * @Date 2018/11/29 22:33
     * @Param [string]
     * @return boolean
     */
    public static boolean isEmptyString(String string){
        if (string == null || string.length() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @Description:判断字符串是否不为空
     * @Date 2018/11/29 22:33
     * @Param [string]
     * @return boolean
     */
    public static boolean isNotEmptyString(String string){
        if (string != null && string.length() > 0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @Description:判断集合是否为空
     * @Date 2018/11/29 22:33
     * @Param [collection]
     * @return boolean
     */
    public static boolean isEmptyCollection(Collection<?> collection){
        if (collection == null || collection.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @Description:判断集合是否不为空
     * @Date 2018/11/29 22:33
     * @Param [collection]
     * @return boolean
     */
    public static boolean isNotEmptyCollection(Collection<?> collection){
        if (collection != null && !collection.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @Description:判断map集合是否不为空
     * @Date 2018/11/29 22:33
     * @Param [map]
     * @return boolean
     */
    public static boolean isNotEmptyMap(Map map){
        if (map != null && !map.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @Description:判断map集合是否为空
     * @Date 2018/11/29 22:34
     * @Param [map]
     * @return boolean
     */
    public static boolean isEmptyMap(Map map){
        if (map == null || map.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @Description:检验对象是否为空,String 中只有空格在对象中也算空.
     * @Date 2018/11/29 22:34
     * @Param [object]
     * @return boolean
     */
    public static boolean isEmpty(Object object) {
        if (null == object)
            return true;
        else if (object instanceof String)
            return "".equals(object.toString().trim());
        else if (object instanceof Iterable)
            return !((Iterable) object).iterator().hasNext();
        else if (object.getClass().isArray())
            return Array.getLength(object) == 0;
        else if (object instanceof Map)
            return ((Map) object).size() == 0;
        else if (Number.class.isAssignableFrom(object.getClass()))
            return false;
        else if (Date.class.isAssignableFrom(object.getClass()))
            return false;
        else
            return false;
    }
}
