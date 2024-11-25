package com.alan.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

/**
 * @author linhyanyu
 * @description
 * @since 2024/7/4
 */
interface Demo1I1 { //@1
}
interface Demo1I2 { //@2
}
/**
 * 类中泛型变量案例
 *
 * @param <T1>
 * @param <T2>
 * @param <T3>
 */
public class Demo1<T1, T2 extends Integer, T3 extends Demo1I1 & Demo1I2> implements Demo1I1,Demo1I2{ //@3
    public static void main(String[] args) {
        TypeVariable<Class<Demo1>>[] typeParameters = Demo1.class.getTypeParameters();//@4
        for (TypeVariable<Class<Demo1>> typeParameter : typeParameters) {
            System.out.println("变量名称:" + typeParameter.getName());
            System.out.println("这个变量在哪声明的:" + typeParameter.getGenericDeclaration());
            Type[] bounds = typeParameter.getBounds();
            System.out.println("这个变量上边界数量:" + bounds.length);
            System.out.println("这个变量上边界清单:");
            for (Type bound : bounds) {
                System.out.println(bound.getTypeName());
            }
            System.out.println("--------------------");
        }

        TypeVariable<Class<Demo2>>[] typeParameters1 = Demo2.class.getTypeParameters();
        Type genericSuperclass = Demo2.class.getGenericSuperclass();
        System.out.println(genericSuperclass.getClass());
        ParameterizedType genericSuperclass1 = (ParameterizedType) genericSuperclass;
        System.out.println(genericSuperclass1.getOwnerType());
        System.out.println(genericSuperclass1.getRawType());
        System.out.println(genericSuperclass1.getTypeName());
        System.out.println(Arrays.toString(genericSuperclass1.getActualTypeArguments()));

    }
}
