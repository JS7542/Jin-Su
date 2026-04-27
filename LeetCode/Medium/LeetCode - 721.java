import java.util.*;

class Solution {
    /*
     * 같은 계정의 이메일들을 첫 이메일과 유니온해 같은 집합으로 묶는다.
     * 루트별 이메일을 정렬하고 대표 이메일의 이름을 앞에 붙여 결과를 만든다.
     */
    private final Map<String, String> parent = new HashMap<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> owner = new HashMap<>();

        for (List<String> account : accounts) {
            String firstEmail = account.get(1);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);

                parent.putIfAbsent(email, email);
                owner.put(email, account.get(0));
                union(firstEmail, email);
            }
        }

        Map<String, TreeSet<String>> groups = new HashMap<>();

        for (String email : parent.keySet()) {
            String root = find(email);

            groups.computeIfAbsent(root, value -> new TreeSet<>())
                    .add(email);
        }

        List<List<String>> answer = new ArrayList<>();

        for (Map.Entry<String, TreeSet<String>> entry : groups.entrySet()) {
            List<String> merged = new ArrayList<>();
            merged.add(owner.get(entry.getKey()));
            merged.addAll(entry.getValue());
            answer.add(merged);
        }

        return answer;
    }

    private String find(String email) {
        String root = parent.get(email);

        if (!root.equals(email)) {
            parent.put(email, find(root));
        }

        return parent.get(email);
    }

    private void union(String first, String second) {
        parent.putIfAbsent(first, first);
        parent.putIfAbsent(second, second);

        String firstRoot = find(first);
        String secondRoot = find(second);

        if (!firstRoot.equals(secondRoot)) {
            parent.put(secondRoot, firstRoot);
        }
    }
}
