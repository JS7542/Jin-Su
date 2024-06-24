import java.io.*;

class Main {
    /*
     * 시험 점수를 구간별로 나누어 A부터 F까지의 등급을 결정한다.
     * 높은 점수 조건부터 차례대로 비교해 하나의 등급을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = Integer.parseInt(br.readLine().trim());

        if (score >= 90) System.out.print("A");
        else if (score >= 80) System.out.print("B");
        else if (score >= 70) System.out.print("C");
        else if (score >= 60) System.out.print("D");
        else System.out.print("F");
    }
}
