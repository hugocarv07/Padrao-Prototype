package padroescriacao.prototype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoTest {

    @Test
    void cloneEhOutroObjetoComOsMesmosValores() throws CloneNotSupportedException {
        Endereco endereco = new Endereco("Rua A", 1);

        Endereco clone = (Endereco) endereco.clone();

        assertNotSame(endereco, clone);
        assertEquals("Rua A", clone.getLogradouro());
        assertEquals(1, clone.getNumero());
    }

    @Test
    void alterarCloneNaoAlteraOriginal() throws CloneNotSupportedException {
        Endereco endereco = new Endereco("Rua A", 1);

        Endereco clone = (Endereco) endereco.clone();
        clone.setLogradouro("Rua B");
        clone.setNumero(2);

        assertEquals("Endereco{logradouro='Rua A', numero=1}", endereco.toString());
        assertEquals("Endereco{logradouro='Rua B', numero=2}", clone.toString());
    }
}
