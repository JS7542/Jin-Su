import java.io.*; import java.util.*;
class Main {
    /*
     * 현재 시각을 초 단위로 바꾸고 요리 시간을 더한다.
     * 하루 초로 나눈 나머지를 다시 시, 분, 초로 변환한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int total=Integer.parseInt(st.nextToken())*3600+Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken());
        total=(total+Integer.parseInt(br.readLine()))%86400;
        System.out.print(total/3600+" "+total%3600/60+" "+total%60);
    }
}
