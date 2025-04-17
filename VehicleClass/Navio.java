import java.util.Scanner;

class Navio extends Veiculo {
	private String Nome;
	private int NumeroTripulantes;
	private int DataLancamento;

	public Navio(String nome, int numeroTripulantes, int dataLancamento, 
                long capacidadeTanque, int numeroPassageiros, int preco) {
        super(capacidadeTanque, numeroPassageiros, preco);
        setNome(nome);
        setNumeroTripulantes(numeroTripulantes);
        setDataLancamento(dataLancamento);
    }

	public Navio() {
		entrada();
	}

	private void entrada() {
		String nome;
		int tripulantes;
		int dataLancamento;

		nome = get_string("Por favor, indique o nome do navio");
		setNome(nome);
		tripulantes = get_int("Por favor, indique o número de tripulantes");
		setNumeroTripulantes(tripulantes);
		dataLancamento = get_int("Por favor, indique a data de lançamento do navio");
		setDataLancamento(dataLancamento);
	}

	public String getNome() {
		return Nome;
	}

	public int getNumeroTripulantes() {
		return NumeroTripulantes;
	}

	public int getDataLancamento() {
		return DataLancamento;
	}

	private void setNome(String nome) {
		this.Nome = nome;
	}

	private void setNumeroTripulantes(int numeroTripulantes) {
		if (numeroTripulantes < 0) {
			System.out.println("Número de tripulantes não pode ser negativo.");
			numeroTripulantes = 0;
		}
		this.NumeroTripulantes = numeroTripulantes;
	}

	private void setDataLancamento(int dataLancamento) {
		this.DataLancamento = dataLancamento;
	}

	private String get_string(String prompt) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(prompt);
		String value = scanner.nextLine();
		return value;
	}

	public int passageirosPorTripulantes()
	{
		int passageirosPorTripulantes = getNumeroPassageiros() / getNumeroTripulantes();
		return passageirosPorTripulantes;
	}

    @Override
	public void imprimir() {
		System.out.println("\n");
		System.out.println("Navio:");
		System.out.println("Nome: " + getNome());
		System.out.println("Número de Tripulantes: " + getNumeroTripulantes());
		super.imprimir();
		System.out.println("Data de Lançamento: " + getDataLancamento());
		System.out.println("\n");
	}
}