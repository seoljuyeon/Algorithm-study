package soli.PGS2.ch10_implement;


public class PGS57_키패드누르기 {
    public String solution(int[] numbers, String hand) {

        int[][] keypad = {{3,1},
                {0,0}, {0,1}, {0,2},
                {1,0}, {1,1}, {1,2},
                {2,0}, {2,1}, {2,2},
                {3,0}, {3,1}, {3,2}};

        int[] lefthand = keypad[10];
        int[] righthand = keypad[12];

        StringBuilder sb = new StringBuilder();

        for(int num : numbers) {

            int[] enter = keypad[num];

            if((num == 1) || (num == 4) || (num==7)) {
                sb.append("L");
                lefthand = keypad[num];
            }

            else if((num == 3) || (num == 6) || (num == 9)) {
                sb.append("R");
                righthand = keypad[num];
            }

            else {
                int left = Math.abs(lefthand[0] - enter[0]) + Math.abs(lefthand[1] - enter[1]);
                int right = Math.abs(righthand[0] - enter[0]) + Math.abs(righthand[1] - enter[1]);

                if(left < right) {
                    sb.append("L");
                    lefthand = keypad[num];
                } else if(left > right) {
                    sb.append("R");
                    righthand = keypad[num];
                } else {
                    if(hand.equals("right")) {
                        sb.append("R");
                        righthand = keypad[num];
                    }
                    else {
                        sb.append("L");
                        lefthand = keypad[num];
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        PGS57_키패드누르기 pgs57_키패드누르기 = new PGS57_키패드누르기();

        System.out.println(pgs57_키패드누르기.solution( new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5} , "right"));
        System.out.println(pgs57_키패드누르기.solution( new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2} , "left"));
        System.out.println(pgs57_키패드누르기.solution( new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0} , "right"));
    }
}
