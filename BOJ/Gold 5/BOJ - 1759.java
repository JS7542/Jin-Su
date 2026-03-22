import java.io.*;
import java.util.*;

class Main {
    static int length;
    static char[] letters;
    static StringBuilder output = new StringBuilder();

    /*
     * 문자를 오름차순으로 정렬하고 길이 L의 조합을 백트래킹으로 만든다.
     * 모음이 한 개 이상이고 자음이 두 개 이상인 조합만 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        length = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        letters = new char[count];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < count; i++) letters[i] = st.nextToken().charAt(0);

        Arrays.sort(letters);
        make(0, new StringBuilder(), 0, 0);

        System.out.print(output);
    }

    static void make(
            int start,
            StringBuilder password,
            int vowels,
            int consonants
    ) {
        if (password.length() == length) {
            if (vowels >= 1 && consonants >= 2) {
                output.append(password).append('\n');
            }
            return;
        }

        for (int index = start; index < letters.length; index++) {
            char current = letters[index];
            boolean vowel = "aeiou".indexOf(current) >= 0;

            password.append(current);
            make(
                    index + 1,
                    password,
                    vowels + (vowel ? 1 : 0),
                    consonants + (vowel ? 0 : 1)
            );
            password.deleteCharAt(password.length() - 1);
        }
    }
}
