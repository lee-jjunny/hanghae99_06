package org.hanghae99.Day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        String[] pattern = br.readLine().split("\\*");
        String start = pattern[0];
        String end = pattern[1];
        for(int i=0; i<len; i++) {
            String fileName = br.readLine();

            if (fileName.length() < start.length() + end.length()) {
                System.out.println("NE");
            } else if (fileName.startsWith(start) && fileName.endsWith(end)) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}