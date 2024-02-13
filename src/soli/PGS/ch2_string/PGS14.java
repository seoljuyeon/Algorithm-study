package soli.PGS.ch2_string;

public class PGS14 {
    public String solution(String new_id) {

        new_id = new_id.toLowerCase();

        new_id = new_id.replaceAll("[~!@#$%^&*()=+\\[\\{\\]\\}:?,<>/]","");

        new_id = thirdstep(new_id);
        // new_id.replaceAll("\\.{2,}", ".");

        new_id = fourthstep(new_id);

        if(new_id.isEmpty()) {
            new_id = "a";
        }

        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = fourthstep(new_id);
        }

        while(new_id.length() <= 2) {
            new_id += new_id.charAt(new_id.length() - 1);
        }

        return new_id;
    }

    private static String thirdstep(String new_id) {

        StringBuilder sb = new StringBuilder();
        boolean fullstop = false;

        for(int i = 0 ; i < new_id.length() ; i++) {
            if(new_id.charAt(i) != '.'){
                sb.append(new_id.charAt(i));
                fullstop = false;
            } else if(!fullstop) {
                sb.append(new_id.charAt(i));
                fullstop = true;
            }
        }
        return sb.toString();
    }

    private static String fourthstep(String new_id) {

        if(new_id.startsWith(".")) {
            new_id = new_id.substring(1);
        }
        if(new_id.endsWith(".")){
            new_id = new_id.substring(0, new_id.length()-1);
        }

        return new_id;
    }

    public static void main(String[] args) {
        PGS14 pgs14 = new PGS14();

        System.out.println("Test Case1 : " + pgs14.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println("Test Case2 : " + pgs14.solution("z-+.^."));
        System.out.println("Test Case3 : " + pgs14.solution("=.="));
        System.out.println("Test Case4 : " + pgs14.solution("123_.def"));
        System.out.println("Test Case5 : " + pgs14.solution("abcdefghijklmn.p"));

    }

}
