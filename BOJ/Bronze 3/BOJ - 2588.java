import java.io.*;

class Main {
    /*
     * 두 번째 수의 일의 자리부터 각 자리와 첫 번째 수를 곱한다.
     * 부분 곱 세 개와 전체 곱을 문제에서 요구한 순서대로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine().trim());
        int b = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        sb.append(a * (b % 10)).append('\n');
        sb.append(a * ((b / 10) % 10)).append('\n');
        sb.append(a * (b / 100)).append('\n');
        sb.append(a * b);
        System.out.print(sb);
    }
}
