# dictionary
Design of a dictionary using Object Oriented Programming concepts in Java language, unit tests and error handling. Object Oriented Programming concepts in Java language and unit tests.
# Dicionário

![dicionario](https://www.xerpa.com.br/blog/wp-content/uploads/sites/2/2019/09/dicionário-de-rh.jpg)

Neste exercício vamos modelar um dicionário que armazena palavras em Português e sua respectiva tradução para o Inglês, bem como palavras do Inglês e sua equivalente em Português.

## Classe Dicionario.java

Esta será a classe central da aplicação e deve possuir como públicos **somente** os métodos explicados abaixo:

### adicionarPalavra()
Inicialmente, nosso dicionário será vazio e, por meio deste método, vamos cadastrando as palavras. Os parametros deste método devem ser a **palavra** do tipo String, a **traducao** desta palavra, também do tipo String, e o **dicionario** no qual ela será vinculada do tipo TipoDicionario.

Por fim, o método deverá possuir a seguinte assinatura: 

`public void adicionarPalavra(String palavra, String traducao, TipoDicionario dicionario)`

### traduzir()
Este método receberá como parâmetro a **palavra** pela qual se busca a tradução e o **dicionario** no qual ela deve ser pesquisada.

Quando a palavra não existir no dicionário pesquisado, o sistema deve lançar uma exceção do tipo `unchecked` chamada `PalavraNaoEncontradaException`. 

O sistema também deve traduzir a palavra sem diferenciar letras maiúsculas e minúsculas.

Por fim, o método deverá possuir a seguinte assinatura: 

`public String traduzir(String palavra, TipoDicionario dicionarioDeBusca)`

## Enumerador TipoDicionario.java
Este enumerador será utilizado para classificar os dicionários de Inglês e Português. Sendo assim, seus valores deverão ser `INGLES` e `PORTUGUES`.

## Mapas
Devem ser utilizados os recursos do Map, conforme vistos em aula, para cadastrar as palavras onde a chave é a palavra pesquisada e o valor a sua tradução. Como dica final, crie um mapa para as palavras em Português e um mapa para as palavras do Inglês.

## Teste de Exemplo

```java
@Test
public void deveTraduzirCarroELivroDoInglesParaPortuguesEDoPortuguesParaOIngles() {
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
public void deveLancarExceptionQuandoUmaPalavraNaoForEncontrada() {
    Dicionario dicionario = new Dicionario();
    dicionario.adicionarPalavra("Carro", "Car", TipoDicionario.INGLES);
    dicionario.adicionarPalavra("Livro", "Book", TipoDicionario.INGLES);

    String traducao = dicionario.traduzir("Caneta", TipoDicionario.INGLES);
}
```
## Testes Obrigatórios

* Devem existir **obrigatóriamente** na solução entregue testes unitários com os seguintes nomes:

    - deveTraduzirCarroELivroDoInglesParaPortuguesEDoPortuguesParaOIngles
    - deveLancarExceptionQuandoUmaPalavraNaoForEncontrada
