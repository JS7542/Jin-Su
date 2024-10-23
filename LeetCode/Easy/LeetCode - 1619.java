import java.util.*;

class Solution {
    /*
     * 배열을 정렬하고 양쪽에서 5%씩 제거한 구간만 합산한다.
     * 남은 원소 개수로 나누어 평균을 반환한다.
     */
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int remove = arr.length / 20;
        double sum = 0;

        for (int i = remove; i < arr.length - remove; i++) sum += arr[i];
        return sum / (arr.length - remove * 2);
    }
}
