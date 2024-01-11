internal var nochNichtGefundenSDZ = true // ist Schwert des Zerstörers auf dem Feld?
private var x = 0 // Startwerte der Wabenkoordinaten
private var y = 0

class Wabe(spielfeld:Spielfeld) { //wir empfangen die Instanz des Spielfeldes auf dem gespielt wird damit es weitergereicht werden kann
    private var mutatorFactor:Double = 1.0 // Initialwert für die Verstärkung der Monster bei steigender Entfernung


    // erstellen der Werte für die Entfernungsmutation
    init { // Zählung der Koordinaten des Spielerasters // erster init-Block
    y++ // bei jedem aufruf der Waben Initialisierung wird ein Feld weiter gezählt
        if (y == 100){ // immer wenn die letzte Wabe einer Reihe erreicht wird,
            y = 0 // wird y zurückgesetzt
            x++ // und dafür x eins weiter gezählt
        }
        //Aufruf und Empfang des Mutatorfaktor für den steigenden Schwierigkeitsgrad im Spiel vom Start aus steigend
    mutatorFactor = entfernungMutator(spielfeld,x,y) //Instanz vom Spielfeld wird weitergereicht zur Berechnung des Mutatorwertes
}
        // Entfernungsmutationsberechnung fertig

    // erstellen der Inhalte in der Wabe (Items + Feinde)
    private val items = mutableListOf<Item>() // erstellen einer Liste in der Wabe in der die gedropten items gelistet werden
    private val npcs = mutableListOf<Enemy>(Ork(mutatorFactor)) // erstellen des ersten Feindes auf der Wabe
                    // deren Stärke mit hilfe des Entfernungsmutators berechnet wird

    init { // 2. Init-Block
        if((0..100).random() > wieOft_Org()){ npcs.add(Ork(mutatorFactor))} // eventuelle erstellung eines 2. Feindes
        if((0..100).random() > wieOftHeilung()){
            items.add(Heiltrank(mutatorFactor)) // fügt ein Heiltrank zur itemList der Wabe hinzu
        }
        if((0..100).random() > wieOftArmor()){ //  fügt eine Rüstung zur itemList der Wabe hinzu
            items.add((Armor()))
        }
        if((0..100).random() > wieOftWaffen()){
            items.add(Weapon())
        }
        if ((0..300).random() > wieOftTele()){
            items.add(Teleporter())
        }
        /*
        items.forEach{
            println(it)
        }

         */
    }

    fun interact(){

        while(npcs.size > 0){
            npcs[0].werteNeu() // Werte der Gegner bei Betreten anhand XP vom Player neu berechnen
            println("Du stehst einem Ork gegenüber er hat " + npcs[0].hP + " HP und macht mit jedem Schlag " + npcs[0].dmg + " Schaden und du hast noch " + Player.getInstance().hP + " Leben!")
            print("Was möchtest du machen? Kämpfen:1/K oder Wegrennen:2/W : ")
            val input = readlnOrNull().toString()
            if ( input in setOf("1", "K", "k", "Kämpfen","kämpfen")){ // verschiedene Möglichkeiten der Schreibweise für die Entscheidung
                println("Fight")
                fight(Player.getInstance(),npcs[0]) // Aufruf fight Funktion

                // npcs.remove(npcs[0]) -> same
                npcs.removeAt(0)
                //Zufälliger Fund des Schwerts des Zerstörers
                if ((0..100).random() > wievielSchwertDerZer() && nochNichtGefundenSDZ) {
                    nochNichtGefundenSDZ = false
                    items.add(SchwertDesZerstoerers())
                } // fügt das Item zur itemList der Wabe hinzu

            }else if (input in setOf("2", "W", "w", "Wegrennen","wegrennen")) {
                return
            }else println("Ich habe Dich nicht verstanden")


        }//while end
        if (items.size == 0) println("Der Kampf ist vorüber, leider hast du nichts gefunden. Weiter gehts zum nächsten Kampf")
        if (items.size > 0){ // sind Items vorhanden?
            println("Der Kampf ist vorüber und du hast Items gefunden\nMöchtest du sie looten J/N") //  wenn ja, möchte er aufnehmen
            if (readlnOrNull()?.lowercase() == "j"){ // wenn ja durchloopen und jedes aufnehmen
                items.forEach {
                    if (it is SchwertDesZerstoerers)
                        println("Du Hast das Schwert des Zerstörers gefunden - Glückwunsch")
                }
                if(items.size == 1) print("\nDu hast folgenden Gegenstand gefunden: ")
                else print("\nDu hast folgende Gegenstände gefunden: ")
                print(">>>>>>>  ")
                var itemZahl = 1 // für das komma zwischen den einzelnen Items in der aufzählung
                for (i in items){
                    print("" + i.name)
                    if (items.size > 1 && itemZahl < items.size) print(", ")
                    itemZahl ++
                    Player.getInstance().pickUp(i)
                }
                println(" <<<<<<")
                println()
                items.clear()

            }
        } //if itemsize end
    } // interact end

} // wabe end