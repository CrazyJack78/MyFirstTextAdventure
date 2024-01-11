fun statusausgabe(){
    println("\nDu hast ${Player.getInstance().hP} Leben " +
            ", machst ${Player.getInstance().dmg} Grundschaden sowie" +
            " ${Player.getInstance().addWeaponDamage} zusätzlichen Schaden," +
            " also insgesamt ${Player.getInstance().gesamtSchaden()} Schaden\n" +
            "und hast zusätzlich eine Rüstung die ${Player.getInstance().addArmor} Schaden absorbiert")
    println("Du hast ${Player.getInstance().characterXP} XP")

}