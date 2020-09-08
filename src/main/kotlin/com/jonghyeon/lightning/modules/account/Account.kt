package com.jonghyeon.lightning.modules.account

import com.jonghyeon.lightning.modules.tag.Tag
import com.jonghyeon.lightning.modules.zone.Zone
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import kotlin.collections.HashSet

@Entity
class Account {

    @Id @GeneratedValue
    var id: Long? = null

    @Column(unique = true)
    var email: String? = null

    @Column(unique = true)
    var nickName: String? = null

    var password: String? = null

    var emailVerified: Boolean? = null

    var emailCheckToken: String? = null

    var emailCheckTokenGeneratedAt: LocalDateTime? = null

    var joinedAt: LocalDateTime? = null

    var bio: String? = null

    var url: String? = null

    var occupation: String? = null

    var location: String? = null

    @Lob
    @Basic(fetch = FetchType.EAGER)
    var profileImage: String? = null

    var gatheringCreatedByEmail: Boolean? = null

    var gatheringCreatedByWeb: Boolean = true

    var gatheringEnrollmentResultByEmail: Boolean? = null

    var gatheringEnrollmentResultByWeb: Boolean = true

    var gatheringUpdatedByEmail: Boolean? = null

    var gatheringUpdatedByWeb: Boolean = true

    @ManyToMany
    var tags: Set<Tag> = HashSet()

    @ManyToMany
    var zones: Set<Zone> = HashSet()

    fun generateEmailCheckToken() {
        this.emailCheckToken = UUID.randomUUID().toString()
    }

    fun completeSignUp() {
        this.emailVerified = true
        this.joinedAt = LocalDateTime.now()
    }

    fun isValidToken(token: String): Boolean {
        return this.emailCheckToken.equals(token)
    }

    fun canSendConfirmEmail(): Boolean? {
        return this.emailCheckTokenGeneratedAt?.isBefore(LocalDateTime.now().minusHours(1))
    }

}