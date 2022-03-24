package Exceptions;

public class RepositoryException extends Exception {

  private String RepositoryName;
  private String function;
  private String description;

  public RepositoryException(String name, String function, String description) {
    super(String.format("Um erro correu!\nRepositório: %s\nMétodo: %s\nDescrição: %s", name, function, description));
    this.RepositoryName = name;
    this.function = function;
    this.description = description;
  }

  public String getRepositoryName() {
    return this.RepositoryName;
  }

  public String getFunction() {
    return this.function;
  }

  public String getDescription() {
    return this.description;
  }

  public void setRepositoryName(String RepositoryName) {
    this.RepositoryName = RepositoryName;
  }

  public void setFunction(String function) {
    this.function = function;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}