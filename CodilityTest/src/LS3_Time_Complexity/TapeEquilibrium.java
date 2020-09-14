/*
* A non-empty array A consisting of N integers is given. 비어 있지 않은 A 배열에 N개의 정수가 들어있음
* Array A represents numbers on a tape. A 배열은 테이프의 숫자를 나타냄

Any integer P, such that 0 < P < N, splits this tape into two non-empty parts 정수 P 는  0과 N 사이의 숫자이며 2개의 비어있지 않은 부분으로 분리됨
: A[0], A[1], ..., A[P − 1] and
* A[P], A[P + 1], ..., A[N − 1].

The difference between the two parts is the value of 이 두 부분의 차이는 아래와 같음
* : |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part. 즉, 첫 번째 부분 합 과 두 번째 부분 합의 절대 차이

For example, consider array A such that:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
We can split this tape in four places: 4 부분으로 나눌 수 있음 최소값 반환 ㄱㄱ

P = 1, difference = |3 − 10| = 7
P = 2, difference = |4 − 9| = 5
P = 3, difference = |6 − 7| = 1
P = 4, difference = |10 − 3| = 7
Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.

For example, given:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
the function should return 1, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−1,000..1,000].
* */
package LS3_Time_Complexity;

import java.util.Arrays;

public class TapeEquilibrium {
    public static int solution(int[] A){
        int result = 0;
        // P 는 1 이상 N 사이 //
        int allSum = 0;
        for (int i = 0; i < A.length; i++) {
            allSum += A[i];
        }

        int tempSum = 0;
        for (int i = 0; i < A.length-1; i++) {
           tempSum += A[i];
           int dif = Math.abs((allSum-tempSum - tempSum));
           if(dif == 0) return 0;
           if(result > dif || i == 0) {
               result = dif;
           }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] A = {3,1,2,4,3};
        System.out.println(solution(A)+", 기대값 1");

        int[] B = {1,2,3};// 1 - 5 = 4, 3 - 3 = 0
        System.out.println(solution(B)+", 기대값 0");

        int[] C = {-10, -5, 1,2, 3};// -10 - 1 = -11, -15 - 6 = -21 , -14 - 5 = -19, -12 - 3 = -15
        System.out.println(solution(C)+", 기대값 11");
    }
}
