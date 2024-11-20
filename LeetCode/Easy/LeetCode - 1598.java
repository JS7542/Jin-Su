class Solution {
    /*
     * ../는 상위 폴더로 이동하므로 깊이를 하나 줄이고 ./는 이동하지 않는다.
     * 일반 폴더 이름은 하위 이동이므로 깊이를 하나 늘린다.
     */
    public int minOperations(String[] logs) {
        int depth = 0;

        for (String log : logs) {
            if (log.equals("../")) depth = Math.max(0, depth - 1);
            else if (!log.equals("./")) depth++;
        }

        return depth;
    }
}
