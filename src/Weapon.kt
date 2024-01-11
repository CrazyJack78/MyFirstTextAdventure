open class Weapon(): Item {
    open var  damage = (5..20).random()

    /*
    constructor():this(){
      val  damage = (5..20).random()
    }
    Da der Primäre Constructor nichts hat kann man beim sekundären ein leeres this lassen,
     darf es aber trotzdem nicht vergessen
     bei mehreren Constructoren braucht auch der leere Primäre leere Constructor Klammern
     */
    constructor(damageSave:Int):this(){
       var damage = damageSave
    }
    override val typ: String
        get() = "Weapon"
    override val faehigkeit: String
        get() = "Damage"


    override val name:String
        get() = "Waffe(" + damage.toString() + " dmg)"
    override val eigenschaftsStaerke: Int
        get() = damage



    override fun useItem():Boolean {
        if (damage > Player.getInstance().characterXP){
            println("Für diese Waffe bist du noch zu unerfahren")
            return false
        }
        else if (Player.getInstance().addWeaponDamage < damage) {
            Player.getInstance().addWeaponDamage = damage
            print("Du machst nun " + (Player.getInstance().dmg + Player.getInstance().addWeaponDamage) + " Schaden ")
            return true
        }
        else {
            print("Schaden zu gering, Waffe wird entsorgt ")
            return true
        }
    }
}