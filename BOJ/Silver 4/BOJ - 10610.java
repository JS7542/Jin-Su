import java.io.*; import java.util.*;
class Main {
    /*
     * 30의 배수가 되려면 0을 포함하고 모든 자리수 합이 3의 배수여야 한다.
     * 조건을 만족하면 숫자를 내림차순으로 배치해 만들 수 있는 최댓값을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        char[]a=new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();int sum=0;boolean zero=false;for(char c:a){sum+=c-'0';if(c=='0')zero=true;}if(!zero||sum%3!=0){System.out.print(-1);return;}Arrays.sort(a);StringBuilder sb=new StringBuilder();for(int i=a.length-1;i>=0;i--)sb.append(a[i]);System.out.print(sb);
    }
}
