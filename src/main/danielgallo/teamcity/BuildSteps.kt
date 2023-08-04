import jetbrains.buildServer.configs.kotlin.buildSteps.ScriptBuildStep

fun AndroidBuildStep(apkName : String) : ScriptBuildStep {
    val buildStep = ScriptBuildStep {
        scriptContent = """echo $apkName"""
    }

    return buildStep
}