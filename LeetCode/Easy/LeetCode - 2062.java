class Solution {
    /*
     * 각 시작 위치에서 모음으로만 이루어진 부분문자열을 확장한다.
     * 다섯 모음이 모두 등장한 시점부터 가능한 구간을 센다.
     */
    public int countVowelSubstrings(String word) {
        int answer = 0;

        for (int start = 0; start < word.length(); start++) {
            boolean[] seen = new boolean[5];
            int kinds = 0;

            for (int end = start; end < word.length(); end++) {
                int index = vowelIndex(word.charAt(end));
                if (index == -1) break;

                if (!seen[index]) {
                    seen[index] = true;
                    kinds++;
                }

                if (kinds == 5) answer++;
            }
        }

        return answer;
    }

    private int vowelIndex(char ch) {
        if (ch == 'a') return 0;
        if (ch == 'e') return 1;
        if (ch == 'i') return 2;
        if (ch == 'o') return 3;
        if (ch == 'u') return 4;
        return -1;
    }
}
