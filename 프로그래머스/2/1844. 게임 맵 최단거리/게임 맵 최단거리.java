import java.util.*;

class Solution {
     public int solution(int[][] maps) {
          int n = maps.length;
          int m = maps[0].length;
          boolean[][] visited = new boolean[n][m];
          int[] dx = {0, 0, 1, -1};
          int[] dy = {1, -1, 0, 0};

          Queue<int[]> queue = new LinkedList<>();
          queue.add(new int[]{0, 0, 1}); // x, y, 거리
          visited[0][0] = true;

          while (!queue.isEmpty()) {
              int[] cur = queue.poll();
              int x = cur[0], y = cur[1], dist = cur[2];

              if (x == n - 1 && y == m - 1) {
                  return dist;
              }

              for (int i = 0; i < 4; i++) {
                  int nx = x + dx[i];
                  int ny = y + dy[i];

                  if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                  if (visited[nx][ny] || maps[nx][ny] == 0) continue;

                  visited[nx][ny] = true;
                  queue.add(new int[]{nx, ny, dist + 1});
              }
          }

          return -1;
      }

}