package com.products_bet.Controllor;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class Uploadcontrollor {

	private String directory;

	@PostMapping("/upload")
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile Files) throws IOException {

		this.directory = System.getProperty("user.dir")+"/frontend/productsbet/public/assets" ;

		String filename = StringUtils.cleanPath(Files.getOriginalFilename());
		Path fileStorage = get(directory, filename).toAbsolutePath().normalize();
		copy(Files.getInputStream(), fileStorage, REPLACE_EXISTING);
		this.directory = "";
		return ResponseEntity.ok().body(filename);
	}

}