import java.util.*;

class Solution {
    /*
     * 입력 문자열의 각 문자가 대문자인지 소문자인지 확인한다.
     * 대문자는 소문자로, 소문자는 대문자로 바꾸어 출력한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        StringBuilder answer = new StringBuilder();

        for (char ch : text.toCharArray()) {
            answer.append(Character.isUpperCase(ch)
                    ? Character.toLowerCase(ch)
                    : Character.toUpperCase(ch));
        }

        System.out.print(answer);
    }
}
