package com.onboarding.vitalsigns.controller;

import com.onboarding.vitalsigns.entity.VitalSign;
import com.onboarding.vitalsigns.repository.VitalSignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vital-sign")
@RequiredArgsConstructor
public class VitalSignController {

	private final VitalSignRepository vitalSignRepository;

	@PostMapping
	public ResponseEntity<VitalSign> add(@RequestBody VitalSign vitalSign) {
		VitalSign result = vitalSignRepository.save(vitalSign);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("{vitalSignId}")
	public ResponseEntity<VitalSign> get(@PathVariable(name = "vitalSignId") Integer vitalSignId){
		VitalSign result = vitalSignRepository.findById(vitalSignId).orElse(null);
		return ResponseEntity.ok().body(result);
	}
}
