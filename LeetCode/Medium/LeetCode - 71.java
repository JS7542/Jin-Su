import java.util.*;

class Solution {
    /*
     * 경로를 슬래시 기준으로 나누고 디렉터리 스택을 관리한다.
     * 빈 문자열과 점은 무시하고 두 점은 상위 디렉터리를 제거한다.
     */
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        for (String part : path.split("/")) {
            if (part.isEmpty() || part.equals(".")) continue;

            if (part.equals("..")) {
                if (!stack.isEmpty()) stack.removeLast();
            } else {
                stack.addLast(part);
            }
        }

        return "/" + String.join("/", stack);
    }
}
