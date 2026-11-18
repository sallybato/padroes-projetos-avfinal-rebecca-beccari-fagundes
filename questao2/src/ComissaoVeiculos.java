public class ComissaoVeiculos implements ComissaoStrategy {
    @Override
    public double calcular(double valorVenda) {
        double comissao = valorVenda * 0.08;
        if (comissao > 5000.0) {
            return 5000.0;
        }
        return comissao;
    }
}