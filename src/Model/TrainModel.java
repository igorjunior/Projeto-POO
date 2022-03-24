package Model;

import java.util.ArrayList;
import java.util.List;

public class TrainModel extends Model {
  private char name;
  private IExerciseTechnique technique;
  private List<String> exercises = new ArrayList<String>();
  private List<ExercisesModel> exercises_cache = new ArrayList<ExercisesModel>();

  public TrainModel(char name, IExerciseTechnique technique) {
    this.name = name;
    this.technique = technique;
  }

  public char getName() {
    return this.name;
  }

  public void setName(char name) {
    this.name = name;
  }

  public IExerciseTechnique getTechnique() {
    return this.technique;
  }

  public void setTechnique(IExerciseTechnique technique) {
    this.technique = technique;
  }

  public List<String> getExercises() {
    return this.exercises;
  }

  public void addExercises(String exercises) {
    this.exercises.add(exercises);
  }

}