public class AzureMaquinaVirtual implements MaquinaVirtual {
    private String id;

    public AzureMaquinaVirtual(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public double getCustoHora() {
        return 0.12; 
    }
}