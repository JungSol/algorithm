## Cal GCD

**Difficulty:** Easy

알고리즘 문제해결 전략 506p 예제

주어진 자연수 p와 q의 최대공약수를 반환하라.

**Note:**

**Show tag:** \#number\_#theory

----------------------------------------------

**Solution** <br/>
시간복잡도 : log(min(p,q)) 공간복잡도 : O(1) <br/>

시간복잡도에 대한 정보 출처 : https://opentutorials.org/course/1685/9533 <br/>
p mod q가 0이 아닌 경우 p mod q의 값은 [0,q-1] 범위를 가지게 되며, 평균적으로는 중간값을 가진다. <br/>
따라서 mod 연산을 할 떄 마다 범위가 줄어드는데 평균적으로 절반씩 줄어든다. <br/>
위 과정을 통해 통계적으로 탐색하는 수의 범위가 대략 절반적으로 감소하여 위의 시간 복잡도를 근사하게 가질 수 있게 된다. <br/>

유클리드호제법을 적용하여 gcd(p,q) = gcd(q, p%q) = ... = gcd(0, x) = x를 이욯하여 구현하였다. <br/>
