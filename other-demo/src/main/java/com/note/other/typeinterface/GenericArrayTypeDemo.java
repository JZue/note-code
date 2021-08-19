package com.note.other.typeinterface;


import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author xuejunze
 * @date 2021/6/8 12:32 下午
 **/
public class GenericArrayTypeDemo<T> {
    public static void main(String[] args)  {
        Method[] methods = GenericArrayTypeDemo.class.getMethods();
        Method demoMethod = methods[0];
        Type[] genericParameterTypes = demoMethod.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println(genericParameterType.getClass().getSimpleName()+" 【type】 "+genericParameterType);
        }

    }

    public void testGenericArrayType(List<String>[] pTypeArray, T[] vTypeArray
            , List<String> list, String[] strings, GenericArrayTypeDemo<T>[] test, List<List<String>>[] ppTypeList) {
    }
}
