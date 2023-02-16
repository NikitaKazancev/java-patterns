package com.example.pw16.manufactures;

import com.example.pw16.phones.Phone;
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
@RequestMapping("manufactures")
public class ManufactureController {

	@Autowired
	private ManufactureService manufactureService;

	@DeleteMapping
	public void deleteById(@RequestParam Long id) {
		manufactureService.deleteById(id);
	}

	@PostMapping
	public void save(
		@RequestBody Manufacture manufacture,
		@RequestParam Long phoneId
	) {
		manufactureService.save(manufacture, phoneId);
	}

	@GetMapping
	public Iterable<Manufacture> findAll() {
		return manufactureService.findAll();
	}

	@GetMapping("/{id}/phone")
	public Phone getPhone(@PathVariable("id") Long id) {
		return manufactureService.getPhone(id);
	}
}