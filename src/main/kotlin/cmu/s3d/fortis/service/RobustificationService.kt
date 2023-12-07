package cmu.s3d.fortis.service

import cmu.s3d.fortis.common.Spec
import cmu.s3d.fortis.common.SpecType
import cmu.s3d.fortis.common.SupervisoryOptions
import java.rmi.Remote
import java.rmi.RemoteException

interface RobustificationService : Remote {
    /**
     * Robustify the given system with respect to the deviated environment and property. This method uses the
     * supervisory control synthesis algorithm to compute the robustified system.
     *
     * @param sysSpecs the system specifications
     * @param envSpecs the environment specifications
     * @param propSpecs the property specifications
     * @param options the robustification options
     * @param outputFormat the output format of the robustified system
     * @return the robustified system in the form of specifications.
     */
    @Throws(RemoteException::class)
    fun robustify(
        sysSpecs: List<Spec>,
        envSpecs: List<Spec>,
        propSpecs: List<Spec>,
        options: SupervisoryOptions,
        outputFormat: SpecType
    ): List<String>
}

