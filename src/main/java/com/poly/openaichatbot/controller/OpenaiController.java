package com.poly.openaichatbot.controller;

import com.poly.openaichatbot.model.InputModel;
import com.poly.openaichatbot.service.OpenaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class OpenaiController {
    @Autowired
    OpenaiService openaiService;

    //http://localhost:9090/chat
    @PostMapping("/chat")
    public String getRequest(@RequestBody InputModel inputModel) throws IOException {
//        logger.debug("Inside OpenaiController.getRequest() received request as "+ inputModel.getUserInput());
        return openaiService.openaiServiceCall(inputModel.getUserInput());
    }
}
