public class AwsMaquinaVirtual implements MaquinaVirtual {
    private String id;

    public AwsMaquinaVirtual(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public double getCustoHora() {
        return 0.10;
    }
}