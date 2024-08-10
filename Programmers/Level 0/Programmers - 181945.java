import java.util.*;

class Solution {
    /*
     * 문자열 한 개를 입력받는다.
     * 문자열의 각 문자를 처음부터 한 줄에 하나씩 출력한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();

        for (char ch : text.toCharArray()) System.out.println(ch);
    }
}
