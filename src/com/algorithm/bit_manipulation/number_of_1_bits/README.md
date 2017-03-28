## 191. Number of 1 Bits

https://leetcode.com/problems/number-of-1-bits/#/description

Write a function that takes an unsigned integer and returns the number of ��1' bits it has (also known as the Hamming weight) <br./>

```
For example, the 32-bit integer ��11' has binary representation 00000000000000000000000000001011, so the function should return 3.
```

**Show tag:** \#bit\_manipulation

----------------------

**Solution** <br/>
�� ������ ��Ʈ���� �ش� ��Ʈ�� 1���� �ƴ����� �Ǵ��ϴ� ��� (for���� 32�� ���鼭 32��Ʈ�� Ȯ��) <br/>
n�� 1�� & ������ �ϸ� �� ������ ��Ʈ�� 1���� �ƴ��� Ȯ���� �� ���� (&������ ����� 1�̶�� 1�ΰ��̰� 0�̶�� 0�ΰ�) <br/>
������ �� �� ���� �־��� n�� 1bit�� ������ shift������ �ϸ鼭 ��Ʈ�� 1���� �ƴ����� Ȯ��
