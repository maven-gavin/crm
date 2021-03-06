package com.yuanbao.crm.common.repository.support.annotation;


import java.lang.annotation.*;

/**
 * 开启查询缓存
 *
 * @author Zhang Kaitao
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnableQueryCache {

    boolean value() default true;

}
