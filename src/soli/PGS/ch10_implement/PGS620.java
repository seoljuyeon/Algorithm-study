package soli.PGS.ch10_implement;

public class PGS620 {
    public String solution(String number, int k) {

        StringBuilder sb = new StringBuilder();

        int num = 0;
        int idx = 0;

        for(int i = 0 ; i < number.length() - k ; i++) {
            num = 0;
            for(int j = idx ; j <= i + k ; j++){
                if(num < number.charAt(j) - '0') {
                    num = number.charAt(j) - '0';
                    idx = j + 1;
                }
            }
            sb.append(num);
        }

        return sb.toString();

    }


    public static void main(String[] args) {
        PGS620 pgs620 = new PGS620();

        System.out.println(pgs620.solution("1924", 2));

        System.out.println(pgs620.solution("1231234", 3));

        System.out.println(pgs620.solution("4177252841", 4));

    }
}
