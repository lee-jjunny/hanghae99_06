package org.hanghae99.Day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class PR_161990 {
    public static void main(String[] args) throws IOException {
        String[] wallpaper1 = {".#...", "..#..", "...#."};
        String[] wallpaper2 = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
        String[] wallpaper3 = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        String[] wallpaper4 = {"..", "#."};
        int[] result1 = solution_improve(wallpaper1);
        int[] result2 = solution_improve(wallpaper2);
        int[] result3 = solution_improve(wallpaper3);
        int[] result4 = solution_improve(wallpaper4);

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));
        System.out.println(Arrays.toString(result4));
    }

    /* [2] 문제풀이 - 개선 */
    public static int[] solution_improve(String[] wallpaper) {
        int ss = Integer.MAX_VALUE, se = Integer.MAX_VALUE;
        int es = Integer.MIN_VALUE, ee = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++) {
            String row = wallpaper[i];
            for (int j = 0; j < row.length(); j++) {
                if (row.charAt(j) == '#') {
                    ss = Math.min(ss, i);
                    se = Math.min(se, j);
                    es = Math.max(es, i);
                    ee = Math.max(ee, j);
                }
            }
        }

        return new int[]{ss, se, es + 1, ee + 1};
    }

    /* [1] 문제풀이 */
    public static int[] solution(String[] wallpaper) {
        Integer ss = null, se = null;
        Integer es = null, ee = null;
        Integer[] endIdx = new Integer[2];

        for(int i = 0; i < wallpaper.length; i++) {
            String[] row = wallpaper[i].split("");
            for(int j = 0; j < row.length; j++) {
                if("#".equals(row[j])) {
                    if(ss == null || ss > i) {
                        ss = i;
                    }
                    if(se == null || se > j) {
                        se = j;
                    }
                    if(es == null || es < i) {
                        es = i;
                    }
                    if(ee == null || ee < j) {
                        ee = j;
                    }
                }
            }
        }

        int[] answer = {ss, se, es + 1, ee + 1};

        return answer;
    }
}
