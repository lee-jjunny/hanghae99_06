package org.hanghae99.Day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_14495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = Integer.parseInt(br.readLine());
        long result = 1;

        if(idx > 3) {
            long[] numArr = new long[idx + 1];
            numArr[0] = numArr[1] = numArr[2] = numArr[3] = 1;

            for (int i = 4; i <= idx; i++) {
                numArr[i] = numArr[i - 1] + numArr[i - 3];
            }

            result = numArr[idx];
        }

        System.out.print(result);

        br.close();
    }
}
