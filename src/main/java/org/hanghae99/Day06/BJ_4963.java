package org.hanghae99.Day06;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4963 {
    static int w, h;
    static int[][] seaMap;
    static boolean[][] visited;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}; // 8방향
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer whSt = new StringTokenizer(br.readLine());
            w = Integer.parseInt(whSt.nextToken());
            h = Integer.parseInt(whSt.nextToken());

            if (w == 0 && h == 0) break;

            seaMap = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    seaMap[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int islandCnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (seaMap[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        islandCnt++;
                    }
                }
            }

            System.out.println(islandCnt);
        }
    }

    static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowY = now[0];
            int nowX = now[1];

            for (int dir = 0; dir < 8; dir++) {
                int ny = nowY + dy[dir];
                int nx = nowX + dx[dir];

                if (ny >= 0 && ny < h && nx >= 0 && nx < w) {
                    if (seaMap[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}