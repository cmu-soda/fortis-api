package cmu.s3d.fortis.service

import cmu.s3d.fortis.common.Spec
import net.automatalib.word.Word
import java.rmi.Remote
import java.rmi.RemoteException

interface WeakeningService : Remote {
    /**
     * Generate examples from the given system and environment specifications, and a progress property.
     *
     * @param sysSpecs the system specifications
     * @param envSpecs the environment specifications
     * @param progress the progress property event
     * @param fluents the specification strings of the fluents in the invariant
     * @return the generated examples used for the inductive learning process.
     */
    @Throws(RemoteException::class)
    fun generateExamplesFromProgress(
        sysSpecs: List<Spec>,
        envSpecs: List<Spec>,
        progress: String,
        fluents: List<String>
    ): List<Word<String>>

    /**
     * Generate examples from the given system and environment specifications, and a trace.
     *
     * @param sysSpecs the system specifications
     * @param envSpecs the environment specifications
     * @param trace the trace that is observed, i.e., the system may contain a trace that has additional
     *              events that are not in the trace.
     * @param inputs the alphabet of the trace, which could be a subset of the system alphabet.
     * @param fluents the specification strings of the fluents in the invariant
     * @return the generated examples used for the inductive learning process.
     */
    @Throws(RemoteException::class)
    fun generateExamplesFromTrace(
        sysSpecs: List<Spec>,
        envSpecs: List<Spec>,
        trace: Word<String>,
        inputs: Collection<String>,
        fluents: List<String>
    ): List<Word<String>>

    /**
     * Weaken the given safety invariant with respect to the given examples. The safety invariant is in the form:
     * [](a -> b) && [](c -> d), and both the antecedent and consequent should be conjunctions of atomic propositions.
     * The weakening will first add conjunctions to the antecedent, and then remove conjunctions from the consequent.
     *
     * @param invariant the safety invariant
     * @param fluents the specification strings of the fluents in the invariant
     * @param positiveExamples the positive example traces
     * @param negativeExamples the negative example traces
     * @return a list of possible weakened safety invariant specifications
     */
    @Throws(RemoteException::class)
    fun weakenSafetyInvariant(
        invariant: String,
        fluents: List<String>,
        positiveExamples: List<Word<String>>,
        negativeExamples: List<Word<String>>
    ): List<String>

    /**
     * Weakens the given GR(1) invariant with respect to the given examples. The GR(1) invariant is in the form:
     * [](a -> b) && [](c -> d), and the antecedent should be in CNF and the consequent should be in DNF.
     *
     * @param invariant the GR(1) invariant
     * @param fluents the specification strings of the fluents in the invariant
     * @param positiveExamples the positive example traces
     * @param negativeExamples the negative example traces
     * @param maxNumOfNode the maximum number of nodes in the learned LTL formula
     * @return one possible weakened GR(1) invariant specifications
     */
    @Throws(RemoteException::class)
    fun weakenGR1Invariant(
        invariant: String,
        fluents: List<String>,
        positiveExamples: List<Word<String>>,
        negativeExamples: List<Word<String>>,
        maxNumOfNode: Int
    ): String?
}