package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Manager;
import com.example.demo.repository.ManagerRepo;

@Service
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	ManagerRepo managerRepo;

	@Override
	public Manager insertManagerData(Manager mgr) {

		Manager save = managerRepo.save(mgr);
		return save;

	}

	@Override
	public List<Manager> getAllManager() {
		List<Manager> all = managerRepo.findAll();
		return all;
	}

	@Override
	public Manager updateManager(Manager mgr) {
		Manager save = managerRepo.save(mgr);
		return save;

	}

	@Override
	public Manager retriveById(Long id) {
		Optional<Manager> byId = managerRepo.findById(id);
		if (!byId.isPresent()) {
			throw new RuntimeException("Id not Found");
		}
		return byId.get();
	}

	@Override
	public void deleteManager(Long id) {
		managerRepo.deleteById(id);
		System.out.println("Data Deletion Completed..");

	}

}
