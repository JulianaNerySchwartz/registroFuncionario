package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entitties.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Integer n, i;
		String name;
		Double salary, percentage;
		
		System.out.print("How many employees will be registered? ");
		n = sc.nextInt();
		
		List<Employee> list = new ArrayList<>(); 
		
		//Reading data
		
		for (i = 1; i <=n; i++ ) {
			System.out.println();
			
			System.out.printf("Employee #%d%nId: ", i);
			int id = sc.nextInt();
			
			System.out.print("Name: ");
			sc.nextLine();
			name = sc.nextLine();
			
			System.out.print("Salary: ");
			salary = sc.nextDouble();
			
			list.add(new Employee(name, salary, id));
		}
		
		//Increase salary
		
		System.out.println();
		
		System.out.print("Enter the employee id that will  have salary increase: ");
		int id = sc.nextInt();
		
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		
		if (emp == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}
		
		//Print results
		
		System.out.println();
		
		System.out.println("List of employees: ");
		for (Employee x : list) {
			System.out.println(x.toString());
		}
		
		sc.close();
		
	}

}
