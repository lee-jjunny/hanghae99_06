package org.hanghae99.Day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][][] dp;
    static final int INF = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M][3]; // 방향: 0=좌, 1=중앙, 2=우

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], INF);
            }
        }

        // 첫 줄 초기화
        for (int j = 0; j < M; j++) {
            if (j > 0) dp[0][j][0] = map[0][j]; // 왼쪽에서 오는 건 j-1
            dp[0][j][1] = map[0][j];             // 위에서 바로
            if (j < M - 1) dp[0][j][2] = map[0][j]; // 오른쪽에서 오는 건 j+1
        }

        // DP
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int d = 0; d < 3; d++) { // 현재 방향
                    int prevCol = j + (d - 1); // 이전 방향에 따라 열 위치

                    if (prevCol < 0 || prevCol >= M) continue;

                    for (int prevD = 0; prevD < 3; prevD++) {
                        if (prevD == d) continue; // 같은 방향 금지
                        dp[i][j][d] = Math.min(dp[i][j][d], dp[i - 1][prevCol][prevD] + map[i][j]);
                    }
                }
            }
        }

        // 최소값 찾기
        int answer = INF;
        for (int j = 0; j < M; j++) {
            for (int d = 0; d < 3; d++) {
                answer = Math.min(answer, dp[N - 1][j][d]);
            }
        }

        System.out.println(answer);
    }
}
