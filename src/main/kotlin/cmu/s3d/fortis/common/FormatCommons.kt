package cmu.s3d.fortis.common

import java.io.Serializable

enum class SpecType {
    FSP, AUT, FSM, FLTL
}

data class Spec(val type: SpecType, val content: String) : Serializable