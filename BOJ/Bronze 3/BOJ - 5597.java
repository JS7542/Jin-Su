import java.io.*;

class Main {
    /*
     * 1번부터 30번 학생의 제출 여부를 boolean 배열에 기록한다.
     * 제출하지 않은 두 학생의 번호를 오름차순으로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] submitted = new boolean[31];

        for (int i = 0; i < 28; i++) {
            submitted[Integer.parseInt(br.readLine())] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 30; i++) {
            if (!submitted[i]) sb.append(i).append('\n');
        }
        System.out.print(sb);
    }
}
