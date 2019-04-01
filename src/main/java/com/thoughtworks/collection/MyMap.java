package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return this.array.stream().map(i -> i * 3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return this.array.stream().map(i -> Character.toString((char) (i.intValue() + 96))).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        return this.array.stream().map(i -> this.transferStringToChars(i, this.letterList)).collect(Collectors.toList());
    }

    public static String transferStringToChars(Integer num, List<String> letterList) {
        StringBuilder sb = new StringBuilder();
        int firstCharIndex = (num - 1) / 26;
        int secondCharIndex = (num - 1) % 26;
        if (firstCharIndex == 0) {
            sb.append(letterList.get(secondCharIndex));
        } else {
            sb.append(letterList.get(firstCharIndex - 1));
            sb.append(letterList.get(secondCharIndex));
        }
        return sb.toString();
    }

    public List<Integer> sortFromBig() {
        return this.array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return this.array.stream().sorted().collect(Collectors.toList());
    }
}
