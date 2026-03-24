import java.io.*;
import java.util.*;

class Main {
    /*
     * 학생마다 좋아하는 학생 수, 빈칸 수, 행, 열 우선순위로 자리를 선택한다.
     * 모든 배치가 끝나면 인접한 좋아하는 학생 수에 따른 만족도를 합산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int students = size * size;

        int[][] favorites = new int[students + 1][4];
        int[] order = new int[students];

        for (int i = 0; i < students; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            order[i] = student;

            for (int j = 0; j < 4; j++) {
                favorites[student][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] classroom = new int[size][size];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int student : order) {
            int bestRow = -1;
            int bestCol = -1;
            int bestFavorite = -1;
            int bestEmpty = -1;

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    if (classroom[row][col] != 0) continue;

                    int favoriteCount = 0;
                    int emptyCount = 0;

                    for (int direction = 0; direction < 4; direction++) {
                        int nr = row + dr[direction];
                        int nc = col + dc[direction];

                        if (nr < 0 || nr >= size || nc < 0 || nc >= size) continue;

                        if (classroom[nr][nc] == 0) {
                            emptyCount++;
                        } else if (contains(
                                favorites[student],
                                classroom[nr][nc]
                        )) {
                            favoriteCount++;
                        }
                    }

                    if (favoriteCount > bestFavorite
                            || (favoriteCount == bestFavorite
                            && emptyCount > bestEmpty)) {
                        bestFavorite = favoriteCount;
                        bestEmpty = emptyCount;
                        bestRow = row;
                        bestCol = col;
                    }
                }
            }

            classroom[bestRow][bestCol] = student;
        }

        int[] score = {0, 1, 10, 100, 1000};
        int answer = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int student = classroom[row][col];
                int favoriteCount = 0;

                for (int direction = 0; direction < 4; direction++) {
                    int nr = row + dr[direction];
                    int nc = col + dc[direction];

                    if (nr < 0 || nr >= size || nc < 0 || nc >= size) continue;

                    if (contains(favorites[student], classroom[nr][nc])) {
                        favoriteCount++;
                    }
                }

                answer += score[favoriteCount];
            }
        }

        System.out.print(answer);
    }

    static boolean contains(int[] values, int target) {
        for (int value : values) {
            if (value == target) return true;
        }

        return false;
    }
}
