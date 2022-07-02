package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Palavra;
import repositories.PalavraRepository;

public class Arquivo {

  public List<Palavra> ler(File file) {
    List<Palavra> listaPalavras = new ArrayList<>();

    try {
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        String palavra = scanner.nextLine().toUpperCase();
        if (palavra.length() == 5) {
          Palavra p = new Palavra(palavra, new PalavraRepository().removerAcentos(palavra));
          listaPalavras.add(p);
        }
      }
      scanner.close();
    } catch (Exception e) {
      System.err.println("Erro ao ler arquivo: " + e.getLocalizedMessage());
    }

    return listaPalavras;
  }
}
