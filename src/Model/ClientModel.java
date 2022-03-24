package Model;

import java.util.ArrayList;
import java.util.List;

public class ClientModel extends UserModel {
  private InstructorModel instructor;
  private String checkIn;
  private String checkOut;
  private List<ExercisesModel> exercises = new ArrayList<ExercisesModel>();

  public ClientModel(String name, String cpf, String phone, String password, IUserRole role, String checkIn,
      String checkOut) {
    super(name, cpf, phone, password, role);
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }

  public ClientModel(String name, String cpf, String phone, String password, IUserRole role, String checkIn,
      String checkOut, List<ExercisesModel> exercises) {
    super(name, cpf, phone, password, role);
    this.checkIn = checkIn;
    this.checkOut = checkOut;
    this.exercises = exercises;
  }

  public ClientModel(UserModel model, String checkIn, String checkOut) {
    super(model.getName(), model.getCpf(), model.getPhone(), model.getPassword(), model.getRole());
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }

  public ClientModel(UserModel model, String checkIn, String checkOut, List<ExercisesModel> exercises) {
    super(model.getName(), model.getCpf(), model.getPhone(), model.getPassword(), model.getRole());
    this.checkIn = checkIn;
    this.checkOut = checkOut;
    this.exercises = exercises;

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

  public List<ExercisesModel> getExercises() {
    return this.exercises;
  }

  public void addExercises(ExercisesModel exercises) {
    this.exercises.add(exercises);
  }

  public void setInstructor(InstructorModel instructor) {
    this.instructor = instructor;
  }

  public InstructorModel getInstructor() {
    return this.instructor;
  }

}