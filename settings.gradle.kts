pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

        maven {
            url = uri("https://maven.pkg.github.com/sportzinteractive/gaming-f1-fantasy-android")
            credentials {
                username = System.getProperty("gpr.f1.usr") ?: System.getenv("GPR_UEFA_USR")
                password = System.getProperty("gpr.f1.key") ?: System.getenv("GPR_UEFA_KEY")
            }
        }

        maven("https://jitpack.io") // for Editorial
    }
}

rootProject.name = "Match_Predictor"
include(":app")
//include(":match_predictor")
//include(":core")
