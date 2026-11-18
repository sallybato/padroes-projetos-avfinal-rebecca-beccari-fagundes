public class AwsFila implements Fila {
    private String id;

    public AwsFila(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public double getCustoFixoMes() {
        return 0.40;
    }
}