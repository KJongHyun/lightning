package com.jonghyeon.lightning.modules.account

import com.jonghyeon.lightning.modules.account.dto.SignUpDto
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class AccountService(
        val accountRepository: AccountRepository,
        val passwordEncoder: PasswordEncoder
) : UserDetailsService {
    fun processNewAccount(signUpDto: SignUpDto): Account {
        val newAccount = saveNewAccount(signUpDto)
        newAccount.generateEmailCheckToken()
        sendSignUpConfirmEmail(newAccount)

        return newAccount
    }

    fun sendSignUpConfirmEmail(newAccount: Account) {
        TODO("Not yet implemented")
    }

    fun login(account: Account) {
        val token = UsernamePasswordAuthenticationToken(
                UserAccount(account),
                account.password,
                arrayListOf(SimpleGrantedAuthority("ROLE_USER")))
        val context = SecurityContextHolder.getContext()
        context.authentication = token
    }

    private fun saveNewAccount(signUpDto: SignUpDto): Account {
        val account = Account()
        account.email = signUpDto.email
        account.nickName = signUpDto.nickname
        account.password = passwordEncoder.encode(signUpDto.password)
        account.gatheringCreatedByWeb = true
        account.gatheringEnrollmentResultByWeb = true
        account.gatheringUpdatedByWeb = true

        return accountRepository.save(account)
    }

    @Transactional(readOnly = true)
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(email: String): UserDetails {
        val account = accountRepository.findByEmail(email) ?: throw UsernameNotFoundException(email)

        return UserAccount(account)

    }

}