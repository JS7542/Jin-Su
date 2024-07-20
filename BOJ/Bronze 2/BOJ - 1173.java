import java.io.*; import java.util.*;
class Main {
    /*
     * 현재 맥박에서 운동 가능하면 운동하고, 불가능하면 휴식하며 시간을 센다.
     * 최소 맥박에서 한 번도 운동할 수 없다면 -1을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        StringTokenizer st=new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken()),M=Integer.parseInt(st.nextToken()),t=Integer.parseInt(st.nextToken()),r=Integer.parseInt(st.nextToken());
        if(m+t>M){System.out.print(-1);return;}
        int pulse=m,exercise=0,time=0;
        while(exercise<n){ if(pulse+t<=M){pulse+=t;exercise++;}else pulse=Math.max(m,pulse-r); time++; }
        System.out.print(time);
    }
}
