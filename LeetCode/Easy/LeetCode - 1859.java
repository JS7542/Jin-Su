class Solution {
    /*
     * 각 단어의 마지막 숫자를 원래 위치 인덱스로 사용한다.
     * 숫자를 제거한 단어를 올바른 위치에 저장하고 공백으로 이어 붙인다.
     */
    public String sortSentence(String s) {
        String[] shuffled = s.split(" ");
        String[] ordered = new String[shuffled.length];

        for (String word : shuffled) {
            int index = word.charAt(word.length() - 1) - '1';
            ordered[index] = word.substring(0, word.length() - 1);
        }

        return String.join(" ", ordered);
    }
}
