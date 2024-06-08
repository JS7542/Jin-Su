import java.util.*;

class Solution {
    /*
     * 각 명령의 i부터 j까지 배열 구간을 복사해 정렬한다.
     * 정렬된 구간의 k번째 값을 결과 배열에 저장한다.
     */
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int index = 0; index < commands.length; index++) {
            int[] command = commands[index];
            int[] part = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(part);
            answer[index] = part[command[2] - 1];
        }

        return answer;
    }
}
