## 421. Maximum XOR of Two Numbers in an Array

https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/#/description

Given a non-empty array of numbers, a\_0, a\_1, a\_2, �� , a\_n-1, where 0 �� a\_i < 2^31.

Find the maximum result of a\_i XOR a\_j, where 0 �� i, j < n.

Could you do this in O(n) runtime?

```
Input: [3, 10, 5, 25, 2, 8]
Output: 28
Explanation: The maximum result is 5 ^ 25 = 28.
```

**Show tag:** \#bit_manipulation \#trie

-----------------------------------------------

**Solution**
�־��� �迭�� ���ҵ��� ��� trie�� �ִ´�. <br/>
trie�� length�� 2�� Object�迭�̸� �迭�ȿ� �迭�ȿ� �迭.. �̷������� �����ϸ鼭 trie������ �����. <br/>
������� 1010 �� �־����� 32bit �������� 0000 0000 0000 0000 0000 0000 0000 1010 �̹Ƿ� �迭�� depth�� 32���� �������µ� root �迭�� 0�ε����� Object[] �迭�� �����ϰ� �� �迭�� 0 �ε����� Object[] �迭�� �����ϰ�.. �̷������� �ǿ��� �ڸ�����(���� ū�ڸ���) �̾���� trie ������ ����� ���̴�. <br/>
32*n��ŭ�� ������ �̿��Ͽ� trie������ ���� �� �ִ�. <br/>
���Ŀ��� �ٽ� �迭�� ���ҵ��� �ϳ��� ��ȸ�ϸ鼭 maximumXOR���� ã�´�. <br/>
�ش� ���Ұ� �ٸ����ҵ�� XOR�� �ؼ� ���� �� �ִ� currentMaximumXOR���� trie������ �̿��ؼ� ã���� �̸� �̿��ؼ� ���� maximumXor���� ã�´�. <br/>
currentMaximumXOR���� ã�¹���� ������ �� �ڸ������� ��Ʈ���� �� ���� trie�� ��Ʈ��^1 �ε����� null�̸� �� �ڸ����� xor���� �� 1�� ���Ұ� ���ٴ� �ǹ��̹Ƿ� ���� current trie�� current[bit]�� ���ش�. <br/>
�ݸ鿡 null�� �ƴϸ� �� �ڸ��� ��xor���� �� 1�� ���Ұ� �ִٴ� �ǹ��̹Ƿ� currentMaximumXor�� (1<<i)�� �����ְ� current trie�� current[bit^1]�� �̵����ش�. <br/>
(1<<i)�� �ǹ̴� �ش� �ڸ����� �������� ã�°��̴�. <br/>
���� ������ �ݺ��Ͽ� currentMaximumXor�� ã�� ���������δ� maximumXor�� ã�� �� �ִ�. <br/>
**��** ����� trie������ ���鶧�� currentMaximumXor�� ã���� �ش������ ���� ���� �ڸ����� ��Ʈ(���� ū �ڸ���)���� ������ �������� �����Ѵ�. <br/>
�ֳ��ϸ� 1000�� 0xxxx���� ������ ũ��(4bit���ڸ���������). �� ū�ڸ����� ��Ʈ�� 1�ΰ��� �߰��ϸ� ������ �ִ밪���� �� �� �ִ�. ���� xor�� �� ���� ū �ڸ������� ���ؼ� currentMaximum���� ã�� ���̴�. <br/>

**Best Solution**<br/>
��ó : https://discuss.leetcode.com/topic/63213/java-o-n-solution-using-bit-manipulation-and-hashmap/8 <br/>

