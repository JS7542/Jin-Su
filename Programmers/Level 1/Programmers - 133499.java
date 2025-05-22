class Solution {
    /*
     * 가능한 네 발음을 왼쪽부터 매칭한다.
     * 직전에 사용한 발음과 같은 발음을 연속으로 사용할 수 없으며 끝까지 정확히 나뉘면 센다.
     */
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        int answer = 0;

        for (String text : babbling) {
            int index = 0;
            int previous = -1;
            boolean valid = true;

            while (index < text.length()) {
                int matched = -1;

                for (int word = 0; word < words.length; word++) {
                    if (word != previous && text.startsWith(words[word], index)) {
                        matched = word;
                        break;
                    }
                }

                if (matched == -1) {
                    valid = false;
                    break;
                }

                index += words[matched].length();
                previous = matched;
            }

            if (valid) answer++;
        }

        return answer;
    }
}
