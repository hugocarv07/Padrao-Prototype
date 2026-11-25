package padroescriacao.prototype;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        ProcessoJudicial original = new ProcessoJudicial(
                "0001234-56.2026.8.13.0145",
                "Cobrança indevida",
                "1ª Vara Cível de Juiz de Fora",
                new Parte("Maria Souza", new Endereco("Rua A", 1)));
        original.adicionarDocumento(new Documento("Petição Inicial", "Texto da petição inicial"));
        original.adicionarDocumento(new Documento("Procuração", "Texto da procuração"));

        ProcessoJudicial recurso = original.clone();
        recurso.setNumero("0001234-56.2026.8.13.0145-REC");
        recurso.setVara("Turma Recursal");
        recurso.getRequerente().getEndereco().setNumero(2);
        recurso.adicionarDocumento(new Documento("Razões do Recurso", "Texto do recurso"));

        System.out.println(original);
        System.out.println(recurso);
    }
}
