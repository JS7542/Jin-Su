import java.util.*;

class Solution {
    /*
     * 사람 인덱스를 키 순서에 따라 내림차순 정렬한다.
     * 정렬된 인덱스 순서대로 이름 배열을 구성한다.
     */
    public String[] sortPeople(String[] names, int[] heights) {
        Integer[] indices = new Integer[names.length];

        for (int i = 0; i < indices.length; i++) indices[i] = i;

        Arrays.sort(indices, (a, b) -> Integer.compare(heights[b], heights[a]));

        String[] answer = new String[names.length];

        for (int i = 0; i < indices.length; i++) answer[i] = names[indices[i]];

        return answer;
    }
}
