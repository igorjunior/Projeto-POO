package Model;

import java.util.ArrayList;
import java.util.List;

public class ExercisesModel extends Model {
  private IExerciseTechnique exercise;
  private int sets;
  private int reps;
  private List<IExerciseTechnique> techniques = new ArrayList<IExerciseTechnique>();

  public IExerciseTechnique getExercise() {
    return this.exercise;
  }

  public void setExercise(IExerciseTechnique exercise) {
    this.exercise = exercise;
  }

  public int getSets() {
    return this.sets;
  }

  public void setSets(int sets) {
    this.sets = sets;
  }

  public int getReps() {
    return this.reps;
  }

  public void setReps(int reps) {
    this.reps = reps;
  }

  public List<IExerciseTechnique> getTechniques() {
    return this.techniques;
  }

  public void addTechniques(IExerciseTechnique techniques) {
    this.techniques.add(techniques);
  }

}