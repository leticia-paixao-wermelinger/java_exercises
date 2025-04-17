import java.util.Scanner;

class Aviao extends Veiculo {
	private String Prefixo;
	private int DataRevisao;

	public Aviao(String prefixo, int dataRevisao, 
                long capacidadeTanque, int numeroPassageiros, int preco) {
        super(capacidadeTanque, numeroPassageiros, preco);
        setPrefixo(prefixo);
        setDataRevisao(dataRevisao);
    }

	public Aviao() {
		entrada();
	}

	private void entrada() {
		String prefixo;
		int dataRevisao;
		prefixo = get_string("Por favor, indique o prefixo do avião");
		setPrefixo(prefixo);
		dataRevisao = get_int("Por favor, indique a data de revisão do avião");
		setDataRevisao(dataRevisao);
	}

	public String getPrefixo() {
		return Prefixo;
	}

	public int getDataRevisao() {
		return DataRevisao;
	}

	private void setPrefixo(String prefixo) {
		this.Prefixo = prefixo;
	}

	private void setDataRevisao(int dataRevisao) {
		int AnoAtual = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
		if (dataRevisao < 1906 || dataRevisao > AnoAtual) {
			System.out.println("Year must be between 1906 and " + AnoAtual + ".");
		}
		this.DataRevisao = dataRevisao;
	}
	
	private String get_string(String prompt) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(prompt);
		String value = scanner.nextLine();
		return value;
	}

	public void reajustarPreco(double percentual)
	{
		int preco = getPreco();
    	preco = (int) (preco * (1 + percentual / 100.0));
    	super.setPreco(preco);
	}

	@Override
	public void imprimir() {
		System.out.println("\n");
		System.out.println("Avião:");
		System.out.println("Prefixo: " + getPrefixo());
		super.imprimir();
		System.out.println("Data de Revisão: " + getDataRevisao());
		System.out.println("\n");
	}
}