package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int smallBorder = leftBorder < rightBorder ? leftBorder : rightBorder;
        int bigBorder = rightBorder > leftBorder ? rightBorder : leftBorder;
        return IntStream.rangeClosed(smallBorder, bigBorder).filter(i -> i % 2 == 0).sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int smallBorder = leftBorder < rightBorder ? leftBorder : rightBorder;
        int bigBorder = rightBorder > leftBorder ? rightBorder : leftBorder;
        return IntStream.rangeClosed(smallBorder, bigBorder).filter(i -> i % 2 == 1).sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().mapToInt(i -> i * 3 + 2).sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(this::processTripleOfOddAndAddTwo).collect(Collectors.toList());
    }

    public int processTripleOfOddAndAddTwo(int i) {
        if (i % 2 == 0) {
            return i;
        }
        return i * 3 + 2;
    }


    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(i -> i % 2 == 1).mapToInt(i -> i * 3 + 5).sum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> evenList = arrayList.stream().filter(i -> i % 2 == 0).sorted().collect(Collectors.toList());
        if (evenList.size() % 2 == 0) {
            return (evenList.get(evenList.size() / 2 - 1) + evenList.get(evenList.size() / 2)) / 2.0;
        }
        return evenList.get(evenList.size() / 2);
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream().filter(i -> i % 2 == 0).mapToDouble(Integer::doubleValue).average().getAsDouble();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        List<Integer> evenList = arrayList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        return evenList.contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(i -> i % 2 == 0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evenList = arrayList.stream().filter(i -> i % 2 == 0).sorted().collect(Collectors.toList());
        List<Integer> oddList = arrayList.stream().filter(i -> i % 2 == 1).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        evenList.addAll(oddList);
        return evenList;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            result.add((arrayList.get(i) + arrayList.get(i + 1)) * 3);
        }
        return result;
    }
}
