package a_004_기존문제풀기.q_013_기능개발_001_일반_스트림이용;

import java.util.*;

public class Solution {

    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {

            // 1. 한 개 기능을 개발하는데 필요한 날짜 계산
            double days = (100 - progresses[i]) / (double)speeds[i];
            int daysUp = (int)Math.ceil(days);

            // 2. 함께 배포할 기능의 index 찾기
            int j = i + 1;
            for(; j < progresses.length; j++)
                if (progresses[j] + daysUp * speeds[j] < 100)
                    break;

            // 3. 이번에 배포할 기능의 개수를 추가하기
            answer.add(j - i);
            i = j - 1;
        }


//        System.out.println(answer.toString());

        // 4. ArrayList를 array 형태로 변경하여 변환
//        int[] answerArray = new int[answer.size()];
//        for (int i = 0; i < answer.size(); i++)
//            answerArray[i] = answer.get(i);
//
//        return answerArray;

        // 4. ArrayList를 array 형태로 변경하여 변환 (Stream 이용)
        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

//        int[] progresses = {93, 30, 55};
//        int[] speeds = {1, 30, 5};

        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        for (int x : sol.solution(progresses, speeds)) {
//            System.out.println(x + " ");
        }
    }
}
