package com.note.other.typeinterface;

import javax.annotation.Resource;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author xuejunze
 * @date 2021/7/19 4:48 下午
 **/
public class TypeVariableDemo<K extends List<V>,V extends Resource ,T> {
    K k;
    V v;
    List<V> vList;
    Map<V,T> tMap;
    public static void main(String[] args)  {

        Field[] fields = TypeVariableDemo.class.getDeclaredFields();
        for (Field field : fields) {
            Type type = field.getGenericType();
            System.out.println(">>>>>>>>>>>>>"+type.getClass().getSimpleName()+" 【type】 "+type);
            if (type instanceof TypeVariable) {
                TypeVariable typeVariable=((TypeVariable) type);
                System.out.println("【getBounds】"+ Arrays.toString(typeVariable.getBounds()));
                AnnotatedType[] annotatedBounds = typeVariable.getAnnotatedBounds();
                if (annotatedBounds[0].getAnnotations().length>0) {
                    System.out.println("【getAnnotatedBounds】"+ annotatedBounds[0].getAnnotations()[0].annotationType());
                }



                System.out.println("【getAnnotatedBounds.size】"+ typeVariable.getAnnotatedBounds().length);
                System.out.println("【getName】"+typeVariable.getName());
                System.out.println("【getGenericDeclaration】"+typeVariable.getGenericDeclaration());
            }

        }


    }


}
