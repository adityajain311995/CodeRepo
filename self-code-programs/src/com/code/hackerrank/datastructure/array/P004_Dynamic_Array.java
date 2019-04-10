package com.code.hackerrank.datastructure.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.joining;


/**
 * https://www.hackerrank.com/challenges/dynamic-array/problem
 * 
 * @author adijain4
 *
 */
public class P004_Dynamic_Array {
	
	public static void main1(String[] args) throws IOException {
		int N = 2;
		List<List<Integer>> queries = new ArrayList<>();
		queries.add(Arrays.asList(1,0,5));
		queries.add(Arrays.asList(1,1,7));
		queries.add(Arrays.asList(1,0,3));
		queries.add(Arrays.asList(2,1,0));
		queries.add(Arrays.asList(2,1,1));
		
		System.out.println(dynamicArray(N, queries));
	}

	// Complete the dynamicArray function below.
    static List<Integer> dynamicArray(int N, List<List<Integer>> queries) {
    	DynamicArray2[] seqList = new DynamicArray2[N];
    	for(int i=0; i<N; i++) {
    		seqList[i] = new DynamicArray2();
    	}
    	int lastAnswer = 0;
    	List<Integer> result = new ArrayList<>();
    	for(List<Integer> query : queries) {
    		int qType = query.get(0);
    		int x = query.get(1);
			int y = query.get(2);
			int seq = ((x^lastAnswer)%N);
    		if(qType == 1) {
    			seqList[seq].add(y);
    		}else {
    			int size = seqList[seq].size();
    			int elementIndex = y%size;
    			lastAnswer = (int) seqList[seq].get(elementIndex);
    			result.add(lastAnswer);
    		}
    	}
    	return result;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nq = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nq[0]);
        int q = Integer.parseInt(nq[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        List<Integer> result = dynamicArray(n, queries);
        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );
        bufferedReader.close();
        bufferedWriter.close();
    }
	
}

class DynamicArray2<T> {

	private Object[] data;
	private int size;
	
	public DynamicArray2() {
		data = new Object[10];
		size = 0;
	}
	
	public DynamicArray2(int length) {
		data = new Object[length];
		size = 0;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int index) {
		return (T)data[index];
	}
	
	public int size() {
		return size;
	}
	
	public void add(T item) {
		if(size == data.length) {
			resizeArray();
		}
		data[size] = item;
		size = size + 1;
	}
	
	private void resizeArray() {
		Object[] bigger = new Object[2*size];
		for(int i=0; i<size; i++) {
			bigger[i] = data[i];
		}
		data = bigger;
	}
	
}