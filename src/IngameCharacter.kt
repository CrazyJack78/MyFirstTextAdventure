open class IngameCharacter(open var maxHp:Int, open var dmg:Int) {
    var hP = maxHp
    var addWeaponDamage = 0
    var characterXP:Int = 1
    //var playerMalus:Double = 1.0
    var addArmor:Int = 0

    fun isDead():Boolean{ // Rückfrage ob Character besiegt
        return hP <= 0
    } // isDead end

    fun malus():Double{
        return  ((101.0 - characterXP) / 100) // Malus kleiner 1, um so höher xp um so kleiner der Wert
    }

    fun receiveDamage(incomeDamage:Int){ // berechnung des erhaltenen Schadens auf grundlage von vergebenen Schadens und eventueller Items zu Reduzierung
        var damage = incomeDamage
        //damage -= addArmor // Rüstung
        // TODO Damagebrechnung
        if (addArmor > 0) {
            damage = ((1 - (addArmor.toDouble() * 2) / 100) * damage.toDouble()).toInt()
            /* Der Rüstungswert wird verdoppelt und als Prozentsatz vom eigentlichen Schaden abgezogen
            zB 20 Rüstung ergeben 40% die vom Schaden abgezogen werden indem sie durch 100 geteilt (0,4)
            von 1 abgezogen (0,6) und dann mit dem Schaden multipliziert werden - 10 Schaden * 0,6 = 6 Schaden
            das ganze muss wegen der Genauigkeit in Double Zahlen geschehen
             */
        }
        hP -= damage
    } // receiveDamage end

    open fun dealDamage():Int{ //berechnung des vergebenen Schadens inklusive eventueller Items zur Schadenerhöhung
        var damage:Int = dmg
        damage += addWeaponDamage //
        //damage -= addArmor
        //println(damage)

        return  damage //  Rückgabe errechneter Damagewert
    } // dealDamage end
} // IngameCharacter end