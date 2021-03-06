## MINASTIRITH

**Difficulty:** Hard

https://algospot.com/judge/problem/read/MINASTIRITH

단 한 번도 함락된 적이 없다는 성채도시 미나스 아노르에는 반지름이 8 킬로미터나 되는 거대한 원형 성벽, 람마스 에코르가 있습니다. <br/>
도시 전체를 감싸는 이 거대한 성벽에는 n 개의 초소가 배치되어 있습니다. <br/>
각 초소들은 해당 위치를 중심으로 반지름 ri 의 원 내부를 감시할 수 있는데, 성벽의 구조 때문에 초소는 불규칙하게 배치되어 있고 초소마다 감시할 수 있는 범위도 모두 다릅니다. <br/>

(그림생략) <br/>

위 그림에서 굵은 실선은 성벽, 별은 초소의 위치, 그리고 점선은 각 초소가 감시할 수 있는 영역을 나타냅니다. <br/>
최소의 인원으로 성벽의 모든 부분을 감시하기 위해, 일부 초소에만 병사를 배치하려고 합니다. <br/>
각 초소의 위치와 감시 범위가 주어질 때, 성벽의 모든 부분을 감시하기 위해 필요한 최소한의 병사 수를 계산하는 프로그램을 작성하세요. <br/>

문제를 간단하게 하기 위해 성벽은 두께가 없는 원이고 초소는 점이라고 가정합니다.

입력 <br/>
입력의 첫 줄에는 테스트 케이스의 수 c (c <= 50) 가 주어집니다. 각 테스트 케이스의 첫 줄에는 초소의 개수 n (1 <= n <= 100) 이 주어지며, 그 후 n 줄에 각 3 개의 실수로 각 초소의 위치 yi, xi, 그리고 감시 범위 ri (0 < ri <= 16.001) 가 주어집니다. <br/>
성벽은 (0,0) 을 중심으로 하는 반지름 8 인 원으로, 모든 초소는 이 성벽 위에 위치합니다.

출력 <br/>
각 테스트 케이스마다 한 줄에 필요한 최소의 병사 위치를 출력합니다. 만약 어떻게 하더라도 성벽의 모든 부분을 감시할 수 없다면 IMPOSSIBLE 을 대신 출력합니다. 입력에 주어지는 초소의 좌표, 혹은 감시 범위가 최대 0.0000001 만큼 변하더라도 답은 변하지 않는다고 가정해도 좋습니다.

```
Input:
3
10
7.02066050 -3.83540431 4.0
-7.23257714 -3.41903904 2.0
0.00000000 -8.00000000 8.0
-8.00000000 -0.00000000 4.8
-6.47213595 4.70228202 3.2
-4.70228202 6.47213595 4.8
7.60845213 -2.47213595 1.6
-2.47213595 -7.60845213 8.8
6.47213595 4.70228202 7.6
-0.00000000 8.00000000 4.8
4
8.00000000 0.00000000 8.00
0.00000000 -8.00000000 8.00
-8.00000000 -0.00000000 8.00
1.25147572 7.90150672 5.40
1
8 0 15.99

Output: 
5
4
IMPOSSIBLE
```

**Note:**

**Show tag:** \#greedy

------------------------------------

**Main** <br/>
