package org.hanghae99.Day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String bracket = br.readLine();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        for(int i=0; i<bracket.length(); i++) {
            char item = bracket.charAt(i);
            if('(' == item) {
                stack.push(item);
            } else if(')' == item){
                stack.pop();
                if('(' == bracket.charAt(i-1)) {
                    result += stack.size();
                } else {
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }
}