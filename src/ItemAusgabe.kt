fun itemAusgabe(item:Item,count:Int){
    if (item is Heiltrank){
        val item:Heiltrank = item
        println("Das Item an Platz $count ist ein ${item.name} und heilt ${item.hpAdd} Gesundheit")
    }else if (item is Weapon){
        val item:Weapon = item
        println("Das Item an Platz $count ist eine ${item.name} und gibt ${item.damage} Schaden zusätzlich zum Grundschaden")
    }else if (item is Armor){
        val item:Armor = item
        println("Das Item an Platz $count ist eine ${item.name} und gibt ${item.arm} Schutz")
    }else if (item is Teleporter){
        val item:Teleporter = item
        println("Das Item an Platz $count ist eine ${item.name} und ann Dich in ferne Länder bringen")
    }
}