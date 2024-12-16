package java_Practice_Set.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class  Employee{

    int empId;
    String name;
    int salary;

    Employee(int empId,String name,int sal)
    {
        this.name=name;
        this.empId=empId;
        this.salary=sal;
    }

}
public class MapTest2 {
    public static void main(String[] args) {

        List<Employee> empList= Arrays.asList(
                new Employee(101,"Shivam",10000),
                new Employee(102,"Rasika",20000),
                new Employee(103,"Vaishnavi",30000),
                new Employee(104,"Priyanka",40000),
                new Employee(105,"Neha",50000));

        // collection --> filter -- >map -->collect
        // combination of filter and map
        List<String> empSalaries=empList.stream().filter(emp->emp.salary>20000)
                        .map(e->e.name+" - "+e.salary ).collect(Collectors.toList());

        System.out.println(empSalaries);


    }

}
