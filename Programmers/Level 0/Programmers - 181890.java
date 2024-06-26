import java.util.*;

class Solution {
    /*
     * 배열에서 처음 등장하는 l 또는 r의 위치를 찾는다.
     * l이면 왼쪽 구간, r이면 오른쪽 구간을 반환하고 없으면 빈 배열을 반환한다.
     */
    public String[] solution(String[] str_list) {
        for (int i = 0; i < str_list.length; i++) {
            if (str_list[i].equals("l")) return Arrays.copyOfRange(str_list, 0, i);
            if (str_list[i].equals("r")) return Arrays.copyOfRange(str_list, i + 1, str_list.length);
        }

        return new String[0];
    }
}
