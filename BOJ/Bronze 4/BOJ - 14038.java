import java.io.*;

class Main {
    /*
     * 여섯 경기 결과에서 W의 개수를 센다.
     * 승리 수에 따라 그룹 번호 1, 2, 3 또는 탈락 -1을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int wins = 0;

        for (int i = 0; i < 6; i++) {
            if (br.readLine().charAt(0) == 'W') wins++;
        }

        if (wins >= 5) System.out.print(1);
        else if (wins >= 3) System.out.print(2);
        else if (wins >= 1) System.out.print(3);
        else System.out.print(-1);
    }
}
