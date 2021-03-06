## CLOCKSYNC

**Difficulty:** Medium

https://algospot.com/judge/problem/read/CLCKSYNC

(사진생략) <br/>

그림과 같이 4 x 4 개의 격자 형태로 배치된 16개의 시계가 있다. 이 시계들은 모두 12시, 3시, 6시, 혹은 9시를 가리키고 있다. 이 시계들이 모두 12시를 가리키도록 바꾸고 싶다. <br/>

시계의 시간을 조작하는 유일한 방법은 모두 10개 있는 스위치들을 조작하는 것으로, 각 스위치들은 모두 적게는 3개에서 많게는 5개의 시계에 연결되어 있다. 한 스위치를 누를 때마다, 해당 스위치와 연결된 시계들의 시간은 3시간씩 앞으로 움직인다. 스위치들과 그들이 연결된 시계들의 목록은 다음과 같다. <br/>

0	0, 1, 2 <br/>
1	3, 7, 9, 11 <br/>
2	4, 10, 14, 15 <br/>
3	0, 4, 5, 6, 7 <br/>
4	6, 7, 8, 10, 12 <br/>
5	0, 2, 14, 15 <br/>
6	3, 14, 15 <br/>
7	4, 5, 7, 14, 15 <br/>
8	1, 2, 3, 4, 5 <br/>
9	3, 4, 5, 9, 13 <br/>

시계들은 맨 윗줄부터, 왼쪽에서 오른쪽으로 순서대로 번호가 매겨졌다고 가정하자. 시계들이 현재 가리키는 시간들이 주어졌을 때, 모든 시계를 12시로 돌리기 위해 최소한 눌러야 할 스위치의 수를 계산하는 프로그램을 작성하시오. <br/>

입력 <br/>
첫 줄에 테스트 케이스의 개수 C (<= 30) 가 주어진다. 
각 테스트 케이스는 한 줄에 16개의 정수로 주어지며, 각 정수는 0번부터 15번까지 각 시계가 가리키고 있는 시간을 12, 3, 6, 9 중 하나로 표현한다. <br/>

출력 <br/>
각 테스트 케이스당 한 줄을 출력한다. 시계들을 모두 12시로 돌려놓기 위해 눌러야 할 스위치의 최소 수를 출력한다. 만약 이것이 불가능할 경우 -1 을 출력한다. <br/>

```
Input:
2
12 6 6 6 6 6 12 12 12 12 12 12 12 12 12 12 
12 9 3 12 6 6 9 3 12 9 12 9 12 12 6 6

Output: 
2
9
```

**Note:**

**Show tag:** \#exhaustive\_search

------------------------------------

**Main** <br/>
시간복잡도 : O(4^10) 공간복잡도 : O(1) <br/>
각각의 스위치는 4번째 누르는 순간 원점이 되므로 0번, 1번, 2번, 3번만 눌러보면 된다. <br/>
따라서 모든 스위치를 0번~3번 누르면서 만들 수 있는 모든 경우의수(조합)를 따져보아 스위치 누르는 카운트의 최소값을 찾으면 된다. <br/>
각각의 누르는 횟수는 4가지 이고 스위치의 개수는 10개이므로 시간복잡도는 4^10 = 1,048,576이다.