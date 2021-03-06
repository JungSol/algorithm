## 264. Ugly Number2

**Difficulty:** Medium

https://leetcode.com/problems/ugly-number-ii/description/

Write a program to find the n-th ugly number. <br/>

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. <br/>
For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers. <br/>

Note that 1 is typically treated as an ugly number, and n does not exceed 1690. <br/>

**Note** <br/>

**Show tag:** \#math \#dynamic\_programming \#heap

**Related Problem:** \#math.ugly\_number \#math.super\_uglry\_number

```
Input: 10
Output: 12
```

-------------------------------------------

**Solution** <br/>
시간복잡도 : O(n) 공간복잡도 : O(n) <br/>
ugly number는 2와 3과 5의 곱으로 이루어진 수 인데, 작은 순서대로 ugly number를 구하기 위해서 아래와 같은 방법을 사용한다. <br/>
가장 작은 ugly number는 1이므로 1에서 출발하여 1\*2, 1\*3, 1\*5 중에 작은 값을 ugly number에 넣고, 작은 값에 해당하는 factor는 다음으로 작은 ugly number와 곱하도록 하여 다시 비교하는것을 n번 반복한다. <br/>

유의할점은 2\*3 = 3\*2 이므로 곱의 결과가 같은경우를 제거해주기 위해서, 매 반복마다 가장 작은 ugly number를 구한후 해당 ugly number와 같은 결과가 나오는 모든 factor(2or3or5)를 비교 인덱스를 +1 해준다.

**Solution2** <br/>
시간복잡도 : O(n) 공간복잡도 : O(n) <br/>
Solution에서는 prime과 index를 가지고 ugly number를 구하는 부분이 반복되며, 가장 작은 ugly number를 구하는 부분이랑 해당 ugly number를 만드는 소수들의 index를 +1해주는 부분이랑 분리되어 있어 이중루프 안의 반복문이 2개가 있다. <br/>
이를 제거한것이 Solution2이다. <br/>
원리는 같으나 Solution에서는 2차원배열 factors에 각 소수의 값과 index를 저장한 반면 Soluton2에다가는 추가적으로 소수의 값 \* factors[index]로 계산한 ugly number까지 저장한다. <br/>
매 반복문마다 최근에 추가된 ugly number를 만들 수 있는 소수들의 index를 증가시키며, 다음번에 추가될 가장 작은 ugly number를 구해준다. <br/>
n개의 ugly number를 구해야하므로 n번 반복하여 구하는데, 가장 최근에 추가된 ugly number와 같은 값의 ugly number인 소수의 index를 +1 해주고 +1된 소수의 ugly number 값도 새로 계산하여 set 해준다. <br/>
그리고 나서 next라는 변수에 다음번에 추가될 가장 작은 ugly number를 구하여 놓는다. <br/>
그러면 루프가 한번 끝나면 next값을 ugly number에 추가하고 위의 과정을 반복하면 된다.


