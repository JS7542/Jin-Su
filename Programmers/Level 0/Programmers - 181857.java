import java.util.*;

class Solution {
    /*
     * 원본 길이 이상인 가장 작은 2의 거듭제곱 길이를 찾는다.
     * Arrays.copyOf로 늘어난 위치가 0인 새 배열을 만든다.
     */
    public int[] solution(int[] arr) {
        int length = 1;
        while (length < arr.length) length *= 2;
        return Arrays.copyOf(arr, length);
    }
}
