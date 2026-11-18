public abstract class ServicoDecorator implements Fatura {
    protected Fatura fatura;

    public ServicoDecorator(Fatura fatura) {
        this.fatura = fatura;
    }

    @Override
    public String getDescricao() {
        return fatura.getDescricao();
    }

    @Override
    public double getValorTotal() {
        return fatura.getValorTotal();
    }
}