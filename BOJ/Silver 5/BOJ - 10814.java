import java.io.*; import java.util.*;
class Main {
    /*
     * 회원 정보를 입력 순서와 함께 저장하고 나이만 기준으로 안정 정렬한다.
     * 객체 배열의 안정 정렬 특성으로 같은 나이는 가입 순서가 유지된다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int n=Integer.parseInt(br.readLine());String[][] a=new String[n][2];
        for(int i=0;i<n;i++){StringTokenizer st=new StringTokenizer(br.readLine());a[i][0]=st.nextToken();a[i][1]=st.nextToken();}
        Arrays.sort(a,Comparator.comparingInt(x->Integer.parseInt(x[0])));StringBuilder sb=new StringBuilder();
        for(String[] x:a)sb.append(x[0]).append(' ').append(x[1]).append('\n');System.out.print(sb);
    }
}
