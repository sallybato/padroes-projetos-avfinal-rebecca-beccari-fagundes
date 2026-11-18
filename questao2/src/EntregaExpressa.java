public class EntregaExpressa extends ServicoDecorator {
    private double custo = 450.0;

    public EntregaExpressa(Fatura fatura) {
        super(fatura);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + Entrega Expressa (R$ " + custo + ")";
    }

    @Override
    public double getValorTotal() {
        return super.getValorTotal() + custo;
    }
}