import java.util.*;

class Solution {
    /*
     * 문자열과 반복 횟수 n을 입력받는다.
     * 문자열을 n번 반복한 결과를 출력한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        int n = sc.nextInt();
        System.out.print(text.repeat(n));
    }
}
