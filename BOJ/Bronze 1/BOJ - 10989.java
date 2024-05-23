import java.io.*;

class Main {
    /*
     * 입력값 범위가 작으므로 각 숫자의 등장 횟수를 카운팅 배열에 저장한다.
     * 작은 숫자부터 빈도수만큼 반복 출력해 오름차순 결과를 만든다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] count = new int[10001];

        for (int i = 0; i < n; i++) count[Integer.parseInt(br.readLine())]++;

        StringBuilder sb = new StringBuilder();
        for (int value = 1; value <= 10000; value++) {
            while (count[value]-- > 0) sb.append(value).append('\n');
        }
        System.out.print(sb);
    }
}
