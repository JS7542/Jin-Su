import java.io.*; import java.util.*;
class Main {
    /*
     * 모든 시작 위치와 끝 위치 조합으로 연속 부분 문자열을 만든다.
     * HashSet에 저장해 중복을 제거한 뒤 집합 크기를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        String s=new BufferedReader(new InputStreamReader(System.in)).readLine();Set<String>set=new HashSet<>();
        for(int i=0;i<s.length();i++)for(int j=i+1;j<=s.length();j++)set.add(s.substring(i,j));System.out.print(set.size());
    }
}
