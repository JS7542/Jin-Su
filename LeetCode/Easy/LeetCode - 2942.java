import java.util.*;

class Solution {
    /*
     * 각 단어에 문자 x가 포함되는지 확인한다.
     * 포함되는 단어의 인덱스를 결과 리스트에 추가한다.
     */
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) >= 0) answer.add(i);
        }

        return answer;
    }
}
