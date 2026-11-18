public class AwsArmazenamento implements Armazenamento {
    private String id;

    public AwsArmazenamento(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public double getCustoGbMes() {
        return 0.023;
    }
}