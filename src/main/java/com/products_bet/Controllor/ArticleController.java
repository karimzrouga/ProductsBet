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

import com.products_bet.MODEL.Article;
import com.products_bet.MODEL.Categorie;
import com.products_bet.Services.ArticleService;
import com.products_bet.Services.CategorieService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ArticleController {
	@Autowired
	private ArticleService as;
	@Autowired
	private CategorieService cs;
	@GetMapping(path = "/Articleall")
	public @ResponseBody Iterable<Article> getAll() {
		return as.findAll();
	}

	@GetMapping(path = "/Articlehello")
	public String test() {
		return "Article DONE";
	}

	@GetMapping(value = "/Articlefind{fid}")
	public Optional<Article> findbyid(@PathVariable int fid) {
		Optional<Article> fc = as.findbyid(fid);
		if (fc != null) {
			return fc;
		} else {
			return null;
		}
	}

	@PostMapping(path = { "/Articleadd/{id}" })
	private Article addarticle(@RequestBody Article Article,@PathVariable int id) {
		if (Article == null) {
			return null;
		} else

		{
			Categorie categorie = this.cs.findbyid(id).get();
			Article.setCategorie(categorie);
			return as.create(Article);

		}

	}

	@PutMapping(path = { "/Articleupdate" })
	private Article updatearticle(@RequestBody Article medca) {
		return as.update(medca);
	}

	@DeleteMapping(path = "/Articledelete{id}")
	private void Deletearticle(@PathVariable int id) {
		as.Delete(id);

	}
}
