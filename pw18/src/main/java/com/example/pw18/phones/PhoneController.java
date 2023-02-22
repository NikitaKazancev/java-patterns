package com.example.pw18.phones;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phones")
@Slf4j
public class PhoneController {
	private final String logPrefix = "[PhoneController] ";

	private final PhoneService phoneService;

	public PhoneController(PhoneService phoneService) {
		log.info(logPrefix + "Initializing");
		this.phoneService = phoneService;
	}

	@PostMapping
	public void save(@RequestBody Phone phone) {
		log.info(logPrefix + "Save phone {}", phone);
		phoneService.save(phone);
	}

	@DeleteMapping
	public void deleteById(@RequestParam Long id) {
		log.info(logPrefix + "Delete phone by id {}", id);
		phoneService.deleteById(id);
	}

	@GetMapping
	public List<Phone> findAll() {
		log.info(logPrefix + "Find all phones");
		return phoneService.findAll();
	}

	@GetMapping("/{id}")
	public Phone findById(@PathVariable Long id) {
		log.info(logPrefix + "Find phone by id {}", id);
		return phoneService.findById(id);
	}

	@GetMapping("/search")
	public List<PhoneDTO> searchStudents(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "creationYear", required = false) String creationYear
	) {
		log.info(logPrefix + "Find phone by filters: " +
				"{name: \"{}\", creationYear: \"{}\"}", name, creationYear);
		return phoneService.findByFilters(name, creationYear);
	}
}
