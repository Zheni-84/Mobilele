package bg.softuni.mobilele.web;

import bg.softuni.mobilele.model.dto.AddOfferDTO;
import bg.softuni.mobilele.service.BrandService;
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
	private final BrandService brandService;

	public OfferController(OfferService offerService, BrandService brandService) {
		this.offerService = offerService;
		this.brandService = brandService;
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
		model.addAttribute("brands", brandService.getAllBrands());

		return "offer-add";
	}

	@PostMapping("/offers/add")
	public String addOffer(@Valid AddOfferDTO addOfferModel, BindingResult bindResult, RedirectAttributes redirectAttributes) {
		if (bindResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("addOfferModel", addOfferModel);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferModel", bindResult);
			return "redirect:/offers/add";
		}
		offerService.addOffer(addOfferModel);

		return "redirect:/offers/all";
	}
}