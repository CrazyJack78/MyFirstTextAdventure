var auswahl:String = "S"
var ifNewgame:Boolean = true

// Auswahl der CharKlasse Eingabekonvertierung
fun auswahlIncome(){
    val income = readln().drop(0)
    //println(income)
    when(income){
        "M","m","1" -> auswahl = "M"
        "K","F","k","f","2" -> auswahl = "K"
        "B","b","A","a","3","W","w" -> auswahl = "B"
        else -> auswahl = "S"
    }
}
/*
bei der auswahl abfragen ob es laden oder neu Auswahl getroffen wurde und dann die
Abfrage starten oder aus Speicher laden
 */
fun klasseAusgabe(typ:String):String{
    when(typ){
        "K" -> {return "Kämpfer"}
        "M" -> {return "Magier"}
        "B" -> {return "Bogenschütze"}
    }
    return ""
}

fun classChoiceHp():Int{ // Aufruf im Konstruktor der PlayerKlasse
    //val player: Player = Player.getInstance()
    //val instance: Player = Player()

    if (ifNewgame){
        println("Welche Klasse möchtest du wählen M/K/B")
        auswahlIncome() // Aufruf der Eingabe
    }else {

        println("Alte Klasse ${classChoiceAdventure()} wurde geladen")
    }

    when(auswahl){
        "M" -> return 80
        "K" -> return 120
        "B" -> return 90
        else -> {
            println("Keine Auswahl also Standard 100")
            auswahl = "S"
            return 100
        }
    }

}

fun classChoiceDmg():Int{ // Aufruf im Konstruktor der PlayerKlasse
    when(auswahl){ // Auswahl wurde schon bei der CharWahl eingestellt
        "M" -> return 25
        "K" -> return 15
        "B" -> return 20
        else -> {
            println("Keine Auswahl also Standard 100")
            auswahl = "S"
            return 100
        }
    }
}

fun classChoiceAdventure():String{
    when(auswahl){
        "M" -> return "Magier"
        "K" -> return "Kämpfer"
        "B" -> return "Bogenschütze"
        else -> return "Wanderer"
    }
}
/*
class Player(maxHp:Int=100, dmg:Int=15): Player(maxHp,dmg) {

    override val maxHp = 100
    override var dmg   = 15

    companion object { // Zur erstellung eines einzigen Objektes aus dieser klasse
        private val instance: Player = Player()  // Player aus der Player-Klasse erstellen
        fun getInstance(): Player { // instance erstellen die uns immer das eine erstellte Objekt zurückliefert
            return instance
        } // überall imSpiel kann man dann statt mit dem player, mit PLayer.getInstance auf den Spieler zugreifen
    }

}

 */