import java.util.*;

class Solution {
    /*
     * 50×50 셀을 유니온 파인드 집합으로 관리하고 값은 각 집합 루트에 저장한다.
     * 병합·해제 시 루트와 값을 갱신하며 PRINT는 현재 셀 루트의 값을 조회한다.
     */
    private final int[] parent = new int[2501];
    private final String[] value = new String[2501];

    public String[] solution(String[] commands) {
        for (int index = 1; index <= 2500; index++) {
            parent[index] = index;
            value[index] = "";
        }

        List<String> answer = new ArrayList<>();

        for (String command : commands) {
            String[] parts = command.split(" ");

            if (parts[0].equals("UPDATE")) {
                if (parts.length == 4) {
                    int root = find(index(
                            Integer.parseInt(parts[1]),
                            Integer.parseInt(parts[2])
                    ));
                    value[root] = parts[3];
                } else {
                    for (int cell = 1; cell <= 2500; cell++) {
                        if (find(cell) == cell && value[cell].equals(parts[1])) {
                            value[cell] = parts[2];
                        }
                    }
                }
            } else if (parts[0].equals("MERGE")) {
                int first = find(index(
                        Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2])
                ));
                int second = find(index(
                        Integer.parseInt(parts[3]),
                        Integer.parseInt(parts[4])
                ));

                if (first != second) {
                    String mergedValue = value[first].isEmpty()
                            ? value[second] : value[first];

                    parent[second] = first;
                    value[first] = mergedValue;
                    value[second] = "";
                }
            } else if (parts[0].equals("UNMERGE")) {
                int cell = index(
                        Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2])
                );
                int root = find(cell);
                String saved = value[root];

                List<Integer> members = new ArrayList<>();

                for (int current = 1; current <= 2500; current++) {
                    if (find(current) == root) members.add(current);
                }

                for (int member : members) {
                    parent[member] = member;
                    value[member] = "";
                }

                value[cell] = saved;
            } else {
                int root = find(index(
                        Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2])
                ));

                answer.add(value[root].isEmpty() ? "EMPTY" : value[root]);
            }
        }

        return answer.toArray(new String[0]);
    }

    private int index(int row, int col) {
        return (row - 1) * 50 + col;
    }

    private int find(int cell) {
        if (parent[cell] == cell) return cell;
        return parent[cell] = find(parent[cell]);
    }
}
