package com.lol.SpringAI;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/openai")
@CrossOrigin("*")
public class OpenAiController {

    private OllamaChatModel chatModel;

    public OpenAiController(OllamaChatModel chatModel){
        this.chatModel = chatModel;
    }

    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message){
        String response = chatModel.call(message);
        return ResponseEntity.ok(response);
    }
}
