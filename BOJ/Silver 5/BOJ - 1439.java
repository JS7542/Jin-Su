import java.io.*;

class Main {
    /*
     * 문자열에서 0 그룹과 1 그룹의 시작 횟수를 각각 센다.
     * 더 적은 그룹을 뒤집는 것이 전체 문자를 같게 만드는 최소 횟수다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();

        int zeroGroups = text.charAt(0) == '0' ? 1 : 0;
        int oneGroups = text.charAt(0) == '1' ? 1 : 0;

        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) == text.charAt(i - 1)) continue;

            if (text.charAt(i) == '0') zeroGroups++;
            else oneGroups++;
        }

        System.out.print(Math.min(zeroGroups, oneGroups));
    }
}
