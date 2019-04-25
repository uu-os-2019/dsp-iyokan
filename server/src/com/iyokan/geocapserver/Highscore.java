package com.iyokan.geocapserver;

import java.util.*;
import java.util.stream.Stream;

public class Highscore {
    private HashMap<UserGuid, Integer> highscore;

    public Highscore() {
        this.highscore = new HashMap<>();
    }

    public void updateHighscore(UserGuid guid, Integer score) {
        int temp_score = 0;
        if(highscore.get(guid) != null) {
            temp_score = highscore.get(guid);
        }

        this.highscore.put(guid, score + temp_score);
    }

    public Integer getUserHighscore(UserGuid guid) {
        if(this.highscore.containsKey(guid)) {
            return this.highscore.get(guid);
        } else {
            return 0;
        }
    }

    public Map<UserGuid, Integer> getHighscore(int amount) {
        Map<UserGuid, Integer> value = crunchifySortByValue(this.highscore, amount);

        return value;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> crunchifySortByValue(Map<K, V> crunchifyMap, int amount) {

        Map<K, V> crunchifyResult = new LinkedHashMap<>();
        Stream<Map.Entry<K, V>> sequentialStream = crunchifyMap.entrySet().stream();

        // comparingByValue() returns a comparator that compares Map.Entry in natural order on value.
        Comparator<Map.Entry<UserGuid, Integer>> cmp = Map.Entry.comparingByValue();

        sequentialStream.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(amount).forEachOrdered(c -> crunchifyResult.put(c.getKey(), c.getValue()));
        return crunchifyResult;
    }
}
