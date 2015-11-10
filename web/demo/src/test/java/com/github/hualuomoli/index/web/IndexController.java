package com.github.hualuomoli.index.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "${authcPath}/index")
public class IndexController {

	@RequestMapping(value = "")
	public String index() {
		return "index";
	}

}
