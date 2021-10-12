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

import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode

plugins {
  javaLibrary
}

kotlin {
  explicitApi = ExplicitApiMode.Strict
}

dependencies {

  api(libs.kotlinPoet)






  compileOnly(gradleApi())






  implementation(libs.kotlin.compiler)
  implementation(libs.kotlin.reflect)






  testImplementation(libs.bundles.jUnit)
  testImplementation(libs.bundles.kotest)






  testImplementation(projects.modulecheckInternalTesting)
}
