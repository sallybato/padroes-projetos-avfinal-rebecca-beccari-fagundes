public class EmbalagemEspecial extends ServicoDecorator {
    private double custo = 180.0;

    public EmbalagemEspecial(Fatura fatura) {
        super(fatura);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + Embalagem Especial (R$ " + custo + ")";
    }

    @Override
    public double getValorTotal() {
        return super.getValorTotal() + custo;
    }
}