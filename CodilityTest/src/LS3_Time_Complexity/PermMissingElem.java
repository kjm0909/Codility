/*
* An array A consisting of N different integers is given. A 배열에는 N개의 다른 숫자들이 들어있음
* The array contains integers in the range [1..(N + 1)], 배열에는 1~N+1 까지 범위의 숫자가 들어있음
* which means that exactly one element is missing. 즉, 숫자 하나가 빠졌다는 거임

Your goal is to find that missing element. 빠진 숫자를 찾아보쟈

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
* */

package LS3_Time_Complexity;

import java.util.Arrays;

public class PermMissingElem {
    public static int solution(int[] A){
        int result = 0;
        if(A.length==0) return 1;

        Arrays.sort(A);

        for(int i=0; i<A.length; i++){
            if(A[0] != 1) {
                result = 1;
                break;
            }
            else {
                if(i+1 == A.length) {
                    result = A[i] + 1;
                    break;
                }
                if (A[i + 1] != A[i] + 1) {
                    result = A[i] + 1;
                    break;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] A = {1,2,3,5};
        System.out.println(solution(A)+", 기대값 4");

        int[] B = {1,2,3,5,6,7,8,9};
        System.out.println(solution(B)+", 기대값 4");

        int[] C = {2};
        System.out.println(solution(C)+", 기대값 1");

        int[] D = {2,3,4,5,6,7,8}; // 7
        System.out.println(solution(D)+", 기대값 1");

        int[] E = {1,2,3,4,5,6,7,8,9}; //
        System.out.println(solution(E)+", 기대값 9");

        int[] F = {5,6,7,1,2,4};
        System.out.println(solution(F)+", 기대값 3");
    }
}
