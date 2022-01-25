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
import com.products_bet.MODEL.Bet;
import com.products_bet.MODEL.Client;
import com.products_bet.Services.ArticleService;
import com.products_bet.Services.BetService;
import com.products_bet.Services.ClientService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class BetController {
	@Autowired
	private BetService bs;
	@Autowired
	private ClientService cs;
	@Autowired
	private ArticleService as;

	@GetMapping(path = "/Betall")
	public @ResponseBody Iterable<Bet> getAll() {
		return bs.findAll();
	}

	@GetMapping(path = "/Bethello")
	public String test() {
		return "Bet DONE";
	}

	@GetMapping(value = "/Betfind{fid}")
	public Optional<Bet> findbyid(@PathVariable int fid) {
		Optional<Bet> fc = bs.findbyid(fid);
		if (fc != null) {
			return fc;
		} else {
			return null;
		}
	}

	@PostMapping(path = { "/Betadd" })
	private Bet addbet(@RequestBody Bet Bet) {
		if (Bet == null) {
			return null;
		} else

		{
			Bet.setState(true);
			return bs.create(Bet);

		}

	}

	@PostMapping(path = { "/ArBet/{id}" })
	private Bet addbetbyarticle(@RequestBody Bet Bet, @PathVariable String id) {

		String[] arrOfStr = id.split(",");
		for (String i : arrOfStr) {
			int ii = Integer.parseInt(i);
			Article article = as.findbyid(ii).get();
			if (article != null) {
				article.setBet(Bet);
				Bet.addarticle(article);
			}

		}

		return this.bs.create(Bet);

	}

	@PostMapping(path = { "/Bet{id}" })
	private Bet addbetbyclient(@RequestBody Bet Bet, @PathVariable int id) {
		Client client = cs.findbyid(id).get();

		if (client.notExsiste(Bet)) {
			client.addbet(Bet);
			cs.create(client);

		}
		return this.bs.create(Bet);

	}

	@PutMapping(path = { "/Betupdate" })
	private Bet updatebet(@RequestBody Bet medca) {
		return bs.update(medca);
	}

	@DeleteMapping(path = "/Betdelete{id}")
	private void Deletebet(@PathVariable int id) {
		bs.Delete(id);

	}
}
