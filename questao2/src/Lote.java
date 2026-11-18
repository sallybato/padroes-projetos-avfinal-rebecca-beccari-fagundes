import java.util.ArrayList;
import java.util.List;

public class Lote {
    private String nome;
    private String categoria;
    private double precoInicial;
    private double precoReserva;
    private double lanceAtual;
    private boolean aberto;
    private int totalLances = 0;
    
    private ComissaoStrategy regraComissao;
    private List<Interessado> interessados = new ArrayList<>();

    public Lote(String nome, String categoria, double precoInicial, double precoReserva) {
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.lanceAtual = precoInicial;
        this.aberto = true;
    }

    public void adicionarInteressado(Interessado i) {
        interessados.add(i);
    }

    public void removerInteressado(Interessado i) {
        interessados.remove(i);
    }

    public void darLance(double valor, Interessado quemDeuOLance) {
        if (!this.aberto) {
            System.out.println("Lote encerrado. Não aceita lances.");
            return;
        }

        if (valor < this.lanceAtual * 1.05) {
            System.out.println("Lance de R$" + valor + " recusado. Mínimo é R$" + (this.lanceAtual * 1.05));
            return;
        }

        this.lanceAtual = valor;
        this.totalLances++;
        System.out.println("Lance de R$" + valor + " aceito para o lote " + this.nome + "!");
        
        notificarInteressados(quemDeuOLance);
    }

    private void notificarInteressados(Interessado quemDeuOLance) {
        for (Interessado i : interessados) {
            if (i != quemDeuOLance) {
                i.atualizar(this, this.lanceAtual);
            }
        }
    }

    public void setRegraComissao(ComissaoStrategy regra) {
        this.regraComissao = regra;
    }

    public void encerrarLote() {
        this.aberto = false;
        
        if (this.lanceAtual >= this.precoReserva) {
            System.out.println("Lote '" + this.nome + "' ENCERRADO E VENDIDO por R$ " + this.lanceAtual);
            
            if (this.regraComissao != null) {
                double comissao = this.regraComissao.calcular(this.lanceAtual);
                double liquido = this.lanceAtual - comissao;
                
                System.out.println("--- ACERTO DO VENDEDOR ---");
                System.out.println("Valor de Venda: R$ " + this.lanceAtual);
                System.out.println("Comissao Cobrada: R$ " + comissao);
                System.out.println("Valor Liquido a Receber: R$ " + liquido);
            }
            
        } else {
            System.out.println("Lote '" + this.nome + "' ENCERRADO E NÃO VENDIDO (Não atingiu a reserva de R$ " + this.precoReserva + ")");
        }
    }
    
    public String getNome() {
         return nome; 
        }
    public double getLanceAtual() {
         return lanceAtual; 
        }
    public double getPrecoReserva() {
         return precoReserva; 
        }
    public String getCategoria() {
         return categoria; 
        }
    public int getTotalLances() {
         return totalLances; 
        }
    public double getPrecoInicial() {
         return precoInicial; 
        }
}