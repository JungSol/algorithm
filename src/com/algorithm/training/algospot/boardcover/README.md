## BOARDCOVER

**Difficulty:** Easy

https://algospot.com/judge/problem/read/BOARDCOVER#

(그림생략) <br/>

H*W 크기의 게임판이 있습니다. <br/>
게임판은 검은 칸과 흰 칸으로 구성된 격자 모양을 하고 있는데 이 중 모든 흰 칸을 3칸짜리 L자 모양의 블록으로 덮고 싶습니다. <br/>
이 때 블록들은 자유롭게 회전해서 놓을 수 있지만, 서로 겹치거나, 검은 칸을 덮거나, 게임판 밖으로 나가서는 안 됩니다. 위 그림은 한 게임판과 이를 덮는 방법을 보여줍니다.

게임판이 주어질 때 이를 덮는 방법의 수를 계산하는 프로그램을 작성하세요. <br/>

입력 <br/>
입력의 첫 줄에는 테스트 케이스의 수 C (C <= 30) 가 주어집니다. 각 테스트 케이스의 첫 줄에는 2개의 정수 H, W (1 <= H,W <= 20) 가 주어집니다. 다음 H 줄에 각 W 글자로 게임판의 모양이 주어집니다. # 은 검은 칸, . 는 흰 칸을 나타냅니다. 입력에 주어지는 게임판에 있는 흰 칸의 수는 50 을 넘지 않습니다. <br/>

출력 <br/>
한 줄에 하나씩 흰 칸을 모두 덮는 방법의 수를 출력합니다. <br/>

```
Input:
3 
3 7 
#.....# 
#.....# 
##...## 
3 7 
#.....# 
#.....# 
##..### 
8 10 
########## 
#........# 
#........# 
#........# 
#........# 
#........# 
#........# 
########## 

Output: 
0
2
1514
```

**Note:**

**Show tag:** \#exhaustive\_search \#dynamic\_programming

**Realted Problem:** combinatorial_search.boardcover

------------------------------------

**Best Main** <br/>
시간복잡도 : O(4^(k/3)) 공간복잡도 : O(n\*m) (n=행의수,m=열의수, k=흰칸의개수) <br/>
시간복잡도의 경우에는 흰칸의 개수인 k에다가 3칸짜리 블록을 총 k/3개 놓을 수 있따. <br/>
이때 한블록을 놓을떄마다 4가지의 선택이 있으므로 4^(k/3)이다. <br/>
k의 최대값이 50이므로 4^16=2^32로 굉장히 커서 시간초과가 발생할 것 같지만, 실제로는 선택할 수 있는 블록 배치가 크게 제한이 되므로 4^16보다 훨씬 작다. (예를들어 흰칸이 6개가 있다면 4^2=16개의 방법이 있어야 하는데, 실제로는 두가지이다.) <br/>

게임판을 덮을 수 이는 모든 경우를 생성하는 완전탐색을 이용하여 해결한다. <br/>
흰칸의 수가 3의 배수가 아닐 경우네는 무조건 답이 없기때문에 이를 따로 처리하여도 된다. <br/>

이 문제에서 고려해야하는 부분은 블록을 놓는 순서에 따른 중복발생이다. <br/>
같은 배치도 블록을 놓는 순서에 따라서 여러번 셀 수 있기 때문에 특정한 순서대로 블록을 놓도록 강제해야한다. <br/>
재귀호출의 각 단계마다 빈칸 중에서 가장 윗줄, 아래의 사진과 같이 가장 왼쪽의 칸을 덮도록 하는 것이다. <br/>
![block](./block.png) <br/>