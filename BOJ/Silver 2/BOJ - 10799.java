import java.io.*;

class Main {
    /*
     * 여는 괄호 수를 현재 겹친 막대 수로 관리한다.
     * 레이저는 현재 막대 수만큼 조각을 만들고, 막대 끝은 조각 하나를 추가한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sequence = br.readLine();

        int open = 0;
        int pieces = 0;

        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == '(') {
                open++;
            } else {
                open--;

                if (sequence.charAt(i - 1) == '(') pieces += open;
                else pieces++;
            }
        }

        System.out.print(pieces);
    }
}
