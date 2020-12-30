/**
 * 文件名：BeanUtil
 * 作者：张喆
 * 时间：2020/9/29 10:46
 * 描述：
 */

package com.zz.common.util;

import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称:        BeanUtil
 * 创建时间:      2020/9/29 10:46
 * 版本:          1.0
 * 说明:
 */
public class BeanUtil {
    /**
     * 复制集合对象属性值，生成新类型集合
     * @param source 源集合
     * @param targetClass 目标集合类型
     * @return 新集合
     * */
    @SneakyThrows
    public static <T> List<T> copyList(List source, Class<T> targetClass){
        List<T> target = new ArrayList<>(source.size());
        for( int i = 0 ; i < source.size() ; i++){
            Object sourceItem = source.get(i);
            T targetItem = targetClass.newInstance();
            BeanUtils.copyProperties(sourceItem,targetItem);
            target.add(targetItem);
        }
        return target;

    }

    /**
     * 复制单个bean
     */
    public static <S, T> T copyBean(S source, T target) {
        if(source == null || target == null) {
            return null;
        }
        BeanCopier bc = BeanCopier.create(source.getClass(), target.getClass(), false);
        bc.copy(source, target, null);
        return target;
    }

    /**
     * 复制单个bean
     */
    public static <S, T> T copyBean(S source, Class<T> targetClazz) {
        T target = null;
        if(source != null) {
            try {
                BeanCopier bc = BeanCopier.create(source.getClass(), targetClazz, false);
                target = targetClazz.newInstance();
                bc.copy(source, target, null);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return target;
    }

    /**
     * 复制bean列表
     */
    public static <S, T> List<T> copyBeanList(List<S> sourceList, Class<T> targetClazz) {
        List<T> targetList = new ArrayList<T>();
        if(sourceList != null && sourceList.size() > 0) {
            for(S source : sourceList) {
                targetList.add(copyBean(source, targetClazz));
            }
        }
        return targetList;
    }


}
