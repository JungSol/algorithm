18장. 선형 자료 구조

* 동적 리스트 (dynamic array)
	* 배열의 큰 문제는 처음에 배열을 선언할 때 배열의 크기를 지정해야 한다는 것
	* 자료의 개수가 변함에 따라 크기가 변경
	* 동적 배열은 일반 배열처럼 언어 차원에서 지원되는 기능이 아니라 배열을 이용해 만들어 낸 별도의 자료구조
		* 내부적으로 배열을 이용하기 때문에 동적 배열은 배열이 갖는 아래 성질을 물려받음
			* 원소들은 메모리의 연속된 위치에 저장됨
				* 캐시의 효율성과 직결되기 때문에 매우 중요한 특성
			* 주어진 위치의 원소를 반환하거나 변경하는 동작을 O(1)에 할 수 있음
			
* 동적배열의 추가적인 특성
	* 배열의 크기를 변경할 수 있음 (O(n)소요)
		* 단순하게 새 배열을 할당받은 뒤 기존 원소들을 복사하고, 새 배열을 참조하도록 함
	* 주어진 원소를 배열의 맨 끝에 추가함으로써 크기를 1 늘리는 append() 연산을 지원 (O(1)소요)
		* 메모리를 할당받을 때 배열의 크기가 커질떄를 대비해서 여유분의 메모리를 미리 할당 받아둠
			* capacity :할당 받은 메모리의 크기
			* size :실제 원소의 수
		* 이미 할당한 메모리가 꽉 찼을 경우에만 더 큰 메모리를 할당받아 원소를 카피
			* 현재 배열의 크기가 용량보다 작다면?
				* size를 1 늘리고 그 위치에 새 값을 할당하여 O(1)만에 append
			* 현재 배열의 크기가 용량과 같다면?
				* resize가 필요하므로 O(n+m)만큼의 시간을 소요
				* m크기의 새 배열에 n크기의 기존 배열을 복사하고 새 배열을 참조하도록 하여 append 
			* 메모리가 꽉 찼을 경우에의 시간복잡도에 대한 고찰 : 알고리즘 해결 전략 612p~614p
				* _이부분 이해가 잘 안되서 스킵_
				* 상수시간의 append() 구현을 위해서 재할당 할 떄 마다 정해진 개수의 여유분을 확보하는 것이 아니라(이렇게 하면 O(n)), 현재 가진 원소의 개수에 비례해서 여유분을 확보
					* 복사의 수가 배열의 크기에 선형적으로 비례 (배열의 크기가 n일때 전체 복사의 크기는 n이되므로 한번의 재할당은 O(1))
					
* 동적 배열을 사용하는데 여러번 append 한다면?
		* 동적 배열의 용량을 미리 늘려둠으로써 재할당에 드는 비용을 줄일 수 있음
		* java : ensureCapacity()

* 연결리스트
	* 배열 원소들의 순서를 유지하면서 임의의 위치에 원소를 삽입하거나 삭제하는 작업을 상수시간에 할 수 있도록 하는 자료구조
		* 일반적으로 임의의 위치의 삽입/삭제는 선형시간이 걸림
		
* 연결리스트와 배열의 차이점
	* 배열에서는 메모리의 연속된 위치에 각 원소들이 저장
	* 연결 리스트는 원소들이 메모리 여기저기에 흩어져 이쏙, 각 원소들이 이전과 다음 원소를 가리키는 포인터를 가짐
	
* 연결리스트의 구현
	* 머리와 꼬리에 대한 포인터를 가진 클래스로 구현
		
	```
	class ListNode 	{
		int element; // 담고있는 원소
		ListNode head, tail;
	}
	```
* 연결리스트 다루기
	* 검색 : O(n)
		* 연결리스트의 머리에서부터 i번쨰 노드까지 포인터를 따라가며 찾아야 함
	* 삽입 : O(1)
	* 삭제 : O(1)
		* 삽입과 삭제는 삽입/삭제할 노드와 이전/이후 노드의 포인터만 바꾸면 됨
	
