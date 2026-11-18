public class AwsFactory extends CloudFactory {
    
    private int contadorVM = 1;
    private int contadorStorage = 1;
    private int contadorFila = 1;

    @Override
    public MaquinaVirtual criarMaquinaVirtual() {
        String id = "i-" + contadorVM;
        contadorVM++;
        return new AwsMaquinaVirtual(id);
    }

    @Override
    public Armazenamento criarArmazenamento() {
        String id = "s3://" + contadorStorage;
        contadorStorage++;
        return new AwsArmazenamento(id);
    }

    @Override
    public Fila criarFila() {
        String id = "sqs-" + contadorFila;
        contadorFila++;
        return new AwsFila(id);
    }
}