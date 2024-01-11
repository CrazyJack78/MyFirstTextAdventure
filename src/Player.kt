// in der Klassenerstellung des Players erfolgt dir Eigenschaften Empfang/Übergabe
// über eine Funktion im AdventureType
class Player:IngameCharacter(classChoiceHp(), classChoiceDmg()) {

    var inventar = mutableListOf<Item>()
    var teleUnUsed:Boolean = true

    fun gesamtSchaden():Int {
        //var xpDmgMalus: Double = 1.0
        //val xpDmgMalus: Double = (101.0 - exp) / 100
        // der malus wird errechnet durch exp und wird von 100 abgezogen und dann durch 100 dividiert,
        // um dann kleiner als 1 mit dem schaden multipliziert zu werden
        return dmg + addWeaponDamage
    }


    // Singleton Aufbau Versuch: Soll dafür sorgen, dass es nur einen Spieler im Spiel geben kann
    // so braucht der spieler nicht mit übergeben werden, sondern ist global verfügbar

    companion object { // Zur erstellung eines einzigen Objektes aus dieser klasse
        private val instance: Player = Player()  // Player aus der Player-Klasse erstellen
        /* dies ist der direkte Aufruf zur Erstellung des Players direkt bei Programmstart
        sollten Werte dynamisch angepasst werden, müssen sie hier mit übergeben werden aus einer
        ausgelagerten Funktion mit rückgabe, bzw in der Übergabe zur elternklasse ect,
         erste eingabe wäre hier im PLayer
        */
        fun getInstance(): Player { // instance erstellen die uns immer das eine erstellte Objekt zurückliefert
            return instance
        } // überall im Spiel kann man dann statt mit PLayer.getInstance auf den Spieler zugreifen
    }





    // Klassen Methoden
    fun pickUp(i:Item) {
        inventar.add(i) // ein übergebenes Objekt in die List inventar zufügen
    }


    fun inventar(){ // Anzeigen des Inventars und fragen, ob etwas benutzt werden möchte

        println("Du hast folgende Gegenstände im Inventar:\n--------------------------")
        getInstance().inventar.forEachIndexed { index , item ->

            itemAusgabe(item,index+1) // Item eigenschaften Ausgabe
        }
        print("-------------------------\n")

            println("Welches Item möchtest du nutzen? 1-${inventar.size}")
            var choice:Int = 0
            try {
                choice = readln().toInt()-1 // Index ist 1 kleiner als auswahl
            }catch (e: NumberFormatException){
                choice = inventar.size
            }
            if (choice  < inventar.size){ // Überprüfung, ob Inventar Platz belegt
                val used:Boolean = inventar[choice].useItem()
                /*
                if (inventar[choice] is Teleporter){
                    used = inventar[choice].useItem()
                }else used = inventar[choice].useItem()

                 */
                if (inventar[choice] is Teleporter && used){
                    teleUnUsed = false
                }
                if (used){
                    inventar.removeAt(choice)  // entfernen des ausgewählten Items
                    println(" und das Item wurde verbraucht!\n")
                }else println("Das Item ist nicht verbraucht worden")

            }else println("Item nicht vorhanden, weiter gehts...")

    }

} // Player end