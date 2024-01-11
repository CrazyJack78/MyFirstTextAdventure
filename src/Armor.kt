class Armor():Item {
    var arm = (5..15).random() // erstellen der Rüstung mit Wert
    /*var arm:Int = 0
    constructor(){
        arm = (5..15).random() // erstellen der Rüstung mit Wert
    }
    Da der Primäre Constructor nichts hat kann man beim sekundären ein leeres this lassen,
     darf es aber trotzdem nicht vergessen
     bei mehreren Constructoren braucht auch der leere Primäre leere Constructor Klammern
     */
    constructor(armIn:Int):this(){
        arm = armIn
    }
    override val typ: String
        get() = "Armor"
    override val faehigkeit: String
        get() = "Schutz"

    override val eigenschaftsStaerke: Int
        get() = arm
    override val name = "Rüstung" // Für Namenausgabe
    override fun useItem():Boolean {
        //  Player.getInstance().addWeaponDamage = damage
        if (arm > Player.getInstance().characterXP){
            println("Für diese Rüstung bist du noch zu unerfahren")
            return  false
        }
        if(Player.getInstance().addArmor < arm){
            Player.getInstance().addArmor = arm // Übergabe der Rüstung an Player
            println("Gute Wahl, du trägst nun eine Rüstung mit $arm Schutz")
            return true
        }else {
            println("Diese Rüstung bietet weniger Schutz als deine alte Rüstung und wird entsorgt")
            return true
        }

    }

}