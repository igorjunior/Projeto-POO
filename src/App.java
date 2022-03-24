
import Controller.UserController;
import Exceptions.RepositoryException;
import Model.IUserRole;
import Model.UserModel;
import Repository.Repository;
import Scripts.Singleton;
import Views.AddUserView;
import Views.LoginView;
import Views.MainView;
import Views.View;

public class App {
    private void RegisterRepositories() {
        Repository<UserModel> repo = new Repository<UserModel>("UserRepository");
        repo.start();
        Singleton.init("UserRepository", repo);
    }

    private void RegisterControllers() {
        Singleton.init("UserController", new UserController());
    }

    private void RegisterViews() {
        Singleton.init("AddUserView", new AddUserView());
        Singleton.init("MainView", new MainView());
        Singleton.init("LoginView", new LoginView());
    }

    private void RegisterMainAdmin() {
        UserModel user = new UserModel("Admin", "0", "0", "admin", IUserRole.ADMIN);
        Repository<UserModel> userRepository = Singleton.getInstance("UserRepository");
        try {
            userRepository.save(user.getId(), user);
        } catch (RepositoryException e) {
            System.out.println(e.getMessage());
        }
    }

    public void StartApp() {
        RegisterRepositories();
        RegisterControllers();
        RegisterViews();
        RegisterMainAdmin();
        View view = Singleton.getInstance("LoginView");
        view.start();
        view = Singleton.getInstance("MainView");
        view.start();
    }

    public static void main(String[] args) {
        App app = new App();
        app.StartApp();
    }
}
