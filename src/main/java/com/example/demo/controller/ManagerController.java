package com.example.demo.controller;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseMessageDto;
import com.example.demo.entity.Manager;
import com.example.demo.repository.ManagerRepo;
import com.example.demo.service.ManagerService;
import com.example.demo.utility.UtilityConstants;

@RestController
public class ManagerController {

	@Autowired
	ManagerService managerService;
	@Autowired
	ManagerRepo managerRepo;

	@PostMapping("/creation")
	public ResponseEntity<ResponseMessageDto> saveManager(@RequestBody Manager mgr) {
		try {
			if (mgr.getAddress() == null || mgr.getName().isBlank() || mgr.getAddress().isEmpty()
					|| mgr.getName() == null) {
				return ResponseEntity.ok(new ResponseMessageDto(HttpURLConnection.HTTP_BAD_REQUEST,
						UtilityConstants.FAILURE, "Address or name cant be Null"));

			}
			Manager data = managerService.insertManagerData(mgr);
			if (data != null) {
				return ResponseEntity.ok(new ResponseMessageDto(HttpURLConnection.HTTP_ACCEPTED,
						UtilityConstants.SUCCESS, "Details Added Successfully", data));

			} else {
				return ResponseEntity.ok(new ResponseMessageDto(HttpURLConnection.HTTP_BAD_REQUEST,
						UtilityConstants.FAILURE + "Details Added Unsuccessful", data));
			}
		} catch (Exception e) {
			return ResponseEntity.ok(new ResponseMessageDto(HttpURLConnection.HTTP_INTERNAL_ERROR,
					UtilityConstants.FAILED + "Internal Server Error"));
		}
	}

	@PutMapping("/updatation/{id}")
	public ResponseEntity<ResponseMessageDto> updateManger(@PathVariable Long id, @RequestBody Manager mgr) {
		try {
			Optional<Manager> byId = managerRepo.findById(id);
			if (byId.isPresent()) {
				mgr.setId(id);
				Manager updateManager = managerService.updateManager(mgr);
				if (updateManager != null) {
					return ResponseEntity.ok(new ResponseMessageDto(HttpURLConnection.HTTP_CREATED,
							UtilityConstants.SUCCESS, "Manager Updated Successfully", updateManager));
				} else {
					return ResponseEntity.ok(new ResponseMessageDto(HttpURLConnection.HTTP_BAD_REQUEST,
							UtilityConstants.FAILED, "Manager Updation Failed"));
				}

			} else {
				return ResponseEntity.ok(new ResponseMessageDto(HttpURLConnection.HTTP_BAD_REQUEST,
						UtilityConstants.FAILED, "The Id That You have entere is not found"));
			}

		} catch (Exception e) {
			return ResponseEntity.ok(new ResponseMessageDto(HttpURLConnection.HTTP_INTERNAL_ERROR,
					UtilityConstants.FAILED + "Internal Server Error"));

		}
	}

	@GetMapping("/getAll")
	public ResponseEntity<ResponseMessageDto> getAllManagerDetails() {
		try {
			List<Manager> allManager = managerService.getAllManager();
			if (!allManager.isEmpty()) {

				return ResponseEntity.ok(new ResponseMessageDto(HttpURLConnection.HTTP_ACCEPTED,
						UtilityConstants.SUCCESS, "Data Fetch Successfully", allManager));
			} else {
				return ResponseEntity.ok(new ResponseMessageDto(HttpURLConnection.HTTP_BAD_REQUEST,
						UtilityConstants.FAILED, "There is no data in the table"));
			}

		} catch (Exception e) {
			return ResponseEntity.ok(new ResponseMessageDto(HttpURLConnection.HTTP_INTERNAL_ERROR,
					UtilityConstants.FAILED, "Error Occured on fetching Data"));
		}

	}

	@GetMapping("/GetById/{id}")
	public ResponseEntity<ResponseMessageDto> getDetailsById(@PathVariable Long id) {
		try {
			Optional<Manager> byId2 = managerRepo.findById(id);
			if (byId2.isPresent()) {
				Manager byId = managerService.retriveById(id);

				if (!(byId == null)) {
					return ResponseEntity.ok(new ResponseMessageDto(HttpURLConnection.HTTP_ACCEPTED,
							UtilityConstants.SUCCESS, "Data Fetch Successful", byId));

				} else {
					return ResponseEntity.ok(new ResponseMessageDto(HttpURLConnection.HTTP_BAD_REQUEST,
							UtilityConstants.FAILED, "Data Fetching Unsuccessful"));
				}
			} else {
				return ResponseEntity.ok(new ResponseMessageDto(HttpURLConnection.HTTP_BAD_REQUEST,
						UtilityConstants.FAILED, "The Id is not there... check again sir"));

			}
		} catch (Exception e) {
			return ResponseEntity.ok(new ResponseMessageDto(HttpURLConnection.HTTP_INTERNAL_ERROR,
					UtilityConstants.FAILURE, "Problem Occures During Fetching Data"));
		}

	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<ResponseMessageDto> deleteManagerById(@PathVariable Long id) {
		try {
			managerService.deleteManager(id);
			return ResponseEntity.ok(new ResponseMessageDto(HttpURLConnection.HTTP_ACCEPTED, UtilityConstants.SUCCESS,
					"Data deletion Completed"));
		} catch (Exception e) {
			return ResponseEntity.ok(new ResponseMessageDto(HttpURLConnection.HTTP_INTERNAL_ERROR,
					UtilityConstants.FAILURE, "Internal Error Occures"));
		}

	}
}
