import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Auditoria {
    private static Auditoria instancia;
    private List<String> registros;

    private Auditoria() {
        this.registros = new ArrayList<>();
    }

    public static synchronized Auditoria getInstance() {
        if (instancia == null) {
            instancia = new Auditoria();
        }
        return instancia;
    }

    public synchronized void registrar(String nomeAmbiente, String provedor, boolean aceito, String motivo) {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        String resultado = aceito ? "ACEITO" : "RECUSADO (Motivo: " + motivo + ")";
        String linha = "[" + agora.format(formato) + "] Ambiente: " + nomeAmbiente + 
                       " | Provedor: " + provedor + " | Resultado: " + resultado;
        
        registros.add(linha);
    }

    public void imprimirHistorico() {
        System.out.println("\n--- HISTÓRICO DE AUDITORIA ---");
        for (String r : registros) {
            System.out.println(r);
        }
        System.out.println("------------------------------\n");
    }
}