public class Main {
    public static void main(String[] args) throws InterruptedException {
        
        CloudFactory aws = new AwsFactory();
        CloudFactory azure = new AzureFactory();

        Ambiente env1 = new Ambiente("Producao-AWS", "AWS", 1, 10, aws);
        Ambiente env2 = new Ambiente("Teste-AWS", "AWS", 1, 10, aws);
        Ambiente env3 = new Ambiente("Homolog-Azure", "Azure", 1, 10, azure);
        
        // Esse vai ser recusado por estourar o orçamento
        Ambiente env4 = new Ambiente("Dev-Azure", "Azure", 2, 100, azure);

        System.out.println(">>> INICIANDO PROVISIONAMENTOS SIMULTÂNEOS <<<");

        Thread t1 = new Thread(() -> env1.provisionar());
        Thread t2 = new Thread(() -> env3.provisionar());
        
        t1.start();
        t2.start();

        env2.provisionar();
        env4.provisionar();

        t1.join(); 
        t2.join();

        Auditoria.getInstance().imprimirHistorico();
    }
}