import java.io.*;

class Main {
    /*
     * 고정된 ISBN 앞부분의 1-3 합은 91이다.
     * 입력받은 세 숫자에 1, 3, 1 가중치를 적용해 합을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(br.readLine());
        int second = Integer.parseInt(br.readLine());
        int third = Integer.parseInt(br.readLine());

        int sum = 91 + first + second * 3 + third;
        System.out.print("The 1-3-sum is " + sum);
    }
}
