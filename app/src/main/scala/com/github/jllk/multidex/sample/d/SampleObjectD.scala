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
package com.github.jllk.multidex.sample.d

import scala.language.reflectiveCalls

object SampleObjectD {

  def hello = "hello I'am SampleObjectD!"

  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  object SeqF extends Functor[Seq] {
    def map[A, B](seq: Seq[A])(f: A => B): Seq[B] = seq map f
  }

  object optionF extends Functor[Option] {
    def map[A, B](opt: Option[A])(f: A => B): Option[B] = opt map f
  }

  object LoginF {
    def map[A, A2, B](func: A => A2)(f: A2 => B): A => B = {
      val functor = new Functor[({type λ[β] = A => β})#λ] {
        def map[A3, B](func: A => A3)(f: A3 => B): A => B = (a: A) => f(func(a))
      }
      functor.map(func)(f)
    }
  }

  trait Monad[M[_]] {
    def flatMap[A, B](fa: M[A])(f: A => M[B]): M[B]
    def unit[A](a: => A): M[A]

    // some
    def bind[A,B](fa: M[A])(f: A => M[B]): M[B] = flatMap(fa)(f)
    def >>=[A,B](fa: M[A])(f: A => M[B]): M[B] = flatMap(fa)(f)
    def pure[A](a: => A): M[A] = unit(a)
    def `return`[A](a: => A): M[A] = unit(a) // backticks to avoid keyword
  }

  object SeqM extends Monad[Seq] {
    override def flatMap[A, B](seq: Seq[A])(f: A => Seq[B]): Seq[B] = seq flatMap f
    override def unit[A](a: => A): Seq[A] = Seq(a)
  }

  object OptionM extends Monad[Option] {
    override def flatMap[A, B](opt: Option[A])(f: (A) => Option[B]): Option[B] = opt flatMap f
    override def unit[A](a: => A): Option[A] = Option(a)
  }

}
