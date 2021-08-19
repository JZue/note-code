package com.note.other.typeinterface;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author xuejunze
 * @date 2021/7/19 2:32 下午
 **/
public class ParameterizedTypeDemo<T> {

    public static void main(String[] args)  {
        Method[] methods = com.note.other.typeinterface.ParameterizedTypeDemo.class.getMethods();
        Method demoMethod = methods[0];
        Type[] genericParameterTypes = demoMethod.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("========"+genericParameterType.getClass().getSimpleName()+" 【type】 "+genericParameterType);
            if (genericParameterType instanceof ParameterizedType) {
                ParameterizedType pa = (ParameterizedType) genericParameterType;
                System.out.println("【getActualTypeArguments】"+Arrays.toString(pa.getActualTypeArguments()));
                System.out.println("【getOwnerType】"+pa.getOwnerType());
                System.out.println("【getRawType】"+pa.getRawType().getTypeName());
            }
        }

    }

    public <K,V> void testGenericArrayType(List<Long> list,
                                     ParameterizedTypeDemo<T> test,
                                     List<List<String>> ppTypeList,
                                     Map.Entry<K,V> map) {
    }

}
