package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Manager;

public interface ManagerService {
	Manager insertManagerData(Manager mgr);

	List<Manager> getAllManager();

	Manager updateManager(Manager mgr);

	Manager retriveById(Long id);

	void deleteManager(Long id);

}
