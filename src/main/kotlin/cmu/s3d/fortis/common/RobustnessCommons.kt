package cmu.s3d.fortis.common

import net.automatalib.word.Word
import java.io.Serializable

data class EquivClass(val s: Int, val a: String) : Serializable

data class RepTrace(val word: Word<String>, val deadlock: Boolean) : Serializable

data class RepWithExplain(val rep: RepTrace, val explanation: Word<String>?) : Serializable

typealias EquivClassRep = List<RepWithExplain>

data class RobustnessOptions(
    val expand: Boolean = false,
    val minimized: Boolean = false,
    val disables: Boolean = false
) : Serializable