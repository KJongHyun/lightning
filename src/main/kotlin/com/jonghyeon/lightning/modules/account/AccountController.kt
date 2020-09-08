package com.jonghyeon.lightning.modules.account

import com.jonghyeon.lightning.modules.account.dto.SignUpDto
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import javax.validation.Valid

@Controller
class AccountController(
        val accountService: AccountService
) {

    @GetMapping("/sign-up")
    fun signUpForm(model: Model): String {
        model.addAttribute(SignUpDto())
        return "account/sign-up"
    }

    @PostMapping("/sign-up")
    fun signUpSubmit(@Valid signUpDto: SignUpDto, errors: Errors): String {
        if (errors.hasErrors())
            return "account/sign-up"

        var account: Account = accountService.processNewAccount(signUpDto)

        accountService.login(account)

        return "redirect:/"
    }

}