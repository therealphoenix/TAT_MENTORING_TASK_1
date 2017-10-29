package com.klindziuk.mentoring.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Hp on 28/10/2017.
 */
public class Runner {
    public static void main(String[] args) {

        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("String number one");
        listOfStrings.add("Second string");
        listOfStrings.add("Woah! Third string is coming");
        listOfStrings.add("Just fourth String");
        listOfStrings.add("Last String.String number five");

        Collections.sort(listOfStrings, StringUtils.getCompByLength());
        System.out.println(listOfStrings);
        Collections.sort(listOfStrings, StringUtils.getCompByVovLength());
        System.out.println(listOfStrings);
        Collections.sort(listOfStrings, StringUtils.getCompByConsLength());
        System.out.println(listOfStrings);
        StringUtils.changeLines(listOfStrings);
        System.out.println(listOfStrings);
        System.out.println(StringUtils.findLineBySize(listOfStrings, 2));
        StringUtils.revertLine(listOfStrings);
        System.out.println(listOfStrings);
    }
}
