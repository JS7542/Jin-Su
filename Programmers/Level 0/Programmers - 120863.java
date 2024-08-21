class Solution {
    /*
     * +로 나눈 각 항을 확인해 x항의 계수와 상수항을 각각 누적한다.
     * 계수와 상수의 존재 여부에 맞춰 가장 간단한 다항식 문자열을 만든다.
     */
    public String solution(String polynomial) {
        int xCount = 0;
        int constant = 0;

        for (String term : polynomial.split(" \\+ ")) {
            if (term.contains("x")) {
                String coefficient = term.replace("x", "");
                xCount += coefficient.isEmpty() ? 1 : Integer.parseInt(coefficient);
            } else {
                constant += Integer.parseInt(term);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (xCount > 0) sb.append(xCount == 1 ? "x" : xCount + "x");
        if (constant > 0) {
            if (sb.length() > 0) sb.append(" + ");
            sb.append(constant);
        }

        return sb.toString();
    }
}
