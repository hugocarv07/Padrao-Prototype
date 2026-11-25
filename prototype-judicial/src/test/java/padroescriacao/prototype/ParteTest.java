package padroescriacao.prototype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParteTest {

    @Test
    void cloneCopiaOEnderecoEmProfundidade() throws CloneNotSupportedException {
        Parte parte = new Parte("Maria Souza", new Endereco("Rua A", 1));

        Parte clone = parte.clone();

        assertNotSame(parte, clone);
        assertNotSame(parte.getEndereco(), clone.getEndereco());
    }

    @Test
    void alterarCloneNaoAlteraOriginal() throws CloneNotSupportedException {
        Parte parte = new Parte("Maria Souza", new Endereco("Rua A", 1));

        Parte clone = parte.clone();
        clone.setNome("João Lima");
        clone.getEndereco().setNumero(2);

        assertEquals("Parte{nome='Maria Souza', endereco=Endereco{logradouro='Rua A', numero=1}}", parte.toString());
        assertEquals("Parte{nome='João Lima', endereco=Endereco{logradouro='Rua A', numero=2}}", clone.toString());
    }
}
