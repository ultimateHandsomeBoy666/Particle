package com.bullfrog.particle.particle.configuration

enum class RotationDirection {
    ClockWise,
    AntiClockWise
}

sealed class Rotation(
    internal var rotationDirection: RotationDirection = RotationDirection.ClockWise
)

class RotationX(
    internal var angularVelocityX: Int = 0, // X degree per second
) : Rotation()

class RotationY(
    internal var angularVelocityY: Int = 0, // Y degree per second
) : Rotation()

class RotationZ (
    internal var angularVelocityZ: Int = 0, // Z degree per second
): Rotation()