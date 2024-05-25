import java.io.*; import java.util.*;
class Main {
    /*
     * N을 B로 반복해서 나눈 나머지를 각 자리 숫자로 변환한다.
     * 낮은 자리부터 얻어지므로 StringBuilder를 뒤집어 출력한다.
     */
    public static void main(String[] args) throws Exception {
        StringTokenizer st=new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine()); int n=Integer.parseInt(st.nextToken()),b=Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();
        do{int r=n%b;sb.append((char)(r<10?'0'+r:'A'+r-10));n/=b;}while(n>0);
        System.out.print(sb.reverse());
    }
}
