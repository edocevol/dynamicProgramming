package wangyi.p3;

import java.util.Scanner;

/**
 * Created by shugenniu on 2017/9/9.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(count(6));
    }
    private static Integer count(int num){
        int[] count = new int[num+1] ;
        count[0] = 1 ;
        count[1] = 1 ;
        for(int i=2;i<=num;i++){
            for(int j=0;j<i;j++){
                count[i] += count[j]*count[i-j-1] ;
                System.out.println("count["+i+"] is:"+count[i]) ;
            }
        }

        return count[num] ;
    }
}
