import java.io.*; import java.util.*;
class Main {
    /*
     * 세 변을 정렬해 가장 긴 변의 제곱과 나머지 두 변의 제곱합을 비교한다.
     * 0 0 0이 입력될 때까지 right 또는 wrong을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); StringBuilder sb=new StringBuilder();
        while(true){StringTokenizer st=new StringTokenizer(br.readLine());int[] a={Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            if(a[0]==0&&a[1]==0&&a[2]==0)break; java.util.Arrays.sort(a); sb.append(a[0]*a[0]+a[1]*a[1]==a[2]*a[2]?"right":"wrong").append('\n');}
        System.out.print(sb);
    }
}
