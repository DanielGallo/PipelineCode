import jetbrains.buildServer.configs.kotlin.BuildSteps
import jetbrains.buildServer.configs.kotlin.buildSteps.ScriptBuildStep

class AndroidBuildStep(
    private val androidSdkPath: String,
    private val apkName: String
) : ScriptBuildStep ({
    type = "android"
    scriptContent = """
        echo "Building $apkName"
    """.trimIndent()
})

class AndroidBuildStepConfig {
    var androidSdkPath: String = ""
    var apkName: String = ""
}

fun BuildSteps.android(configure: AndroidBuildStepConfig.() -> Unit) : AndroidBuildStep {
    val config = AndroidBuildStepConfig().apply(configure)
    return AndroidBuildStep(config.androidSdkPath, config.apkName)
}
