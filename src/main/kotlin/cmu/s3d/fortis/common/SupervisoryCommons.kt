package cmu.s3d.fortis.common

import net.automatalib.word.Word
import java.io.Serializable

enum class Priority { P0, P1, P2, P3 }

enum class Algorithms { Pareto, Fast }

data class SupervisoryOptions(
    val progress: List<String>,
    val preferredBeh: Map<Priority, List<Word<String>>>,
    val controllable: Map<Priority, List<String>>,
    val observable: Map<Priority, List<String>>,
    val algorithm: Algorithms,
    val maxIter: Int
) : Serializable