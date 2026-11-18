public class Seguro extends ServicoDecorator {
    private double custo;

    public Seguro(Fatura fatura, Lote lote) {
        super(fatura);
        this.custo = lote.getLanceAtual() * 0.015;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + Seguro de Transporte (R$ " + custo + ")";
    }

    @Override
    public double getValorTotal() {
        return super.getValorTotal() + custo;
    }
}