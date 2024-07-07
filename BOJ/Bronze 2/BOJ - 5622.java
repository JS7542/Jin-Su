import java.io.*;

class Main {
    /*
     * 각 알파벳이 속한 전화 다이얼 번호를 계산한다.
     * 번호마다 걸리는 시간인 번호+1을 전체 문자에 대해 누적한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String[] groups = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

        int time = 0;
        for (char ch : text.toCharArray()) {
            for (int i = 0; i < groups.length; i++) {
                if (groups[i].indexOf(ch) >= 0) {
                    time += i + 3;
                    break;
                }
            }
        }

        System.out.print(time);
    }
}
