package soli.PGS.ch10_implement;

public class baseExample {
    public static void main(String[] args) {

        int num = 907;

        String binNum = Integer.toBinaryString(num);
        System.out.println("2진법 = " + binNum);

        String octNum = Integer.toOctalString(num);
        System.out.println("8진법 = " + octNum);

        String hexNum = Integer.toHexString(num);
        System.out.println("16진법 = " + hexNum);

        String formattedNum = String.format("%8s", binNum).replace(" ", "0");
        System.out.println("지정된 형식에 맞춰 출력 = " + formattedNum);
    }

}
