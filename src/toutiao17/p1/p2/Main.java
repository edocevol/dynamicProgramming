package toutiao17.p1.p2;


import java.util.Scanner;

/**
 * Created by shugenniu on 2017/10/17.
 * 牛中超  https://github.com/sixtrees
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        long[] room = new long[n];
        for (int i = 0; i < n; i++) {
            room[i] = scanner.nextLong();
        }
        int roomNo = minNo(room);
        long loopTImes = loopTimes(room[roomNo], n, roomNo, x - 1);
        int idx = x - 1;
        long origin = loopTImes;


        int div = (int) Math.floor(loopTImes / n);
        loopTImes = loopTImes % n;

        for (int i = 0; i < n; i++) {
            room[i] -= div;
        }



        while (loopTImes > 0) {
            room[idx]--;
            if (idx == 0) {
                idx = n;
            }
            idx--;
            loopTImes--;
        }
        room[roomNo] = origin;
        for (int i = 0; i < n - 1; i++) {
            System.out.print(room[i] + " ");
        }
        System.out.println(room[n - 1]);
    }

    /**
     * 根据第i个房间的人数和最后一次人数分配在哪个房间确定循环了多少次
     *
     * @param roomNo
     * @param lastRoom
     * @return
     */
    public static long loopTimes(long roomNo, int n, int iRoom, int lastRoom) {
        long ps = 0;
        if (iRoom == lastRoom) {
            ps = n * roomNo;
        } else {
            ps = n * roomNo;
            ps += (lastRoom < iRoom) ? (lastRoom + n - iRoom ) : (lastRoom - iRoom);
        }
        return ps;
    }

    public static int minNo(long[] room) {
        int min = 0;
        for (int i = 1; i < room.length; i++) {
            if (room[i] < room[min]) {
                min = i;
            }
        }
        return min;
    }
}
