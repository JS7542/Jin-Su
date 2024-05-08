import java.io.*;
import java.util.*;

class Main {
    /*
     * 숫자를 문자 배열로 바꾸고 오름차순으로 정렬한다.
     * 배열을 뒤에서부터 읽으면 각 자리수가 내림차순으로 배치된다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] digits = br.readLine().toCharArray();
        Arrays.sort(digits);

        StringBuilder sb = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) sb.append(digits[i]);
        System.out.print(sb);
    }
}