* 연결리스트 구현
	* C++ : LIST
	* Java, C# : LinkedList
	
* 연결리스트 응용 연산들
	* 잘라 붙이기 연산 (splicing)
		* 연결리스트를 통채로 삽입
		* 연결 리스트에서 노드들 간의 포인터만을 변경해 원소의 삭제와 삽입을 상수 시간에 할 수 있었던 것을 응용
		* 특징
			* 잘라 붙이기 연산은 두 연결 리스트를 상수시간에 하나로 합칠 수 있음
		* 한계
			* 연결 리스트의 크기를 O(1)에 알기가 불가능
				* 연결리스트에서는 크기를 쉽게 알 수 있는 방법이 없어서 원소의 개수를 리스트 객체에서 유지하면서 새 원소를 삽입하거나 삭제할 때 마다 갱신해 줘야 하는데, 잘라붙이기 연산을 하면 몇 개의 원소가 추가되는지 알 방법이 없기 때문
			* 잘라 붙이기 연산을 지원하는 연결 리스트 구현은 많지 않음
				* Java, C#의 LinkedList : 잘라붙이기 연산을 지원하지 않는 대신, 리스트의 크기를 O(1)에 구함
				* C++의 list : splice() 멤버함수를 통해 잘라붙이기 연산을 지원하지만, 리스트의 크기를 구하려면 선형 시간의 반복문을 수행해야 함

	* 삭제했던 원소 돌려놓기
		* 연결리스트에서 노드x를 삭제하면 해당 노드의 이전/이후 노드의 포인터를 바꾸는 것 뿐이고 해당 노드에 있는 정보는 변하지 않음
		* 노드x의 포인터는 prev 노드와 next 노드 정보를 계속 가지고 있으므로 이전/이후 노드의 포인트를 다시 노드x로 바꿔주면 삭제한 원소 돌려놓기 가능
		* 한계
			* 이전 노드나 이후 노드 또한 삭제된 상태에서 수행하면 리스트를 망가뜨리기 떄문에, 항상 삭제한 순서의 반대로(최근에 삭제된 것부터) 복구가 이루어질 때만 사용할 수 있음
		* 사용처
			* 사용자 인터페이스에서 되돌리기(undo)연산을 할 때
			* 조합탐색
				* 답의 한 조각을 만들고, 현재의 상태를 갱신한 뒤 나머지를 재귀호출로 해결하는데, 재귀호출이 끝나면 문제의 상태는 다시 복구되어야 함
				* 양방향 연결리스트로 문제의 현재 상태를 표현하면 되돌리기 연산을 통해 문제의 상태를 되돌리는 작업을 효율적으로 가능
			* 커누스(Donald Knuth)의 춤추는 링크들(Dancing LInks)

* 동적배열과 연결리스트 비교 : 동적배열 vs 연결리스트
	* 이전 원소 / 다음 원소 찾기 : O(1) vs O(1)
	* 임의의 원소 찾기 : O(1) vs O(n)
	* 맨 뒤에 원소 추가/삭제 하기 : O(1) vs O(1)
	* 맨 뒤 이외의 위치에 원소 추가/삭제 하기 : O(n) : O(1)
	* 크기 구하기 : O(1) vs O(n) 혹은 구현에따라 O(1)

* 동적배열과 연결리스트의 선택
	* 삽입과 삭제를 할 일이 없거나, 배열의 끝에서만 하는 경우 : 동적배열
		* 임의의 원소에 빠르게 접근할 수 있을 뿐더러, 원소들이 메모리에 연속해 배치되어 있기 때문에 CPU의 캐시 효율도 더 높여줌
	 * 임의의 원소를 접근하는 것이 아니라 모든 원소를 순회하며 삽입과 삭제를 할 경우 : 연결리스트

* 예제
	1. 조세푸스(josephus) : solve(2017-11-10)
