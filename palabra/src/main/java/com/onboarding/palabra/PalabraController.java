package com.onboarding.palabra;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ForkJoinPool;

@RestController
@RequestMapping("/palabra")
public class PalabraController {

    @GetMapping("{value}")
    public ResponseEntity<String> change(@PathVariable(name = "value") String value) throws InterruptedException {
        Thread.sleep(5000);
        String result = value + "_modificado";
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/async-deferredresult/{value}")
    public DeferredResult<ResponseEntity<?>> handleReqDefResult(@PathVariable(name = "value") String value) {
        DeferredResult<ResponseEntity<?>> output = new DeferredResult<>();
        
        ForkJoinPool.commonPool().submit(() -> {
            String result = value;
            try {
                Thread.sleep(5000);
                result = value + "_modificado";
            } catch (InterruptedException e) {
            }
            output.setResult(ResponseEntity.ok(result));
        });

        return output;
    }
}
