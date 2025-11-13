import java.util.*;

class Solution {
    /*
     * 차량 경로를 진출 지점 오름차순으로 정렬한다.
     * 현재 카메라를 지나지 않는 차량을 만날 때 그 차량의 진출 지점에 새 카메라를 둔다.
     */
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(route -> route[1]));

        int cameras = 0;
        int position = Integer.MIN_VALUE;

        for (int[] route : routes) {
            if (route[0] > position) {
                cameras++;
                position = route[1];
            }
        }

        return cameras;
    }
}
