class Solution {
    
    public static int[] findIndex(int number){
        char[][] keyPad = {{'1','2','3'},{'4','5','6'},{'7','8','9'},{'*','0','#'}};
        int x = 0, y = 0;
        
        if(number == 42){ // '*'
            return new int[]{3, 0};
        }else if(number == 35){// '#'
            return new int[]{3,2};
        }
        
        for (int i = 0; i < keyPad.length ; i++) {
            for (int j = 0; j < keyPad[0].length; j++) {
                if(number == Character.getNumericValue(keyPad[i][j])){
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    public static double getDistance(int[] number, int[] currentHand){
        int yd = Math.abs(currentHand[0]-number[0]);
        int xd = Math.abs(currentHand[1]-number[1]);
        return yd + xd;
    }
    
    public String solution(int[] numbers, String hand) {
       StringBuilder answer = new StringBuilder();
         int leftHand = '*';
        int rightHand = '#';

        for (int number : numbers){
            if(number == 1 || number == 4 || number == 7){ // 왼손
                leftHand = number; // 왼손 해당 위치로
                answer.append("L");
            }else if ((number == 3 || number == 6 || number == 9)){ // 오른손
                rightHand = number; // 오른손 해당 위치로
                answer.append("R");
            }else{ // 거리상 가까운 손이 먼저
                double rightDistance = getDistance(findIndex(number), findIndex(rightHand));
                double leftDistance = getDistance(findIndex(number), findIndex(leftHand));
                if(rightDistance < leftDistance){
                    rightHand = number;
                    answer.append("R");
                }else if (rightDistance > leftDistance){
                    leftHand = number;
                    answer.append("L");
                }else{
                    if(hand.equals("right")){
                        rightHand = number;
                        answer.append("R");
                    }else{
                        leftHand = number;
                        answer.append("L");
                    }
                }
            }
        }

        return answer.toString();
    }
}