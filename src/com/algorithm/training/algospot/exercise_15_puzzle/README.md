## 15 Puzzle (15퍼즐 상태 표현하기)

**Difficulty:** None

알고리즘 문제해결 전략2의 587p 예제이다.

15퍼즐의 상태는 0부터 15까지의 숫자가 들어있는 4 x 4 크기의 배열로 표현할 수 있다. <br/>
4가지 함수를 구현하라. <br/>
1. board를 bit mask를 이용하여 8byte 정수로 표현하는 getMask
2. mask를 board로 복구시키는 getBoard
3. mask가 주어지면 index 위치에 쓰인 값을 반환하는 getValue
4. mask가 주어지면 특정 위치의 값을 바꾸는 setValue
```
```

**Show tag:** \#bit\_manipulation \#bit\_mask

----------------------

**Solution** <br/>
0~15의 숫자는 4비트로 표현할 수 있고, 배열의 크기가 16이므로 16개의 숫자가 있으므로 비트마스크를 사용하면 64비트(4*16)의 정수 하나로 표현할 수 있다. <br/>

1. getMask
	* 각 board\[i\]\[j\]는 4비트로 0000~1111까지 표현 될 수 있다.
	* 따라서 각 i랑 j를 순서를 매기기 귀하여 (4\*i+j)를 하여 index를 구한다.
	* board\[i\]\[k\]값을 (index\*4) 만큼 왼쪽쉬프트연산을 하여 mask에 누적한다.
2. getBoard
	* 원하는 index 이하의 숫자는 오른쪽 쉬프트 연산으로 없애버리고 15랑 &연산을 하면 (i,j)의 값을 얻을 수 있다.
3. getValue
	* getBoard랑 거의 비슷하다. (getBoard는 i,j로 index를 만들어준다는 부분만 다르다.)
4. setValue
	* mask에다가 해당 index의 비트들을 모두 0으로 셋팅해준다.
		* 15를 index\*4 만큼 왼쪽 쉬프트 연산을 하여 자리를 맞춰주고 이를 not연산한것과 &연산을 하면 0으로 셋팅된다.
	* 해당 index의 비트들이 0으로 초기화 되었다면 value를 index\*4 만큼 왼쪽 쉬프트하여 or 연산을 하여 원하는 value로 셋팅한다.
	
구현할 때 곱하기 역시 비트연산을 이용하였다. (index\*4 = index<<2) <br/>
자바에서는 long 타입이 부호가 있기 때문에 실질적으로 사용할 수 있는 비트는 맨 앞의 부호비트를 제외하여 63비트이다. <br/>
따라서 내가 구현한 코드에서 가장 마지막 board\[3\]\[3\] 값이 8(이진수로 1000)을 넘어가면 overflow가 나온다. <br/>
