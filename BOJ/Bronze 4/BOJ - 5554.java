import java.io.*;

class Main {
    /*
     * 네 구간에서 걸린 시간을 초 단위로 모두 합산한다.
     * 전체 시간을 분과 초로 나누어 한 줄씩 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = 0;

        for (int i = 0; i < 4; i++) total += Integer.parseInt(br.readLine());

        System.out.println(total / 60);
        System.out.print(total % 60);
    }
}
