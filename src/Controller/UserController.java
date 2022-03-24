package Controller;

import java.util.ArrayList;
import java.util.List;

import Exceptions.ControllerException;
import Exceptions.RepositoryException;
import Model.ClientModel;
import Model.InstructorModel;
import Model.UserModel;
import Repository.Repository;
import Scripts.ParseCPF;
import Scripts.ParseHour;
import Scripts.Singleton;

public class UserController extends Controller {

  public void AddUser(UserModel user) throws ControllerException {
    if (!ParseCPF.checkCPF(user.getCpf()))
      throw new ControllerException("UserController", "AddUser", "O CPF é inválido");

    Repository<UserModel> userRepository = Singleton.getInstance("UserRepository");
    try {
      if (userRepository.find(user.getId()) != null)
        throw new ControllerException("UserController", "AddUser", "O Usuário já está cadastrado");
      userRepository.save(user.getId(), user);
    } catch (RepositoryException e) {
      System.out.println(e.getMessage());
    }
  }

  public void AddUser(ClientModel user) throws ControllerException {
    if (!ParseHour.checkHour(user.getCheckIn()))
      throw new ControllerException("UserController", "AddUser", "O Horário de entrada é inválido");
    if (!ParseHour.checkHour(user.getCheckOut()))
      throw new ControllerException("UserController", "AddUser", "O Horário de saída é inválido");
    AddUser((UserModel) user);
  }

  public void AddUser(InstructorModel user) throws ControllerException {
    if (!ParseHour.checkHour(user.getCheckIn()))
      throw new ControllerException("UserController", "AddUser", "O Horário de entrada é inválido");
    if (!ParseHour.checkHour(user.getCheckOut()))
      throw new ControllerException("UserController", "AddUser", "O Horário de saída é inválido");
    AddUser((UserModel) user);
  }

  public List<UserModel> GetUsers() throws ControllerException {
    Repository<UserModel> userRepository = Singleton.getInstance("UserRepository");
    try {
      return userRepository.all();
    } catch (RepositoryException e) {
      System.out.println(e.getMessage());
    }
    return new ArrayList<UserModel>();
  }

}
