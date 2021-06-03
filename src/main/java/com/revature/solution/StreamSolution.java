package com.revature.solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.revature.models.Address;
import com.revature.models.MobileNumber;
import com.revature.models.Student;
import com.revature.models.TempStudent;

public class StreamSolution {
	
    public static void main(String[] args) {
    	
    	/*
    	 * ============== Don't alter the code between lines 24 - 42 ==============
    	 */
 
        Student student1 = new Student(
            "Bob",
            20,
            new Address("1234"),
            Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));
 
        Student student2 = new Student(
            "Alice",
            20,
            new Address("1235"),
            Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));
 
        Student student3 = new Student(
            "Wally",
            20,
            new Address("1236"),
            Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));
 
        List<Student> students = Arrays.asList(student1, student2, student3);
        
    	/*
    	 *========== Don't alter the code ABOVE ^ (in lines 24 - 42) ===============
    	 */
        
        /***************************************************************************
         (1) Get the student with the name "Bob" and print his name to the console.
         	 If "Bob" does not exist, print "No student found".
        ****************************************************************************/
        Optional<Student> stud = students.stream()
            .filter(student -> student.getName().equals("Bob"))
            .findFirst();
        System.out.println(stud.isPresent() ? stud.get().getName() : "No student found");
        System.out.println("--------------------");      
 
        /***************************************************************************
         (2) Get the student with matching address "1235" and print their name to the console.
             If the address does not exist, print "No student found".
             HINT: Save students.stream()...etc to an Optional<Student> in the case that the student
             doesn't exist. Resource: https://www.geeksforgeeks.org/java-8-optional-class/
        ****************************************************************************/
        Optional<Student> stud1 = students.stream()
            .filter(student -> student.getAddress().getZipcode().equals("1235"))
            .findFirst();
        System.out.println(stud1.isPresent() ? stud1.get().getName() : "No student found");
        System.out.println("--------------------");
 
        /****************************************************************************
         (3) Get all the students that have the mobile number "3333" and print their
             names to the console.
        *****************************************************************************/
        List<Student> stud2 = students.stream()
            .filter(student111 -> student111.getMobileNumbers().stream().anyMatch(x -> Objects.equals(x.getNumber(), "3333")))
            .collect(Collectors.toList());
 
          String result1 = stud2.stream().map(std -> std.getName()).collect(Collectors.joining(",", "[", "]"));
          System.out.println(result1);
        System.out.println("--------------------");
 
        /***************************************************************************
         (4) Get all student having mobile number "1233" and "1234" and print their
             names to the console.
         ***************************************************************************/
        List<Student> stud3 = students.stream()
            .filter(student -> student.getMobileNumbers().stream().allMatch(x -> Objects.equals(x.getNumber(), "1233") || Objects.equals(x.getNumber(), "1234")))
            .collect(Collectors.toList());
 
        String result4 = stud3.stream().map(std -> std.getName()).collect(Collectors.joining(",", "[", "]"));
        System.out.println(result4);
        System.out.println("--------------------");
 
        /***************************************************************************
	     (5) Create a List<Student> from the List<TempStudent> (using .stream()... only).
	         Hint: Use Collectors.toList().  Print it to the console. 
	         Resource: https://www.geeksforgeeks.org/collectors-tolist-method-in-java-with-examples/
        ****************************************************************************/
        TempStudent tmpStud1 = new TempStudent(
            "Bob1",
            201,
            new Address("12341"),
            Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));
 
        TempStudent tmpStud2 = new TempStudent(
            "Alice1",
            202,
            new Address("12351"),
            Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));
 
        List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);
        
        // Solution here
        List<Student> studentList = tmpStudents.stream()
            .map(tmpStud -> new Student(tmpStud.name, tmpStud.age, tmpStud.address, tmpStud.mobileNumbers))
            .collect(Collectors.toList());
 
        System.out.println(studentList);
        System.out.println("--------------------");
        /***************************************************************************
         (6) Convert the List<Student> (on line 42) to List<String> of just their
             names.  Call this new list "studentNames". Print it to the console.
        ****************************************************************************/
        List<String> studentNames = studentList.stream()
            .map(Student::getName)
            .collect(Collectors.toList());
 
        System.out.println(studentNames.stream().collect(Collectors.joining(",")));
        System.out.println(studentNames.stream().collect(Collectors.joining(",", "[", "]")));
        System.out.println("--------------------");
 
        /***************************************************************************
          (7) Convert List<Students> to a single String called name with just their names.
          	  Print that String to the console.
        ****************************************************************************/
        String name = students.stream()
            .map(Student::getName)
            .collect(Collectors.joining(",", "[", "]"));
        System.out.println(name);
        System.out.println("--------------------");
 
        /****************************************************************************
         (8) Change all the Strings within the List<String> nameList to Upper Case.
             Print it to the screen.
        *****************************************************************************/
        List<String> nameList =
            Arrays.asList("Bob", "Danny", "Alice", "Eddie", "Cathy");
 
        // Solution here
        nameList.stream()
            .map(String::toUpperCase)
            .forEach(System.out::println);
        System.out.println("--------------------");
 
        /****************************************************************************
         (9) Sort List<String> namesList by natural order.
             Hint: Research .sorted() method https://www.geeksforgeeks.org/stream-sorted-in-java/#:~:text=Stream%20sorted()%20returns%20a,streams%2C%20no%20stability%20is%20guaranteed.
         *****************************************************************************/
        List<String> namesList =
            Arrays.asList("Bob", "Danny", "Alice", "Eddie", "Cathy");
 
        // Solution here
        namesList.stream()
            .sorted()
            .forEach(System.out::println);
        System.out.println("--------------------");
 
    }
}