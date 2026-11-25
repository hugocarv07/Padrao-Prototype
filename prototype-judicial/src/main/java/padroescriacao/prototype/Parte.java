package padroescriacao.prototype;

public class Parte implements Cloneable {
    private String nome;
    private Endereco endereco;

    public Parte(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public Parte clone() throws CloneNotSupportedException {
        Parte parteClone = (Parte) super.clone();
        parteClone.endereco = (Endereco) this.endereco.clone();
        return parteClone;
    }

    @Override
    public String toString() {
        return "Parte{" +
                "nome='" + nome + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
