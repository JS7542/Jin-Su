import java.io.*;

class Main {
    /*
     * 입력 크기를 4로 나눈 횟수만큼 long을 반복한다.
     * 마지막에 int를 붙여 요구된 자료형 문자열을 완성한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n / 4; i++) sb.append("long ");
        sb.append("int");
        System.out.print(sb);
    }
}
