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

public class ComputerStore {
	static Computer computer1;
	static Computer computer2;
	static Computer computer3;
	static Computer computer4;

	public static void main(String[] args) {
		// Create a Computer object using the default constructor
		computer1 = new Computer();
		computer2 = new Computer();

		// Create a Computer object using the parameterized constructor
		computer3 = createComputer();
		computer4 = createComputer();

		System.out.println("Computer 1:");
		computer1.printComputer();
		System.out.println("Computer 2:");
		computer2.printComputer();
		System.out.println("Computer 3:");
		computer3.printComputer();
		System.out.println("Computer 4:");
		computer4.printComputer();
	}
	public static Computer createComputer() {
		System.out.println("\n");
		System.out.println("Creating a new computer from Computer Store Class...");
		System.out.println("Please enter the details of the computer.");
		String brand = setBrand();
		String model = setModel();
		int year = setYear();
		String serialNumber = setSerialNumber();
		String processor = setProcessor();
		return new Computer(brand, model, year, serialNumber, processor);
	}

	static public String setBrand() {
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
		return newBrand;
	}

	static public int isValidString(String str, String fieldName) {
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

	static public String setModel() {
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
		return newModel;
	}

	static public int setYear() {
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
		return newYear;
	}

	static public String setSerialNumber() {
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
		return newSerialNumber;
	}

	static public String setProcessor() {
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

		return newProcessor;
	}
}

/*public class ComputerStore {
	private String storeName;
	private String location;
	private Computer[] computers;
	private int computerCount;

	public ComputerStore(String storeName, String location) {
		this.storeName = storeName;
		this.location = location;
		this.computers = new Computer[100]; // Assuming a maximum of 100 computers
		this.computerCount = 0;
	}

	public void addComputer(Computer computer) {
		if (computerCount < computers.length) {
			computers[computerCount++] = computer;
		} else {
			System.out.println("Store is full, cannot add more computers.");
		}
	}

	public void printComputers() {
		System.out.println("Computers in " + storeName + " located at " + location + ":");
		for (int i = 0; i < computerCount; i++) {
			System.out.println(computers[i]);
		}
	}*/