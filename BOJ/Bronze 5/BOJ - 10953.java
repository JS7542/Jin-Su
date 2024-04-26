import java.io.*;

class Main {
    /*
     * 각 줄의 두 정수는 쉼표로 구분되어 있다.
     * 두 문자를 정수로 변환해 합을 테스트 케이스마다 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String[] values = br.readLine().split(",");
            sb.append(Integer.parseInt(values[0]) + Integer.parseInt(values[1])).append('\n');
        }

        System.out.print(sb);
    }
}
