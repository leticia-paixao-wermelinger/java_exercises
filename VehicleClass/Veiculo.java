import java.util.Scanner;

class Veiculo {
	private long CapacidadeTanque;
	private int NumeroPassageiros;
	private int Preco;

	public Veiculo(long capacidade, int numeroPassageiros, int preco) {
		setCapacidadeTanque(capacidade);
		setNumeroPassageiros(numeroPassageiros);
		setPreco(preco);
	}

	public Veiculo() {
		entrada();
	}

	private void entrada(){
		long capacidade;
		int passageiros;
		int preco;

		capacidade = get_int("Por favor, indique a capacidade do tanque");
		setCapacidadeTanque(capacidade);
		passageiros = get_int("Por favor, indique o número de passageiros");
		setNumeroPassageiros(passageiros);
		preco = get_int("Por favor, indique o preço do navio");
		setPreco(preco);
	}

	public long getCapacidadeTanque() {
		return CapacidadeTanque;
	}

	public int getNumeroPassageiros() {
		return NumeroPassageiros;
	}

	public int getPreco() {
		return Preco;
	}

	protected void setCapacidadeTanque(long capacidadeTanque) {
		if (capacidadeTanque < 0) {
			System.out.println("Capacidade do tanque não pode ser negativa.");
			capacidadeTanque = 0;
		}
		this.CapacidadeTanque = capacidadeTanque;
	}

	protected void setNumeroPassageiros(int numeroPassageiros) {
		if (numeroPassageiros < 0) {
			System.out.println("Número de passageiros não pode ser negativo.");
			numeroPassageiros = 0;
		}
		this.NumeroPassageiros = numeroPassageiros;
	}

	protected void setPreco(int preco) {
		if (preco < 0) {
			System.out.println("Preço não pode ser negativo.");
			preco = 0;
		}
		this.Preco = preco;
	}

	protected int get_int(String prompt) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(prompt);
		int value = 0;
		try {
			value = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("You must insert a number.");
			return get_int(prompt);
		}
		if (value < 0) {
			System.out.println("You must insert a positive number.");
			return get_int(prompt);
		}
		return value;
	}

	public void imprimir() {
		System.out.println("Número de passageiros: " + getNumeroPassageiros());
		System.out.println("Capacidade do tanque: " + getCapacidadeTanque());
		System.out.println("Preço: " + getPreco());
	}
}