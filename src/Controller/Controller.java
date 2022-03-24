package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Exceptions.ControllerException;

public abstract class Controller {
  private static int currentId = 1;
  private int id;

  public Controller() {
    this.id = currentId++;
  }

  private String getBack() {
    return "0 - Voltar";
  }

  protected int getInput(int min, int max) throws ControllerException {
    System.out.println(getDesc());
    System.out.println(getBack());
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int i = 0;
    try {
      i = Integer.parseInt(br.readLine());
    } catch (NumberFormatException nfe) {
      throw new ControllerException("Default", "getInput", "A entrada deve ser um número");
    } catch (IOException e) {
      throw new ControllerException("Default", "getInput", e.getMessage());
    }
    if (i < min || i > max) {
      throw new ControllerException("Default", "getInput", "Entrada não encontrada");
    }
    return i;
  }

  protected abstract String getDesc();

  protected abstract String start();

  public int getId() {
    return this.id;
  }
}
