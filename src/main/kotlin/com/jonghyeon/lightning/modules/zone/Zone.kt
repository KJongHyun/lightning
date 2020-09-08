package com.jonghyeon.lightning.modules.zone

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Zone {

    @Id @GeneratedValue
    var id: Long? = null

}