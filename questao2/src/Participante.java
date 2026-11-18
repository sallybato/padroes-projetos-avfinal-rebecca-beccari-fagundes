public class Participante implements Interessado {
    private String nome;

    public Participante(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(Lote lote, double novoValor) {
        System.out.println("[" + this.nome + "] O lote '" + lote.getNome() + "' recebeu um novo lance de R$ " + novoValor);
    }
}