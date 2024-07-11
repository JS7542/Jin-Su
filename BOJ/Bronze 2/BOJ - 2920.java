import java.io.*; import java.util.*;
class Main {
    /*
     * 여덟 음이 1부터 증가하는지 8부터 감소하는지 확인한다.
     * 두 경우가 모두 아니면 mixed를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        StringTokenizer st=new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        boolean asc=true,desc=true;
        for(int i=1;i<=8;i++){ int x=Integer.parseInt(st.nextToken()); if(x!=i) asc=false; if(x!=9-i) desc=false; }
        System.out.print(asc?"ascending":desc?"descending":"mixed");
    }
}
