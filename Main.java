import java.io.File;
import java.util.List;
import java.util.Scanner;

import entities.Palavra;
import repositories.PalavraRepository;
import util.Arquivo;

public class Main {

  public static void main(String[] args) {
    int tentativas = 6;

    try { 
      Scanner sc = new Scanner(System.in);
      PalavraRepository pRepository = new PalavraRepository();

      List<Palavra> palavrasDicionario = new Arquivo().ler(new File("dicionario.txt"));
      Palavra palavraDicionario = pRepository.sortearPalavraDicionario(palavrasDicionario);

      String palavraUsuario;

      boolean erro = false;
      while (tentativas != 0) {
        System.out.println("\nNúmero de tentativas restantes: " + tentativas);
        System.out.print("Digite uma palavra de 5 letras: ");
        palavraUsuario = pRepository.removerAcentos(sc.nextLine().toUpperCase());
  
        if (palavraUsuario.length() != 5) {
          System.out.println("\nInsira uma palavra com 5 letras.");
          erro = true;
        } else if (!pRepository.verificarPalavraValida(palavraUsuario, palavrasDicionario)) {
          System.out.println("\nInsira uma palavra válida.");
          erro = true;
        } else {
          erro = false;
        }

        if (!erro) {
          String resultado = new Checar().resultados(palavraUsuario, palavraDicionario);

          if (resultado.equals("CCCCC")) {
            System.out.println("\nParabéns você conseguiu adivinhar a palavra!");
            sc.close();
            return;
          }
  
          tentativas--;
        }
      }
      sc.close();
      System.out.println("\nVocê não conseguiu adivinhar a palavra. A palavra era: " + palavraDicionario.nome);
    } catch (Exception e) {
      System.err.println("\nErro inesperado: " + e.getLocalizedMessage());
      return;
    }
  }
}
