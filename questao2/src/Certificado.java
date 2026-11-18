public class Certificado extends ServicoDecorator {
    private double custo = 300.0;

    public Certificado(Fatura fatura) {
        super(fatura);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + Certificado de Autenticidade (R$ " + custo + ")";
    }

    @Override
    public double getValorTotal() {
        return super.getValorTotal() + custo;
    }
}