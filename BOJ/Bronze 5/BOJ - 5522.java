import java.io.*;
class Main {
    /*
     * 다섯 줄에 주어진 카드 점수를 모두 더한다.
     * 누적된 총점을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); int sum=0;
        for(int i=0;i<5;i++) sum+=Integer.parseInt(br.readLine());
        System.out.print(sum);
    }
}
