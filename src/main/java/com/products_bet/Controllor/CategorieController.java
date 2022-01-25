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

import com.products_bet.MODEL.Categorie;
import com.products_bet.Services.CategorieService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class CategorieController {
	@Autowired
	private CategorieService cs;

	@GetMapping(path = "/Categorieall")
	public @ResponseBody Iterable<Categorie> getAll() {
		return cs.findAll();
	}

	@GetMapping(path = "/Categoriehello")
	public String test() {
		return "Categorie DONE";
	}

	@GetMapping(value = "/Categoriefind{fid}")
	public Optional<Categorie> findbyid(@PathVariable int fid) {
		Optional<Categorie> fc = cs.findbyid(fid);
		if (fc != null) {
			return fc;
		} else {
			return null;
		}
	}

	@PostMapping(path = { "/Categorieadd" })
	private Categorie addcategorie(@RequestBody Categorie Categorie) {
		if (Categorie == null) {
			return null;
		} else

		{
			return cs.create(Categorie);

		}

	}

	@PutMapping(path = { "/Categorieupdate" })
	private Categorie updatecategorie(@RequestBody Categorie medca) {
		return cs.update(medca);
	}

	@DeleteMapping(path = "/Categoriedelete{id}")
	private void Deletecategorie(@PathVariable int id) {
		cs.Delete(id);

	}
}
