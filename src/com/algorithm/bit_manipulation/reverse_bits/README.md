## 190. Reverse Bits

https://leetcode.com/problems/reverse-bits/#/description

Reverse bits of a given 32 bits unsigned integer.

```
For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
```

**Follow up** <br/>
If this function is called many times, how would you optimize it?

**Show tag:** \#bit\_manipulation

----------------------------

**Solution : ������ �ڵ�** <br/>
�� ������ ��Ʈ���� �ش� ��Ʈ�� 1���� �ƴ����� �Ǵ��Ͽ�(n&1������ �̿���) 1�̸� Math.pow(2,31-�����ʸ��°����)�� result�� �����ؼ� ���غ����� �ߴµ� ġ������ �������� �־��� <br/>
**��** Java������ int���� signed���̱� ������ �ǿ��� ��Ʈ�� ��ȣ��Ʈ�� ����ϱ� ������ Integer.MAX_VALUE����  2147483647(01111111111111111111111111111111)�� <br/>
���� pow(2,31)�� �ϸ� 2147483648�� �ƴ� 2147483647�� �ǹǷ� ����ε� ���� ǥ���� �� ���� <br/>
���� ���� ������ ���� ������ �ƴ� ��Ʈ������ �̟G�ؾ� ���� ������

**Best Solution** <br/>
for���� 32�� �ݺ��ϸ� �� �ݺ����� result�� ��Ʈ�� 1bit�� ���� ����Ʈ���� <br/>
���� for�������� n�� ���� ������ ��Ʈ���� result���ٰ� ������ <br/>
���� ���� for���� �����ϸ� �� for������ result�� 1bit�� �������� �̵��ϸ鼭 reverse �� <br/>