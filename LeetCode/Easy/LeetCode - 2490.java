class Solution {
    /*
     * 각 단어의 마지막 문자가 다음 단어의 첫 문자와 같은지 확인한다.
     * 마지막 단어와 첫 단어의 연결까지 만족하면 원형 문장이다.
     */
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            String current = words[i];
            String next = words[(i + 1) % words.length];

            if (current.charAt(current.length() - 1) != next.charAt(0)) return false;
        }

        return true;
    }
}
