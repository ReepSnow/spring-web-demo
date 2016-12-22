package com.reepsnow.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.reepsnow.bean.Account;
import com.reepsnow.service.AccountManager;

@Controller
/*如果需要返回页面需要用control，如果返回是json或者是其他并非页面信息，则需要用restcontrol，在springMVCl里面是通过requestbody实现返回的数据格式*/
public class ModelAttributeController {

	@Autowired
	AccountManager accountManager;
	
    @RequestMapping("/hello1/{name}")
    public String hello(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
    @RequestMapping("/hello2/{number}")
    public String hello2() {
    	return "hello2";
    }

	@ModelAttribute
	public Account addAccount(@RequestParam String number) {
		System.out.println("  在第一种写法中，方法通过返回值的方式默认地将添加一个属性；");
	    return accountManager.findAccount(number);
	}
	/*
	// Add multiple attributes
	@ModelAttribute
	public void populateModel(@RequestParam String number, Model model) {
		System.out.println("在第二种写法中，方法接收一个Model对象，然后可以向其中添加任意数量的属性。");
	    model.addAttribute(accountManager.findAccount(number));
	    // add more ...
	}*/
	
	/*这个是下面这个方法的测试url 注意是post请求 http://localhost:8080/accounts/account?number=dd*/	
	@RequestMapping(value = "/accounts/{account}", method = RequestMethod.POST)
	public String savePOST(@ModelAttribute("account") Account account) {
		return "hello2";
	}
	
	/*这个是下面这个方法的测试url 注意是put请求 http://localhost:8080/accounts/account?number=dd*/	
	@RequestMapping(value = "/accounts/{account}", method = RequestMethod.PUT)
	public String savePUT(@ModelAttribute("account") Account account) {
		return "hello2";
	}


	public AccountManager getAccountManager() {
		return accountManager;
	}


	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}
	
}