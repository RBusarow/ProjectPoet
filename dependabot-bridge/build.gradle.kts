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

plugins {
  id("com.rickbusarow.gradle-dependency-sync") version "0.11.4"
}

dependencies {

  dependencySync("com.android.tools.build:gradle:7.0.3")
  dependencySync("com.github.javaparser:javaparser-symbol-solver-core:3.23.1")
  dependencySync("com.rickbusarow.hermit:hermit-core:0.9.5")
  dependencySync("com.rickbusarow.hermit:hermit-coroutines:0.9.5")
  dependencySync("com.rickbusarow.hermit:hermit-junit4:0.9.5")
  dependencySync("com.rickbusarow.hermit:hermit-junit5:0.9.5")
  dependencySync("com.rickbusarow.hermit:hermit-mockk:0.9.5")
  dependencySync("com.squareup.anvil:gradle-plugin:2.3.10-1-6-0")
  dependencySync("com.squareup:kotlinpoet:1.10.2")
  dependencySync("com.vanniktech:gradle-maven-publish-plugin:0.18.0")

  dependencySync("io.kotest:kotest-assertions-core-jvm:5.0.0")
  dependencySync("io.kotest:kotest-property-jvm:5.0.0")
  dependencySync("io.kotest:kotest-runner-junit5-jvm:5.0.0")

  dependencySync("javax.inject:javax.inject:1")

  dependencySync("net.swiftzer.semver:semver:1.1.2")

  dependencySync("org.codehaus.groovy:groovy-xml:3.0.9")
  dependencySync("org.codehaus.groovy:groovy:3.0.9")
  dependencySync("org.jetbrains.kotlin:kotlin-compiler-embeddable:1.6.0")
  dependencySync("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")
  dependencySync("org.jetbrains.kotlin:kotlin-reflect:1.6.0")
  dependencySync("org.jetbrains.kotlinx:kotlinx-knit:0.3.0")
  dependencySync("org.jlleitschuh.gradle:ktlint-gradle:10.2.0")
  dependencySync("org.junit.jupiter:junit-jupiter-api:5.8.2")
  dependencySync("org.junit.jupiter:junit-jupiter-engine:5.8.2")
  dependencySync("org.junit.jupiter:junit-jupiter-params:5.8.2")
}
