package com.capgemini.controller;

public class Oefening {

    public static String reverse(final String input) {

        final StringBuilder result = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            result.append(input.charAt(i));
        }
        return result.toString();

    }

}
