package wangyi.p1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by shugenniu on 2017/9/9.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long num = scanner.nextLong();
            StringBuilder sb = new StringBuilder();
            while(num!=0) {
                if(num%2==0) {
                    //如果是偶数，选择2
                    sb.append('2');
                    num = (num-2)/2;
                }else {
                    sb.append('1');
                    num = (num-1)/2;
                }
            }
            System.out.println(sb.reverse().toString());
        }
        scanner.close();
    }

}
