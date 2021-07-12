package com.bullfrog.particle.particle

class Rotation(
        internal var angularVelocity: Int = 0, // degree per second
        internal var rotationDirection: RotationDirection = RotationDirection.ClockWise
) {

    companion object {
        val ROTATION_NONE = Rotation()
    }

    enum class RotationDirection {
        ClockWise,
        AntiClockWise
    }
}