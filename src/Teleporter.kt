class Teleporter() :Item {


    override val typ: String
        get() = "Teleporter"
    override val name: String = "Teleporter"
    override val eigenschaftsStaerke: Int
        get() = 0
    override val faehigkeit: String
        get() = "teleportieren"

    override fun useItem(): Boolean {


        //println("Du teleportierst zu ...")

        return field.teleport() // Rückgabe ob verwendet oder ob nicht

    }

}