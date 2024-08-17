import java.util.*;
class Solution {
    /*
     * 1부터 n까지 3과 5의 배수 여부를 확인한다.
     * 조건에 따라 FizzBuzz, Fizz, Buzz 또는 숫자 문자열을 저장한다.
     */
    public List<String> fizzBuzz(int n){List<String>r=new ArrayList<>();for(int i=1;i<=n;i++)r.add(i%15==0?"FizzBuzz":i%3==0?"Fizz":i%5==0?"Buzz":String.valueOf(i));return r;}
}
