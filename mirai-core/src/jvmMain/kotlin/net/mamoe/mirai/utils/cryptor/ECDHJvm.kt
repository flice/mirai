/*
 * Copyright 2020 Mamoe Technologies and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AGPLv3 license that can be found through the following link.
 *
 * https://github.com/mamoe/mirai/blob/master/LICENSE
 */

package net.mamoe.mirai.utils.cryptor

import net.mamoe.mirai.utils.md5
import org.bouncycastle.jce.provider.BouncyCastleProvider
import java.security.*
import java.security.spec.ECGenParameterSpec
import java.security.spec.X509EncodedKeySpec
import javax.crypto.KeyAgreement


actual typealias ECDHPrivateKey = PrivateKey
actual typealias ECDHPublicKey = PublicKey

actual class ECDHKeyPair(
    private val delegate: KeyPair
) {
    actual val privateKey: ECDHPrivateKey get() = delegate.private
    actual val publicKey: ECDHPublicKey get() = delegate.public

    actual val initialShareKey: ByteArray = ECDH.calculateShareKey(privateKey, initialPublicKey)
}

@Suppress("FunctionName")
actual fun ECDH() = ECDH(ECDH.generateKeyPair())

actual class ECDH actual constructor(actual val keyPair: ECDHKeyPair) {
    actual companion object {
        init {
            Security.addProvider(BouncyCastleProvider())
        }

        actual fun generateKeyPair(): ECDHKeyPair {
            return ECDHKeyPair(KeyPairGenerator.getInstance("EC", "BC").apply { initialize(ECGenParameterSpec("secp192k1")) }.genKeyPair())
        }

        actual fun calculateShareKey(
            privateKey: ECDHPrivateKey,
            publicKey: ECDHPublicKey
        ): ByteArray {
            val instance = KeyAgreement.getInstance("ECDH", "BC")
            instance.init(privateKey)
            instance.doPhase(publicKey, true)
            return md5(instance.generateSecret())
        }

        actual fun constructPublicKey(key: ByteArray): ECDHPublicKey {
            return KeyFactory.getInstance("EC", "BC").generatePublic(X509EncodedKeySpec(key))
        }
    }

    actual fun calculateShareKeyByPeerPublicKey(peerPublicKey: ECDHPublicKey): ByteArray {
        return calculateShareKey(keyPair.privateKey, peerPublicKey)
    }

    actual override fun toString(): String {
        return "ECDH(keyPair=$keyPair)"
    }
}