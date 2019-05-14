package kotmw.plugin.kotlinplugintutorial

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

open class KotlinPluginCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        return when (command.name.toLowerCase()) {
            "kotlin" -> {
                sender.sendMessage("ことりん！")
                true
            }
            "kotmw" -> {
                if (!args.isEmpty()) {
                    when (args[0].toLowerCase()) {
                        "muni" -> {
                            sender.sendMessage("むにむに")
                            true
                        }
                        else -> false
                    }
                } else {
                    sender.sendMessage("ことむー")
                    false
                }
            }
            else -> false
        }
    }

}
