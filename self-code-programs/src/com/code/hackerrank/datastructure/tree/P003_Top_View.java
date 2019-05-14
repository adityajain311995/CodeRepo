package com.code.hackerrank.datastructure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class P003_Top_View {

	public static void main(String[] args) {
		topView(null);
	}

	
	public static void topView(Node root) {

		if (root == null) {
			return;
		}
		
		class MyMap<K, V> {

			private Map<K, List<V>> map = null;

			public MyMap() {
				map = new HashMap<K, List<V>>();
			}

			public V put(K key, V value) {
				if (map.containsKey(key)) {
					map.get(key).add(value);
				} else {
					List<V> list = new ArrayList<>();
					list.add(value);
					map.put(key, list);
				}

				return value;
			}

			public List<V> get(K key) {
				return map.get(key);
			}

			public Map<K, List<V>> getMap() {
				return map;
			}

		}
		
		MyMap<Integer, Node> hashTable = new MyMap<>();
		hashTable.put(0, root);
		
		Map<Node, Integer> distMap = new HashMap<>();
		distMap.put(root, 0);
		
		Queue<Node> que = new LinkedList<>();
		que.add(root);

		while (!que.isEmpty()) {
			Node current = que.remove();

			if (current.left != null) {
				int distLeft = distMap.get(current) - 1;
				hashTable.put(distLeft, current.left);
				distMap.put(current.left, distLeft);
				que.add(current.left);
			}
			if (current.right != null) {
				int distRight = distMap.get(current) + 1;
				hashTable.put(distRight, current.right);
				distMap.put(current.right, distRight);
				que.add(current.right);
			}
		}
		
		List<Integer> distList = new ArrayList<>(hashTable.getMap().keySet());
		Collections.sort(distList);

		for(Integer dist : distList) {
			System.out.print(hashTable.get(dist).get(0).data + " ");
		}
		
	}
	
}


