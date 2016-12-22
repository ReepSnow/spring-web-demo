package com.reepsnow.service;

import org.springframework.stereotype.Service;

import com.reepsnow.bean.Account;
@Service
public class AccountManager {

	public Account findAccount(String number) {
		// TODO Auto-generated method stub
		return new Account(number);
	}

}
