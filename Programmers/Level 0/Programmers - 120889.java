import java.util.*;
class Solution {
    /*
     * 세 변을 정렬해 가장 긴 변과 나머지 두 변의 합을 비교한다.
     * 삼각형 조건을 만족하면 1, 아니면 2를 반환한다.
     */
    public int solution(int[] sides){Arrays.sort(sides);return sides[0]+sides[1]>sides[2]?1:2;}
}
