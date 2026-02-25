package com.springboot.basicsofspringboot;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@GetMapping("/api")
	public Set<String> hello() {
		return Set.of("Miller", "Bravis", "Makram"); // JSON collection
	}
	
}
