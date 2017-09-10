package toutiao.p2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int userNum = scanner.nextInt();

            int[] like = new int[userNum + 1];

            for (int i = 1; i <= userNum; i++) {
                like[i] = scanner.nextInt();
            }

            //查询的个数
            int countCX = scanner.nextInt();

            int[][] queries = new int[countCX][3];
            for (int j = 0; j < countCX; j++) {
                for (int i = 0; i < 3; i++) {
                    //输入查询
                    queries[j][i] = scanner.nextInt();
                }
            }
            //存放答案
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < countCX; i++) {
                //处理每一次查询
                int ans = 0;
                for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                    //查询咯
                    if(like[j] ==queries[i][2]){
                        ans++;
                    }
                }
                list.add(ans);
            }
            for (int ans:list) {
                System.out.println(ans);
            }
        }
        scanner.close();
    }
}
