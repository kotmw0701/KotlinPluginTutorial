package kotmw.plugin.kotlinplugintutorial

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import java.security.SecureRandom

open class KotlinPluginListener : Listener {

    @EventHandler
    fun joinCafe(e: PlayerJoinEvent) {
        e.player.sendMessage("""
            |ふわああぁ！いらっしゃぁい！よぉこそぉ↑マイクラ鯖へ～！
            |どうぞどうぞ！ゆっぐりしてってぇ！いやま゛っ↓てたよぉ！
            |やっとプレイヤーさんが来てくれたゆぉ！嬉しいなあ！
            |ねえなんにぃするぅ 色々あるよぉ、これね、${arrayOf("アスレチック","迷路","エンドラ戦","RTA").let { it[SecureRandom().nextInt(it.size)] }}って言うんだってぇ
            |${arrayOf("管理人","実況者","動画投稿者","ぺこ").let { it[SecureRandom().nextInt(it.size)] }}さんに教えてもらったンの！ここからスタートだから頑張ってにぇ
            |""".trimMargin().split("\n".toRegex(), 0).toTypedArray())
    }
}
