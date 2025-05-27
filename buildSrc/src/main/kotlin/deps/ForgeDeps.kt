package deps

object ForgeDeps {
    fun get(minecraft: String): List<VersionedDependency> {
        return buildDependencies {
            modstitchModImplementation("thedarkcolour:kotlinforforge:4.11.0")
        }
    }
}