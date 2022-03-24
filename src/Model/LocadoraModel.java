package Model;

public class LocadoraModel extends Model {

  private String nome;
  private String cnpj;
  private String telefone;

  public LocadoraModel(String nome, String cnpj, String telefone) {
    this.nome = nome;
    this.cnpj = cnpj;
    this.telefone = telefone;
  }

  @Override
  public String getId() {
    return this.cnpj;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCnpj() {
    return this.cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getTelefone() {
    return this.telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

}
