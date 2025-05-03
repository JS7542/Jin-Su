import java.util.*;

class Solution {
    /*
     * 시작 단어에서 한 글자씩 바꿔 사전에 존재하는 단어를 BFS로 탐색한다.
     * 방문한 단어는 다시 사용하지 않고 endWord를 처음 만나는 레벨 길이를 반환한다.
     */
    public int ladderLength(
            String beginWord,
            String endWord,
            List<String> wordList
    ) {
        Set<String> dictionary = new HashSet<>(wordList);

        if (!dictionary.contains(endWord)) return 0;

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        dictionary.remove(beginWord);

        int length = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int index = 0; index < size; index++) {
                String current = queue.poll();

                if (current.equals(endWord)) return length;

                char[] letters = current.toCharArray();

                for (int position = 0; position < letters.length; position++) {
                    char original = letters[position];

                    for (char replacement = 'a'; replacement <= 'z'; replacement++) {
                        if (replacement == original) continue;

                        letters[position] = replacement;
                        String next = new String(letters);

                        if (dictionary.remove(next)) queue.offer(next);
                    }

                    letters[position] = original;
                }
            }

            length++;
        }

        return 0;
    }
}
