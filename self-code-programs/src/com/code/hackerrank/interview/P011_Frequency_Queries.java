package com.code.hackerrank.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P011_Frequency_Queries {

	static Map<Integer, List<Integer>> frequencyMap = new HashMap<>();

	static List<Integer> freqQuery(List<List<Integer>> queries) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		for (List<Integer> list : queries) {
			int query = list.get(0);
			int value = list.get(1);
			if (query == 1) {
				addToMap(map, value);
			} else if (query == 2) {
				removeFromMap(map, value);
			} else {
				result.add(checkPresence(value));
			}
		}
		return result;
	}

	static void addToMap(Map<Integer, Integer> map, Integer key) {
		int frequency;
		if (map.containsKey(key)) {
			frequency = map.get(key) + 1;
			map.put(key, frequency);
		} else {
			frequency = 1;
			map.put(key, frequency);
		}

		if (!frequencyMap.containsKey(frequency)) {
			List<Integer> list = new ArrayList<>();
			frequencyMap.put(frequency, list);
		}

		if (frequency == 1) {
			frequencyMap.get(frequency).add(key);
		} else {
			frequencyMap.get(frequency - 1).remove(key);
			if (frequencyMap.get(frequency - 1).isEmpty()) {
				frequencyMap.remove(frequency - 1);
			}
			frequencyMap.get(frequency).add(key);
		}
	}

	static void removeFromMap(Map<Integer, Integer> map, Integer key) {
		if (map.containsKey(key)) {
			int frequency;
			frequency = map.get(key) - 1;
			if (frequency == 0) {
				map.remove(key);
				return;
			}
			map.put(key, frequency);
			if (frequency == 0) {
				frequencyMap.get(frequency + 1).remove(key);
			} else {
				frequencyMap.get(frequency + 1).remove(key);
				if (frequencyMap.get(frequency + 1).isEmpty()) {
					frequencyMap.remove(frequency + 1);
				}
				frequencyMap.get(frequency).add(key);
			}
		}

	}

	static int checkPresence(int frequency) {
		if (frequencyMap.containsKey(frequency)) {
			return 1;
		} else {
			return 0;
		}
	}
}
