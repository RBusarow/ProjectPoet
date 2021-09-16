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
  id("com.rickbusarow.gradle-dependency-sync") version "0.11.2"
}

dependencies {

  dependencySync("com.android.tools.build:gradle:7.0.2")
  dependencySync("com.github.javaparser:javaparser-symbol-solver-core:3.23.0")
  dependencySync("com.rickbusarow.hermit:hermit-core:0.9.5")
  dependencySync("com.rickbusarow.hermit:hermit-coroutines:0.9.5")
  dependencySync("com.rickbusarow.hermit:hermit-junit4:0.9.5")
  dependencySync("com.rickbusarow.hermit:hermit-junit5:0.9.5")
  dependencySync("com.rickbusarow.hermit:hermit-mockk:0.9.5")
  dependencySync("com.squareup.anvil:gradle-plugin:2.3.4")
  dependencySync("com.squareup:kotlinpoet:1.9.0")
  dependencySync("com.vanniktech:gradle-maven-publish-plugin:0.18.0")

  dependencySync("io.kotest:kotest-assertions-core-jvm:4.6.1")
  dependencySync("io.kotest:kotest-property-jvm:4.6.1")
  dependencySync("io.kotest:kotest-runner-junit5-jvm:4.6.1")

  dependencySync("javax.inject:javax.inject:1")

  dependencySync("net.swiftzer.semver:semver:1.1.1")

  dependencySync("org.codehaus.groovy:groovy-xml:3.0.8")
  dependencySync("org.codehaus.groovy:groovy:3.0.8")
  dependencySync("org.jetbrains.kotlin:kotlin-compiler-embeddable:1.5.30")
  dependencySync("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")
  dependencySync("org.jetbrains.kotlin:kotlin-reflect:1.5.30")
  dependencySync("org.jetbrains.kotlinx:kotlinx-knit:0.3.0")
  dependencySync("org.jlleitschuh.gradle:ktlint-gradle:10.2.0")
  dependencySync("org.junit.jupiter:junit-jupiter-api:5.7.2")
  dependencySync("org.junit.jupiter:junit-jupiter-engine:5.7.2")
  dependencySync("org.junit.jupiter:junit-jupiter-params:5.7.2")
}
