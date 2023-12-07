package cmu.s3d.fortis.service

import cmu.s3d.fortis.common.EquivClassRep
import cmu.s3d.fortis.common.RobustnessOptions
import cmu.s3d.fortis.common.Spec
import cmu.s3d.fortis.common.SpecType
import java.rmi.Remote
import java.rmi.RemoteException

interface RobustnessComputationService : Remote {
    /**
     * Compute the robustness of the given system, environment, and property. A deviation model is used to generated
     * explanations if exists.
     *
     * @param sysSpecs the system specifications
     * @param envSpecs the environment specifications
     * @param propSpecs the property specifications
     * @param devSpecs the deviation model specifications
     * @param options the robustness computation options
     * @return the robustness of the system in the form of equivalence classes and their representative traces
     *         (with explanations).
     */
    @Throws(RemoteException::class)
    fun computeRobustness(
        sysSpecs: List<Spec>,
        envSpecs: List<Spec>,
        propSpecs: List<Spec>,
        devSpecs: List<Spec>,
        options: RobustnessOptions
    ): List<EquivClassRep>

    /**
     * Compute the unsafe behaviors of the given system, environment, and property. A deviation model is used to
     * generated explanations if exists.
     *
     * @param sysSpecs the system specifications
     * @param envSpecs the environment specifications
     * @param propSpecs the property specifications
     * @param devSpecs the deviation model specifications
     * @param options the robustness computation options
     * @return the unsafe behaviors of the system in the form of equivalence classes and their representative traces
     *         (with explanations).
     */
    @Throws(RemoteException::class)
    fun computeIntolerableBeh(
        sysSpecs: List<Spec>,
        envSpecs: List<Spec>,
        propSpecs: List<Spec>,
        devSpecs: List<Spec>,
        options: RobustnessOptions
    ): List<EquivClassRep>

    /**
     * Compare the robustness of two systems with same environment and property. A deviation model is
     * used to generated explanations if exists.
     *
     * @param sys1Specs the system1 specifications
     * @param sys2Specs the system2 specifications
     * @param envSpecs the environment specifications
     * @param propSpecs the property specifications
     * @param devSpecs the deviation model specifications
     * @param options the robustness computation options
     * @return the robustness that system1 is more robust than system2 in the form of equivalence classes
     *         and their representative trace (with explanations).
     */
    @Throws(RemoteException::class)
    fun compareRobustnessOfTwoSystems(
        sys1Specs: List<Spec>,
        sys2Specs: List<Spec>,
        envSpecs: List<Spec>,
        propSpecs: List<Spec>,
        devSpecs: List<Spec>,
        options: RobustnessOptions
    ): List<EquivClassRep>

    /**
     * Compare the robustness of two properties with same system and environment. A deviation model is
     * used to generated explanations if exists.
     *
     * @param sysSpecs the system specifications
     * @param envSpecs the environment specifications
     * @param prop1Specs the property1 specifications
     * @param prop2Specs the property2 specifications
     * @param devSpecs the deviation model specifications
     * @param options the robustness computation options
     * @return the robustness that the system under property1 is more robust than it under property2
     *         in the form of equivalence classes and their representative trace (with explanations).
     */
    @Throws(RemoteException::class)
    fun compareRobustnessOfTwoProps(
        sysSpecs: List<Spec>,
        envSpecs: List<Spec>,
        prop1Specs: List<Spec>,
        prop2Specs: List<Spec>,
        devSpecs: List<Spec>,
        options: RobustnessOptions
    ): List<EquivClassRep>

    /**
     * Compute the weakest assumption of the given system, environment, and property.
     *
     * @param sysSpecs the system specifications
     * @param envSpecs the environment specifications
     * @param propSpecs the property specifications
     * @param options the robustness computation options
     * @param outputFormat the output format of the weakest assumption model
     * @return the weakest assumption model of the system w.r.t the property
     */
    @Throws(RemoteException::class)
    fun computeWeakestAssumption(
        sysSpecs: List<Spec>,
        envSpecs: List<Spec>,
        propSpecs: List<Spec>,
        options: RobustnessOptions,
        outputFormat: SpecType
    ): String
}