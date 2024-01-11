interface Item {
    val faehigkeit:String
    val eigenschaftsStaerke:Int
    val typ:String
    val name:String
    fun useItem():Boolean // ist für die Verwendung des Items,
// dadurch stellt man sicher, dass die Funktion auch für verschiedene Itemklassen verwendbar ist ohne Typecast

}

// TODO
/*
Weitere Items
verschiedene Waffen - Bogen, Schwert, Zauberstab, Axt, Keule
Waffen für Einhand und Zweihand
Verschiedene Rüstungsteile: Body, Helm, Stiefel, Handschuh, Beine, Schild
Rüstungsmaterialien - Stahl, Kette, Leder, Stoff
Accessor - Ketten, Ringe
 */