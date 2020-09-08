package com.jonghyeon.lightning.modules.account

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Account {

    @Id @GeneratedValue
    var id: Long? = null

    @Column(unique = true)
    var email: String? = null

    @Column(unique = true)
    var nickName: String? = null

    var password: String? = null

}