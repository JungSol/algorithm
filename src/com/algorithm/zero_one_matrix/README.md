## 542. 01 Matrix

https://leetcode.com/problems/01-matrix/

Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell. <br/>
The distance between two adjacent cells is 1.

```
input <br/>
0 0 0 <br/>
0 1 0 <br/>
0 0 0 <br/>
output <br/>
0 0 0 <br/>
0 1 0 <br/>
0 0 0 <br/>
```

**Note** <br/>
1. The number of elements of the given matrix will not exceed 10,000. <br/>
2. There are at least one 0 in the given matrix. <br/>
3. The cells are adjacent in only four directions: up, down, left and right. <br/>

**Shot tag:** \#depth\_fisrt\_search \#breadth\_first\_search

----------------------

**Best Solution** <br/>
0�� 1�� �̷���� ����̹Ƿ� 0�� cell�� �䵵 0�� <br/>
ó���� for������ ����� ���鼭 1�� cell�� Integer.MAX_VALUE�� �ٲ㼭 � ���� ���ص� ũ���� �� <br/>
���� ���� 0�� cell�� ��ǥ(i,j)�� ť�� �־�ּ� �Ŀ� �� ��ǥ���� �������� Ž���ϵ��� ���� <br/>
����� �� �� �Ŀ��� queue���� �ϳ��� �����鼭 �ش� ��ǥ�� ��,�Ʒ�,��,�츦 ���� �ش� ��ǥ�� value�� ��,�Ʒ�,��,���� ������ 1���� ���� �ּҰ����� �����ָ鼭 �̵��ϸ� ��. -> MIN(matrix[i-1][j]+1, matrix[i+1][j]+1, matrix[i][j-1]+1, matrix[i][j+1]+1, matrix[i][j]) <br/>
���࿡ ���ο� �ּҰ����� �� �ϸ� �ٽ� ť�� �־��ָ鼭 ť�� �������� �ݺ� 