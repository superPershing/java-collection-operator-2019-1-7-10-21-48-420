package com.thoughtworks.collection;

import java.util.*;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int smallBorder = leftBorder < rightBorder ? leftBorder : rightBorder;
        int bigBorder = rightBorder > leftBorder ? rightBorder : leftBorder;
        int sumEvens = 0;
        for (int i = smallBorder; i <= bigBorder; i++) {
            if (i % 2 == 0) {
                sumEvens += i;
            }
        }
        return sumEvens;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int smallBorder = leftBorder < rightBorder ? leftBorder : rightBorder;
        int bigBorder = rightBorder > leftBorder ? rightBorder : leftBorder;
        int sumOdds = 0;
        for (int i = smallBorder; i <= bigBorder; i++) {
            if (i % 2 == 1) {
                sumOdds += i;
            }
        }
        return sumOdds;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().mapToInt(i -> i * 3 + 2).sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        for (Integer i : arrayList) {
            if (i % 2 == 0) {
                result.add(i);
            } else {
                result.add(i * 3 + 2);
            }
        }
        return result;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(i -> i % 2 == 1).mapToInt(i -> i * 3 + 5).sum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        double result;
        List<Integer> evenList = arrayList.stream().filter(i -> i % 2 == 0).sorted().collect(Collectors.toList());
        if (evenList.size() % 2 == 0) {
            result = (evenList.get(evenList.size() / 2 - 1) + evenList.get(evenList.size() / 2)) / 2.0;
        } else {
            result = evenList.get(evenList.size() / 2);
        }
        return result;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream().filter(i -> i % 2 == 0).mapToDouble(i -> i.doubleValue()).average().getAsDouble();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        List<Integer> evenList = arrayList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        if (evenList.contains(specialElment)) {
            return true;
        } else {
            return false;
        }
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List<Integer> evenList = arrayList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        return evenList.stream().distinct().collect(Collectors.toList());
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
