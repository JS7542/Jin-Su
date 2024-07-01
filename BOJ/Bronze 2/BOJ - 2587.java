import java.io.*;
import java.util.*;

class Main {
    /*
     * 다섯 수의 합을 구하고 배열을 오름차순으로 정렬한다.
     * 평균은 합/5, 중앙값은 정렬된 배열의 가운데 값이다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[5];
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            sum += numbers[i];
        }

        Arrays.sort(numbers);
        System.out.println(sum / 5);
        System.out.print(numbers[2]);
    }
}
