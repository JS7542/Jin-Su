import java.io.*; import java.util.*;
class Main {
    /*
     * 평균 R1+R2=2S 식을 R2=2S-R1으로 정리한다.
     * 입력된 R1과 S를 공식에 대입해 두 번째 값을 구한다.
     */
    public static void main(String[] args) throws Exception {
        StringTokenizer st=new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int r1=Integer.parseInt(st.nextToken()), s=Integer.parseInt(st.nextToken());
        System.out.print(2*s-r1);
    }
}
