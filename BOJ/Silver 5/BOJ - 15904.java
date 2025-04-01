import java.io.*;

class Main {
    /*
     * 입력 문자열에서 U, C, P, C가 순서대로 등장하는지 확인한다.
     * 목표 문자와 같은 문자를 만날 때마다 다음 문자로 진행한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String target = "UCPC";
        int index = 0;

        for (char ch : text.toCharArray()) {
            if (index < target.length() && ch == target.charAt(index)) index++;
        }

        System.out.print(index == target.length() ? "I love UCPC" : "I hate UCPC");
    }
}
