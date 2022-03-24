package Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Model.Model;

public class Repository<T extends Model> {

  private String fileName;
  private List<T> list;
  private Boolean started;

  public Repository(String name) {
    this.fileName = name;
    this.list = new ArrayList<T>();
    this.started = false;
  }

  private String getFileName() {
    return String.format("/db/%s.data", fileName);
  }

  @SuppressWarnings("unchecked")
  public void start() {
    ObjectInputStream ois = null;
    try {
      File file = new File("/db/");
      file.mkdir();
      file = new File(getFileName());
      file.createNewFile();
      ois = new ObjectInputStream(new FileInputStream(file));
      list = (ArrayList<T>) ois.readObject();
    } catch (IOException e) {
      list = new ArrayList<T>();
    } catch (ClassNotFoundException e) {
      list = new ArrayList<T>();
    }

    try {
      if (ois != null)
        ois.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    this.started = true;
  }

  public List<T> all() {
    return list;
  }

  public T find(String id) {
    for (T item : list) {
      if (item.getId() == id)
        return item;
    }
    return null;
  }

  private void store() {
    ObjectOutputStream oos = null;
    try {
      oos = new ObjectOutputStream(new FileOutputStream(getFileName(), false));
      oos.writeObject(list);
      oos.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      if (oos != null)
        oos.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void save(String id, T obj) {
    int findIndex = -1;
    for (int i = 0; i < list.size(); i++) {
      T item = list.get(i);
      if (item.getId() == id)
        findIndex = i;
    }
    if (findIndex != -1) {
      list.set(findIndex, obj);
    } else {
      list.add(obj);
    }
    store();
  }

  public void delete(String id) {
    for (int i = 0; i < list.size(); i++) {
      T item = list.get(i);
      if (item.getId() == id) {
        list.remove(i);
      }
    }
    store();
  }

}
