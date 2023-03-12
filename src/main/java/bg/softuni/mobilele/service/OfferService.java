package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.dto.AddOfferDTO;
import bg.softuni.mobilele.model.entity.ModelEntity;
import bg.softuni.mobilele.model.entity.OfferEntity;
import bg.softuni.mobilele.model.entity.UserEntity;
import bg.softuni.mobilele.model.mapper.OfferMapper;
import bg.softuni.mobilele.repository.ModelRepository;
import bg.softuni.mobilele.repository.OfferRepository;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.user.CurrentUser;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

	private final OfferRepository offerRepository;
	private final ModelRepository modelRepository;
	private final OfferMapper offerMapper;
	private final UserRepository userRepository;
	private final CurrentUser currentUser;

	public OfferService(OfferRepository offerRepository, ModelRepository modelRepository, OfferMapper offerMapper,
			UserRepository userRepository, CurrentUser currentUser) {
		this.offerRepository = offerRepository;
		this.modelRepository = modelRepository;
		this.offerMapper = offerMapper;
		this.userRepository = userRepository;
		this.currentUser = currentUser;
	}

	public void addOffer(AddOfferDTO addOfferDTO) {
		// TODO: 3/11/2023
		OfferEntity newOffer = offerMapper.offerDtoToOfferEntity(addOfferDTO);
		UserEntity seller = userRepository.findByEmail(currentUser.getEmail())
				.orElseThrow();
		ModelEntity model = modelRepository.findById(addOfferDTO.getModelId()).orElseThrow();
		newOffer.setModel(model).setSeller(seller);
		offerRepository.save(newOffer);
	}
}
