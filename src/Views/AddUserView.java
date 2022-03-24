package Views;

import java.util.ArrayList;
import java.util.List;

import Controller.UserController;
import Exceptions.ControllerException;
import Model.ClientModel;
import Model.IUserRole;
import Model.InstructorModel;
import Model.UserModel;
import Scripts.ConsoleScanner;
import Scripts.MenuInteraction;
import Scripts.Singleton;

public class AddUserView extends View {

  public AddUserView() {
    super("Adicionar Usuario");
  }

  private void CreateUserModel(UserModel user) {
    try {
      UserController controller = Singleton.getInstance("UserController");
      controller.AddUser(user);
    } catch (ControllerException e) {
      back(e.getMessage());
    }
  }

  private void CreateClient(UserModel user) {
    clearConsole();
    System.out.println("-======= Adicionar Usuario =======-");
    System.out.println("Qual o horário de entrada do aluno? (HH:mm)");
    String checkIn = ConsoleScanner.string();
    System.out.println("Qual o horário de saída do aluno? (HH:mm)");
    String checkOut = ConsoleScanner.string();

    ClientModel client = new ClientModel(user, checkIn, checkOut);
    try {
      UserController controller = Singleton.getInstance("UserController");
      controller.AddUser(client);
    } catch (ControllerException e) {
      back(e.getMessage());
    }
  }

  private void CreateInstructor(UserModel user) {
    clearConsole();
    System.out.println("-======= Adicionar Usuario =======-");
    System.out.println("Qual o salário do professor?");
    double salary = 0.0;
    while (true) {
      try {
        salary = Double.parseDouble(ConsoleScanner.string());
        break;
      } catch (NumberFormatException e) {
        System.out.println("Entrada invalida!");
      }
    }
    System.out.println("Qual o horário de entrada do professor? (HH:mm)");
    String checkIn = ConsoleScanner.string();
    System.out.println("Qual o horário de saída do professor? (HH:mm)");
    String checkOut = ConsoleScanner.string();
    InstructorModel instructor = new InstructorModel(user, salary, checkIn, checkOut);
    try {
      UserController controller = Singleton.getInstance("UserController");
      controller.AddUser(instructor);
    } catch (ControllerException e) {
      back(e.getMessage());
    }
  }

  private void CreateUser() {
    clearConsole();

    System.out.println("-======= Adicionar Usuario =======-");
    System.out.println("Digite o nome do usuario:");
    String name = ConsoleScanner.string();
    System.out.println("Digite o CPF do usuario:");
    String cpf = ConsoleScanner.string();
    System.out.println("Digite o Telefone do usuario:");
    String phone = ConsoleScanner.string();
    System.out.println("Digite a Senha do usuario:");
    String password = ConsoleScanner.string();
    UserModel user = (UserModel) Singleton.getInstance("LoggedUser");
    List<String> cargos = new ArrayList<String>();
    if (user.getRole() == IUserRole.ADMIN) {
      cargos.add("Administrador");
      cargos.add("Professor");
    }
    if (user.getRole() == IUserRole.COACH || user.getRole() == IUserRole.ADMIN) {
      cargos.add("Aluno");
    }
    int action = MenuInteraction.getInteraction("Selecione o cargo do usuario",
        false, cargos);
    IUserRole cargo = IUserRole.CLIENT;
    switch (action) {
      case 1:
        cargo = IUserRole.ADMIN;
        break;
      case 2:
        cargo = IUserRole.COACH;
        break;
    }
    UserModel user_ = new UserModel(name, cpf, phone, password, cargo);
    if (cargo == IUserRole.COACH)
      CreateInstructor(user_);
    if (cargo == IUserRole.CLIENT)
      CreateClient(user_);
    CreateUserModel(user_);

  }

  @Override
  public void start() {
    CreateUser();
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
