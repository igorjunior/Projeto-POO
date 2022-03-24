package Model;

public class UserModel extends Model {

  private String name;
  private String cpf;
  private String phone;
  private String password;
  private IUserRole role;

  public UserModel(String name, String cpf, String phone, String password, IUserRole role) {
    this.name = name;
    this.cpf = cpf;
    this.phone = phone;
    this.password = password;
    this.role = role;
  }

  @Override
  public String getId() {
    return this.cpf;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public IUserRole getRole() {
    return this.role;
  }

  public void setRole(IUserRole role) {
    this.role = role;
  }

}
