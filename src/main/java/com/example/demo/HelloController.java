package com.example.demo;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.form.RescheduleForm;
import com.example.demo.service.TestService;
import com.example.demo.util.Config;

@Controller
public class HelloController {
	@Resource
	TestService testService;
	private static final Logger logger = LogManager.getLogger(HelloController.class);
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String hello(Model model) {
		logger.info("call com.example.demo.HelloController.hello");
        model.addAttribute("message", "Thread ID:" + Thread.currentThread().getId());
        model.addAttribute("current_delay", Config.getValueByLong("scheduler.delay"));
        model.addAttribute("current_interval", Config.getValueByLong("scheduler.interval"));
        return "hello";
    }
	
	@RequestMapping(value="/reschedule", method=RequestMethod.POST)
	public String reschedule(Model model, @ModelAttribute("rescheduleForm") RescheduleForm rescheduleForm) {
		logger.info("call com.example.demo.HelloController.reschedule");
		testService.reschedule(rescheduleForm.getInterval(), rescheduleForm.getDelay());
        model.addAttribute("message", "Thread ID:" + Thread.currentThread().getId());
        model.addAttribute("current_delay", rescheduleForm.getDelay());
        model.addAttribute("current_interval", rescheduleForm.getInterval());
        return "hello";
    }
}
