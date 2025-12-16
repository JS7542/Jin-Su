import java.io.*;
import java.util.*;

class Main {
    /*
     * A+B와 C+D의 모든 합을 각각 배열에 저장하고 정렬한다.
     * 두 배열의 양 끝 포인터를 움직이며 합이 0인 중복 조합 수를 한 번에 센다.
     */
    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
            c[i] = scanner.nextInt();
            d[i] = scanner.nextInt();
        }

        int size = n * n;
        long[] first = new long[size];
        long[] second = new long[size];

        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                first[index] = (long) a[i] + b[j];
                second[index] = (long) c[i] + d[j];
                index++;
            }
        }

        Arrays.sort(first);
        Arrays.sort(second);

        int left = 0;
        int right = size - 1;
        long answer = 0;

        while (left < size && right >= 0) {
            long sum = first[left] + second[right];

            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                long firstValue = first[left];
                long secondValue = second[right];
                long firstCount = 0;
                long secondCount = 0;

                while (left < size && first[left] == firstValue) {
                    firstCount++;
                    left++;
                }

                while (right >= 0 && second[right] == secondValue) {
                    secondCount++;
                    right--;
                }

                answer += firstCount * secondCount;
            }
        }

        System.out.print(answer);
    }

    private static class FastScanner {
        private final InputStream input;
        private final byte[] buffer = new byte[1 << 16];
        private int pointer;
        private int length;

        FastScanner(InputStream input) {
            this.input = input;
        }

        int nextInt() throws IOException {
            int character;

            do {
                character = read();
            } while (character <= ' ');

            int sign = 1;

            if (character == '-') {
                sign = -1;
                character = read();
            }

            int value = 0;

            while (character > ' ') {
                value = value * 10 + character - '0';
                character = read();
            }

            return value * sign;
        }

        private int read() throws IOException {
            if (pointer >= length) {
                length = input.read(buffer);
                pointer = 0;

                if (length <= 0) return -1;
            }

            return buffer[pointer++];
        }
    }
}
