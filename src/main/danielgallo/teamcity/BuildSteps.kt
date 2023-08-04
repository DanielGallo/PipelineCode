import jetbrains.buildServer.configs.kotlin.BuildSteps
import jetbrains.buildServer.configs.kotlin.buildSteps.ScriptBuildStep

fun BuildSteps.android(init: ScriptBuildStep.() -> Unit, apkName: String) : ScriptBuildStep {
    val buildStep = ScriptBuildStep(init)
    buildStep.scriptContent = """
        echo "Building $apkName"
    """.trimIndent()

    return buildStep
}