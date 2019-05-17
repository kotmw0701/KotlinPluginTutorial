package kotmw.plugin.kotlinplugintutorial

import kotmw.plugin.kotlinplugintutorial.kotmwapi.Polar_Coordinate3D
import org.bukkit.plugin.java.JavaPlugin

class KotlinPluginTutorial : JavaPlugin() {

    override fun onEnable() {
        val cmd = KotlinPluginCommand()
        getCommand("kotlin")?.setExecutor(cmd)
        getCommand("kotmw")?.setExecutor(cmd)
        server.pluginManager.registerEvents(KotlinPluginListener(this), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
