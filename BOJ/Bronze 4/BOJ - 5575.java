import java.io.*; import java.util.*;
class Main {
    /*
     * 출근 시각과 퇴근 시각을 각각 초로 환산해 차이를 계산한다.
     * 근무 시간을 시, 분, 초 형식으로 세 직원에 대해 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); StringBuilder sb=new StringBuilder();
        for(int t=0;t<3;t++){
            StringTokenizer st=new StringTokenizer(br.readLine()); int[] v=new int[6]; for(int i=0;i<6;i++)v[i]=Integer.parseInt(st.nextToken());
            int diff=(v[3]*3600+v[4]*60+v[5])-(v[0]*3600+v[1]*60+v[2]);
            sb.append(diff/3600).append(' ').append(diff%3600/60).append(' ').append(diff%60).append('\n');
        }
        System.out.print(sb);
    }
}
