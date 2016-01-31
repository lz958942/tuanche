package com.tuanche.common.threadsafe;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tc on 2016/1/30.
 * ConcurrentHash是线程安全的,同时具有较高效率,因为将Map进行了分组<br/>
 * HashTable是早期java的一个同步对象，使用synchronized关键字实现各个方法<br/>
 */
public class ThreadSafeMap<T, V> implements Map<T, V> {

    ConcurrentHashMap<T, V> localMap;

    public ThreadSafeMap() {
        localMap = new ConcurrentHashMap<T, V>();
    }

    public int size() {
        return localMap.size();
    }


    public boolean isEmpty() {
        return localMap.isEmpty();
    }

    public boolean containsKey(Object key) {
        return localMap.containsKey(key);
    }


    public boolean containsValue(Object value) {
        return localMap.containsValue(value);
    }


    public V get(Object key) {
        return localMap.get(key);
    }


    public V put(T key, V value) {
        return localMap.put(key, value);
    }


    public V remove(Object key) {
        return localMap.remove(key);
    }


    public void putAll(Map<? extends T, ? extends V> m) {
        localMap.putAll(m);
    }


    public void clear() {
        localMap.clear();
    }


    public Set<T> keySet() {
        return localMap.keySet();
    }


    public Collection<V> values() {
        return localMap.values();
    }


    public Set<Entry<T, V>> entrySet() {
        return localMap.entrySet();
    }
}
