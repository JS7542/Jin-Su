class Solution {
    /*
     * 각 문자 위치를 오른쪽으로 k칸 이동시킨 원형 인덱스를 계산한다.
     * 이동한 위치의 문자를 결과 문자열에 순서대로 추가한다.
     */
    public String getEncryptedString(String s, int k) {
        StringBuilder answer = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            answer.append(s.charAt((i + k) % n));
        }

        return answer.toString();
    }
}
