import java.io.*; import java.util.*;
class Main {
    /*
     * 마지막 날에는 미끄러지지 않으므로 V-A 높이까지만 반복 이동하면 된다.
     * 필요한 반복 일수를 올림 나눗셈으로 구하고 마지막 하루를 더한다.
     */
    public static void main(String[] args) throws Exception {
        StringTokenizer st=new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        long a=Long.parseLong(st.nextToken()),b=Long.parseLong(st.nextToken()),v=Long.parseLong(st.nextToken());
        System.out.print((v-a+a-b-1)/(a-b)+1);
    }
}
