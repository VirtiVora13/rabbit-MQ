package com.practice.rabbitmq;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RabbitMQListener implements MessageListener {

    static String data = "10";
    @Override
    public void onMessage(Message message) {
        data = new String(message.getBody());
        System.out.println("message: " + new String(message.getBody()));
//        ModelAndView mv = new ModelAndView("home");
//        mv.addObject("bidder", new String(message.getBody()));
    }

    @GetMapping("/home")
    public String getHome(Model model){
        System.out.println("data: " + data);
        model.addAttribute("bidder", data);
        return "home";
    }

    @RequestMapping(value = "/data",method = RequestMethod.GET, produces = { "application/json" })
    @ResponseBody
    public ResponseEntity<String> getData(Model model){
        //model.addAttribute("bidder", data);
        return new ResponseEntity<String>("{ \"data\": \""+data+"\"}", HttpStatus.OK);
    }
}
