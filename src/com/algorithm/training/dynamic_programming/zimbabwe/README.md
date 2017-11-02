## ZIMBABWE

**Difficulty:** Hard

https://algospot.com/judge/problem/read/ZIMBABWE

계란 한 개에 _ _ _ _ _ _ _ _ _ _ _ _ _ 웨브바짐 달러! <br/>
계획 경제의 실패로 세계 최고의 인플레이션을 자랑하게 된 공산 국가 웨브바짐에서는 하루 중에도 물가가 계속 오르기 때문에 물건의 가격을 실시간으로 바꿔야 합니다. <br/>
웨브바짐에서 가장 큰 무가베 마트에서는 그래서 위와 같이 빈 칸만 쓰여 있는 광고판을 붙여놓고 계란 가격이 오름에 따라 (정확히는 웨브바짐 달러의 가치가 추락함에 따라) 실시간으로 숫자가 크게 적힌 플라스틱 판을 빈 칸에 갈아 끼웁니다. <br/>
예를 들어 계란 한 개에 35억 웨브바짐 달러라고 하면, 3이 쓰인 판 한 개, 5가 쓰인 판 한 개, 0이 쓰인 판 여덟 개를 빈칸에 순서대로 끼우는 것이죠. <br/>

무가베 마트에서 아르바이트를 하는 종욱이는 어느 날 곤란한 손님을 맞았습니다. <be/>
이 손님은 아까 사 갔던 계란을 환불하겠다고 돌아왔는데, 영수증을 잃어버린데다 계란을 얼마에 샀는지를 기억하지도 못한다고 하는군요. <br/>
계란 값은 그 사이 한 번 또 올랐기 때문에 광고판에 적힌 가격은 이미 바뀐 뒤입니다. <br/>
다행히 종욱이는 두 가지를 기억합니다.
* 마지막에 계란 가격이 올랐을 때, 종욱이는 광고판에 꽂힌 플라스틱 판의 순서만 바꿨습니다. 다른 플라스틱 판을 가져오거나 있던 플라스틱 판을 뺄 일은 없었다는 것이죠.
* 마지막 계란 가격을 보면서 '와 이거면 정확히 사탕 m개를 살 수 있구나' 라고 생각했습니다. 따라서 마지막 계란 가격은 m의 배수였습니다. (사탕 가격도 이미 올랐기 때문에 이걸 가지고 계란 가격을 계산할 수는 없습니다)

지금 계란 가격 e와 m이 주어질 때 가능한 이전 계란 가격이 몇 가지나 있는지 계산하는 프로그램을 작성하세요. <br/>
이전 계란 가격은 e 보다 항상 작아야 합니다.

입력 <br/>
입력의 첫 줄에는 테스트 케이스의 수 c (c <= 50) 가 주어집니다. 그 후 c줄에 각각 2개의 자연수 e와 m (1 <= e <= 10^14, 2 <= m <= 20)이 주어집니다. 현재 계란 가격은 0으로 시작하지 않지만, 이전 계란 가격은 0으로 시작할 수 있습니다.

출력 <br/>
각 테스트 케이스마다 한 줄에 가능한 가격의 수를 1,000,000,007 로 나눈 나머지를 출력하세요.	

```
Input:
4
321 3
123 3
422 2
12738173912 7 

Output: 
5
0
2
11033
```

**Note:**

**Show tag:** \#dynamic\_programming \#bit\_mask

------------------------------------

**Solution** <br/>
시간복잡도 : O(n\*m\*2^n) 공간복잡도 : O(m\*2^n) (n : 현재 계란 가격의 자릿수, m : 사탕배수) <br/> 
dp 구상은 내가했는데 주어진 숫자가 422일 때 224가 두번 만들어질 수 있으므로 이런 중복을 제거하는 부분은 알고리즘 문제 해결 전략 책을 보고 구현하였다. <br/>
getEggCostCount(int visit, int currentIndex, int remained, int isSmall)을 visit에 비트 마스크 기법을 이용하여 조합한 숫자들을 저장하며, 현재 조합하여 m으로 나눈 나머지의 숫자가 remained이며 현재가격보다 작은게 보장된다면 isSmall이 1이며 아직 아니라면 isSmall이 0일때 currentIndex이후의 자릿수를 채워서 가능한 이전 계란 가격을 반환하는 함수이다. <br/>
만들 수 있는 모든 조합을 만들어나가면서 답을 찾는데, <br/>
문제에서 고려해야 할 것이 여러가지가 있으므로 한가지씩 정리하면 아래와 같다. <br/>
1. 이전의 계란 가격은 m으로 나눠 떨어져야 한다.
	* 나눠떨어지는지의 계산이 필요하므로 조합한 이전가격이 얼마인지를 알 필요가 있다. <br/>
	* 그러나 조합한 가격은 int범위를 넘어가므로 메모리제이션에 한계가 있으므로 각 자릿수를 하나씩 채워나갈 때 마다 즉각즉각 m으로 나눠서 그 나머지를 계속 함수에 전달해주는 방식으로 계산한다.
	* 최종적으로 나머지가 0이 되는지를 확인하여 0일떄만 카운트 해주면 된다.
2. 이전의 계란 가격은 현재 계란 가격보다 저렴한다.
	* 이전 계란 가격이 현재 계란 가격보다 저렴하려면 다른 숫자가 나오는 가장 앞의 자릿수가 이전 가격이 작아야 한다.
	* isSmall이라는 변수를 이용해서 1이면 이미 작은것이 보장된것이고 0이면 아직 작은것이 보장되지 않았다는 것으로 표현한다.
	* isSmall이 1이 된 이후로는 만들 수 있는 모든 조합에 대해 재귀호출 하면 된다.
	* isSmall이 0일 경우에는 해당 currentIndex 자릿수의 숫자가 이전 가격이 현재 가격보다 작거나 같은 숫자만 오도록 조합을 하면 된다.
3. 중복된 숫자 조합의 제거은 제거되어야 한다.
	* 중복된 숫자의 조합을 제거 하기 위해서 현재 가격을 정렬한 sortedEggCost 배열을 이용한다.
	* sortedEggCost 배열을 만들어서 이 배열을 가지고 조합을 하는데, 같은 숫자가 여러개가 있다면 그 중 가장 먼저 오는 것만 선택하도록 구현을 한다.
	* sortedEggCost의 현재 사용할 숫자의 바로 앞의 숫자가 아래의 경우에 해당되는 경우만 사용하면 된다.
		1. 없거나 (i==0)
		2. 현재 숫자랑 다르거나 (sortedEggCost[i-1] != sortedEggCost[i])
		3. 이미 사용된 ( visit & (1 << i-1) != 0 )
			* 3번의 의미는 앞에 숫자와 현재 숫자가 같은데 앞의 숫자가 사용되지 않았다면 현재 숫자를 사용하지 않는다는 것인데, 만약 현재 숫자를 사용해버리면 앞의 숫자가 현재 숫자보다 뒤에 오는 조합이 만들어지므로 사용하지 않는 것이다.