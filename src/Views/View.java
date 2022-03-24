package Views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.IUserRole;
import Model.UserModel;
import Scripts.MenuInteraction;
import Scripts.Singleton;

public abstract class View implements Serializable {
  private String name;
  private Map<String, List<IUserRole>> actions;
  private String back;

  public void start() {
    clearConsole();
    List<String> actions_names = new ArrayList<String>();
    List<String> actions_views = new ArrayList<String>();
    UserModel loggedUser = Singleton.getInstance("LoggedUser");
    for (var view : actions.entrySet()) {
      Boolean find = false;
      for (IUserRole role : view.getValue()) {
        if (role == loggedUser.getRole()) {
          find = true;
          break;
        }
      }
      if (find) {
        View tmp = Singleton.getInstance(view.getKey());
        actions_names.add(tmp.name);
        actions_views.add(view.getKey());
      }
    }
    int action = MenuInteraction.getInteraction(name, back != null, actions_names);
    if (action == 0) {
      View tmp = Singleton.getInstance(back);
      tmp.start();
    } else {
      View tmp = Singleton.getInstance(actions_views.get(action - 1));
      tmp.start();
    }
  }

  protected void clearConsole() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public View(String name, Map<String, List<IUserRole>> actions, String back) {
    this.name = name;
    this.actions = actions;
    this.back = back;
  }

  public View(String name, String back) {
    this.name = name;
    this.back = back;
    this.actions = new HashMap<>();
  }

  public View(String name, Map<String, List<IUserRole>> actions) {
    this.name = name;
    this.back = null;
    this.actions = actions;
  }

  public View(String name) {
    this.name = name;
    this.back = null;
    this.actions = new HashMap<>();
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Map<String, List<IUserRole>> getActions() {
    return this.actions;
  }

  public void addActions(String actions, List<IUserRole> roles) {
    this.actions.put(actions, roles);
  }

}
