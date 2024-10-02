class Solution {
    /*
     * 배열의 각 숫자를 문자열로 변환해 모든 문자를 확인한다.
     * 문자 7이 나타날 때마다 개수를 증가시킨다.
     */
    public int solution(int[] array){int answer=0;for(int x:array)for(char c:String.valueOf(x).toCharArray())if(c=='7')answer++;return answer;}
}
