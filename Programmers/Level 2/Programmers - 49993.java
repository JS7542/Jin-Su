class Solution {
    /*
     * 각 스킬트리에서 선행 스킬에 포함된 문자만 순서대로 확인한다.
     * 현재 배워야 할 스킬과 다른 선행 스킬이 먼저 나오면 잘못된 스킬트리다.
     */
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String tree : skill_trees) {
            int expected = 0;
            boolean valid = true;

            for (char learned : tree.toCharArray()) {
                int position = skill.indexOf(learned);

                if (position < 0) continue;

                if (position != expected) {
                    valid = false;
                    break;
                }

                expected++;
            }

            if (valid) answer++;
        }

        return answer;
    }
}
