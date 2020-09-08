package com.jonghyeon.lightning.modules.account

import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User

class UserAccount(account: Account) : User(account.nickName, account.password, arrayListOf(SimpleGrantedAuthority("ROLE_USER")))