public class PainelLeiloeiro implements Interessado {
    @Override
    public void atualizar(Lote lote, double novoValor) {
        System.out.println("[PAINEL LEILOEIRO] Lote: " + lote.getNome() + 
                           " | Maior Lance: R$ " + novoValor + 
                           " | Total de Lances: " + lote.getTotalLances());
    }
}