package Views;

import java.util.ArrayList;

import Controller.UserController;
import Exceptions.ControllerException;
import Model.UserModel;
import Scripts.ConsoleScanner;
import Scripts.MenuInteraction;
import Scripts.Singleton;

public class LoginView extends View {

  public LoginView() {
    super("Efetuar Login");
  }

  private void loginUser() {
    System.out.println("-======= Logar no sistema =======-");
    System.out.println("Digite o seu CPF:");
    String cpf = ConsoleScanner.string();
    System.out.println("Digite a sua senha:");
    String password = ConsoleScanner.string();

    UserController userController = Singleton.getInstance("UserController");
    UserModel cur_user = null;
    try {
      for (UserModel user : userController.GetUsers()) {
        if (user.getCpf().equals(cpf)) {
          cur_user = user;
        }
      }
    } catch (ControllerException e) {
      System.out.println(e.getMessage());
    }
    if (cur_user == null) {
      back("CPF não registrado");
    }
    if (!cur_user.getPassword().equals(password)) {
      back("Senha incorreta");
    }

    Singleton.init("LoggedUser", cur_user);
  }

  @Override
  public void start() {
    loginUser();
  }

  public void back(String message) {
    clearConsole();
    System.out.println(message);
    int action = MenuInteraction.getInteraction("Selecione uma ação", true, new ArrayList<String>());
    if (action == 0)
      start();
    else
      back(message);
  }
}
