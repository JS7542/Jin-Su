import java.io.*;

class Main {
    /*
     * 학점의 첫 문자로 기본 점수를 정한다.
     * 뒤의 +, 0, - 기호에 따라 0.3을 더하거나 뺀다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String grade = br.readLine();

        if (grade.equals("F")) {
            System.out.print("0.0");
            return;
        }

        double score = 4 - (grade.charAt(0) - 'A');

        if (grade.charAt(1) == '+') score += 0.3;
        else if (grade.charAt(1) == '-') score -= 0.3;

        System.out.printf("%.1f", score);
    }
}
