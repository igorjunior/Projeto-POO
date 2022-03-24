package Exceptions;

public class ControllerException extends Exception {

  private String controllerName;
  private String function;
  private String description;

  public ControllerException(String name, String function, String description) {
    super(String.format("Um erro ocorreu!\nControlador: %s\nMétodo: %s\nDescrição: %s", name, function, description));
    this.controllerName = name;
    this.function = function;
    this.description = description;
  }

  public String getControllerName() {
    return this.controllerName;
  }

  public String getFunction() {
    return this.function;
  }

  public String getDescription() {
    return this.description;
  }
}