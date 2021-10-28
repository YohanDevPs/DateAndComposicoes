package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.WorkerLevel;


public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("hh/MM/yyyy");
		
		System.out.print("Enter department name: ");
		String nameDepartment = sc.nextLine();		
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String nameWorker = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(nameWorker, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(nameDepartment));
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		List<HourContract> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter contract #"+(i+1)+" data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours):" );
			int hours = sc.nextInt();
			
			HourContract hourContract = new HourContract(contractDate, valuePerHour, hours);
			
			worker.addContract(hourContract);
			}
		
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
	
		String month_year = sc.next();
	
		int month = Integer.parseInt(month_year.substring(0, 2));
		int year = Integer.parseInt(month_year.substring(3));
		
		System.out.println("Name: "+worker.getName());
		System.out.println("Department: "+worker.getDepartment().getName());
		System.out.print("Income for "+ month+"/"+ year +": "+ String.format("%.2f", worker.income(year, month)));
		
		
		sc.close();
	}
}

