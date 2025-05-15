import java.util.*;

class Solution {
    /*
     * 각 불량 아이디 패턴과 일치하는 사용자 후보를 만든다.
     * 패턴 순서대로 서로 다른 사용자를 선택하고 최종 사용자 집합을 비트마스크로 저장한다.
     */
    private String[] users;
    private String[] banned;
    private final Set<Integer> combinations = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        users = user_id;
        banned = banned_id;

        search(0, 0);
        return combinations.size();
    }

    private void search(int index, int usedMask) {
        if (index == banned.length) {
            combinations.add(usedMask);
            return;
        }

        for (int user = 0; user < users.length; user++) {
            if ((usedMask & (1 << user)) != 0) continue;
            if (!matches(users[user], banned[index])) continue;

            search(index + 1, usedMask | (1 << user));
        }
    }

    private boolean matches(String user, String pattern) {
        if (user.length() != pattern.length()) return false;

        for (int index = 0; index < user.length(); index++) {
            if (pattern.charAt(index) != '*'
                    && pattern.charAt(index) != user.charAt(index)) {
                return false;
            }
        }

        return true;
    }
}
