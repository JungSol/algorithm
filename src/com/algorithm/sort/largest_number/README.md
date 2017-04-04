## 179. Largest Number

https://leetcode.com/problems/largest-number/#/description

Given a list of non negative integers, arrange them such that they form the largest number.

```
For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
```

**Note:** The result may be very large, so you need to return a string instead of an integer.

**Show tag:** \#sort

-----------------------------------------------

**Solution** <br/>
int�� �迭�� string�� �迭�� �ٽ� ���� ������ largest number�� ���� �� �ִ� �������� ������ �� �ϳ��� string�� ���� ������ �� �տ� �ִ� 0�� �������ִ� �۾��� �Ͽ� ��ȯ�Ѵ�. <br/>
������ ������ String o1, String o2�� ���� �� o1+o2�� o2+o1�� ���ؼ� �����ϸ� �ȴ�. <br/>
o1+o2�� o2+o1���� Ŭ ��� o1�� �տ��;� �ϴ� ���̸� �� �ݴ��� ��� o2�� �տ��;� �ϴ� ���̴�.