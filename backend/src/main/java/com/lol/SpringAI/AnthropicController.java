package com.lol.SpringAI;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/anthropic")
@CrossOrigin("*")
public class AnthropicController {

//    private OllamaChatModel chatModel;
 private ChatClient chatClient;

    public AnthropicController(OllamaChatModel chatModel){
        this.chatClient = ChatClient.create(chatModel);
    }

    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message){
        String response = chatClient.prompt(message).call().content();
        return ResponseEntity.ok(response);
    }
}
