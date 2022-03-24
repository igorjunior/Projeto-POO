import Model.LocadoraModel;
import Repository.Repository;
import Singleton.Singleton;

public class App {
    public static void main(String[] args) throws Exception {

        Repository<LocadoraModel> test = new Repository<LocadoraModel>("LocadoraRepository");
        test.start();
        Singleton.init("LocadoraRepository", test);
        test = Singleton.getInstance("LocadoraRepository");

        LocadoraModel test_ = new LocadoraModel("Locadora", "CNPJ", "Telefone");
        test.save(test_.getId(), test_);
        System.out.println(test.all().size());
        for (LocadoraModel item : test.all()) {
            System.out.println(item.getCnpj());
        }
    }
}
