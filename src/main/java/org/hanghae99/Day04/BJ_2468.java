package org.hanghae99.Day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2468 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 탐색 영역의 가로/세로 길이
        int[][] area = new int[N][N]; // 지역 높이
        boolean[][] visited; // 지역 방문 여부

        int maxRainLv = 0; // 가장 높은 지역의 높이(가장 낮은 강수량~가장높은 강수량 탐색을 위함)
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                maxRainLv = Math.max(maxRainLv, area[i][j]);
            }
        }
        br.close();

        int result = 0;
        // 비 오는 높이 탐색
        for(int rain=0; rain<maxRainLv; rain++) {
            visited = new boolean[N][N];
            int safeZone = 0;

            // 지도 탐색
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    // 방문한적 없고, 잠기지 않음 -> 안전지대 대상. 이 지점을 기준으로 BFS 탐색해보자
                    if(!visited[i][j] && area[i][j] > rain) {
                        // bfs 탐색(주변 영역을 탐색 해서 한 뭉치임을 표시)
                        bfs(i, j, rain, area, visited, N);

                        // 안전 영역 갯수 증가
                        safeZone++;
                    }
                }
            }

            // 가장 많은 안전 영역의 갯수를 반환해야 하므로, 강수량별 안전 영역 최댓값 비교
            result = Math.max(result, safeZone);
        }

        System.out.print(result);
    }

    static void bfs(int x, int y, int rain, int[][] area, boolean[][] visited, int N) {
        // 상하좌우 방향 정의
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 상하좌우 탐색 후 추가적으로 탐색해야할 좌표들을 넣기 위함
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true; // 시작 지점 방문 처리

        // 더 이상 탐색할 좌표가 없을때까지(=큐에 대상이 없을 때)
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            int cx = coordinate[0];
            int cy = coordinate[1];

            // 상하좌우 탐색
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                // 지도 범위 안에 있는지 확인
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    // 아직 방문한적 없는 좌표이면서 강수량보다 높은 지대
                    if (!visited[nx][ny] && area[nx][ny] > rain) {
                        visited[nx][ny] = true;
                        // 해당 안전지대를 기준으로 탐색하기 위해 다시 queue에 좌표를 넣음
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
