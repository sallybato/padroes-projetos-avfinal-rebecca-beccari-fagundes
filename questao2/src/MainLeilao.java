public class MainLeilao {
    public static void main(String[] args) {
        
        System.out.println("--- INICIANDO CASA DE LEILOES ---");

        Lote lote1 = new Lote("Quadro Raro", "Arte", 1000.0, 1500.0);
        Lote lote2 = new Lote("iPhone 15", "Eletronicos", 3000.0, 5000.0);

        Participante p1 = new Participante("Ana");
        Participante p2 = new Participante("Beto");
        Participante p3 = new Participante("Carla");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();

        lote1.adicionarInteressado(p1);
        lote1.adicionarInteressado(p2);
        lote1.adicionarInteressado(p3);
        lote1.adicionarInteressado(painel);
        lote1.adicionarInteressado(auditor);

        lote2.adicionarInteressado(p1);
        lote2.adicionarInteressado(p2);
        lote2.adicionarInteressado(painel);
        lote2.adicionarInteressado(auditor);

        System.out.println("\n--- LOTE 1 ---");
        lote1.setRegraComissao(new ComissaoArte());

        lote1.darLance(1020.0, p1); 
        lote1.darLance(1100.0, p1); 
        
        System.out.println("Campanha: Mudando regra de comissao do Lote 1");
        lote1.setRegraComissao(new ComissaoEletronicos());

        lote1.darLance(1600.0, p3); 

        System.out.println("Carla deixou de acompanhar o Lote 1");
        lote1.removerInteressado(p3);

        lote1.darLance(1700.0, p2); 

        lote1.encerrarLote();

        System.out.println("\n--- LOTE 2 ---");
        lote2.setRegraComissao(new ComissaoEletronicos());

        lote2.darLance(3000.0, p3); 
        lote2.darLance(3200.0, p3); 

        lote2.encerrarLote();

        System.out.println("\n--- FATURA DO COMPRADOR ---");
        
        Fatura fatura = new FaturaBase(lote1);
        
        fatura = new Seguro(fatura, lote1);
        fatura = new Certificado(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura = new EmbalagemEspecial(fatura); 

        System.out.println(fatura.getDescricao());
        System.out.println("TOTAL A PAGAR: R$ " + fatura.getValorTotal());
    }
}