/*
 * Copyright (C) 2016 chentaov5@gmail.com
 *
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
package com.github.jllk.multidex.sample

import com.github.jllk.multidex.sample.a.SampleActivityA
import com.github.jllk.multidex.sample.b.SampleActivityB
import com.github.jllk.multidex.sample.c.SampleActivityC

import scala.collection.JavaConversions._
import scala.collection.mutable

object SampleModuleMgr {

 val sModule2dexIdx = mutable.Map[String, Integer]()

 sModule2dexIdx += (classOf[SampleActivityA].getName -> 5)
 sModule2dexIdx += (classOf[SampleActivityB].getName -> 6)
 sModule2dexIdx += (classOf[SampleActivityC].getName -> 7)

 def getConfig: java.util.Map[String, Integer] = sModule2dexIdx
}
