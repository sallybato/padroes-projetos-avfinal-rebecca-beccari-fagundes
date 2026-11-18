public class ComissaoEletronicos implements ComissaoStrategy {
    @Override
    public double calcular(double valorVenda) {
        double comissao = valorVenda * 0.12;
        if (comissao < 50.0) {
            return 50.0;
        }
        return comissao;
    }
}