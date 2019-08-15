package com.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU1LinkedHashMap extends LinkedHashMap {

    private Integer cachaSize;

    public LRU1LinkedHashMap(int maxCapacity) {
        super(16, 0.75f, true);
        this.cachaSize = maxCapacity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry entry) {
        return size() > cachaSize;
    }

}
