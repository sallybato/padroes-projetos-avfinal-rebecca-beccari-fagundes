public class ComissaoArte implements ComissaoStrategy {
    @Override
    public double calcular(double valorVenda) {
        return valorVenda * 0.20;
    }
}