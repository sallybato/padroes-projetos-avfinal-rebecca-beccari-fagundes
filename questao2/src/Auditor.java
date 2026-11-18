import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Auditor implements Interessado {
    @Override
    public void atualizar(Lote lote, double novoValor) {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        System.out.println("[AUDITORIA - " + agora.format(formato) + "] Lote: " + 
                           lote.getNome() + " | Lance Aceito: R$ " + novoValor);
    }
}