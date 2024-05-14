import java.io.*;
import java.util.*;

class Main {
    /*
     * P 과목을 제외하고 학점×과목평점을 누적한다.
     * 누적 전공평점을 총 학점으로 나누어 전공평균을 계산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> score = new HashMap<>();
        score.put("A+", 4.5); score.put("A0", 4.0);
        score.put("B+", 3.5); score.put("B0", 3.0);
        score.put("C+", 2.5); score.put("C0", 2.0);
        score.put("D+", 1.5); score.put("D0", 1.0);
        score.put("F", 0.0);

        double totalCredit = 0;
        double totalScore = 0;

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (!grade.equals("P")) {
                totalCredit += credit;
                totalScore += credit * score.get(grade);
            }
        }

        System.out.print(totalScore / totalCredit);
    }
}
