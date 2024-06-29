import java.io.*;

class Main {
    /*
     * 조리 시간이 10초 단위가 아니면 버튼으로 정확히 맞출 수 없다.
     * 300초, 60초, 10초 버튼을 큰 단위부터 사용한 횟수를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seconds = Integer.parseInt(br.readLine());

        if (seconds % 10 != 0) {
            System.out.print(-1);
            return;
        }

        int fiveMinutes = seconds / 300;
        seconds %= 300;
        int oneMinute = seconds / 60;
        seconds %= 60;
        int tenSeconds = seconds / 10;

        System.out.print(fiveMinutes + " " + oneMinute + " " + tenSeconds);
    }
}
