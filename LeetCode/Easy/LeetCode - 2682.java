import java.util.*;

class Solution {
    /*
     * 현재 위치에서 전달 횟수×k만큼 원형으로 이동한다.
     * 이미 공을 받은 위치를 다시 만나면 종료하고 받지 못한 번호를 반환한다.
     */
    public int[] circularGameLosers(int n, int k) {
        boolean[] received = new boolean[n];
        int position = 0;
        int turn = 1;

        while (!received[position]) {
            received[position] = true;
            position = (position + turn * k) % n;
            turn++;
        }

        List<Integer> losers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!received[i]) losers.add(i + 1);
        }

        return losers.stream().mapToInt(Integer::intValue).toArray();
    }
}
