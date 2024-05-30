import java.io.*;
import java.util.*;

class Main {
    /*
     * 세 정수를 배열에 저장하고 오름차순으로 정렬한다.
     * 정렬된 값을 공백으로 구분해 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[3];

        for (int i = 0; i < 3; i++) numbers[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(numbers);
        System.out.print(numbers[0] + " " + numbers[1] + " " + numbers[2]);
    }
}
