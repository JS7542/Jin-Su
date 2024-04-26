import java.io.*;

class Main {
    /*
     * 한 번에 최대 5만큼 이동할 수 있다.
     * 전체 거리를 5로 올림 나눗셈해 최소 이동 횟수를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int distance = Integer.parseInt(br.readLine());

        System.out.print((distance + 4) / 5);
    }
}
