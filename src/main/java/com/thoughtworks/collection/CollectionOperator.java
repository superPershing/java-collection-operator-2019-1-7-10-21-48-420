package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        if (left <= right) {
            return IntStream.rangeClosed(left, right).boxed().collect(Collectors.toList());
        } else {
            return IntStream.rangeClosed(right, left).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        }
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        if (left <= right) {
            return IntStream.rangeClosed(left, right).boxed().filter(i -> i % 2 == 0).collect(Collectors.toList());
        } else {
            return IntStream.rangeClosed(right, left).boxed().filter(i -> i % 2 == 0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        }
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).boxed().filter(i -> i % 2 == 0).collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> firstArrayList = Arrays.stream(firstArray).boxed().collect(Collectors.toList());
        List<Integer> secondArrayList = Arrays.stream(secondArray).boxed().collect(Collectors.toList());
        firstArrayList.retainAll(secondArrayList);
        return firstArrayList;

    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstArrayList = Arrays.stream(firstArray).collect(Collectors.toList());
        List<Integer> temp = Arrays.stream(secondArray).collect(Collectors.toList());
        temp.removeAll(firstArrayList);
        firstArrayList.addAll(temp);
        return firstArrayList;
    }
}
