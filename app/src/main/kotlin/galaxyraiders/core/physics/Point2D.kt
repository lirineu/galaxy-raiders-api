@file:Suppress("UNUSED_PARAMETER") // <- REMOVE
package galaxyraiders.core.physics

import kotlin.math.abs
import kotlin.math.sqrt

data class Point2D(val x: Double, val y: Double) {
  operator fun plus(p: Point2D): Point2D {
    return Point2D(x + p.x, y + p.y)
  }

  operator fun plus(v: Vector2D): Point2D {
    return Point2D(x + v.dx, y + v.dy)
  }

  override fun toString(): String {
    return "Point2D(x=$x, y=$y)"
  }

  fun toVector(): Vector2D {
    return Vector2D(x, y)
  }

  fun impactVector(p: Point2D): Vector2D {
    return Vector2D(abs(x - p.x), abs(y - p.y))
  }

  fun impactDirection(p: Point2D): Vector2D {
    val vetorDeImpacto: Vector2D = impactVector(p)
    return vetorDeImpacto / vetorDeImpacto.magnitude
  }

  fun contactVector(p: Point2D): Vector2D {
    val vetorDeImpacto: Vector2D = impactVector(p)
    return vetorDeImpacto.normal
  }

  fun contactDirection(p: Point2D): Vector2D {
    val vetorDeContato: Vector2D = contactVector(p)
    return vetorDeContato / vetorDeContato.magnitude
  }

  fun distance(p: Point2D): Double {
    return sqrt(abs(x - p.x) * abs(x - p.x) + abs(y - p.y) * abs(y - p.y))
  }
}

