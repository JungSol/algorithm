## CHRISTMAS

**Difficulty:** Medium

https://algospot.com/judge/problem/read/CHRISTMAS

크리스마스를 맞이하여 산타 할아버지는 전세계의 착한 어린이 K명에게 인형을 사주려고 한다. <br/>
산타 할아버지는 인형을 구입하기 위해서 유명한 인형가게인 "놀이터"에 찾아갔다. <br/>
놀이터에는 N개의 인형 상자가 한 줄로 진열되어 있고, 각 인형 상자에는 한 개 이상의 인형이 들어 있다. <br/>
그리고 놀이터에서는 주문의 편의성을 위해 각 상자에 번호를 붙여 놓았고, 주문은 "H번 상자부터 T번 상자까지 다 주세요."라고만 할 수 있다. (H ≤ T)

산타 할아버지는 한 번 주문할 때마다, 주문한 상자에 있는 인형들을 모두 꺼내서 각각을 K명에게 정확히 같은 수만큼 나누어 주고, 남는 인형이 없도록 한다. <br/>

1. 한 번 주문할 수 있다면, 가능한 주문 방법은 몇 가지인가?
2. 여러 번 주문할 수 있다면, 주문이 겹치지 않게 최대 몇 번 주문할 수 있는가? (주문이 겹친다는 것은 어떤 두 주문에 같은 번호의 인형 상자가 포함되는 것을 말한다.)

입력 <br/>
첫 번째 줄에는 테스트 케이스의 개수 T가 주어진다. ( T ≤ 60 ) <br/>
각 테스트 케이스의 첫 번째 줄에는 인형 상자의 개수 N과 어린이의 수 K가 주어진다.(1 ≤ N, K ≤ 100000) <br/>
두 번째 줄에는 1번 인형 상자부터 N번 인형 상자까지 각 인형 상자에 들어 있는 인형의 개수 Di가 주어진다. ( 1 ≤ i ≤ N, 1 ≤ Di ≤ 100000 ) <br/>

출력 <br/>
1번에 대한 답과 2번에 대한 답을 한 줄에 하나의 빈칸으로 나누어 출력한다. 1번 답은 매우 클 수 있으므로 20091101로 나눈 나머지를 출력한다.

```
Input:
1
6 4
1 2 3 4 5 6

Output: 
3 1
```

**Note:**

**Show tag:** \#partition\_sum \#dynamic\_programming

------------------------------------

**Best Main** <br/>
1번문제) 한 번 주문할 수 있다면, 가능한 주문 방법은 몇 가지인가? <br/>
시간복잡도 : O(n+k) 공간복잡도 : O(n+k) (n=상자개수 k=아이들명수) <br/>
H에서 T까지 구입해서 모든 어린이들에게 동일한 개수의 인형을 나눠주기 위해서는, 인형의 총 수가 어린이수(K)의 배수여야 한다. <br/>
상자별 인형 개수의 부분합 배열을 만들어두고 이를 pDollNumbers라고 칭하면, <br/>
(pDollNumbers[T]-pDollNumbers[H-1])%K = 0 <br/>
pDollNumbers[T]%K = pDollNumbers[H-1]%K <br/>
즉, pDollNumbers[T]%K와 pDollNumbers[H-1]%K가 같을 떄 주문이 가능하다. <br/>
pDollNumbers는 K로 나눈 나머지만 가지고 H부터 T까지 구입해서 아이들에게 나눠줄 수 있는지를 판단 가능하므로, <br/>
pDollNumbers에는 부분합의 K로 나눈 나머지를 저장해둔다. <br/>

이후 주문방법의 개수를 구하는 것은 pDollNumbers[T]=pDollNumbers[K]일 때 주문이 가능하므로, <br/>
pDollNumbers[]의 각 원소는 0~K-1까지의 값을 가질 수 있고 이를 카운트해준다. <br/>
그 후 카운트된 값이 2이상이면 이들 중 2개를 선택하면 한 번의 주문이 되므로 카운트된 값중에 2개를 선택하는 경우의수를 구한다. <br/>

이 때 count를 세 줄때 int형범위를 넘어서는 연산이 있으므로 형에 주의해야 한다. <br/>
이를 위해 pDollCounter배열을 long형으로 두었다. <br/>
(어차피 pDollCount배열에는 최대값이 100000으로 long형이 불필요하므로 int형배열로 선언하고 계산과정에서 long형으로 형변환해도 상관없다.) <br/>

2번문제) 여러 번 주문할 수 있다면, 주문이 겹치지 않게 최대 몇 번 주문할 수 있는가? (주문이 겹친다는 것은 어떤 두 주문에 같은 번호의 인형 상자가 포함되는 것을 말한다.) <br/>
시간복잡도 : O(n+k) 공간복잡도 : O(n+k) (n=상자개수 k=아이들명수) <br/>
동적계획법을 이용하여 해결한다. <br/>
for루프를 이용해서 0부터 상자개수까지 순회하는데 이 때 각 for문에서는 0번상자부터 i번 상자까지의 범위 내에서 서로 겹치지 않고 구매할 수 있는 부분 구간수를 의미한다. <br/>
각 루프안에서 할 수 있는 행동은 두가지이다. <br/>
1. i번 상자를 구매하지 않는 경우
	* i번 상자를 사지 않을 경우 ret[i] = ret[i-1]이다.
2. i번 상자를 구매하는 경우
	* i번 상자를 구매하려면 상자별 인형 개수의 부분합(pDollNumbers)이 같은 상자가 있어야한다.
	* pDollNumbers가 같은 상자가 여러개라면 해당 상자들 중에 가장 뒤에있는 상자를 선택해야 한다.(구간의 수를 최대화 하는 것이 목적이므로 구간의 크기는 줄여야 하기 떄문이다.)
		* 이를 구현하기 위해서 prevPDoll에 해당 부분합의 값이 등장한 마지막 상자번호를 저장해두고 이 배열에 접근하여 바로바로 가장 뒤에 있는 상자를 선택한다.
	* i번 상자와 구매할 상자를 결정했으면(해당 상자를 j라고 지칭) 이를 주문1개로 보고, 0 ~ j-1까지의 범위내의 최대 주문수를 구해서 더해준다.
	* 따라서 i번 상자를 살 경우에는 ret[i] = 1 + ret[j-1] 이다.

구현에서 주의할 점은 첫번째는, pDollNumbers[-1]=0을 추가하여 계산하였다는 것이다. <br/>
(나는 pDollNumbers[0]=0을 하고, 입력받는 것들을 1부터 n index에 넣는것으로 구현하였다.) <br/>
이로인해 pDollNumbers[i]=pDollNumbers[j-1](i>=j)인지를 확인할 때 j=0인 예외에 대해서 별도의 처리를 하지 않아도 괜찮아진다.

