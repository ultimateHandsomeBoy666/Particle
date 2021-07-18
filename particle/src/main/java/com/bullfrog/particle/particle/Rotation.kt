package com.bullfrog.particle.particle

enum class RotationDirection {
    ClockWise,
    AntiClockWise
}

class Rotation(
        internal var angularVelocity: Int = 0, // degree per second
        internal var rotationDirection: RotationDirection = RotationDirection.ClockWise
) {

}