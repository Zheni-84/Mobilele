package bg.softuni.mobilele.model.dto;

import bg.softuni.mobilele.model.entity.ModelEntity;
import bg.softuni.mobilele.model.entity.enums.CategoryEnum;

import java.io.Serializable;

/**
 * A DTO for the {@link ModelEntity} entity
 */
public class ModelDTO implements Serializable {

	private long id;

	private String name;

	private CategoryEnum category;

	private String imageUrl;

	private int startYear;

	private Long endYear;

	private BrandDTO brand;

	public long getId() {
		return id;
	}

	public ModelDTO setId(long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public ModelDTO setName(String name) {
		this.name = name;
		return this;
	}

	public CategoryEnum getCategory() {
		return category;
	}

	public ModelDTO setCategory(CategoryEnum category) {
		this.category = category;
		return this;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public ModelDTO setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		return this;
	}

	public int getStartYear() {
		return startYear;
	}

	public ModelDTO setStartYear(int startYear) {
		this.startYear = startYear;
		return this;
	}

	public Long getEndYear() {
		return endYear;
	}

	public ModelDTO setEndYear(Long endYear) {
		this.endYear = endYear;
		return this;
	}

	public BrandDTO getBrand() {
		return brand;
	}

	public ModelDTO setBrand(BrandDTO brand) {
		this.brand = brand;
		return this;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" +
				"name = " + name + ", " +
				"category = " + category + ", " +
				"imageUrl = " + imageUrl + ", " +
				"startYear = " + startYear + ", " +
				"endYear = " + endYear + ", " +
				"brand = " + brand + ")";
	}
}