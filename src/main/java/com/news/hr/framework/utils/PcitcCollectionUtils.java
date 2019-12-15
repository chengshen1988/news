package com.news.hr.framework.utils;

import com.google.gson.Gson;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

public class PcitcCollectionUtils {

    /**
     * 求两个集合的差     {1,2,3},{1,2}->{3}
     * @param primary
     * @param sub
     * @param <E>
     * @return
     */
    public static <E> Set<E> diff(Set<E> primary, Set<E> sub){
        if(CollectionUtils.isEmpty(primary)){
            return Collections.emptySet();
        }
        if(CollectionUtils.isEmpty(primary)){
            return primary;
        }
        primary.removeAll(sub);
        return primary;
    }

    /**
     * 求两个集合的差     {1,2,3},{1,2}->{3}
     * @param primary
     * @param sub
     * @param <E>
     * @return
     */
    public static <E> List<E> diff(List<E> primary, List<E> sub){
        if(CollectionUtils.isEmpty(primary)){
            return Collections.emptyList();
        }
        if(CollectionUtils.isEmpty(primary)){
            return primary;
        }
        primary.removeAll(sub);
        return primary;
    }

    public static void main(String[] args) {
        List<String> primary = Arrays.asList("1","2","3");
        List<String> sub = Arrays.asList("1","2");

        Set<String> primarySet = new HashSet<>(primary);
        Set<String> subSet = new HashSet<>(sub);
        Set<String> result = diff(primarySet, subSet);

        System.out.println(new Gson().toJson(result));


    }



}
