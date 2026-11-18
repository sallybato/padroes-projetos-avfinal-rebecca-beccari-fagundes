public class ComissaoImoveis implements ComissaoStrategy {
    @Override
    public double calcular(double valorVenda) {
        return (valorVenda * 0.03) + 1500.0;
    }
}