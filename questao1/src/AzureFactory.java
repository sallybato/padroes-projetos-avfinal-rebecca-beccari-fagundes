public class AzureFactory extends CloudFactory {
    
    private int contadorVM = 1;
    private int contadorStorage = 1;
    private int contadorFila = 1;

    @Override
    public MaquinaVirtual criarMaquinaVirtual() {
        String id = "vm-" + contadorVM;
        contadorVM++;
        return new AzureMaquinaVirtual(id);
    }

    @Override
    public Armazenamento criarArmazenamento() {
        String id = "blob://" + contadorStorage;
        contadorStorage++;
        return new AzureArmazenamento(id);
    }

    @Override
    public Fila criarFila() {
        String id = "sb-" + contadorFila;
        contadorFila++;
        return new AzureFila(id);
    }
}