public class AzureArmazenamento implements Armazenamento {
    private String id;

    public AzureArmazenamento(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public double getCustoGbMes() {
        return 0.02; 
    }
}