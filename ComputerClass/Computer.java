/**
 * Universidade Veiga de Almeida
 * Curso: Análise e Desenvolvimento de Sistemas
 * Disciplina: Programação Orientada a Objetos I (E90100024)
 * Professora: Itala Freire De Macedo
 * Estudante: Letícia Paixão Wermelinger
 * Matrícula: 1240210571
 * Data: 30/03/2025
 */

import java.util.Scanner;

public class Computer {
	private String brand;
	private String model;
	private int year;
	private String serialNumber;
	private String processor;

	public Computer() {
		System.out.println("\n");
		System.out.println("Creating a new computer from Computer Class...");
		System.out.println("Please enter the details of the computer.");
        setBrand();
        setModel();
        setYear();
        setSerialNumber();
        setProcessor();
		System.out.println("\n");
    }

	public Computer(String brand, String model, int year, String serialNumber, String processor) {
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.serialNumber = serialNumber;
		this.processor = processor;
	}

	// SETTERS
	private void setBrand() {
		String newBrand = "";
		boolean isValid = false;
		while (isValid == false) {
			System.out.print("Enter the brand of the computer: ");
			Scanner scanner = new Scanner(System.in);
			newBrand = scanner.nextLine();
			if (isValidString(newBrand, "Brand") == 1) {
				isValid = true;
			}
		}
		this.brand = newBrand;
	}

	private int isValidString(String str, String fieldName) {
		if (str.isEmpty() || str.isBlank()) {
			System.out.println(fieldName + " cannot be empty.");
			return 0;
		} else if (str.length() > 20) {
			System.out.println(fieldName + " name is too long. Maximum length is 20 characters.");
			return 0;
		} else if (!str.matches("[a-zA-Z0-9 ]+")) {
			System.out.println(fieldName + " name can only contain letters, numbers, and spaces.");
			return 0;
		}
		return 1;
	}

	private void setModel() {
		String newModel = "";
		boolean isValid = false;
		while (isValid == false) {
			System.out.print("Enter the model of the computer: ");
			Scanner scanner = new Scanner(System.in);
			newModel = scanner.nextLine();
			if (isValidString(newModel, "Model") == 1) {
				isValid = true;
			}
		}
		this.model = newModel;
	}

	private void setYear() {
		int newYear = 0;
		int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
		boolean isValid = false;
		while (isValid == false) {
			System.out.print("Enter the year of the manufacture: ");
			Scanner scanner = new Scanner(System.in);
			try {
				newYear = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Year must be a number.");
				continue;
			}
			if (newYear < 1990 || newYear > currentYear) {
				System.out.println("Year must be between 1900 and " + currentYear + ".");
			} else {
				isValid = true;
			}
		}		
		this.year = newYear;
	}

	private void setSerialNumber() {
		String newSerialNumber = "";
		boolean isValid = false;
		while (isValid == false) {
			System.out.print("Enter the serial number of the computer: ");
			Scanner scanner = new Scanner(System.in);
			newSerialNumber = scanner.nextLine();
			if (isValidString(newSerialNumber, "Serial Number") == 1) {
				isValid = true;
			}
		}
		this.serialNumber = newSerialNumber;
	}

	private void setProcessor() {
		String newProcessor = "";
		boolean isValid = false;
		while (isValid == false) {
			System.out.print("Enter the processor type: ");
			Scanner scanner = new Scanner(System.in);
			newProcessor = scanner.nextLine();
			if (isValidString(newProcessor, "Processor") == 1) {
				isValid = true;
			}
		}

		this.processor = newProcessor;
	}

	// GETTERS
	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public String getProcessor() {
		return processor;
	}

	// PRINT METHOD
	public void printComputer() {
		System.out.println("Brand: " + getBrand());
		System.out.println("Model: " + getModel());
		System.out.println("Year: " + getYear());
		System.out.println("Serial Number: " + getSerialNumber());
		System.out.println("Processor: " + getProcessor());
		System.out.println();
	}
}