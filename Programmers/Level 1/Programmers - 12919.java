class Solution {
    /*
     * 문자열 배열을 순회하며 Kim과 같은 원소의 인덱스를 찾는다.
     * 지정된 문장 형식에 인덱스를 넣어 반환한다.
     */
    public String solution(String[] seoul){for(int i=0;i<seoul.length;i++)if(seoul[i].equals("Kim"))return "김서방은 "+i+"에 있다";return "";}
}
