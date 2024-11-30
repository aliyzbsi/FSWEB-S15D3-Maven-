package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {

    private static Map<Integer,Employee> employeeMap;

    private static List<Employee> duplicatedEmployees;

    public static void main(String[] args) {
        LinkedList<Employee> employees=new LinkedList<>();
        employees.add(new Employee(1, "Ali", "Kaya"));
        employees.add(new Employee(2, "Ahmet", "Yılmaz"));
        employees.add(new Employee(3, "Mehmet", "Çelik"));
        employees.add(new Employee(1, "Ali", "Yüzbaşı"));
        employees.add(new Employee(2, "Ahmet", "Kurt"));

        List<Employee> duplicates=findDuplicates(employees);
        System.out.println("Tekrarlayan çalışanlar: ");
        for (Employee duplicate:duplicates){
            System.out.println(duplicate);
        }
        System.out.println("-------");
        System.out.println("Üstteki for ile aynı işi yapan farklı bir yöntem: ");
        duplicates.forEach(System.out::println);
        System.out.println(
                "-------"
        );
        Map<Integer, Employee> uniques = findUniques(employees);
        System.out.println("\nBenzersiz Employee nesneleri:");
        uniques.values().forEach(System.out::println);

        // Tekrar edenleri silme
        List<Employee> uniqueList = removeDuplicates(employees);
        System.out.println("\nTekrarlayanlar silindikten sonra kalan Employee nesneleri:");
        uniqueList.forEach(System.out::println);
    }

   public static List<Employee> findDuplicates(List<Employee> employeeList){
        employeeMap=new HashMap<>();
        duplicatedEmployees=new LinkedList<>();
        Iterator<Employee> iterator=employeeList.iterator();
        while (iterator.hasNext()){
           Employee employee=iterator.next();
            if(employee==null){
                System.out.println("null record");
                continue;
            }
            if (employeeMap.containsKey(employee.getId())){
                duplicatedEmployees.add(employee);
            }else{
                employeeMap.put(employee.getId(),employee);
            }

        }
        return duplicatedEmployees;
   }

    public static Map<Integer,Employee> findUniques(List<Employee> employeeList){
        employeeMap=new HashMap<>();
        Iterator<Employee> iterator=employeeList.iterator();
        while (iterator.hasNext()){
            Employee employee=iterator.next();
            if(employee==null){
                System.out.println("null record");
                continue;
            }
            if (!employeeMap.containsKey(employee.getId())){
                employeeMap.put(employee.getId(),employee);
            }
        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employeeList){
       List<Employee> duplicates=findDuplicates(employeeList);
       Map<Integer,Employee> uniques=findUniques(employeeList);
       List<Employee> onlyUnique=new LinkedList<>(uniques.values());
       onlyUnique.removeAll(duplicates);
       return onlyUnique;


    }

}