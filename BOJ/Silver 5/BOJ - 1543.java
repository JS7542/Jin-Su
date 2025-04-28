import java.io.*;

class Main {
    /*
     * 문서의 왼쪽부터 검색어가 시작하는지 확인한다.
     * 일치하면 검색어 길이만큼, 아니면 한 칸 이동해 겹치지 않는 개수를 센다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String word = br.readLine();

        int count = 0;
        int index = 0;

        while (index + word.length() <= document.length()) {
            if (document.startsWith(word, index)) {
                count++;
                index += word.length();
            } else {
                index++;
            }
        }

        System.out.print(count);
    }
}
