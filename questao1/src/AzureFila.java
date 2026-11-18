public class AzureFila implements Fila {
    private String id;

    public AzureFila(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public double getCustoFixoMes() {
        return 0.50; 
    }
}