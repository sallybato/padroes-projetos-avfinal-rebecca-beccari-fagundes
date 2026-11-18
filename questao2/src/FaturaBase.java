public class FaturaBase implements Fatura {
    private Lote lote;

    public FaturaBase(Lote lote) {
        this.lote = lote;
    }

    @Override
    public String getDescricao() {
        return "Lote: " + lote.getNome() + " | Valor de Venda: R$ " + lote.getLanceAtual();
    }

    @Override
    public double getValorTotal() {
        return lote.getLanceAtual();
    }
}