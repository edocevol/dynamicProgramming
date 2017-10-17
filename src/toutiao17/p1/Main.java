package toutiao17.p1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by shugenniu on 2017/10/17.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] map = new char[n][m];
            for (int i = 0; i < n; i++) {
                map[i] = sc.next().toCharArray();
            }

            int px = 0, py = 0, bx = 0, by = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    //玩家
                    if (map[i][j] == 'S') {
                        px = i;
                        py = j;
                    }
                    //箱子
                    if (map[i][j] == '0') {
                        bx = i;
                        by = j;
                    }
                }
            }

            Map S = new Map(px, py, bx, by);
            Map E = resolve(S, map, m, n);
            int res = -1;
            if (E != null) {
                res = 0;
                while (E.previous != null) {
                    res++;
                    E = E.previous;
                }
            }
            System.out.println(res);
        }


    }

    public static void printMX(char[][] arr) {
        for (char[] row : arr) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static Map resolve(Map begin, char[][] map, int m, int n) {
        Queue<Map> queue = new LinkedList<>();
        ArrayList<Map> arrayList = new ArrayList<>();

        //表示箱子的移动的方向
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        queue.offer(begin);

        while (!queue.isEmpty()) {
            Map local = queue.remove();
            arrayList.add(local);
            for (int i = 0; i < dir.length; i++) {
                //对上下左右四个方向进行尝试
                Map next = new Map(local.px + dir[i][0], local.py + dir[i][1]);
                next.previous = local;
                //保证箱子不会出界
                if (next.px >= 0 && next.px < n && next.py < m && next.py >= 0
                        && map[next.px][next.py] != '#') {
                    //如果人到达了箱子的位置，要箱子换为人的坐标，箱子的坐标想dir[i]移动
                    if (next.px == local.bx && next.py == local.by) {
                        next.bx = local.bx + dir[i][0];
                        next.by = local.by + dir[i][1];
                    } else {
                        next.bx = local.bx;
                        next.by = local.by;
                    }

                    if (arrayList.contains(next))
                        continue;
                    //如果next节点是合法的节点，则可以将该节点做为最终的节点
                    if (next.bx >= 0 && next.bx < n && next.by < m && next.by >= 0
                            && map[next.bx][next.by] != '#') {
                        arrayList.add(next);
                        queue.offer(next);
                    } else {
                        continue;
                    }
                    //到达最终状态
                    if (map[next.bx][next.by] == 'E') {
                        return next;
                    }
                }
            }
        }
        return null;
    }
}

class Map {
    //玩家坐标
    int px;
    int py;
    //箱子坐标
    int bx;
    int by;
    Map previous;

    public Map(int px, int py) {
        this.px = px;
        this.py = py;
    }

    public Map(int px, int py, int bx, int by) {
        this.px = px;
        this.py = py;
        this.bx = bx;
        this.by = by;
    }

    // ArrayList 的contains 会隐式的调用对象的equals 方法
    public boolean equals(Object obj) {
        if (obj instanceof Map) {
            if (((Map) obj).px == px && ((Map) obj).py == py && ((Map) obj).bx == bx && ((Map) obj).by == by)
                return true;
        }
        return false;
    }
}