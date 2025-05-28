import java.io.*;
import java.util.*;

class Main {
    /*
     * 결과 문자열을 단조 감소 스택처럼 사용한다.
     * 더 큰 숫자를 만나면 제거 가능 횟수 안에서 앞의 작은 숫자를 삭제한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken());
        int remove = Integer.parseInt(st.nextToken());
        String number = br.readLine();

        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char digit = number.charAt(i);

            while (remove > 0 && stack.length() > 0
                    && stack.charAt(stack.length() - 1) < digit) {
                stack.deleteCharAt(stack.length() - 1);
                remove--;
            }

            stack.append(digit);
        }

        if (remove > 0) {
            stack.setLength(stack.length() - remove);
        }

        System.out.print(stack);
    }
}
