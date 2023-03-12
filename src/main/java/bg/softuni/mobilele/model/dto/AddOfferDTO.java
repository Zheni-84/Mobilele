package bg.softuni.mobilele.model.dto;

import bg.softuni.mobilele.model.entity.OfferEntity;
import bg.softuni.mobilele.model.entity.enums.EngineEnum;
import bg.softuni.mobilele.model.entity.enums.TransmissionEnum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link OfferEntity} entity
 */
public class AddOfferDTO implements Serializable {

	@NotNull
	@Min(1)
	private Long modelId;

	@NotNull
	private EngineEnum engine;

	@NotEmpty
	private String imageUrl;

	@NotNull
	private int mileage;

	@Positive
	@NotNull
	private BigDecimal price; // Integer???

	@Min(1900)
	@NotNull
	private int year;

	@NotEmpty
	private String description;

	@NotNull
	private TransmissionEnum transmission;

	public Long getModelId() {
		return modelId;
	}

	public AddOfferDTO setModelId(Long modelId) {
		this.modelId = modelId;
		return this;
	}

	public EngineEnum getEngine() {
		return engine;
	}

	public AddOfferDTO setEngine(EngineEnum engine) {
		this.engine = engine;
		return this;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public AddOfferDTO setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		return this;
	}

	public int getMileage() {
		return mileage;
	}

	public AddOfferDTO setMileage(int mileage) {
		this.mileage = mileage;
		return this;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public AddOfferDTO setPrice(BigDecimal price) {
		this.price = price;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public AddOfferDTO setDescription(String description) {
		this.description = description;
		return this;
	}

	public TransmissionEnum getTransmission() {
		return transmission;
	}

	public AddOfferDTO setTransmission(TransmissionEnum transmission) {
		this.transmission = transmission;
		return this;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" +
				"engine = " + engine + ", " +
				"imageUrl = " + imageUrl + ", " +
				"mileage = " + mileage + ", " +
				"price = " + price + ", " +
				"description = " + description + ", " +
				"transmission = " + transmission + ")";
	}
}