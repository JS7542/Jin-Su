class WordDictionary {
    private static class Node {
        Node[] children = new Node[26];
        boolean word;
    }

    private final Node root = new Node();

    /*
     * 단어 추가 시 트라이 경로를 만들고 끝 노드를 표시한다.
     * 검색 중 점 문자는 모든 자식 분기를 재귀 탐색하고 일반 문자는 해당 자식만 따라간다.
     */
    public WordDictionary() {
    }

    public void addWord(String word) {
        Node current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new Node();
            }

            current = current.children[index];
        }

        current.word = true;
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(Node node, String word, int index) {
        if (node == null) return false;
        if (index == word.length()) return node.word;

        char ch = word.charAt(index);

        if (ch == '.') {
            for (Node child : node.children) {
                if (search(child, word, index + 1)) return true;
            }

            return false;
        }

        return search(node.children[ch - 'a'], word, index + 1);
    }
}
