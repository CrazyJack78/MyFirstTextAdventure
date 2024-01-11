
class Spielfeld(var playerX:Int, var playerY: Int) {
    val arraySizeX:Int = 100
    val arraySizeY:Int = 100



    private var waben = Array(arraySizeX){ _->Array(arraySizeY){ _-> Wabe(this)}} // Autoertsellung von Array 100x100 in der jedesmal eine Wabe des Spielfeld erstellt wird
    // für Wabe wird das Spielfeld mitübergeben damit die Werte aus der Klasse im Mutator genutzt werden können
    // this steht für diese Instanz des Spielfeldes


    fun directionConvert(direction:String) {
        when (direction) {
            "n" -> {
                movePlayer(0, 1)
            }
            "s" -> {
                movePlayer(0, -1)
            }
            "o" -> {
                movePlayer(1, 0)
            }
            "w" -> {
                movePlayer(-1, 0)
            }
        }
    } // empfängt die gewünschte Richtung und sendet sie an movePlayer

    private fun movePlayer(diffX:Int, diffY:Int){

        playerX += diffX
        playerY += diffY
        if (playerX > 99) playerX = playerX%100 // bei überschreiten des Randes kommt man auf den gegenüberliegendes Seite wieder raus hier 0
        if (playerY > 99) playerY = playerY%100
        if (playerX < 0) playerX += 100 // bei überschreiten des Randes kommt man auf den gegenüberliegendes Seite wieder raus hier 100
        if (playerY < 0) playerY += 100
    }

    fun interact(){

        waben[playerX][playerY].interact() // interaktion mit spielfeld im gameloop aufgerufen ruft die interact der wabe des entsprechenden Spielfeldes auf
    }


    fun teleport():Boolean{
        println("Wohin möchtest du teleportieren")

        var xx:Int
        var yy:Int
        try {
            println("X-Achse max ${arraySizeX - 1}")
            xx = readln().toInt()
        }catch (e:NumberFormatException){
            println("Falsche eingabe / Abbruch")
            return false
        }
        try {
            println("Y-Achse max ${arraySizeY - 1}")
            yy = readln().toInt()
        }catch (e:NumberFormatException){
            println("Falsche eingabe / Abbruch")
            return false
        }
        if (yy > arraySizeY-1 || xx > arraySizeX-1){
            println("Min Wert zu hoch / Abbruch")
            return false
        }else{
            playerX = xx
            playerY = yy
            return true
        }

    }


} // Spielfeld end
/*Feldaufbau y99,x0...y99,x99
              y0,x0....y0,x99 */