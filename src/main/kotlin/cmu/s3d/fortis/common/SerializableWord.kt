package cmu.s3d.fortis.common

import net.automatalib.word.Word
import java.io.Serializable

class SerializableWord(private val symbols: Array<String>) : Word<String>(), Serializable {
    override fun length(): Int {
        return symbols.size
    }

    override fun getSymbol(i: Int): String {
        return symbols[i]
    }
}

fun Word<String>.asSerializableWord(): SerializableWord {
    return SerializableWord(this.asList().toTypedArray())
}