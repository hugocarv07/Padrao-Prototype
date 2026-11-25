package padroescriacao.prototype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessoJudicialTest {

    private ProcessoJudicial processo;

    @BeforeEach
    void preparar() {
        processo = new ProcessoJudicial("0001", "Cobrança indevida", "1ª Vara Cível",
                new Parte("Maria Souza", new Endereco("Rua A", 1)));
        processo.adicionarDocumento(new Documento("Petição Inicial", "texto inicial"));
        processo.adicionarDocumento(new Documento("Procuração", "texto procuração"));
    }

    @Test
    void cloneTemOsMesmosDadosDoOriginal() throws CloneNotSupportedException {
        ProcessoJudicial clone = processo.clone();

        assertNotSame(processo, clone);
        assertEquals(processo.toString(), clone.toString());
    }

    @Test
    void alterarCamposSimplesDoCloneNaoAlteraOriginal() throws CloneNotSupportedException {
        ProcessoJudicial clone = processo.clone();
        clone.setNumero("0001-REC");
        clone.setAssunto("Recurso");
        clone.setVara("Turma Recursal");

        assertEquals("0001", processo.getNumero());
        assertEquals("Cobrança indevida", processo.getAssunto());
        assertEquals("1ª Vara Cível", processo.getVara());
    }

    @Test
    void parteEEnderecoSaoCopiadosEmProfundidade() throws CloneNotSupportedException {
        ProcessoJudicial clone = processo.clone();
        clone.getRequerente().setNome("João Lima");
        clone.getRequerente().getEndereco().setNumero(2);

        assertNotSame(processo.getRequerente(), clone.getRequerente());
        assertEquals("Maria Souza", processo.getRequerente().getNome());
        assertEquals(1, processo.getRequerente().getEndereco().getNumero());
        assertEquals("João Lima", clone.getRequerente().getNome());
        assertEquals(2, clone.getRequerente().getEndereco().getNumero());
    }

    @Test
    void listaDeDocumentosEhIndependente() throws CloneNotSupportedException {
        ProcessoJudicial clone = processo.clone();
        clone.adicionarDocumento(new Documento("Razões do Recurso", "texto recurso"));

        assertEquals(2, processo.getDocumentos().size());
        assertEquals(3, clone.getDocumentos().size());
        assertNotSame(processo.getDocumentos(), clone.getDocumentos());
    }

    @Test
    void documentosSaoCopiadosEmProfundidade() throws CloneNotSupportedException {
        ProcessoJudicial clone = processo.clone();
        clone.getDocumentos().get(0).setConteudo("conteúdo alterado");

        assertNotSame(processo.getDocumentos().get(0), clone.getDocumentos().get(0));
        assertEquals("texto inicial", processo.getDocumentos().get(0).getConteudo());
        assertEquals("conteúdo alterado", clone.getDocumentos().get(0).getConteudo());
    }

    @Test
    void toStringDoOriginalEDoCloneAposAlteracoes() throws CloneNotSupportedException {
        ProcessoJudicial clone = processo.clone();
        clone.setNumero("0001-REC");
        clone.getRequerente().getEndereco().setNumero(2);

        assertEquals("ProcessoJudicial{numero='0001', assunto='Cobrança indevida', vara='1ª Vara Cível', "
                + "requerente=Parte{nome='Maria Souza', endereco=Endereco{logradouro='Rua A', numero=1}}, "
                + "documentos=[Documento{titulo='Petição Inicial', conteudo='texto inicial'}, "
                + "Documento{titulo='Procuração', conteudo='texto procuração'}]}", processo.toString());
        assertEquals("ProcessoJudicial{numero='0001-REC', assunto='Cobrança indevida', vara='1ª Vara Cível', "
                + "requerente=Parte{nome='Maria Souza', endereco=Endereco{logradouro='Rua A', numero=2}}, "
                + "documentos=[Documento{titulo='Petição Inicial', conteudo='texto inicial'}, "
                + "Documento{titulo='Procuração', conteudo='texto procuração'}]}", clone.toString());
    }

    @Test
    void cloneDeCloneContinuaIndependente() throws CloneNotSupportedException {
        ProcessoJudicial primeiro = processo.clone();
        ProcessoJudicial segundo = primeiro.clone();
        segundo.getRequerente().getEndereco().setLogradouro("Rua Z");

        assertEquals("Rua A", processo.getRequerente().getEndereco().getLogradouro());
        assertEquals("Rua A", primeiro.getRequerente().getEndereco().getLogradouro());
        assertEquals("Rua Z", segundo.getRequerente().getEndereco().getLogradouro());
    }
}
