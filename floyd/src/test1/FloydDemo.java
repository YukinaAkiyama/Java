package test1;


import java.util.Arrays;

/**
 * @author 浪子傑
 * @version 1.0
 * @date 2020/6/27
 */
public class FloydDemo {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[]{0, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, 0, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, 0, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, 0, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, 0, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, 0, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, 0};

        Graph graph = new Graph(vertex, matrix);
        graph.floyd();
        graph.show();

    }
}

// 创建图
class Graph {
    /**
     * 存放顶点的数组
     */
    private char[] vertex;

    /**
     * 保存各个顶点到其他顶点的距离
     */
    private int[][] dis;

    /**
     * 保存到达目标顶点的前驱节点
     */
    private int[][] pre;

    /**
     * 构造函数
     *
     * @param vertex 顶点数组
     * @param dis    邻接矩阵
     */
    public Graph(char[] vertex, int[][] dis) {
        int length = vertex.length;
        this.vertex = vertex;
        this.dis = dis;
        this.pre = new int[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    /**
     * 展示
     */
    public void show() {
        for (int i = 0; i < dis.length; i++) {
            for (int j = 0; j < dis[i].length; j++) {
                System.out.print(vertex[pre[i][j]] + " ");
            }
            System.out.println();
            for (int j = 0; j < dis[i].length; j++) {
                System.out.print("(" + vertex[i] + "-->" + vertex[j] + ":" + dis[i][j] + ")");
            }
            System.out.println();
            System.out.println();
        }
    }

    /**
     * 弗洛伊德算法
     */
    public void floyd() {
        // k为中间节点的下标
        for (int k = 0; k < dis.length; k++) {
            // i为开始节点的下标
            for (int i = 0; i < dis.length; i++) {
                // j为结束节点的下标
                for (int j = 0; j < dis.length; j++) {
                    // 计算以k为中间节点，i为开始节点，j为结束节点，i->k->j的距离
                    int length = dis[i][k] + dis[k][j];
                    // 将i->k->j的距离与i->j的距离进行比较
                    // 如果i->j的距离大，则更新距离表和前驱节点表
                    if (length < dis[i][j]) {
                        dis[i][j] = length;
                        pre[i][j] = pre[i][k];
                    }
                }
            }
        }
    }
}
