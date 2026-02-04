import java.io.*;
import java.util.*;

class Main {
    /*
     * 벨트 내구도 배열과 위쪽 N칸의 로봇 존재 여부를 함께 회전한다.
     * 로봇 이동과 새 로봇 올리기를 반복해 내구도 0인 칸이 K개 이상 되는 단계를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        int[] durability = new int[n * 2];
        boolean[] robot = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for (int index = 0; index < durability.length; index++) {
            durability[index] = Integer.parseInt(st.nextToken());
        }

        int step = 0;

        while (zeroCount(durability) < limit) {
            step++;

            rotate(durability);
            rotate(robot);
            robot[n - 1] = false;

            for (int index = n - 2; index >= 0; index--) {
                if (!robot[index] || robot[index + 1]
                        || durability[index + 1] == 0) continue;

                robot[index] = false;
                robot[index + 1] = true;
                durability[index + 1]--;
            }

            robot[n - 1] = false;

            if (durability[0] > 0) {
                robot[0] = true;
                durability[0]--;
            }
        }

        System.out.print(step);
    }

    static void rotate(int[] array) {
        int last = array[array.length - 1];

        for (int index = array.length - 1; index > 0; index--) {
            array[index] = array[index - 1];
        }

        array[0] = last;
    }

    static void rotate(boolean[] array) {
        for (int index = array.length - 1; index > 0; index--) {
            array[index] = array[index - 1];
        }

        array[0] = false;
    }

    static int zeroCount(int[] durability) {
        int count = 0;

        for (int value : durability) {
            if (value == 0) count++;
        }

        return count;
    }
}
