package deps

object NeoForgeDeps {
    fun get(minecraft: String): List<VersionedDependency> {
        return buildDependencies {
            if (minecraft == "1.21.8"){
                modstitchModRuntimeOnly("thedarkcolour:kotlinforforge:5.10.0")
            }
            if (minecraft == "1.21.10"){
                modstitchModRuntimeOnly("thedarkcolour:kotlinforforge:6.0.0")
            }

        }
    }
}