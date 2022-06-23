package com.onboarding.palabra;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/palabra")
public class PalabraController {

    @GetMapping("{value}")
    public ResponseEntity<String> change(@PathVariable(name = "value") String value) throws InterruptedException {
        Thread.sleep(5000);
        String result = value + "_modificado";
        return ResponseEntity.ok().body(result);
    }
}
