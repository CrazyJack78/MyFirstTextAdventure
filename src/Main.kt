lateinit var field:Spielfeld

fun main() {

    //val player: Player = Player.getInstance() // Player wird direkt bei Start in der
    // Klasse initialisiert und bekommt dort auch seine Eigenschaften zugewiesen

    while (true){
        println("Möchtest du ein neues Spiel starten oder ein altes laden (N)eu / (L)aden")
        when(readln()){
            "n","N" -> {
                ifNewgame = true
                handyCap() // Abfrage zum Schwierigkeitsgrad
                field = Spielfeld(0,0) // erstellen des Spielfeldes
                break // whileSchleife beenden
            }
            "l","L" -> {
                ifNewgame = false
                loadAdventureType()

                loadGame()
                //field = Spielfeld(0,0)
                //field = loadingSaveGame() // Spielfeld wird beim laden erstellt und ins field geladen
                break // While-Schleife beenden
            }
            else -> {
                println("Falsche Auswahl, nochmal")
            }
        }

    }




    while (true) {// Gameloop
        if (Player.getInstance().isDead()) {
            break
        }
        wohinDesWeges(field)

        field.interact() // nach erfolgreicher Richtungsauswahl
        Player.getInstance().teleUnUsed = true
        inventarAuslöser()

        //saveIn(field)
    } //Gameloop Ende
    println("Du bist tot")
}
/*
Ideen für später
verschiedene Spielerklassen -
a: Gegner die mit der entfernung vom Start aus stärker werden (Stichwort Pythagoras für Entfernungsberechnung) XXX
b: oder Gegner die mit dem eigenen Level stärker werden Multiplikator für empfangenen Schaden und Malus für verteilten Schaden XXX
XP entwicklung pro Gegner und dessen Stärke, damit verbundener anstieg der HP des Gegners (zusätzlich zum Anstieg pro Entfernung) XXX
XP vielleicht noch verfeinern
eine legendäre Waffe irgendwo auf dem feld
verschiedene Waffen und Rüstungen
einfache Rüstung hinzugefügt XXX
Die Waffen und Rüstungen nach Stärke nur bei bestimmten XP zulassen XXX
teleporter XXX
teleporter mit Leveleinschränkungen
teleporter löst die nächste Runde sofort aus
*/
