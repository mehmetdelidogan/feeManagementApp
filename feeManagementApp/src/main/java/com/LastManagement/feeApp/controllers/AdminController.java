package com.LastManagement.feeApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.LastManagement.feeApp.DAO.Admin_DAO;
import com.LastManagement.feeApp.Entity.Accountant;

@RestController
@RequestMapping(value="/accountant")
public class AdminController {
	@Autowired
	Admin_DAO admin_DAO;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Accountant> getAccountantById(@PathVariable("id") int id) {
		System.out.println("Fetching Student with id " + id);
		Accountant accountant = admin_DAO.findById(id);
		if (accountant == null) {
			return new ResponseEntity<Accountant>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Accountant>(accountant, HttpStatus.OK);
	}

	@PostMapping(value = "/create", headers = "Accept=application/json")
	public ResponseEntity<Void> createAccountant(@RequestBody Accountant accountant, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Accountant " + accountant.getName());
		admin_DAO.addAccountant(accountant);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/accountant/{id}").buildAndExpand(accountant.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping(value = "/get", headers = "Accept=application/json")
	public List<Accountant> getAllAccountants() {
		List<Accountant> tasks = admin_DAO.getAccountants();
		return tasks;

	}

	@PutMapping(value = "/update", headers = "Accept=application/json")
	public ResponseEntity<String> updateAccountant(@RequestBody Accountant currentAccountant) {
		System.out.println("sd");
		Accountant accountant = admin_DAO.findById(currentAccountant.getId());
		if (accountant == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		admin_DAO.update(currentAccountant, currentAccountant.getId());
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<Accountant> deleteUser(@PathVariable("id") int id) {
		Accountant accountant = admin_DAO.findById(id);
		if (accountant == null) {
			return new ResponseEntity<Accountant>(HttpStatus.NOT_FOUND);
		}
		admin_DAO.delete(id);
		return new ResponseEntity<Accountant>(HttpStatus.NO_CONTENT);
	}

}
