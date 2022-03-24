package Views;

import java.util.ArrayList;
import java.util.List;

import Model.IUserRole;

public class MainView extends View {

  public MainView() {
    super("Painel do Usuario", "LoginView");
    List<IUserRole> roles = new ArrayList<IUserRole>();
    roles.add(IUserRole.ADMIN);
    roles.add(IUserRole.COACH);
    this.addActions("UsersView", roles);
    roles.clear();
    roles.add(IUserRole.ADMIN);
    this.addActions("ExercisesView", roles);
    roles.clear();
    roles.add(IUserRole.CLIENT);
    this.addActions("TrainsView", roles);
  }
}
