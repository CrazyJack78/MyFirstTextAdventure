import kotlin.system.exitProcess

fun wohinDesWeges(field:Spielfeld){
    while (true && Player.getInstance().teleUnUsed) { //Warten auf richtige Eingabe

        print("Hallo ${classChoiceAdventure()}. Wohin des Weges?\nN/S/O/W\noder Save & Exit:")
        when (val direction:String = readlnOrNull().toString().lowercase()) {
            "n","w","o","s" -> {
                field.directionConvert(direction)
                break
            }
            "exit" -> exitProcess(0)
            "save","saving" -> {
                saveIn(field)

            }
            "se" -> {
                saveIn(field)
                exitProcess(0)
            }
            else -> {
                println("Falsche Eingabe")
            }
        } // when end

    }
}