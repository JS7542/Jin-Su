import java.io.*;

class Main {
    /*
     * 다섯 학생의 점수가 40보다 작으면 40점으로 보정한다.
     * 보정한 점수 합을 5로 나눈 평균을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            sum += Math.max(40, Integer.parseInt(br.readLine()));
        }

        System.out.print(sum / 5);
    }
}
