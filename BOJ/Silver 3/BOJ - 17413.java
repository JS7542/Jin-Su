import java.io.*;

class Main {
    /*
     * 태그 안의 문자는 그대로 출력하고 태그 밖의 단어만 뒤집는다.
     * 공백이나 태그 시작을 만나면 쌓아둔 단어를 먼저 뒤집어 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();

        StringBuilder answer = new StringBuilder();
        StringBuilder word = new StringBuilder();
        boolean inTag = false;

        for (char ch : text.toCharArray()) {
            if (ch == '<') {
                answer.append(word.reverse());
                word.setLength(0);
                inTag = true;
                answer.append(ch);
            } else if (ch == '>') {
                inTag = false;
                answer.append(ch);
            } else if (inTag) {
                answer.append(ch);
            } else if (ch == ' ') {
                answer.append(word.reverse()).append(' ');
                word.setLength(0);
            } else {
                word.append(ch);
            }
        }

        answer.append(word.reverse());
        System.out.print(answer);
    }
}
