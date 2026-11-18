public class Ambiente {
    private String nome;
    private String provedorNome;
    private int qtdVms;
    private int qtdGb;
    private CloudFactory factory; 

    public Ambiente(String nome, String provedorNome, int qtdVms, int qtdGb, CloudFactory factory) {
        this.nome = nome;
        this.provedorNome = provedorNome;
        this.qtdVms = qtdVms;
        this.qtdGb = qtdGb;
        this.factory = factory;
    }

    public void provisionar() {
        Configuracao config = Configuracao.getInstance();

        MaquinaVirtual vm = factory.criarMaquinaVirtual();
        Armazenamento storage = factory.criarArmazenamento();
        Fila fila = factory.criarFila();

        double custoVms = this.qtdVms * vm.getCustoHora() * 730;
        double custoStorage = this.qtdGb * storage.getCustoGbMes();
        double custoFila = fila.getCustoFixoMes();
        double custoTotal = custoVms + custoStorage + custoFila;

        if (custoTotal > config.getOrcamentoMaximo()) {
            
            Auditoria.getInstance().registrar(this.nome, this.provedorNome, false, 
                "Custo R$" + custoTotal + " ultrapassou o orçamento de R$" + config.getOrcamentoMaximo());
            
            System.out.println("PROVISIONAMENTO RECUSADO: " + this.nome + " (Orçamento excedido)");
            return; 
        }

        Auditoria.getInstance().registrar(this.nome, this.provedorNome, true, "");

        System.out.println("\n--- AMBIENTE PROVISIONADO: " + this.nome + " ---");
        System.out.println("Provedor: " + this.provedorNome);
        System.out.println("Região: " + config.getRegiaoPadrao());
        System.out.println("VM: " + vm.getId());
        System.out.println("Storage: " + storage.getId());
        System.out.println("Fila: " + fila.getId());
        System.out.println("Custo Mensal Estimado: R$ " + String.format("%.2f", custoTotal));
        System.out.println("--------------------------------------------------");
    }
}