package Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Exceptions.RepositoryException;
import Model.Model;

public class Repository<T extends Model> {

  private String repoName;
  private List<T> list;
  private Boolean started;

  public Repository(String name) {
    this.repoName = name;
    this.list = new ArrayList<T>();
    this.started = false;
  }

  private String getFileName() {
    return String.format("db/%s.data", repoName);
  }

  @SuppressWarnings("unchecked")
  public void start() {
    ObjectInputStream ois = null;
    try {
      File file = new File(getFileName());
      file.getParentFile().mkdirs();
      file.createNewFile();
      ois = new ObjectInputStream(new FileInputStream(file));
      list = (ArrayList<T>) ois.readObject();
    } catch (ClassNotFoundException e) {
      list = new ArrayList<T>();
    } catch (IOException e) {
      list = new ArrayList<T>();
    }

    try {
      if (ois != null)
        ois.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    started = true;
  }

  public List<T> all() throws RepositoryException {
    if (!this.started)
      throw new RepositoryException(this.repoName, "all", "O repositório não foi iniciado");
    return list;
  }

  public T find(String id) throws RepositoryException {
    if (!this.started)
      throw new RepositoryException(this.repoName, "find", "O repositório não foi iniciado!");
    for (T item : list) {
      if (item.getId().equals(id))
        return item;
    }
    return null;
  }

  private void store() throws RepositoryException {
    if (!this.started)
      throw new RepositoryException(this.repoName, "store", "O repositório não foi iniciado!");
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

  public void save(String id, T obj) throws RepositoryException {
    int findIndex = -1;
    for (int i = 0; i < list.size(); i++) {
      T item = list.get(i);
      if (item.getId().equals(id))
        findIndex = i;
    }
    if (findIndex != -1) {
      list.set(findIndex, obj);
    } else {
      list.add(obj);
    }
    store();
  }

  public void delete(String id) throws RepositoryException {
    for (int i = 0; i < list.size(); i++) {
      T item = list.get(i);
      if (item.getId().equals(id)) {
        list.remove(i);
      }
    }
    store();
  }
}