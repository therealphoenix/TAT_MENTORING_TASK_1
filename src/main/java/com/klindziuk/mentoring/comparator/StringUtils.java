package com.klindziuk.mentoring.comparator;

import java.util.*;

/**
 * Created by Hp on 28/10/2017.
 */
public class StringUtils {
    private static final char[] VOVELS = {'a', 'e', 'i', 'o', 'u'};
    private static final char[] CONSONANTS = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};

    private StringUtils() {
    }

    public static Comparator<String> getCompByLength() {
        Comparator<String> comp = new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        };
        return comp;
    }

    public static Comparator<String> getCompByVovLength() {
        Comparator<String> comp = new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                return countingVowels(s1) - countingVowels(s2);
            }
        };
        return comp;
    }

    public static Comparator<String> getCompByConsLength() {
        Comparator<String> comp = new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                return countingConsonants(s1) - countingConsonants(s2);
            }
        };
        return comp;
    }

    public static int countingVowels(String s1) {
        String lowerCaseString = s1.toLowerCase();
        int vowelCount = 0;
        for (int i = 0; i < lowerCaseString.length(); ++i) {
            Character charCharacter = lowerCaseString.charAt(i);

            if (Arrays.binarySearch(VOVELS, charCharacter) >= 0) {
                vowelCount += 1;
            }
        }
        return vowelCount;
    }

    public static int countingConsonants(String s1) {
        String lowerCaseString = s1.toLowerCase();
        int vowelCount = 0;
        for (int i = 0; i < lowerCaseString.length(); ++i) {
            Character charCharacter = lowerCaseString.charAt(i);

            if (Arrays.binarySearch(CONSONANTS, charCharacter) >= 0) {
                vowelCount += 1;
            }
        }
        return vowelCount;
    }

    public static void changeLines(List<String> list) {
        for (int i = 1; i < list.size() - 1; i = i + 2) {
            list.set(i, changeFirstWithLast(list.get(i)));
        }
    }

    public static String changeFirstWithLast(String line) {
        char[] arr = line.toCharArray();
        char temp = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
        return String.valueOf(arr);
    }

    public static String findLineBySize(List<String> list, int rank) {
        if (rank <= 0) {
            throw new IllegalArgumentException("Rank should be greater than zero!");
        }
        Collections.sort(list, getCompByLength());
        return list.get(rank - 1);
    }

    public static List<String> revertLine(List<String> list) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String s1 = builder.append(list.get(i)).reverse().toString();
            builder.setLength(0);
            list.set(i, s1);
        }
        return list;
    }

}
