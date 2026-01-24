package deps

object ForgeDeps {
    fun get(minecraft: String): List<VersionedDependency> {
        return buildDependencies {
            modstitchLegacyModRuntimeOnly("thedarkcolour:kotlinforforge:4.11.0")
        }
    }
}