import java.io.*;

class Main {
    /*
     * 연속한 같은 색을 하나의 그룹으로 보고 파란색·빨간색 그룹 수를 센다.
     * 전체를 그룹이 많은 색으로 한 번 칠한 뒤 적은 색 그룹만 덧칠하는 것이 최적이다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String colors = br.readLine();

        int blueGroups = 0;
        int redGroups = 0;

        for (int i = 0; i < colors.length(); i++) {
            if (i > 0 && colors.charAt(i) == colors.charAt(i - 1)) continue;

            if (colors.charAt(i) == 'B') blueGroups++;
            else redGroups++;
        }

        System.out.print(Math.min(blueGroups, redGroups) + 1);
    }
}
