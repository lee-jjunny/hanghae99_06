package org.hanghae99.Day11;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 조카
        int N = Integer.parseInt(st.nextToken()); // 과자

        int[] snack = new int[N];
        st = new StringTokenizer(br.readLine());
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
            maxLen = Math.max(maxLen, snack[i]);
        }

        int left = 1, right = maxLen;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long count = 0;

            for (int i = 0; i < N; i++) {
                count += snack[i] / mid;
            }

            if (count >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}