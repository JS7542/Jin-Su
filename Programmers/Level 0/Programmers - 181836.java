class Solution {
    /*
     * 각 원본 문자를 k번 반복해 가로로 확대한 한 줄을 만든다.
     * 완성된 줄을 k번 복사해 세로 방향도 확대한다.
     */
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        int index = 0;

        for (String line : picture) {
            StringBuilder expanded = new StringBuilder();
            for (char ch : line.toCharArray()) expanded.append(String.valueOf(ch).repeat(k));

            for (int repeat = 0; repeat < k; repeat++) {
                answer[index++] = expanded.toString();
            }
        }

        return answer;
    }
}
