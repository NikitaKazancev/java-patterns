package com.example.pw18.manufactures;

import com.example.pw18.phones.Phone;
import com.example.pw18.phones.MyPhoneRepo;
import java.util.List;

import com.example.pw18.phones.PhoneRepo;
import org.springframework.stereotype.Service;

@Service
public class ManufactureService {

	private final MyManufactureRepo myManufactureRepo;
	private final ManufactureRepo manufactureRepo;

	private final MyPhoneRepo myPhoneRepo;
	private final PhoneRepo phoneRepo;

	public ManufactureService(
			MyManufactureRepo myManufactureRepo,
			ManufactureRepo manufactureRepo,
			MyPhoneRepo myPhoneRepo,
			PhoneRepo phoneRepo
	) {
		this.myManufactureRepo = myManufactureRepo;
		this.manufactureRepo = manufactureRepo;
		this.myPhoneRepo = myPhoneRepo;
		this.phoneRepo = phoneRepo;
	}

	public void save(Manufacture manufacture, Long id) {
		manufacture.setPhone(phoneRepo.findById(id).get());
		manufactureRepo.save(manufacture);
	}

	public List<Manufacture> findAll() {
		return manufactureRepo.findAll();
	}

	public void deleteById(Long id) {
		manufactureRepo.deleteById(id);
	}

	public Manufacture findById(Long id) {
		return myManufactureRepo.findById(id);
	}

	public Phone getPhone(Long id) {
		return findById(id).getPhone();
	}

	public List<ManufactureDTO> findByFilters(String name, String address) {
		return myManufactureRepo
				.findByFilters(name, address).stream()
				.map(ManufactureDTO::withPhone).toList();
	}
}
