import entities.Palavra;

public class Checar {

  public String resultados(String palavraUsuario, Palavra palavraDicionario) {
    char[] palavraUsuarioCharArray = palavraUsuario.toCharArray();
    char[] palavraDicionarioCharArray = palavraDicionario.semAcento.toCharArray();

    String resultado = "";
    boolean existe = false;

    for(int i = 0; i < 5; i++) {
      if (palavraUsuarioCharArray[i] == palavraDicionarioCharArray[i]) {
        resultado += "C";
      } else {
        for(int j = 0; j < 5; j++) {
          if (palavraUsuarioCharArray[i] == palavraDicionarioCharArray[j]) {
            existe = true;
            break;
          }
        }
        if (existe == true) {
          resultado += "E";
        } else {
          resultado += "?";
        }
        existe = false;
      }
    }

    System.out.println("\nPalavra informada: " + palavraUsuario);
    System.out.println("Palavra no dicionário: " + palavraDicionario.nome);
    System.out.println("\nLegenda: (C = letra existe na posição certa, E = letra existe, ? = letra não existe)\nResultado: " + resultado);

    return resultado;
  }
}
