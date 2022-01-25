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

import com.products_bet.MODEL.Bet;
import com.products_bet.MODEL.Event;
import com.products_bet.Services.BetService;
import com.products_bet.Services.EventService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class EventController {
	@Autowired
	private EventService cs;
	@Autowired
	private BetService bs;

	@GetMapping(path = "/Eventall")
	public @ResponseBody Iterable<Event> getAll() {
		return cs.findAll();
	}

	@GetMapping(path = "/Eventhello")
	public String test() {
		return "Event DONE";
	}

	@GetMapping(value = "/Eventfind{fid}")
	public Optional<Event> findbyid(@PathVariable int fid) {
		Optional<Event> fc = cs.findbyid(fid);
		if (fc != null) {
			return fc;
		} else {
			return null;
		}
	}

	@PostMapping(path = { "/Eventaddbet/{id}" })
	private Event addevents(@RequestBody Event event, @PathVariable String id) {

		String[] arrOfStr = id.split(",");
		for (String i : arrOfStr) {
			int ii = Integer.parseInt(i);
			Bet bet = bs.findbyid(ii).get();
			if (bet != null) {
				bet.setEvent(event);
				event.addbet(bet);
			}

		}
		return cs.create(event);
	}

	@PostMapping(path = { "/Eventadd" })
	private Event addevent(@RequestBody Event Event) {
		if (Event == null) {
			return null;
		} else

		{
			return cs.create(Event);

		}

	}

	@PutMapping(path = { "/Eventupdate" })
	private Event updateevent(@RequestBody Event medca) {
		return cs.update(medca);
	}

	@DeleteMapping(path = "/Eventdelete{id}")
	private void Deleteevent(@PathVariable int id) {
		cs.Delete(id);

	}
}
