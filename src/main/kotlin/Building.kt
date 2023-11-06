class Building(private val nameBuilder: String) {

    private var rooms: MutableList<Room>? = null


    fun addRoom(room: Room) {
        if (rooms == null) {
            rooms = ArrayList()
        }
        rooms!!.add(room)
        println( nameBuilder + rooms)
    }


    override fun toString(): String {
        return "Building(nameBuilder='$nameBuilder', rooms=$rooms)"
    }
}
