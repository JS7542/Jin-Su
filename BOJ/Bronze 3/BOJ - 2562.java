import java.io.*;

class Main {
    /*
     * 아홉 개의 수를 읽으며 가장 큰 값과 위치를 함께 저장한다.
     * 위치는 문제 기준에 맞춰 1부터 시작하는 번호로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 1; i <= 9; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value > max) {
                max = value;
                index = i;
            }
        }

        System.out.println(max);
        System.out.print(index);
    }
}
