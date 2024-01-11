import kotlin.math.*

fun entfernungMutator(e:Spielfeld,wabeX:Int,wabeY:Int):Double{



        /*
        man braucht für die Berechnung im Raster
        die größe des array x*y falls entfernung in alle Richtungen gleich sein soll
        die Position des ersten punktes x+y
        die Position des zweiten Punktes x+y
        */
        var xIn = wabeX // welche Wabe wird aabgefragt
        var yIn = wabeY
        val arrayX = e.arraySizeX // größe des Spielfeldes
        val arrayY = e.arraySizeY
        val startXIn = e.playerX //Startposition Spieler
        val startYIn = e.playerY

// statischer Entfernung bei der Verdoppelt werden soll
        val doppelHcEntfernung = 70.71

        // gibt an bei welcher Entfernung der handycap sich verdoppelt hat und ist die Rechtengrundlage für die anderen Entfernungen
// für dynamisch müsste sie für das entsprechende Feld individual anhand der Größe des beides mit der entsprechenden Größe vorberechnet werden
// etwa so
// (sqrt(maxX*maxX + maxY*maxY))/2
//halber pythagoras auf ganzes Feld
// in Double weil sonst zu ungenau

        if (xIn == arrayX) {
            xIn -= 1
        }
        if (yIn == arrayY) {
            yIn -= 1
        }
// Position Entfernung in Double
        val maxX: Double = arrayX.toDouble()
        val maxY: Double = arrayY.toDouble()
        val startX: Double = startXIn.toDouble()
        val startY: Double = startYIn.toDouble()
        var x: Double = xIn.toDouble()
        var y: Double = yIn.toDouble()
// Zwischen-Werte

// beeinflusst den Punkt wo die Verdoppelung des hC ist, höher erschwert es da die dHE kleiner wird
        val dHEfactor = 1 // verändert den faktor bei welcher Entfernung schon doppelte eigenschaften der Gegener sind

// hCFactor erhöht den Schwierigkeitsgrad direkt zusätzlich zur Berechnung
        val hCFactor = 1 // erhöht in der Endberechnung den  mutatorfaktor nach der Berechnung

//dynamische Entfernungsberechnung, so ist das handycap bei 2 auf maximaler Entfernung (halbe größe vom spielfeld)
        val dHE = ((sqrt(maxX * maxX + maxY * maxY)) / 2) / dHEfactor
// wenn man statt maxX und maxY angibt, wo die Verdoppelung ist, kann man es verschieben


        var diffX: Double = 0.0
        var diffY: Double = 0.0

        val maxDiffX: Double = maxX / 2
        val maxDiffY: Double = maxY / 2

// var diffXY:Double = 0.0

// X Entfernung

        if (x > startX) {
            diffX = x - startX
        } else if (x < startX) {
            diffX = startX - x
        }
// wenn Entfernung größer als die Hälfte
        if (diffX > maxDiffX) {
            diffX = maxDiffX - diffX % maxDiffX
            //println(diffX)
        }

//.  Y Entfernung

        if (y > startY) {
            diffY = y - startY
        } else if (y < startY) {
            diffY = startX - y
        }

// wenn Entfernung größer als die Hälfte
        if (diffY > maxDiffY) {
            diffY = maxDiffY - diffY % maxDiffY
        }

        var diffXY: Double = sqrt(diffX * diffX + diffY * diffY) // wurzel ziehen
// sqrt(number.toDouble) wurzel von number


        //println("diffXY: " + diffXY)
// hCFactor erhöht den Schwierigkeitsgrad direkt zusätzlich zur Berechnung
        return ((((100 / dHE) * diffXY) / 100) + 1) * hCFactor // so würde bei einer Entfernung von 50*50 Feldern der handycap-Factor bei 2 liegen bei einer entfernung von diffXY von 70.71... (pythagoras von x und y)





//

// facktor 100/doppelHcEntfernung
//   factor * diffXY






}