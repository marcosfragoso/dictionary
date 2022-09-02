package domain;

import exceptions.PalavraNaoEncontradaException;
import util.TipoDicionario;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> palavrasPortugues = new HashMap<>();
    private Map<String, String> palavrasIngles = new HashMap<>();

    public void adicionarPalavra(String palavra, String traducao, TipoDicionario dicionario){
        switch (dicionario){
            case PORTUGUES:
                this.palavrasPortugues.put(palavra.toLowerCase(), traducao);
                break;
            case INGLES:
                this.palavrasIngles.put(palavra.toLowerCase(), traducao);
                break;
        }
    }
    public String traduzir(String palavra, TipoDicionario dicionarioDeBusca) throws PalavraNaoEncontradaException {

        String palavraTraduzida = null;

        switch (dicionarioDeBusca){
            case PORTUGUES:
                if(!this.palavrasPortugues.containsKey(palavra.toLowerCase())){
                    throw new PalavraNaoEncontradaException();
                } else {
                    palavraTraduzida = this.palavrasPortugues.get(palavra.toLowerCase());
                }
                break;
            case INGLES:
                if(!this.palavrasIngles.containsKey(palavra.toLowerCase())){
                    throw new PalavraNaoEncontradaException();
                } else {
                    palavraTraduzida = this.palavrasIngles.get(palavra.toLowerCase());
                }
                break;
        }
        return palavraTraduzida;
    }

}