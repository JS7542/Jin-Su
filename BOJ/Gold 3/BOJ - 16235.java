import java.io.*;
import java.util.*;

class Main {
    /*
     * 각 칸의 나무 나이를 오름차순으로 유지하며 봄·여름을 처리한다.
     * 가을에는 나이가 5의 배수인 나무가 번식하고 겨울에는 양분을 추가한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int treeCount = Integer.parseInt(st.nextToken());
        int years = Integer.parseInt(st.nextToken());

        int[][] winter = new int[size][size];
        int[][] nutrients = new int[size][size];

        for (int[] row : nutrients) Arrays.fill(row, 5);

        for (int row = 0; row < size; row++) {
            st = new StringTokenizer(br.readLine());

            for (int col = 0; col < size; col++) {
                winter[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer>[][] trees = new ArrayList[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                trees[row][col] = new ArrayList<>();
            }
        }

        for (int i = 0; i < treeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());

            trees[row][col].add(age);
        }

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        while (years-- > 0) {
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    Collections.sort(trees[row][col]);

                    List<Integer> alive = new ArrayList<>();
                    int deadNutrients = 0;

                    for (int age : trees[row][col]) {
                        if (nutrients[row][col] >= age) {
                            nutrients[row][col] -= age;
                            alive.add(age + 1);
                        } else {
                            deadNutrients += age / 2;
                        }
                    }

                    nutrients[row][col] += deadNutrients;
                    trees[row][col] = alive;
                }
            }

            List<int[]> births = new ArrayList<>();

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    for (int age : trees[row][col]) {
                        if (age % 5 == 0) births.add(new int[]{row, col});
                    }
                }
            }

            for (int[] parent : births) {
                for (int direction = 0; direction < 8; direction++) {
                    int nr = parent[0] + dr[direction];
                    int nc = parent[1] + dc[direction];

                    if (nr < 0 || nr >= size || nc < 0 || nc >= size) continue;

                    trees[nr][nc].add(0, 1);
                }
            }

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    nutrients[row][col] += winter[row][col];
                }
            }
        }

        int answer = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                answer += trees[row][col].size();
            }
        }

        System.out.print(answer);
    }
}
