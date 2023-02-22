package com.example.pw18.phones;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PhoneService {
	private final MyPhoneRepo myPhoneRepo;
	private final PhoneRepo phoneRepo;

	public PhoneService(MyPhoneRepo myPhoneRepo, PhoneRepo phoneRepo) {
		this.phoneRepo = phoneRepo;
		this.myPhoneRepo = myPhoneRepo;
	}

	public void save(Phone phone) {
		phoneRepo.save(phone);
	}

	public void deleteById(Long id) {
		phoneRepo.deleteById(id);
	}

	public List<Phone> findAll() {
		return phoneRepo.findAll();
	}

	public Phone findById(Long id) {
		return myPhoneRepo.findById(id);
	}

	public List<PhoneDTO> findByFilters(
			String name, String creationYear
	) {
		return myPhoneRepo.findByFilters(name, creationYear)
				.stream().map(PhoneDTO::withManufacture).toList();
	}
}
