import java.io.File

internal val startSign = '\u0160'  //"_start_"
internal val endSign =   '\u011a'  //"_end_"
internal val trennSign = '\u0164'  //"_trenn_"

// Liste der Eigenschaften erstellen um später zum String zu übertragen


var adventurTyp = auswahl // welcher Charackter wurde verwendet

// SaveFunktionsaufruf
internal  fun saveIn(koord:Spielfeld){
    val playerEigenschaften = listOf(
        "pEXP" to Player.getInstance().characterXP,
        "pDMG" to Player.getInstance().dmg,
        "pAddDMG" to Player.getInstance().addWeaponDamage,
        "pAddARM" to Player.getInstance().addArmor,
        "pMaxHP" to Player.getInstance().maxHp,
        "pHP" to Player.getInstance().hP,
        "gL" to handyCap)

    //playerEigenschaftenNachLaden()
    // Verortung des Spielers
    //val xKoord:Int = koord.playerX
    //val yKoord:Int = koord.playerY
    // Verortung des Spielers zusammengefasst
    val xyKo = listOf("xK" to koord.playerX,
                      "yK" to koord.playerY)
    val xyKoord = listOf<Int>(koord.playerX,koord.playerY)

    //Inventar
    val inventar:MutableList<Item> = Player.getInstance().inventar

    //InventarKlasse Item to String
    var inventarString:String = ""
    inventar.forEachIndexed { index, inhalt ->
        if (index == 0) inventarString = "InventarStart------------------\n"
        inventarString += "InvPl: " + index.toString() + "Typ: " + inhalt.typ +
                " ItemEigenschaft: " + "iE${startSign}" + inhalt.eigenschaftsStaerke + "${endSign}iE" +
                " ItemName: " + "iN$startSign" + inhalt.typ + "${endSign}iN" +
                " ${inhalt.faehigkeit}\n"
        if (index == inventar.size-1) inventarString += "InventarEnde----------------"
    }

    // Alles in einem String zusammenfassen
    var uebergabeString = ""

    uebergabeString += "AdventureTyp $startSign$adventurTyp$endSign\n"

    playerEigenschaften.forEach{ //(key,value) -> // statt it kann auch key (it.first) und value(it.second)
        // key Value wären nur eindeutigere frei wählbarere Namen statt firs und second
        uebergabeString += "P-Eigen: ${it.first}${startSign}"+it.second.toString()+"${endSign}${it.first}\n"
    }

    //KoordinatenÜbergabe an Save
    xyKo.forEach { (key,value) ->
        if (key == "xK") uebergabeString += "Koord: ${key}${startSign}" + value.toString() + "${endSign}${key}\n"
        if (key == "yK") uebergabeString += "Koord: ${key}${startSign}" + value.toString() + "${endSign}${key}\n"
    }

    // Schwert der Zerstörung gefunden
    uebergabeString += "SDZ $startSign$nochNichtGefundenSDZ$endSign\n"


    uebergabeString += inventarString
    //println(uebergabeString)
    File("Data/game.save").writer().use { it.write(uebergabeString)
    // it.write schreibt dann den übergebenen String in die Datei
        // use wird verwendet um die Datei nach dem Verarbeiten wieder zu schließen

    }

    // TODO SpielfeldInhalt speichern
}