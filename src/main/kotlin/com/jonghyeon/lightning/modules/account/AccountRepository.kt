package com.jonghyeon.lightning.modules.account

import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, Long> {
    fun findByEmail(email: String): Account?
}