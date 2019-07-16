## Cal Factor

**Difficulty:** Easy

알고리즘 문제해결 전략 497p 예제

주어진 자연수 n의 소인수분해 결과를 반환한다.

**Note:**

**Show tag:** \#number\_#theory

----------------------------------------------

**Solution** <br/>
시간복잡도 : O(루트n) 공간복잡도 : O(1) <br/>
2부터 루트n까지 반복순회하면서 n의 약수를 찾을때마다 n을 더이상 이 숫자로 나눌 수 없을 떄까지 나눈다. <br/>
소인수분해는 n을 소수의 곱으로 나타내는 것이지만 이 코드에서는 2부터 루트n까지의 모든 숫자로 나눠주는데 이렇게 해도 상관 없는 이유는 아래와 같다.<br/>
i가 합성수라면 이미 n은 i의 소인수들로 최대한 나눠진 뒤이기 때문에 n이 i로 나눠떨어질리가 없기 때문이다. <br/>
위와 같은 이유로 2부터 루트n까지의 순회를 다 끝내고 남은 n이 1이 아니라면, 소수이기 때문에 마지막에 리스트에 추가해주는 작업도 필요하다.

**Solution2** <br/>
시간복잡도 : O(n의소인수분해개수) 공간복잡도 : O(1) (에라토스테네스의 체를 제외한 시간/공간복잡도) <br/> 
_시간복잡도를 정확하게 모르곘음_ <br/>
에라토스테네스의 체를 이용하여 n+1크기의 배열에 각 index마다 각 숫자가 소수인지 합성수인지 뿐만 아니라 가장 작은 소인수를 기록해둔다. <br/>
소수일 경우 가장 작은 소인수는 자기자신이며 합성수이면 소인수 중에 가장 작은 수가 들어갈 것이다. <br/>
처음 배열에는 (0과 1번째를 제외하고는) 자기자신으로 초기화시켜두고, 에라토스테네스의 체를 수행하여 2부터 n까지의 루프에서 배열의 값이 자기자신이라면 해당 수는 소수인것이며 해당 수의 배수들은 합성수이다. <br/>
따라서 해당 수의 배수들의 배열의 값을 변경해주는데 배수들 중에 이미 배열의 값이 자기자신이 아닌 수들은 더 작은 소인수가 존재한다는 것이기 때문에 패스하고 배열의 값이 자기자신인 경우에만 변경해주면 된다.

에라토스테네스의 체를 이용하여 구해둔 배열(fac라지칭)을 사용하면 빠르게 소인수분해를 수행할 수 있다. <br/>
fac[n]에는 n의 소인수중에 가장 작은 값이 있으므로 n을 fac[n]으로 나눠주면서, <br/>
소인수분해의 결과 개수만큼만 반복 수행하면 바로 구할 수 있다.