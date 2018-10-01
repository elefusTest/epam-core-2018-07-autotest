package com.epam.se06;

import io.vavr.Tuple;
import io.vavr.Tuple2;

import java.util.Collections;
import java.util.HashMap;

public interface MapUtils<K,V> extends java.util.Map<K,V> {

    static <K,V> java.util.Map<K, V> of() {
        return Collections.unmodifiableMap(new HashMap<>());
    }

    static <K,V> java.util.Map<K, V> of(K k, V v) {
        HashMap<K, V> map = new HashMap<>();
        map.put(k, v);
        return Collections.unmodifiableMap(map);
    }

    static <K,V> java.util.Map<K, V> of(K k1, V v1, K k2, V v2) {
        HashMap<K, V> map = new HashMap<>();
        map.put(k1, v1);
        map.put(k2, v2);
        return Collections.unmodifiableMap(map);
    }

    static <K,V> java.util.Map<K, V> of(Tuple2<K,V>... entries) {
        HashMap<K, V> map = new HashMap<>();
        for (Tuple2<K,V> entry : entries)
            map.put(entry._1, entry._2);
        return Collections.unmodifiableMap(map);
    }

    static <K,V> Tuple2<K,V> entry(K k, V v) {
        return Tuple.of(k, v);
    }
}
