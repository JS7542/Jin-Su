import java.io.*; import java.util.*;
class Main {
    /*
     * B진법 문자열을 왼쪽부터 읽으며 현재값×B+새 숫자로 누적한다.
     * 숫자와 알파벳 문자를 각각 0~35 값으로 변환한다.
     */
    public static void main(String[] args) throws Exception {
        StringTokenizer st=new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine()); String s=st.nextToken(); int b=Integer.parseInt(st.nextToken()),answer=0;
        for(char c:s.toCharArray()){int v=Character.isDigit(c)?c-'0':c-'A'+10;answer=answer*b+v;}
        System.out.print(answer);
    }
}
