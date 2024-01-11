open class Enemy(hp:Int, dmg:Int):IngameCharacter(hp, dmg) {

    // Original Damage Berechnung wird überschrieben damit der Schaden nur für die EnemyKlasse überschrieben
    // wird da sie mit steigender XP des Spielers angepasst wird
    override fun dealDamage():Int{ //berechnung des vergebenen Schadens inklusive eventueller Items zur Schadenerhöhung
        //var damage:Int = dmg
        //damage = (damage / Malus()).toInt() // Anpassung der dmg der Gegner durch den errechneten Malus
        //println(damage)

        return  dmg //  Rückgabe errechneter Damagewert
    } // dealDamage end

    // werte bei Betreten eines Feldes anhand SpielerXP neu berechnen
    fun werteNeu(){
        val playerMalus: Double = Player.getInstance().malus()
        this.hP = (this.hP / playerMalus).toInt() // der Malus muss mit der instanz des PLayers aufgerufen werde
        this.dmg = (this.dmg / playerMalus).toInt() // da sonst die instanz des Enemy für die malus berechnung genommen wird
    }
}