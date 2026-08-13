class Solution {

    static class Node {

        char leftChar;
        char rightChar;

        int length;
        int prefix;
        int suffix;
        int max;

        Node(char ch) {
            leftChar = ch;
            rightChar = ch;
            length = 1;
            prefix = 1;
            suffix = 1;
            max = 1;
        }
    }

    Node[] tree;

    public int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {

        int n = s.length();

        tree = new Node[4 * n];

        build(s, 1, 0, n - 1);

        int k = queryIndices.length;
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            update(1, 0, n - 1, index, ch);

            ans[i] = tree[1].max;
        }

        return ans;
    }

    // ---------------- BUILD ----------------

    private void build(
            String s,
            int node,
            int start,
            int end) {

        if (start == end) {
            tree[node] = new Node(s.charAt(start));
            return;
        }

        int mid = start + (end - start) / 2;

        build(s, node * 2, start, mid);
        build(s, node * 2 + 1, mid + 1, end);

        tree[node] = merge(
                tree[node * 2],
                tree[node * 2 + 1]
        );
    }

    // ---------------- UPDATE ----------------

    private void update(
            int node,
            int start,
            int end,
            int index,
            char ch) {

        if (start == end) {
            tree[node] = new Node(ch);
            return;
        }

        int mid = start + (end - start) / 2;

        if (index <= mid) {

            update(
                    node * 2,
                    start,
                    mid,
                    index,
                    ch
            );

        } else {

            update(
                    node * 2 + 1,
                    mid + 1,
                    end,
                    index,
                    ch
            );
        }

        tree[node] = merge(
                tree[node * 2],
                tree[node * 2 + 1]
        );
    }

    // ---------------- MERGE ----------------

    private Node merge(Node left, Node right) {

        Node result = new Node(left.leftChar);

        result.length = left.length + right.length;

        result.leftChar = left.leftChar;
        result.rightChar = right.rightChar;

        result.prefix = left.prefix;
        result.suffix = right.suffix;

        result.max = Math.max(
                left.max,
                right.max
        );

        // Boundary characters are equal
        if (left.rightChar == right.leftChar) {

            // Join suffix of left + prefix of right
            result.max = Math.max(
                    result.max,
                    left.suffix + right.prefix
            );

            // Entire left segment has same character
            if (left.prefix == left.length) {

                result.prefix =
                        left.length + right.prefix;
            }

            // Entire right segment has same character
            if (right.suffix == right.length) {

                result.suffix =
                        right.length + left.suffix;
            }
        }

        return result;
    }
}