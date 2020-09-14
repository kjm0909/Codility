/*
* A small frog wants to get to the other side of the road. 반대편에 가고 싶은 개구리
* The frog is currently located at position X  X 에 위치한 개구리
* and wants to get to a position greater than or equal to Y. 크거나 같은 Y로 가고 싶은 개구리
* The small frog always jumps a fixed distance, D. // 개구리는 정해진 길이, D만큼 점프 가능

Count the minimal number of jumps that the small frog must perform to reach its target. // 목표 지점으로 가는 가장 작은 횟수 세기

Write a function:

class Solution { public int solution(int X, int Y, int D); }

that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.

For example, given:

  X = 10
  Y = 85
  D = 30
the function should return 3, because the frog will be positioned as follows:

after the first jump, at position 10 + 30 = 40
after the second jump, at position 10 + 30 + 30 = 70
after the third jump, at position 10 + 30 + 30 + 30 = 100
Write an efficient algorithm for the following assumptions:

X, Y and D are integers within the range [1..1,000,000,000];
X ≤ Y.
* */
package LS3_Time_Complexity;

public class FrogJmp {
    public static int solution(int X, int Y, int D){
        int result = 0;

        if(X==Y) return 0;
        else if(X+D == Y) return 1;

        int rest = (Y-X)/D;
        if((Y-X)%D==0) result = rest;
        else result = rest+1;

        return result;
    }

    public static void main(String[] args) {
        System.out.println("1번째: "+solution(10,85,30)+", 기대값: 3");
        System.out.println("2번째: "+solution(30,30,30)+", 기대값: 0");
        System.out.println("3번째: "+solution(30,40,30)+", 기대값: 1");
        System.out.println("4번째: "+solution(1,3,1)+", 기대값: 2");
    }
}
