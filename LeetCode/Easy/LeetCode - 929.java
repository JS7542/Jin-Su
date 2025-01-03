import java.util.*;

class Solution {
    /*
     * 로컬 이름에서는 점을 제거하고 + 뒤의 문자를 무시한다.
     * 정규화한 로컬 이름과 도메인을 합쳐 집합에 저장한다.
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();

        for (String email : emails) {
            String[] parts = email.split("@");
            String local = parts[0].split("\\+")[0].replace(".", "");
            unique.add(local + "@" + parts[1]);
        }

        return unique.size();
    }
}
