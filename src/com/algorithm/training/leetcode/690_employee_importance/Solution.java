package com.algorithm.training.hash_table.employee_importance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Integer, Employee> linkEmployeesMap;
    public int getImportance(List<Employee> employees, int id) {
        linkEmployeesMap = new HashMap<>();
        for(Employee employee : employees) {
            linkEmployeesMap.put(employee.id, employee);
        }
        return calSubordinatesImportance(id);
    }
    public int calSubordinatesImportance(int id) {
        int importance = linkEmployeesMap.get(id).importance;
        for(int subordinatesId : linkEmployeesMap.get(id).subordinates) {
            importance += calSubordinatesImportance(subordinatesId);
        }
        return importance;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, 5, Arrays.asList(2, 3)));
        employees.add(new Employee(2, 3, Arrays.asList()));
        employees.add(new Employee(3, 3, Arrays.asList()));
        System.out.println(solution.getImportance(employees, 1));
    }
}

/*
�ð����⵵ : O(n) �������⵵ : O(n) <br/>
map���ٰ� employee id�� key�� �Ͽ� ������ �����صΰ� <br/>
(ó������ map�� value�� entry�� employee�� importance�� subordinates�� �����ϴ� ������� �����Ͽ��µ�, �׳� employee ��ü�� �ִ°����� �����丵) <br/>
ã���� �ϴ� id���� ����Ͽ� �Լ��� ���ȣ�� �ϸ� dfs�� ��� ������������ Ÿ�� �������� �������� importance�� ���Ͽ���. <br/>
 */
