import domain.Dicionario;
import exceptions.PalavraNaoEncontradaException;
import org.junit.Test;
import util.TipoDicionario;

import static org.junit.Assert.assertEquals;

public class DicionarioTest {
    @Test
    public void deveTraduzirCarroELivroDoInglesParaPortuguesEDoPortuguesParaOIngles() throws PalavraNaoEncontradaException {
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavra("Carro", "Car", TipoDicionario.INGLES);
        dicionario.adicionarPalavra("Livro", "Book", TipoDicionario.INGLES);
        dicionario.adicionarPalavra("Tiger", "Tigre", TipoDicionario.PORTUGUES);
        dicionario.adicionarPalavra("Paper", "Papel", TipoDicionario.PORTUGUES);

        assertEquals("Car", dicionario.traduzir("carro", TipoDicionario.INGLES));
        assertEquals("Book", dicionario.traduzir("lIVRO", TipoDicionario.INGLES));

        assertEquals("Papel", dicionario.traduzir("pApEr", TipoDicionario.PORTUGUES));
        assertEquals("Tigre", dicionario.traduzir("TIGER", TipoDicionario.PORTUGUES));
    }
    @Test(expected = PalavraNaoEncontradaException.class)
    public void deveLancarExceptionQuandoUmaPalavraNaoForEncontrada() throws PalavraNaoEncontradaException {
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavra("Carro", "Car", TipoDicionario.INGLES);
        dicionario.adicionarPalavra("Livro", "Book", TipoDicionario.INGLES);

        String traducao = dicionario.traduzir("Caneta", TipoDicionario.INGLES);
    }
    @Test(expected = PalavraNaoEncontradaException.class)
    public void deveLancarExceptionQuandoUmaPalavraNaoForEncontradaEmPortugues() throws PalavraNaoEncontradaException {
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavra("Carro", "Car", TipoDicionario.PORTUGUES);
        dicionario.adicionarPalavra("Livro", "Book", TipoDicionario.PORTUGUES);

        String traducao = dicionario.traduzir("Caneta", TipoDicionario.PORTUGUES);
    }


}
