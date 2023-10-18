package self.alg.union_find;

public class OptimizedUnion {
    public static void main(String[] args) {
        // https://www.geeksforgeeks.org/union-by-rank-and-path-compression-in-union-find-algorithm/
        // https://www.algotree.org/algorithms/disjoint_set/
    }

    public void union(int x, int y, int[] parent, int[] rank) {
        int xR = find(x, parent);
        int yR = find(x, parent);

        attachByRank(xR, yR, parent, rank);
    }

    private int find(int x, int [] parent) {
        if (parent[x] == x) {
            return x;
        }

        parent[x] = find(parent[x], parent); // path compression
        return parent[x];
    }

    private void attachByRank(int x, int y, int[] parent, int[] rank) {
        // always attach smaller depth of tree under the root of deeper tree
        if (rank[x] >= rank[y]) {
            rank[x]++;
            parent[y] = x;
        } else {
            rank[y]++;
            parent[x] = y;
        }
    }

    private boolean sameRoot(int x, int y, int [] parent) {
        return find(x, parent) == find(y, parent);
    }
}
