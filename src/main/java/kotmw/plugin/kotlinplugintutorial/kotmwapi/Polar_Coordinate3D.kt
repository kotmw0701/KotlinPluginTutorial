package kotmw.plugin.kotlinplugintutorial.kotmwapi

import org.bukkit.Location
import org.bukkit.World

class Polar_Coordinate3D(private val world: World, private var radius: Double, private var theta: Double, private var phi: Double): Cloneable {

    fun convertLocation() : Location{
        val x = radius*Math.sin(theta)*Math.cos(phi)
        val y = radius*Math.sin(theta)*Math.sin(phi)
        val z = radius*Math.cos(theta)
        return Location(world, x, y, z)
    }

    fun add(pc :Polar_Coordinate3D): Polar_Coordinate3D {
        this.radius += pc.radius
        this.theta += pc.theta
        this.phi += pc.phi
        return this
    }

    fun add(radius: Double, theta: Double, phi: Double): Polar_Coordinate3D {
        this.radius += radius
        this.theta += theta
        this.phi += phi
        return this
    }

    override fun clone(): Polar_Coordinate3D {
        return super.clone() as Polar_Coordinate3D
    }

    companion object {
        fun fromLocation(loc: Location): Polar_Coordinate3D{
            val radius = loc.distance(Location(loc.world, 0.0, 0.0, 0.0))
            val x = loc.x
            val y = loc.y
            val z = loc.z
            val theta = Math.acos(z/Math.sqrt(Math.pow(x, 2.0)+Math.pow(y, 2.0)+Math.pow(z, 2.0)))
            val phi = Math.atan(y/x)
            return Polar_Coordinate3D(loc.world!!, radius, theta, phi)
        }
    }
}
