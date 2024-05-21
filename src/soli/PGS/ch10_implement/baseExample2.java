package soli.PGS.ch10_implement;

public class baseExample2 {

    public static void main(String[] args) {

        int num = 907;

        for(int i = 2 ; i < 10 ; i++) {
            String result = Integer.toString(num, i);

            System.out.println( "10진수 " + num + "은 " + i + "진수로 " + result);
        }

        String s = "32023";
        int n = Integer.parseInt(s, 4);
        System.out.println( "4진수 " + s + "를 " + "10진수로 "+ n );


    }
}

//10진수 907은 2진수로 1110001011
//10진수 907은 3진수로 1020121
//10진수 907은 4진수로 32023
//10진수 907은 5진수로 12112
//10진수 907은 6진수로 4111
//10진수 907은 7진수로 2434
//10진수 907은 8진수로 1613
//10진수 907은 9진수로 1217