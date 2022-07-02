package repositories;

import java.text.Normalizer;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import entities.Palavra;

public class PalavraRepository {

  public String removerAcentos(String valor) {
    String normalizer = Normalizer.normalize(valor, Normalizer.Form.NFD);
    Pattern pattern = Pattern.compile("[^\\p{ASCII}]");

    return pattern.matcher(normalizer).replaceAll("");
  }

  public Palavra sortearPalavraDicionario(List<Palavra> palavrasDicionario) {
    Collections.shuffle(palavrasDicionario);
    return palavrasDicionario.get(0);
  }

  public boolean verificarPalavraValida(String palavra, List<Palavra> palavrasDicionario) {
    for (Palavra p : palavrasDicionario) {
      if (palavra.contains(p.semAcento)) {
        return true;
      }
    }
    return false;
  }
}
