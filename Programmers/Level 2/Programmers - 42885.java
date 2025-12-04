import java.util.*;

class Solution {
    /*
     * 사람 몸무게를 정렬하고 가장 가벼운 사람과 가장 무거운 사람을 짝지어 본다.
     * 함께 탈 수 있으면 양쪽 포인터를 이동하고 아니면 무거운 사람만 태운다.
     */
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int light = 0;
        int heavy = people.length - 1;
        int boats = 0;

        while (light <= heavy) {
            if (people[light] + people[heavy] <= limit) light++;
            heavy--;
            boats++;
        }

        return boats;
    }
}
