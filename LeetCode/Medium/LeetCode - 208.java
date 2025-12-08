class Trie {
    private static class Node {
        Node[] children = new Node[26];
        boolean word;
    }

    private final Node root = new Node();

    /*
     * 각 노드는 다음 알파벳 자식 26개와 단어 종료 여부를 가진다.
     * 삽입은 경로를 만들고, 검색과 접두사 확인은 해당 경로 존재 여부를 검사한다.
     */
    public Trie() {
    }

    public void insert(String word) {
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
        Node node = find(word);
        return node != null && node.word;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private Node find(String text) {
        Node current = root;

        for (char ch : text.toCharArray()) {
            current = current.children[ch - 'a'];

            if (current == null) return null;
        }

        return current;
    }
}
