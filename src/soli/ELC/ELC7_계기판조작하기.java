package soli.ELC;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ELC7_계기판조작하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        int K = sc.nextInt();

        long i = N + 1;

        while(true) {
            StringBuilder sb = new StringBuilder(String.valueOf(i));
            Set<Character> set = new HashSet<>();
            for(int j = 0 ; j < sb.length() ; j++) {
                set.add(sb.charAt(j));
            }

            if(set.size() == K) {
                System.out.println(sb.toString());
                break;
            }
            i++;
        }
    }
}
