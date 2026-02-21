import java.io.*;
import java.util.*;

class Main {
    /*
     * 크레인과 박스를 무거운 순서로 정렬한다.
     * 매 분마다 각 크레인이 들 수 있는 가장 무거운 남은 박스를 하나씩 옮긴다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cranesCount = Integer.parseInt(br.readLine());
        Integer[] cranes = new Integer[cranesCount];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < cranesCount; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }

        int boxesCount = Integer.parseInt(br.readLine());
        List<Integer> boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < boxesCount; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(cranes, Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());

        if (!boxes.isEmpty() && boxes.get(0) > cranes[0]) {
            System.out.print(-1);
            return;
        }

        int minutes = 0;

        while (!boxes.isEmpty()) {
            int boxIndex = 0;

            for (int crane : cranes) {
                while (boxIndex < boxes.size() && boxes.get(boxIndex) > crane) {
                    boxIndex++;
                }

                if (boxIndex < boxes.size()) {
                    boxes.remove(boxIndex);
                }
            }

            minutes++;
        }

        System.out.print(minutes);
    }
}
