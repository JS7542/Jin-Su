import java.io.*;
import java.util.*;

class Main {
    /*
     * 여자 2명과 남자 1명으로 만들 수 있는 최대 팀 수를 먼저 계산한다.
     * 인턴 인원을 제외하고도 남은 인원이 팀 구성을 만족할 때까지 팀 수를 줄인다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int women = Integer.parseInt(st.nextToken());
        int men = Integer.parseInt(st.nextToken());
        int interns = Integer.parseInt(st.nextToken());

        int teams = Math.min(women / 2, men);

        while (teams > 0 && women + men - teams * 3 < interns) teams--;

        System.out.print(teams);
    }
}
