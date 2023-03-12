package bg.softuni.mobilele.model.dto;

import bg.softuni.mobilele.model.entity.BrandEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link BrandEntity} entity
 */
public class BrandDTO implements Serializable {

	private String name;

	private List<ModelDTO> models = new ArrayList<>();

	public String getName() {
		return name;
	}

	public BrandDTO setName(String name) {
		this.name = name;
		return this;
	}

	public List<ModelDTO> getModels() {
		return models;
	}

	public BrandDTO setModels(List<ModelDTO> models) {
		this.models = models;
		return this;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" +
				"name = " + name + ", " +
				"models = " + models + ")";
	}
}