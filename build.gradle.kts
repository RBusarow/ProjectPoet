/*
 * Copyright (C) 2021 Rick Busarow
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import io.gitlab.arturbosch.detekt.detekt
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.tasks.BaseKtLintCheckTask

buildscript {
  repositories {
    mavenCentral()
    google()
    maven("https://plugins.gradle.org/m2/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
  }
  dependencies {
    classpath(libs.agp)
    classpath(libs.kotlin.gradle)
    classpath(libs.ktlint.gradle)
    classpath(libs.vanniktech.maven.publish)
  }
}

plugins {
  id("com.github.ben-manes.versions") version "0.39.0"
  id("io.gitlab.arturbosch.detekt") version "1.18.1"
  id("com.rickbusarow.module-check") version "0.11.3"
  id("org.jetbrains.dokka") version "1.6.0"
  id("com.osacky.doctor") version "0.7.3"
  id("com.dorongold.task-tree") version "2.1.0"
  base
}

allprojects {

  repositories {
    google()
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://jitpack.io")
    jcenter {
      content {
        // needed for Detekt
        includeModule("org.jetbrains.kotlinx", "kotlinx-html-jvm")
        // https://youtrack.jetbrains.com/issue/IDEA-261387
        includeModule("org.jetbrains.trove4j", "trove4j")
      }
    }
    maven("https://s3-us-west-2.amazonaws.com/si-mobile-sdks/android/")
  }

  tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>()
    .configureEach {

      kotlinOptions {

        jvmTarget = "1.8"

        freeCompilerArgs = listOf(
          "-Xinline-classes",
          "-Xopt-in=kotlin.ExperimentalStdlibApi",
          "-Xuse-experimental=kotlin.contracts.ExperimentalContracts"
        )
      }
    }
}

@Suppress("DEPRECATION")
detekt {

  parallel = true
  config = files("$rootDir/detekt/detekt-config.yml")

  reports {
    xml.enabled = false
    html.enabled = true
    txt.enabled = false
  }
}

tasks.withType<DetektCreateBaselineTask> {

  setSource(files(rootDir))

  include("**/*.kt", "**/*.kts")
  exclude("**/resources/**", "**/build/**", "**/src/test/java**")

  // Target version of the generated JVM bytecode. It is used for type resolution.
  this.jvmTarget = "1.8"
}

tasks.withType<Detekt> {

  setSource(files(rootDir))

  include("**/*.kt", "**/*.kts")
  exclude("**/resources/**", "**/build/**", "**/src/test/java**", "**/src/test/kotlin**")

  // Target version of the generated JVM bytecode. It is used for type resolution.
  this.jvmTarget = "1.8"
}

fun isNonStable(version: String): Boolean {
  val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
  val regex = "^[0-9,.v-]+(-r)?$".toRegex()
  val isStable = stableKeyword || regex.matches(version)
  return isStable.not()
}

tasks.named(
  "dependencyUpdates",
  com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask::class.java
).configure {
  rejectVersionIf {
    isNonStable(candidate.version) && !isNonStable(currentVersion)
  }
}

allprojects {
  apply(plugin = "org.jlleitschuh.gradle.ktlint")

  configure<KtlintExtension> {
    debug.set(false)

    disabledRules.set(
      setOf(
        "no-wildcard-imports",
        "max-line-length", // manually formatting still does this, and KTLint will still wrap long chains when possible
        "filename", // same as Detekt's MatchingDeclarationName, but Detekt's version can be suppressed and this can't
        "experimental:argument-list-wrapping" // doesn't work half the time
      )
    )
  }
  tasks.withType<BaseKtLintCheckTask> {
    workerMaxHeapSize.set("512m")
  }
}

val kotlinVersion = libs.versions.kotlin.get()

allprojects {
  configurations.all {
    resolutionStrategy {
      force("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
      eachDependency {
        when {
          requested.group == "org.jetbrains.kotlin" -> useVersion(kotlinVersion)
        }
      }
    }
  }
}
