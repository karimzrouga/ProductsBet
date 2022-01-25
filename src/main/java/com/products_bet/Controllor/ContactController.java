package com.products_bet.Controllor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.products_bet.MODEL.Contact;
import com.products_bet.Services.ContactService;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ContactController {
	@Autowired
	private ContactService cs;

	@GetMapping(path = "/contactall")
	public @ResponseBody Iterable<Contact> getAll() {
		return cs.findAll();
	}

	@GetMapping(path = "/contacthello")
	public String test() {
		return "contact DONE";
	}

	@GetMapping(value = "/contactfind{fid}")
	public Optional<Contact> findbyid(@PathVariable int fid) {
		Optional<Contact> fc = cs.findbyid(fid);
		if (fc != null) {
			return fc;
		} else {
			return null;
		}
	}

	@PostMapping(path = { "/contactadd" })
	private Contact addcontact(@RequestBody Contact contact) {
		if (contact == null) {
			return null;
		} else

		{
			return cs.create(contact);

		}

	}

	@PutMapping(path = { "/contactupdate" })
	private Contact updatecontact(@RequestBody Contact medca) {
		return cs.update(medca);
	}

	@DeleteMapping(path = "/contactdelete{id}")
	private void Deletecontact(@PathVariable int id) {
		cs.Delete(id);

	}
}
