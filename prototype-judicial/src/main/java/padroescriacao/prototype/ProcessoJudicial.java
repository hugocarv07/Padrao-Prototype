package padroescriacao.prototype;

import java.util.ArrayList;
import java.util.List;

public class ProcessoJudicial implements Cloneable {
    private String numero;
    private String assunto;
    private String vara;
    private Parte requerente;
    private List<Documento> documentos;

    public ProcessoJudicial(String numero, String assunto, String vara, Parte requerente) {
        this.numero = numero;
        this.assunto = assunto;
        this.vara = vara;
        this.requerente = requerente;
        this.documentos = new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getVara() {
        return vara;
    }

    public void setVara(String vara) {
        this.vara = vara;
    }

    public Parte getRequerente() {
        return requerente;
    }

    public void setRequerente(Parte requerente) {
        this.requerente = requerente;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void adicionarDocumento(Documento documento) {
        this.documentos.add(documento);
    }

    @Override
    public ProcessoJudicial clone() throws CloneNotSupportedException {
        ProcessoJudicial processoClone = (ProcessoJudicial) super.clone();
        processoClone.requerente = this.requerente.clone();
        processoClone.documentos = new ArrayList<>();
        for (Documento documento : this.documentos) {
            processoClone.documentos.add(documento.clone());
        }
        return processoClone;
    }

    @Override
    public String toString() {
        return "ProcessoJudicial{" +
                "numero='" + numero + '\'' +
                ", assunto='" + assunto + '\'' +
                ", vara='" + vara + '\'' +
                ", requerente=" + requerente +
                ", documentos=" + documentos +
                '}';
    }
}
