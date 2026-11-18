import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracao {
    private static Configuracao instancia;

    private String regiaoPadrao;
    private double orcamentoMaximo;

    private Configuracao() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("questao1/config.properties")) {
            props.load(fis);
            this.regiaoPadrao = props.getProperty("regiao.padrao");
            this.orcamentoMaximo = Double.parseDouble(props.getProperty("orcamento.maximo"));
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de configuração: " + e.getMessage());
        }
    }

    public static Configuracao getInstance() {
        if (instancia == null) {
            instancia = new Configuracao();
        }
        return instancia;
    }

    public String getRegiaoPadrao() {
        return regiaoPadrao;
    }

    public double getOrcamentoMaximo() {
        return orcamentoMaximo;
    }
}