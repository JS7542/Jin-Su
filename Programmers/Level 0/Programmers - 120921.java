class Solution {
    /*
     * A를 오른쪽으로 한 칸씩 밀며 B와 같은지 확인한다.
     * 처음 일치하는 이동 횟수를 반환하고 끝까지 없으면 -1을 반환한다.
     */
    public int solution(String A,String B){String cur=A;for(int i=0;i<A.length();i++){if(cur.equals(B))return i;cur=cur.charAt(cur.length()-1)+cur.substring(0,cur.length()-1);}return -1;}
}
