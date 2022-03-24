package Model;

import java.io.Serializable;
import java.util.UUID;

public abstract class Model implements Serializable {
	private String id;

	public Model() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return this.id;
	}
}