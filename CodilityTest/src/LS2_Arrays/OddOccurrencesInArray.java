/*
* A non-empty array A consisting of N integers is given.
* The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value,
* except for one element that is left unpaired.

For example, in array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the elements at indexes 0 and 2 have value 9,
the elements at indexes 1 and 3 have value 3,
the elements at indexes 4 and 6 have value 9,
the element at index 5 has value 7 and is unpaired.
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

For example, given array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the function should return 7, as explained in the example above.

Write an efficient algorithm for the following assumptions:

N is an odd integer within the range [1..1,000,000];
each element of array A is an integer within the range [1..1,000,000,000];
all but one of the values in A occur an even number of times.
* */
package LS2_Arrays;

import java.util.Arrays;
import java.util.LinkedList;

public class OddOccurrencesInArray {
    public static int solution(int[] A){
        int result = 0;

        if(A.length == 1) return A[0];

        Arrays.sort(A);

        for(int i=0; i<A.length-1; i++){
            if(A[i] != A[i+1]){
                result = A[i];
            }else{
                i++;
            }
        }
        if(result==0) result = A[A.length-1];

        return result;
    }
    /*public static int solution(int[] A){
        int result = 0;
        int len = A.length;

        if(len==1) return A[0];

        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0; i<len; i++){
            list.add(A[i]);
        }

        int i = 1;
        while(list.size() > 1 && i<list.size()){
            System.out.println(list.get(0)+", "+list.get(i));
            if (list.get(0) == list.get(i)) {
                list.remove(i);
                list.remove(0);
                i = 1;
            }else{
                i++;
                if(i == list.size()){
                    result = list.get(0);
                    break;
                }
            }
            if(list.size() == 1) {
                result = list.peek();
                break;
            }
        }
        return result;
//        result = list.peek();

        // 66% timeout error O(N**2)
        *//*for(int i=0; i<len-1; i++){
            if(A[i] != 0) {
                for(int j=i+1; j<len; j++){
                    if (A[i] == A[j]) {
                        A[i] = A[j] = 0;
                        break;
                    }
                }
            }
        }
        for(int i=0; i<len; i++){
            if(A[i]!=0) return A[i];
        }*//*


    }*/

    public static void main(String[] args) {
        int[] A = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(solution(A)+", expect 7");

        int[] B = {2, 2, 3, 3, 4};
        System.out.println(solution(B)+", expect 4");

        int[] C = {1};
        System.out.println(solution(C)+", expect 1");

        int[] D = {9, 3, 9, 3, 9, 7, 9, 9, 3, 9, 3, 9, 7, 9, 9, 3, 9, 3, 9, 7, 9, 9, 3, 9, 3, 9, 7, 9, 9, 3, 9, 3, 9, 7, 9, 9, 3, 9, 3, 9, 7, 9, 9, 3, 9, 3, 9, 7, 9};
        System.out.println(solution(D)+", expect 7");

        int[] E = {4, 3, 5, 4, 5};
        System.out.println(solution(E)+", expect 3");
    }
}
