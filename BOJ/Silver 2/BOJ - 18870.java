import java.io.*; import java.util.*;
class Main {
    /*
     * 원본 좌표를 복사해 정렬하고 중복을 제거하며 압축 인덱스를 매핑한다.
     * 원본 순서대로 각 좌표의 매핑된 순위를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int n=Integer.parseInt(br.readLine());int[] a=new int[n],sorted=new int[n];StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)a[i]=sorted[i]=Integer.parseInt(st.nextToken());Arrays.sort(sorted);Map<Integer,Integer> map=new HashMap<>();int rank=0;
        for(int x:sorted)if(!map.containsKey(x))map.put(x,rank++);StringBuilder sb=new StringBuilder();for(int x:a)sb.append(map.get(x)).append(' ');System.out.print(sb);
    }
}
