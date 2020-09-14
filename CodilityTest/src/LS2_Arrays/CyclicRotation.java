/*
* An array A consisting of N integers is given.
* Rotation of the array means that each element is shifted right by one index,
*  and the last element of the array is moved to the first place.
* For example,
* the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).

The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

Write a function:

class Solution { public int[] solution(int[] A, int K); }

that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given

    A = [3, 8, 9, 7, 6]
    K = 3
the function should return [9, 7, 6, 3, 8]. Three rotations were made:

    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
For another example, given

    A = [0, 0, 0]
    K = 1
the function should return [0, 0, 0]

Given

    A = [1, 2, 3, 4]
    K = 4
the function should return [1, 2, 3, 4]

Assume that:

N and K are integers within the range [0..100];
each element of array A is an integer within the range [−1,000..1,000].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
* */

package LS2_Arrays;

import java.util.LinkedList;

public class CyclicRotation {
    public static int[] solution(int[] A, int K){
        int[] answer = new int[A.length];
        if(A.length == K || A.length == 1 || A.length == 0 || K ==0 ) return A;

        int ab = 0;
        if(K > A.length) K = K%A.length;
        for(int i=0; i<A.length; i++){
            if(K > i){
                ab = A.length - K + i;
            }else{
                ab = Math.abs(K-i);
            }
            answer[i] = A[ab];
        }

        return answer;
    }
    /*
    public static int[] solution(int[] A, int K){
        int[] answer = A;

        if(answer.length == K || answer.length == 1 || K == 0){
            return A;
        }

        LinkedList<Integer> list = new LinkedList<>();

        for(int i=0; i<A.length; i++){
            list.add(A[i]);
        }

        for(int i=0; i<K; i++){
            if(list.size() >= 1) { // 87% 의 원인... size 체크 확실히!
                int temp = list.get(list.size() - 1);
                list.remove(list.size() - 1);
                list.add(0, temp);
            }
        }

        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+", ");
            answer[i] = list.get(i);
        }
        return answer;

    }*/

    public static void main(String[] args) {
        int[] test_1 = {3, 8, 9, 7, 6};
        System.out.println("3, 8, 9, 7, 6 =>  expect 9, 7, 6, 3, 8");
        int[] answer_1 = solution(test_1, 3);
        for(int i=0; i<answer_1.length; i++){
            System.out.print(answer_1[i]+", ");
        }

        int[] test_2 = {0, 0, 0};
        System.out.println("\n0, 0, 0 =>  expect 0, 0, 0");
        int[] answer_2 = solution(test_2, 1);
        for(int i=0; i<answer_2.length; i++){
            System.out.print(answer_2[i]+", ");
        }

        int[] test_3 = {1, 2, 3, 4};
        System.out.println("\n1, 2, 3, 4 =>  expect 1, 2, 3, 4");
        int[] answer_3 = solution(test_3, 4);
        for(int i=0; i<answer_3.length; i++){
            System.out.print(answer_3[i]+", ");
        }

        int[] test_4 = {1,2,3,4,5,6,7,8,9,10,11,12};
        System.out.println("\n1,2,3,4,5,6,7,8,9,10,11,12 =>  expect 8,9,10,11,12,1,2,3,4,5,6,7");
        int[] answer_4 = solution(test_4, 5);
        for(int i=0; i<answer_4.length; i++){
            System.out.print(answer_4[i]+", ");
        }

        int[] test_5 = {1,3,5,7};
        System.out.println("\n1,3,5,7 =>  expect 1,3,5,7");
        int[] answer_5 = solution(test_5, 8);
        for(int i=0; i<answer_5.length; i++){
            System.out.print(answer_5[i]+", ");
        }

        int[] test_6 = {};
        System.out.println("\n null=>  expect null");
        int[] answer_6 = solution(test_6, 8);
        for(int i=0; i<answer_6.length; i++){
            System.out.print(answer_6[i]+", ");
        }

    }
}
