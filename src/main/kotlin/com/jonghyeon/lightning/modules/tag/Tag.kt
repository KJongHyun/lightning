package com.jonghyeon.lightning.modules.tag

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Tag {
    @Id @GeneratedValue
    var id: Long? = null
}