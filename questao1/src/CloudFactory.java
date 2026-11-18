public abstract class CloudFactory {
    public abstract MaquinaVirtual criarMaquinaVirtual();
    public abstract Armazenamento criarArmazenamento();
    public abstract Fila criarFila();
}