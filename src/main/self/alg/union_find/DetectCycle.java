package self.alg.union_find;

// t.c.
public class DetectCycle {
    static class Edge {
        public Edge(int src, int dst) {
            this.src = src;
            this.dst = dst;
        }

        int src;
        int dst;


    }

    public static boolean unionFind(Edge[] edges, int vertices) {
        int[] parent = new int[vertices];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (Edge e: edges) {
            if (findRoot(parent, e.src) == findRoot(parent, e.dst)) {
                return true;
            }
            union(parent, e.src, e.dst);
        }

        return false;
    }

    static int findRoot(int[] parent, int x) {
        if (parent[x] == x) {
            return parent[x];
        }

        parent[x] = findRoot(parent, parent[x]); // using union by rank/height, t.c. improved to o (log n)
        return parent[x];
    }

    static void union(int[] parent, int x, int y) {
        int xRoot = findRoot(parent, x);
        int yRoot = findRoot(parent, y);

        parent[xRoot] = yRoot;
    }

    public static void main(String[] args) {
        System.out.println(Character.valueOf((char) (1 + 'a')));
        Edge edge0 = new Edge(0, 1);
        Edge edge1 = new Edge(1, 2);
        Edge edge2 = new Edge(2, 0);
        Edge[] edges = new Edge[]{edge0, edge1, edge2};

        boolean cycleDetected = unionFind(edges, 3);
        System.out.println("Find cycle = " + cycleDetected);
    }
}
