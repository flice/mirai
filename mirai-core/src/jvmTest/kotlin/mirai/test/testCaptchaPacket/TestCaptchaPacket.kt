/*
 * Copyright 2020 Mamoe Technologies and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AGPLv3 license that can be found through the following link.
 *
 * https://github.com/mamoe/mirai/blob/master/LICENSE
 */

package mirai.test.testCaptchaPacket

import net.mamoe.mirai.utils.cryptor.decryptBy
import net.mamoe.mirai.utils.io.hexToBytes
import net.mamoe.mirai.utils.io.toUHexString


fun main() {
    val key = "65 F7 F3 14 E3 94 10 1F DD 95 84 A3 F5 9F AD 94".hexToBytes()
    val data =
        "8D 4F 6A 70 F8 4A DE 43 AF 75 D1 3F 3A 3F F2 E0 A8 16 1A 46 13 CD B0 51 45 00 29 52 57 75 6D 4A 4C D9 B7 98 8C B0 96 EC 57 4E 67 FB 8D C5 F1 BF 72 38 40 42 19 54 C2 28 F4 72 C8 AE 24 EB 66 B5 D0 45 0B 72 44 81 E2 F6 2B EE C3 85 93 BA CB B7 72 F4 1A 30 F9 5B 3D B0 79 3E F4 0B F2 1A A7 49 60 3B 37 02 60 0C 5D D5 76 76 47 4F B5 B3 F5 CA 58 6C FC D2 41 3E 24 D1 FB 0A 18 53 D8 E5 A5 85 A8 BC 51 54 3B 66 5B 21 C6 7B AF C9 62 F0 AA 9C CF 2E 84 0F CC 15 5B 35 93 49 5C E4 28 49 A7 8A D3 30 A9 6E 36 4E 7A 49 28 69 4D C3 25 39 6E 45 6E 40 F2 86 1E F4 4F 00 A6 9D E6 9B 84 19 69 C1 31 6A 17 BA F0 0D 8A 22 09 86 24 92 F7 22 C3 47 7F F2 BF 94 8A 8A B5 29".hexToBytes()
            .decryptBy(key)
    println(data.toUHexString())

    //00 02 00 00 08 04 01 E0 00 00 04 56 00 00 00 01 00 00 15 E3 01 00 38 58 CE A0 12 81 31 5C 5E 36 23 5B E4 0E 05 A6 47 BF 7C 1A 7A 35 37 59 90 17 50 66 0C 07 03 77 E4 48 DB 28 0A CF C3 A9 B7 C0 95 D3 9D 00 AA A5 EB FB D6 85 8D 10 61 5A D0 01 03 00 19 02 CA 53 7E F0 7B 32 82 EC 9F DE CF 51 8B A4 93 26 76 EC 42 1C 02 00 74 58 14 00 05 00 00 00 00 00 04 6C 73 64 61 00 40 CE 99 84 E8 F1 59 31 B0 3F 6C 4D 44 09 E4 82 77 96 67 03 A7 3A EA 8F 36 B9 20 79 7E C9 0F 75 3C 2A C3 E1 E5 C6 00 B3 5E 91 5B 47 63 EF AF 30 C0 48 2F 58 23 96 CF 65 2F 4C 75 95 A6 CA 5A 2C 5C 00 10 E1 50 C9 F4 F6 F4 2F D1 7F E9 8C AB B6 1C 38 7B

}