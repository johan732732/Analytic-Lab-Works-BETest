/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author Sistemas
 */
public class Regex {

    /**
     * 1 We can to use arrays (vector, list...) for storing and filter by
     * patterns o a set of strings In this case, I will use a ArrayList to store
     * every regex element java
     */
    private final List<String> regexList = new ArrayList<>();
    private final String regex;

    public Regex(String regex) {

        this.regex = regex;
        /**
         * Split the regex
         */
        String[] parts = regex.split("");

        /**
         * Reads every regex element and store it in the arrayList
         */
        this.regexList.addAll(Arrays.asList(parts));

    }

    public Regex() {
        this.regex = null;
    }

    /**
     * Filters the regex by a parameter
     *
     * @param f
     */
    public void filter(String f) {
        regexList.stream().map(String::toLowerCase).filter(x -> x.startsWith(f)).forEach(x -> System.out.println(x));
    }

    /**
     * Orders the regex's elements
     */
    public void order() {
        regexList.stream().sorted().forEach(System.out::println);
    }

    /**
     * Count the elements on the list
     */
    public void count() {
        long x = regexList.stream().count();
        System.out.println(x);
    }

    /**
     * Show a number records
     *
     * @param l limit
     */
    public void limit(int l) {
        regexList.stream().limit(l).forEach(System.out::println);
    }

    /**
     * Show the letters count less than two
     */
    public void countLetters() {
        Map<String, Long> frecuency = regexList.stream()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        frecuency.entrySet().removeIf(entry -> (entry.getValue() < 2));

        System.out.println("String:" + regex);
        System.out.println(frecuency);
    }

    private void pointOne() {
        System.out.println("------------- POINT 1 ---------------------------");
        Regex reg = new Regex("aaabbccaa");

        reg.filter("c");
        reg.order();
        reg.count();
        reg.limit(2);
    }

    private void pointTwo() {
        System.out.println("------------- POINT 2 ---------------------------");

        Regex reg1 = new Regex("abcde");
        reg1.countLetters();

        Regex reg2 = new Regex("aabbcde");
        reg2.countLetters();

        Regex reg3 = new Regex("aabBcde");
        reg3.countLetters();

        Regex reg4 = new Regex("indivisibility");
        reg4.countLetters();

        Regex reg5 = new Regex("Indivisibilities");
        reg5.countLetters();

        Regex reg6 = new Regex("aA11");
        reg6.countLetters();

        Regex reg7 = new Regex("ABBA");
        reg7.countLetters();
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Regex r = new Regex();
        r.pointOne();
        r.pointTwo();

    }

}
