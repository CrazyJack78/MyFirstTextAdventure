private var wieOftWaffen = 99
private var wieOftHeilung = 99
private var wieOftArmor = 99
private var wieOftTele = 999
private var wieOftOrg = 99
private var wieOftSDZ = 99
var handyCap = 0
//var handyCapReload = 0

fun ausgabeWahrscheinlichkeiten(){
    println("$handyCap + $wieOftWaffen + $wieOftHeilung + $wieOftArmor + $wieOftTele + $wieOftOrg + $wieOftSDZ")
}

fun handyCap(){
    println("Welchen Schwierigkeitsgrad möchest du? Leicht: 1,l,e - Mittel: 2,m - Schwer: 3,s,h\n")
    while (true){
        when(readln()){
            "1","l","L","e","E" ->{
                wieOftWaffen = 70
                wieOftHeilung = 15
                wieOftArmor = 70
                wieOftTele = 500
                wieOftOrg = 99
                wieOftSDZ = 93
                handyCap = 1
                println("Du hast leicht gewählt")
                return
            }
            "2","m","M" ->{
                wieOftWaffen = 85
                wieOftHeilung = 30
                wieOftArmor = 85
                wieOftTele = 750
                wieOftOrg = 95
                wieOftSDZ = 96
                handyCap = 2
                println("Du hast mittel gewählt")
                return
            }
            "3","s","S","h","H"->{
                wieOftWaffen = 90
                wieOftHeilung = 50
                wieOftArmor = 95
                wieOftTele = 900
                wieOftOrg = 90
                wieOftSDZ = 99
                handyCap = 3
                println("Du hast schwer gewählt")
                return
            }
            else -> println("Falsche Auswahl - Nochnal!")
        }
    }

}

fun handyCapReload(handyCapReload:Int){
    when(handyCapReload) {
        1 -> {
            wieOftWaffen = 70
            wieOftHeilung = 15
            wieOftArmor = 70
            wieOftTele = 500
            wieOftOrg = 99
            wieOftSDZ = 9
            handyCap = 1
            println("Es wurde leicht geladen")
            return
        }

        2 -> {
            wieOftWaffen = 85
            wieOftHeilung = 30
            wieOftArmor = 85
            wieOftTele = 750
            wieOftOrg = 95
            wieOftSDZ = 9
            handyCap = 2
            println("Es wurde mittel geladen")
            return
        }

        3 -> {
            wieOftWaffen = 90
            wieOftHeilung = 50
            wieOftArmor = 95
            wieOftTele = 900
            wieOftOrg = 90
            wieOftSDZ = 9
            handyCap = 3
            println("Es wurde schwer geladen")
            return
        }
    }
}

fun wieOftWaffen():Int{
    return wieOftWaffen
}

fun wieOftHeilung():Int{
    return wieOftHeilung
}

fun wieOftArmor():Int{
    return wieOftArmor
}

fun wieOftTele():Int{
    return wieOftTele
}

fun wieOft_Org():Int{
    return wieOftOrg
}

fun wievielSchwertDerZer():Int{
    return wieOftSDZ
}