package com.qrai.neoserialize

import scala.reflect.Typeable

extension [A1: Typeable, B1](f1: A1 => B1)
  def orElse[A2: Typeable, B2](f2: A2 => B2): (A1 | A2) => (B1 | B2) =
    case v1: A1 => f1(v1)
    case v2: A2 => f2(v2)