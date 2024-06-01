import java.io.*;

class Main {
    /*
     * 문자열의 각 문자가 대문자인지 소문자인지 확인한다.
     * 대문자는 소문자로, 소문자는 대문자로 변환해 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (char ch : text.toCharArray()) {
            sb.append(Character.isUpperCase(ch)
                    ? Character.toLowerCase(ch)
                    : Character.toUpperCase(ch));
        }

        System.out.print(sb);
    }
}
