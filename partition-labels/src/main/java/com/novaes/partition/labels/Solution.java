/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.partition.labels;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author andre
 */
public class Solution {

    public List<Integer> partition(String string) {
        String lista = "";
        char[] array = string.toCharArray();
        lista += toString(array[0]) + "#";
        for (int i = 1; i < array.length; i++) {
            if (lista.contains(toString(array[i]))) {
                lista = lista.substring(0, lista.indexOf(toString(array[i])))
                        + lista.substring(lista.indexOf(toString(array[i])), lista.length()).replaceAll("#", "")
                        + toString(array[i]) + "#";
            } else {
                lista += toString(array[i]) + "#";
            }
        }
        return Arrays.asList(lista.split("#")).stream().map(s -> s.length()).collect(Collectors.toList());
    }

    private static String toString(char c) {
        return new String(new char[]{c});
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partition("abcdefpqrsptxyzzx"));
    }

}