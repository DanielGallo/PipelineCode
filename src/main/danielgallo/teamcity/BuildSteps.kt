import jetbrains.buildServer.configs.kotlin.BuildSteps
import jetbrains.buildServer.configs.kotlin.buildSteps.ScriptBuildStep

class AndroidBuildStep(
    private val androidSdkPath: String,
    private val apkName: String
) : ScriptBuildStep ({
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
    val result = AndroidBuildStep(config.androidSdkPath, config.apkName)
    step(result)
    return result
}
