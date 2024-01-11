import java.io.File

val startSign = "_start_"
val endSign = "_end_"
val trennSign = "_trenn_"

fun saveIn(koord:Spielfeld){
    //Spielereigenschaften
    val expPlayer:Int = Player.getInstance().characterXP
    val dmgPlayer:Int = Player.getInstance().dmg
    val addWeaponDmgPlayer:Int = Player.getInstance().addWeaponDamage
    val addArmor:Int = Player.getInstance().addArmor
    val maxHP:Int = Player.getInstance().maxHp
    val hp:Int = Player.getInstance().hP
    //Eigenschaften in Liste zusammengefasst
    val eigenschaften = listOf<Int>(expPlayer,dmgPlayer,addWeaponDmgPlayer,addArmor,maxHP,hp)

    // Verortung des Spielers
    val xKoord:Int = koord.playerX
    val yKoord:Int = koord.playerY
    // Verortung des Spielers zusammengefasst
    val xyKoord = listOf<Int>(xKoord,yKoord)

    //Inventar
    val inventar:MutableList<Item> = Player.getInstance().inventar

    //InventarKlasse Item to String
    var inventarString:String =""
    inventar.forEachIndexed { index, inhalt ->
        if (index == 0) inventarString = "Inventar${startSign}\n"
        println(inhalt.typ)
        val typ = inhalt.typ
        if (typ == "Heiltrank"){
            inventarString += "InvPl: " + index.toString() + " Class-Heiltrank " +
                    " ItemName: " + "iN${startSign}" + inhalt.name + "iN${endSign}" +
                    "ItemEigenschaft: " + "iE${startSign}" + inhalt.eigenschaft + "iE${endSign} HP\n"
        }else
        if (typ == "Weapon"){
            inventarString += "InvPl: " + index.toString() + " Class-Weapon " +
                " ItemName: " + "iN${startSign}" + inhalt.name + "iN${endSign}" +
                "ItemEigenschaft: " + "iE${startSign}" + inhalt.eigenschaft + "iE${endSign} dmg\n"
        }else
        if (typ == "Amor"){
            inventarString += "InvPl: " + index.toString() + " Class-Armor " +
                " ItemName: " + "iN${startSign}" + inhalt.name + "iN${endSign}" +
                "ItemEigenschaft: " + "iE${startSign}" + inhalt.eigenschaft + "iE${endSign} Protection\n"
        }else
        if (typ == "Teleporter"){
            inventarString += "InvPl: " + index.toString() + " Class-Armor " +
                " ItemName: " + "iN${startSign}" + inhalt.name + "iN${endSign}" +
                "ItemEigenschaft: kann teleportieren!\n"
        }
        if (index == inventar.size-1) inventarString += "Inventar${endSign}"
    }

    // Alles in einem String zusammenfassen
    var uebergabeString = ""
    eigenschaften.forEachIndexed{ index,inhalt ->
        if (index == 0) uebergabeString += "pEXP${startSign}"+inhalt.toString()+"pEXP${endSign}\n"
        if (index == 1) uebergabeString += "pDMG${startSign}"+inhalt.toString()+"pDMG${endSign}\n"
        if (index == 2) uebergabeString += "pAddDMG${startSign}"+inhalt.toString()+"pAddDMG${endSign}\n"
        if (index == 3) uebergabeString += "pAddARM${startSign}"+inhalt.toString()+"pAddARM${endSign}\n"
        if (index == 4) uebergabeString += "pMaxHP${startSign}"+inhalt.toString()+"pMaxHP${endSign}\n"
        if (index == 5) uebergabeString += "pHP${startSign}"+inhalt.toString()+"pHP${endSign}\n"
    }
    xyKoord.forEachIndexed{ index,inhalt ->
        if (index == 0) uebergabeString += "xK${startSign}" + inhalt.toString() + "xK${endSign}/"
        if (index == 1) uebergabeString += "yK${startSign}" + inhalt.toString() + "yK${endSign}\n"
    }

    uebergabeString += inventarString

    File("Data/game.save").writeText(uebergabeString)


}