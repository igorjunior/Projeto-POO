package Model;

public class InstructorModel extends UserModel {

  private double salary;
  private String checkIn;
  private String checkOut;

  public InstructorModel(String name, String cpf, String phone, String password, IUserRole role, double salary,
      String checkIn, String checkOut) {
    super(name, cpf, phone, password, role);
    this.salary = salary;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }

  public InstructorModel(UserModel model, double salary, String checkIn, String checkOut) {
    super(model.getName(), model.getCpf(), model.getPhone(), model.getPassword(), model.getRole());
    this.salary = salary;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public Double getSalary() {
    return this.salary;
  }

  public void setCheckIn(String checkIn) {
    this.checkIn = checkIn;
  }

  public String getCheckIn() {
    return this.checkIn;
  }

  public void setCheckOut(String checkOut) {
    this.checkOut = checkOut;
  }

  public String getCheckOut() {
    return this.checkOut;
  }
}