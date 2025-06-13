class Solution {
    /*
     * 문제에 제시된 일곱 단계 규칙을 순서대로 문자열에 적용한다.
     * 허용 문자 정리, 점 압축, 길이 조절과 빈 문자열 보완을 수행한다.
     */
    public String solution(String new_id) {
        String id = new_id.toLowerCase()
                .replaceAll("[^a-z0-9._-]", "")
                .replaceAll("[.]{2,}", ".")
                .replaceAll("^[.]|[.]$", "");

        if (id.isEmpty()) id = "a";
        if (id.length() > 15) id = id.substring(0, 15);

        id = id.replaceAll("[.]$", "");

        while (id.length() < 3) {
            id += id.charAt(id.length() - 1);
        }

        return id;
    }
}
