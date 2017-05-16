package com.github.diegopacheco.sandbox.java.awsxray.rest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@EnableAutoConfiguration
public class CalcController {

	@RequestMapping("/sum/{a}/{b}")
	@ResponseBody
	Double sum(@PathVariable(value="a") Double a,
			   @PathVariable(value="b") Double b) {
		return a + b;
	}
	
	@RequestMapping("/sub/{a}/{b}")
	@ResponseBody
	Double sub(@PathVariable(value="a") Double a,
			   @PathVariable(value="b") Double b) {
		return a - b;
	}

}
