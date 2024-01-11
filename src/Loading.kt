import java.io.File

private val playerReloadList = mutableListOf<Int>()
private val playerKoordList = mutableListOf("" to 0)
private val inventarPairList = mutableListOf("" to 0)
private var sdzVorhanden = false

private fun subStringBackInt(dateiZeile:String):Int{
    return dateiZeile.substring(dateiZeile.indexOf(startSign)+1,dateiZeile.indexOf(endSign)).toInt()
}
private fun subStringBackStringLastFound(dateiZeile:String):String{
    return dateiZeile.substring(dateiZeile.lastIndexOf(startSign)+1,dateiZeile.lastIndexOf(endSign))
}

fun playerEigenschaftenNachLaden(){
    println("XP: ${Player.getInstance().characterXP}" +
            "/dmg: ${Player.getInstance().dmg}" +
            "/addDmg: ${Player.getInstance().addWeaponDamage}" +
            "/addArm: ${Player.getInstance().addArmor}" +
            "/maxHP: ${Player.getInstance().maxHp}" +
            "/hP: ${Player.getInstance().hP}" +
            "/handycap $handyCap")
}

fun playerReload() {
    Player.getInstance().characterXP = playerReloadList[0]
    Player.getInstance().dmg = playerReloadList[1]
    Player.getInstance().addWeaponDamage = playerReloadList[2]
    Player.getInstance().addArmor = playerReloadList[3]
    Player.getInstance().maxHp = playerReloadList[4]
    Player.getInstance().hP = playerReloadList[5]
    handyCap = playerReloadList[6]
    //handyCapReload(playerReloadList[6])
}

fun dateiToLists() {


    File("Data/Game.save").bufferedReader().use { bufferReader ->
        bufferReader.forEachLine { line ->
        /* man kann statt line auch it verwenden, wenn man das "line ->" weg lässt, allerdings gibt es eine warnung wegen Shadowing,
         weil it auch schon nach .use verwendet werden kann.
         Ich hab jetzt bei beiden it weg gelassen wegen eindeutiger Namen statt "bufferReader ->" und dann bufferReader.forEachLine
         kann aber auch schon it.forEachLine verwendet werden, bufferReader ist auch nur eine eigene Variable
         */
        if (line.contains("AdventureTyp")) {
                auswahl = subStringBackStringLastFound(line)
                //println(auswahl)
                ifNewgame = false
            }

            // Playereigenschaften übertragen
            if (line.contains("P-Eigen")) { // Spielerwertewerden in listOf gespeichert
                playerReloadList.add(subStringBackInt(line))
            }

            // Player Koordinaten übertragen
            if (line.contains("Koord")) {
                //if (it.contains("xK")) field.playerX = subStringBackInt(it)
                //if (it.contains("yK")) field.playerY = subStringBackInt(it)
                if (line.contains("xK")) playerKoordList.add("X" to subStringBackInt(line))
                if (line.contains("yK")) playerKoordList.add("Y" to subStringBackInt(line))
            }

            // Für den Teleporter muss das Spielfeld vor der Erstellung des Inventars geschehen
            // später noch das Spielfeld speichern

            if (line.contains("SDZ")) sdzVorhanden = subStringBackStringLastFound(line).toBoolean()

            // Inventar übertragen
            if (line.contains("InvPl")) {
                inventarPairList.add(subStringBackStringLastFound(line) to subStringBackInt(line))

            }
        }


    }
}
fun loadGame(){
    dateiToLists() // inhalt aus Datei in verschiedene Listen laden
    //println(inventarPairList.size)
    // Spieler Koordinaten eintragen und Spielfeld daraus generieren
    handyCapReload(playerReloadList[6])
    //ausgabeWahrscheinlichkeiten()
    field = Spielfeld(playerKoordList.find { it.first == "X" }?.second ?:0,playerKoordList.find{ it.first == "Y"}?.second ?:0)
    field.playerX = playerKoordList.find { it.first == "X" }?.second ?:0 // X Posiion des Spielers
    field.playerX = playerKoordList.find{ it.first == "Y"}?.second ?:0 // Y Position des Spielers
    nochNichtGefundenSDZ = sdzVorhanden
    inventarPairList.forEach{
        val key     = it.first
        val value   = it.second
        if (key == "Heiltrank") Player.getInstance().inventar.add(Heiltrank(value))
        if (key == "Weapon") Player.getInstance().inventar.add(Weapon(value))
        if (key == "Armor") Player.getInstance().inventar.add(Armor(value))
        if (key == "Teleporter") Player.getInstance().inventar.add(Teleporter())
        if (key == "SDZ") {
            Player.getInstance().inventar.add(SchwertDesZerstoerers())

        }

    }
    playerReload()
    //playerEigenschaftenNachLaden()

}
fun loadAdventureType(){
    File("Data/Game.save").forEachLine {
        //ifNewgame = false
        if (it.contains("AdventureTyp")) {
            auswahl = subStringBackStringLastFound(it)
            //println(auswahl)

        }
    }
}