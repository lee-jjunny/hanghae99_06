package org.hanghae99.Day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public String solution(String s) {
        StringBuilder result = new StringBuilder();
        boolean isStartOfWord = true;

        for (char c : s.toCharArray()) {
            if (isStartOfWord) {
                result.append(Character.toUpperCase(c));
                isStartOfWord = false;
            } else {
                result.append(Character.toLowerCase(c));
            }

            if (c == ' ') {
                isStartOfWord = true;
            }
        }

        return result.toString();
    }

    // main 메서드에서 테스트
    public static void main(String[] args) {
        Main sol = new Main();
        String input = "3people unFollowed me";
        System.out.println(sol.solution(input));
    }
}