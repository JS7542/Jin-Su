import java.io.*;
import java.util.*;

class Solution {
    static int size;
    static int length;
    static int capacity;
    static int[][] honey;

    /*
     * 각 가로 구간에서 용량 C 이하로 선택 가능한 벌통 부분집합의 최대 수익을 구한다.
     * 서로 겹치지 않는 두 구간 조합의 수익 합 중 최댓값을 계산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            length = Integer.parseInt(st.nextToken());
            capacity = Integer.parseInt(st.nextToken());

            honey = new int[size][size];

            for (int row = 0; row < size; row++) {
                st = new StringTokenizer(br.readLine());

                for (int col = 0; col < size; col++) {
                    honey[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] profit = new int[size][size - length + 1];

            for (int row = 0; row < size; row++) {
                for (int col = 0; col + length <= size; col++) {
                    profit[row][col] = bestSubset(row, col, 0, 0, 0);
                }
            }

            int answer = 0;

            for (int firstRow = 0; firstRow < size; firstRow++) {
                for (int firstCol = 0; firstCol + length <= size; firstCol++) {
                    for (int secondRow = firstRow; secondRow < size; secondRow++) {
                        for (int secondCol = 0; secondCol + length <= size; secondCol++) {
                            if (firstRow == secondRow
                                    && secondCol < firstCol + length) continue;

                            answer = Math.max(
                                    answer,
                                    profit[firstRow][firstCol] + profit[secondRow][secondCol]
                            );
                        }
                    }
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }

    static int bestSubset(
            int row,
            int startCol,
            int index,
            int amount,
            int profit
    ) {
        if (amount > capacity) return 0;
        if (index == length) return profit;

        int value = honey[row][startCol + index];

        return Math.max(
                bestSubset(row, startCol, index + 1, amount, profit),
                bestSubset(
                        row,
                        startCol,
                        index + 1,
                        amount + value,
                        profit + value * value
                )
        );
    }
}
