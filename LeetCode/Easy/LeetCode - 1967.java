class Solution {
    /*
     * patterns의 각 문자열이 word 내부에 포함되는지 확인한다.
     * 부분문자열로 등장하는 패턴의 개수를 센다.
     */
    public int numOfStrings(String[] patterns, String word) {
        int answer = 0;

        for (String pattern : patterns) {
            if (word.contains(pattern)) answer++;
        }

        return answer;
    }
}
