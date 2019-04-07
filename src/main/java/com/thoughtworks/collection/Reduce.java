package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return this.arrayList.stream().reduce(Integer::max).get();
    }

    public int getMinimum() {
        return this.arrayList.stream().reduce(Integer::min).get();
    }

    public double getAverage() {
        return this.arrayList.stream().reduce((x, y) -> x + y).get() / new Double(this.arrayList.size());

    }

    public double getOrderedMedian() {
        List<Integer> orderArray = this.arrayList.stream().sorted().collect(Collectors.toList());
        if (this.arrayList.size() % 2 == 0) {
            return (orderArray.get(this.arrayList.size() / 2 - 1) + orderArray.get(this.arrayList.size() / 2)) / 2.0;
        }
        return orderArray.get(this.arrayList.size() / 2);
    }

    public int getFirstEven() {
        for (Integer i : arrayList) {
            if (i % 2 == 0) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    public int getIndexOfFirstEven() {
        for (int i = 0; i < this.arrayList.size(); i++) {
            if (this.arrayList.get(i) % 2 == 0) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    public boolean isEqual(List<Integer> arrayList) {
        if (this.arrayList.size() == arrayList.size()) {
            for (int i = 0; i < this.arrayList.size(); i++) {
                if (this.arrayList.get(i) != arrayList.get(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        int arraySize = this.arrayList.size();
        if (arraySize % 2 == 0) {
            return (this.arrayList.get(arraySize / 2 - 1) + (this.arrayList.get(arraySize / 2))) / 2.0;
        }
        return new Double(this.arrayList.get(arraySize / 2));
    }

    public int getLastOdd() {
        List<Integer> reversedArrayList = new ArrayList<>();
        reversedArrayList.addAll(this.arrayList);
        Collections.reverse(reversedArrayList);
        for (Integer i : reversedArrayList) {
            if (i % 2 == 1) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    public int getIndexOfLastOdd() {
        for (int i = this.arrayList.size() - 1; i >= 0; i++) {
            if (this.arrayList.get(i) % 2 == 1) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }
}
