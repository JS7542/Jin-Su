import java.util.*;

class Solution {
    /*
     * 파일명을 HEAD와 NUMBER 부분으로 분리한다.
     * HEAD 대소문자 무시 비교 후 NUMBER 숫자값으로 비교하고 원래 순서를 유지한다.
     */
    public String[] solution(String[] files) {
        Arrays.sort(files, (first, second) -> {
            String[] a = split(first);
            String[] b = split(second);

            int head = a[0].compareToIgnoreCase(b[0]);
            if (head != 0) return head;

            return Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1]));
        });

        return files;
    }

    private String[] split(String file) {
        int start = 0;
        while (start < file.length() && !Character.isDigit(file.charAt(start))) start++;

        int end = start;
        while (end < file.length() && Character.isDigit(file.charAt(end)) && end - start < 5) end++;

        return new String[]{file.substring(0, start), file.substring(start, end)};
    }
}
