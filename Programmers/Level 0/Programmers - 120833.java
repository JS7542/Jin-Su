import java.util.*;

class Solution {
    /*
     * num1부터 num2까지의 범위를 끝 인덱스가 제외되는 copyOfRange로 복사한다.
     * num2 위치까지 포함하기 위해 종료 위치에 1을 더한다.
     */
    public int[] solution(int[] numbers, int num1, int num2) {
        return Arrays.copyOfRange(numbers, num1, num2 + 1);
    }
}
