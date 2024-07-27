import java.util.*;

class Solution {
    /*
     * 문자열에서 숫자인 문자만 골라 정수 배열에 저장한다.
     * 배열을 오름차순으로 정렬해 반환한다.
     */
    public int[] solution(String my_string) {
        int[] answer = my_string.chars()
                .filter(Character::isDigit)
                .map(ch -> ch - '0')
                .toArray();
        Arrays.sort(answer);
        return answer;
    }
}
