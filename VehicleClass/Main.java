class Main {
    public static void main(String[] args) {
        int quantidadeNavios = 5;
        int quantidadeAvioes = 5;
        
        System.out.println("\nCriando veículo básico com construtor parametrizado...");
        Veiculo veiculo = new Veiculo(5000L, 5, 50000);
        veiculo.imprimir();
		System.out.println("\n");

        Navio[] navios = criarNaviosTeste(quantidadeNavios);
        Aviao[] avioes = criarAvioesTeste(quantidadeAvioes);
        
        System.out.println("=== TESTANDO NAVIOS ===");
        testarNavios(navios);
        
        System.out.println("\n=== TESTANDO AVIÕES ===");
        testarAvioes(avioes);
        
        System.out.println("\n=== REAJUSTE DE PREÇOS ===");
        reajustarPrecosVeiculos(navios, avioes, 10.0);
        
        System.out.println("\n=== DADOS APÓS REAJUSTE ===");
        mostrarTodosVeiculos(navios, avioes);
        
        System.out.println("\n=== TESTES ESPECÍFICOS ===");
        testarMetodosEspecificos(navios, avioes);
    }
    
    private static Navio[] criarNaviosTeste(int quantidade) {
        Navio[] navios = new Navio[quantidade];
        String[] nomes = {"Titanic", "Queen Mary", "Noah's Ark", "Black Pearl", "Flying Dutchman"};
        int[] tripulantes = {1000, 1200, 50, 200, 150};
        int[] anos = {1912, 1936, 3000, 1750, 1720};
        long[] capacidades = {5000, 6000, 3000, 2000, 2500};
        int[] passageiros = {2000, 2500, 100, 500, 400};
        int[] precos = {10000000, 12000000, 5000000, 3000000, 3500000};
        
        for (int i = 0; i < quantidade; i++) {
            navios[i] = new Navio(nomes[i], tripulantes[i], anos[i], capacidades[i], passageiros[i], precos[i]);
        }
        return navios;
    }
    
    private static Aviao[] criarAvioesTeste(int quantidade) {
        Aviao[] avioes = new Aviao[quantidade];
        String[] prefixos = {"PT-ABC", "PT-DEF", "PT-GHI", "PT-JKL", "PT-MNO"};
        int[] anos = {2020, 2018, 2022, 2015, 2023};
        long[] capacidades = {10000, 12000, 15000, 8000, 9000};
        int[] passageiros = {150, 200, 250, 120, 180};
        int[] precos = {50000000, 60000000, 75000000, 40000000, 45000000};
        
        for (int i = 0; i < quantidade; i++) {
            avioes[i] = new Aviao(prefixos[i], anos[i], capacidades[i], passageiros[i], precos[i]);
        }
        return avioes;
    }
    
    private static void testarNavios(Navio[] navios) {
        for (int i = 0; i < navios.length; i++) {
            System.out.println("\nNavio #" + (i+1) + ":");
            navios[i].imprimir();
            
            int ratio = navios[i].passageirosPorTripulantes();
            System.out.println("Razão passageiros/tripulantes: " + ratio);
        }
    }
    
    private static void testarAvioes(Aviao[] avioes) {
        for (int i = 0; i < avioes.length; i++) {
            System.out.println("\nAvião #" + (i+1) + ":");
            avioes[i].imprimir();
        }
    }
    
    private static void reajustarPrecosVeiculos(Navio[] navios, Aviao[] avioes, double percentual) {
        System.out.println("Aplicando reajuste de " + percentual + "% a todos os veículos...");
        
        for (Navio navio : navios) {
            int precoAntigo = navio.getPreco();
            navio.setPreco((int)(precoAntigo * (1 + percentual/100)));
			System.out.println("Navio " + navio.getNome() + " - Preço antigo: " + precoAntigo + ", Novo preço: " + navio.getPreco());
        }
        
        for (Aviao aviao : avioes) {
			int precoAntigo = aviao.getPreco();
            aviao.reajustarPreco(percentual);
			System.out.println("Avião " + aviao.getPrefixo() + " - Preço antigo: " + precoAntigo + ", Novo preço: " + aviao.getPreco());
        }
    }
    
    private static void mostrarTodosVeiculos(Navio[] navios, Aviao[] avioes) {
        System.out.println("=== NAVIOS ===");
        for (Navio navio : navios) {
            navio.imprimir();
        }
        
        System.out.println("\n=== AVIÕES ===");
        for (Aviao aviao : avioes) {
            aviao.imprimir();
        }
    }
    
    private static void testarMetodosEspecificos(Navio[] navios, Aviao[] avioes) {
        System.out.println("\nTestando navio com dados inválidos:");
        Navio navioInvalido = new Navio("Navio Fantasma", -10, -100, -500, -200, -1000000);
        navioInvalido.imprimir();
        
        System.out.println("\nTestando avião com dados inválidos:");
        Aviao aviaoInvalido = new Aviao("", 3000, -1000, -150, -5000000);
        aviaoInvalido.imprimir();
        
        System.out.println("\nTestando reajuste com percentual negativo:");
        Aviao aviaoTeste = avioes[0];
        int precoOriginal = aviaoTeste.getPreco();
        System.out.println("Preço original: " + precoOriginal);
        aviaoTeste.reajustarPreco(-50);
        System.out.println("Preço após reajuste negativo: " + aviaoTeste.getPreco());
        aviaoTeste.setPreco(precoOriginal);
        
        System.out.println("\nTestando maior navio por capacidade:");
        Navio maiorNavio = navios[0];
        for (Navio navio : navios) {
            if (navio.getCapacidadeTanque() > maiorNavio.getCapacidadeTanque()) {
                maiorNavio = navio;
            }
        }
        System.out.println("Maior navio (capacidade): " + maiorNavio.getNome() + 
                         " com " + maiorNavio.getCapacidadeTanque() + " litros");
    }
}