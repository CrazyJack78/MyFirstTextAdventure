import kotlin.system.exitProcess

fun fight(player:IngameCharacter, npc:IngameCharacter){
    var fightPosition:Int = (0..1).random()
    //var erlittenerSchaden = 0
    val playerHpStart:Int = Player.getInstance().hP
    while (!(Player.getInstance().isDead() || npc.isDead())){  //leben beide = !(false || false) = true --- stirbt einer !(false || true) = false > Weil negiert

        if (fightPosition == 0) {
            npc.receiveDamage(Player.getInstance().dealDamage())   //Schadensberechnung receiveDamage berechnung ausgehend von dealDamage Berechnung /Rüstung/Stärke usw
            fightPosition = 1
        }else {
            Player.getInstance().receiveDamage(npc.dealDamage())
            //erlittenerSchaden += npc.dealDamage()
            fightPosition = 0
        }
    } // while Ende
    if (player.isDead()){
        println("You're Dead. Try again")
        exitProcess(1) //
        // exitProcess(1)
    }else {
        Player.getInstance().characterXP ++ // Spieler XP Erhöhung in der InGameCharacterKlasse
        //Player.getInstance().exp ++
        println("Du hast ${playerHpStart - Player.getInstance().hP} Schaden erlitten\n")
    }
} // fight end
