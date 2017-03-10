package com.fangzhzh.android.nzbuses.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangzhenfang
 * @since 1/18/17 2:34 PM
 */
public class ListUtils {
    public static <T> boolean isEmpty(List<T> list) {
        return list == null || list.isEmpty();
    }

    public interface MapFilter<T,K> {

        T map(K object);
    }

    public static <T,K> List<T> map(List<K> list, MapFilter<T,K> filter) {
        List<T> resultList = new ArrayList<T>();
        if (!isEmpty(list)) {
            for (K item : list) {
                resultList.add(filter.map(item));
            }
        }
        return resultList;
    }
}
