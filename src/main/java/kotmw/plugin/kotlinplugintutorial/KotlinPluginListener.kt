package kotmw.plugin.kotlinplugintutorial

import kotmw.plugin.kotlinplugintutorial.kotmwapi.Polar_Coordinate3D
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.scheduler.BukkitRunnable
import java.security.SecureRandom

open class KotlinPluginListener(val plugin :KotlinPluginTutorial) : Listener {

    @EventHandler
    fun joinCafe(e: PlayerJoinEvent) {
        e.player.sendMessage("""
            |ふわああぁ！いらっしゃぁい！よぉこそぉ↑マイクラ鯖へ～！
            |どうぞどうぞ！ゆっぐりしてってぇ！いやま゛っ↓てたよぉ！
            |やっとプレイヤーさんが来てくれたゆぉ！嬉しいなあ！
            |ねえなんにぃするぅ 色々あるよぉ、これね、${arrayOf("アスレチック", "迷路", "エンドラ戦", "RTA").let { it[SecureRandom().nextInt(it.size)] }}って言うんだってぇ
            |${arrayOf("管理人", "実況者", "動画投稿者", "ぺこ").let { it[SecureRandom().nextInt(it.size)] }}さんに教えてもらったンの！ここからスタートだから頑張ってにぇ
            |""".trimMargin().split("\n".toRegex(), 0).toTypedArray())
    }

    @EventHandler
    fun clickRight(e: PlayerInteractEvent) {
        if (e.action == Action.RIGHT_CLICK_BLOCK) {
            object : BukkitRunnable() {
                override fun run() {
                    e.player.location.world?.spawnParticle(Particle.REDSTONE, e.player.location.add(0.0, 2.0, 0.0), 1, Particle.DustOptions(Color.RED, 1.0f))
                }
            }.runTaskTimer(plugin, 0, 50)
        }
    }

}
