import java.util.*;

class Solution {
    /*
     * 문자열을 네 구간으로 나누는 모든 길이 1~3 조합을 백트래킹한다.
     * 앞쪽 0과 255 초과 구간을 제외한 완성 주소만 결과에 추가한다.
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> answer = new ArrayList<>();
        build(s, 0, new ArrayList<>(), answer);
        return answer;
    }

    private void build(
            String s,
            int index,
            List<String> parts,
            List<String> answer
    ) {
        if (parts.size() == 4) {
            if (index == s.length()) answer.add(String.join(".", parts));
            return;
        }

        int remainingParts = 4 - parts.size();
        int remainingChars = s.length() - index;

        if (remainingChars < remainingParts || remainingChars > remainingParts * 3) return;

        for (int length = 1; length <= 3 && index + length <= s.length(); length++) {
            String part = s.substring(index, index + length);

            if (part.length() > 1 && part.charAt(0) == '0') break;
            if (Integer.parseInt(part) > 255) break;

            parts.add(part);
            build(s, index + length, parts, answer);
            parts.remove(parts.size() - 1);
        }
    }
}
