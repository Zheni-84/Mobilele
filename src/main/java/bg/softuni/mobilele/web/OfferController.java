package bg.softuni.mobilele.web;

import bg.softuni.mobilele.model.dto.AddOfferDTO;
import bg.softuni.mobilele.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OfferController {

	private final OfferService offerService;

	public OfferController(OfferService offerService) {
		this.offerService = offerService;
	}

	@ModelAttribute("addOfferModel")
	public AddOfferDTO initOfferModel() {
		return new AddOfferDTO();
	}

	@GetMapping("/offers/all")
	public String allOffers(Model model) {

		return "offers";
	}

	@GetMapping("/offers/add")
	public String addOffer(Model model) {

		return "offer-add";
	}

	@PostMapping("/offers/add")
	public String addOffer(@Valid AddOfferDTO addOfferModel, BindingResult bindResult, RedirectAttributes redirectAttributes) {
		if (bindResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("addOfferModel", addOfferModel);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferModel", bindResult);
			return "redirect:/offers/add";
		}
		// TODO: 3/11/2023

		return "redirect:/";
	}
}
