open class Heiltrank():Item {
    var hpAdd = 0
    //override var name = "Heiltrank"
    // Da der Primäre Constructor nichts hat kann man beim sekundären ein leeres this lassen,
    //     darf es aber trotzdem nicht vergessen
    // da hier zwei verschiedene Constructoren verwendet werden die jeder eigene Eigenschaften haben die der andere
    // nicht hat, muss ein primärer leerer verwendet werden und die anderen Beiden bekommen ein leeres This
    // bei mehreren Constructoren braucht auch der leere Primäre leere Constructor Klammern
    constructor(mutator:Double):this(){ // Construktor vom Erstellen des Spiels
        this.hpAdd = (20*mutator.toInt()..60*mutator.toInt()).random()
    }

    constructor(hpAddLoad:Int):this(){ // Constructor vom Laden des Spiels
        this.hpAdd = hpAddLoad
    }

    override val typ: String
        get() = "Heiltrank"
    override val faehigkeit: String
        get() = "HP"
    override val name:String
        get() = "Heiltrank (${hpAdd.toString()}hp)"
    // der heiltrank wird mit einer zufälligen Menge an HP generiert
    override val eigenschaftsStaerke: Int
        get() = hpAdd


    override fun useItem():Boolean {
        Player.getInstance().hP += hpAdd
        if (Player.getInstance().hP > Player.getInstance().maxHp) {
            Player.getInstance().hP = Player.getInstance().maxHp

        }
        print("Du hast nun wieder " + Player.getInstance().hP + " Leben ")
        return true
    }

} // Heiltrank end
