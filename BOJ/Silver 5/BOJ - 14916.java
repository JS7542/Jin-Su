import java.io.*;

class Main {
    /*
     * 5원 동전을 가능한 많이 사용하되 남은 금액이 2원으로 나누어질 때까지 줄인다.
     * 가능한 조합을 찾으면 동전 수를, 끝까지 찾지 못하면 -1을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());

        for (int five = money / 5; five >= 0; five--) {
            int remaining = money - five * 5;

            if (remaining % 2 == 0) {
                System.out.print(five + remaining / 2);
                return;
            }
        }

        System.out.print(-1);
    }
}
