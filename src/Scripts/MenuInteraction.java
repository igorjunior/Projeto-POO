package Scripts;

import java.util.List;

public final class MenuInteraction {

  public static int getInteraction(String name, Boolean hasBack, List<String> actions) {
    int action = -1;
    do {
      System.out.println(String.format("|  %s  |", name));
      for (int i = 0; i < actions.size(); i++) {
        System.out.println(String.format("|  %d. %s  |", i + 1, actions.get(i)));
      }
      if (hasBack) {
        System.out.println(String.format("|  0. %s  |", "Voltar"));
      }
      try {
        action = Integer.parseInt(ConsoleScanner.string());
      } catch (NumberFormatException e) {
        action = -1;
      }
      if (action < 0 || action > actions.size()) {
        System.out.println("Entrada inválida!");
      }
    } while (action < 0 || action > actions.size());
    return action;
  }
}
