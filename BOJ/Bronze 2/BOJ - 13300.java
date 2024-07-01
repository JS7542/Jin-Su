import java.io.*;
import java.util.*;

class Main {
    /*
     * 성별과 학년별 학생 수를 이차원 배열에 센다.
     * 각 그룹 인원을 방 정원 K로 올림 나눗셈해 필요한 방 수를 합산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int capacity = Integer.parseInt(st.nextToken());
        int[][] count = new int[2][7];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            count[gender][grade]++;
        }

        int rooms = 0;

        for (int gender = 0; gender < 2; gender++) {
            for (int grade = 1; grade <= 6; grade++) {
                rooms += (count[gender][grade] + capacity - 1) / capacity;
            }
        }

        System.out.print(rooms);
    }
}
