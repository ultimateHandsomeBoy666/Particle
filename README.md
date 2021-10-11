# particle

[![](https://jitpack.io/v/ultimateHandsomeBoy666/particle.svg)](https://jitpack.io/#ultimateHandsomeBoy666/particle)

[中文介绍](https://juejin.cn/post/6986667003884863519)

This is a handy android library for particle effect.

To start with, you need to add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Then add the dependency

```groovy
dependencies {
	implementation 'com.github.ultimateHandsomeBoy666:Particle:0.1.2'
}
```

<br/>

And add the following code:
```kotlin
Particles.with(context, container) // container is the parent ViewGroup for particles
		.colorFromView(button)// color sampling from button
		.particleNum(200)// how many particles
		.anchor(button)// use button as the anchor of the animation
		.shape(Shape.CIRCLE)// circle particle
		.radius(2, 6)// random circle radius from 2 to 6
		.anim(ParticleAnimation.EXPLOSION)// using explosion animation
		.start()
```
you can get something like this:

<img src="https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/da7082f52a674bafb5eeb86eb25de7c4~tplv-k3u1fbpfcp-watermark.image" width="180" height="400">

You can have more particle annimations by customizing the particle motion curve. The app module in the project shows how to customize it, check it out. 

<img src="https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/2e965bcfd21a42a7ab9fc23dedae21ef~tplv-k3u1fbpfcp-watermark.image" width="180" height="400"><img src="/gifs/demo.gif" width="180" height="400"><img src="/gifs/demo1.gif" width="180" height="400"><img src="/gifs/demo2.gif" width="180" height="400"><img src="/gifs/demo4.gif" width="180" height="400"><img src="/gifs/demo5.gif" width="180" height="400">

