fun inventarAuslöser(){
    if (!Player.getInstance().isDead()){
        statusausgabe()
        if (Player.getInstance().inventar.size > 0) {
            Player.getInstance().inventar()
        }
    }
}