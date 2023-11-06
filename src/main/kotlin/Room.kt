class Room(private var numberRoom: String, private var square: Int, private var window: Int) {

    private var lights: MutableList<Light>? = null
    private var subjects: MutableList<Subject>? = null

    private fun windowsLight(window: Int): Int {
        return window * WINDOW_LIGHT_LK_700
    }

    @Throws(IlluminanceTooMuchException::class)
    fun addLight(light: Light) {
        if (lights == null) {
            lights = ArrayList()
        }
        val totalLight = 0
        for (l in lights!!) {
            if (totalLight + windowsLight(window) + l.lumen < LIGHT_MIN_LK_300 ||
                totalLight + windowsLight(window) + l.lumen > LIGHT_MAX_LK_4000
            ) {
                throw IlluminanceTooMuchException(" Освещенность вышла за пределы  300-4000 лк")
            }
        }
        lights!!.add(light)
    }

    @Throws(SpaceUsageTooMuchException::class)
    fun addSubject(subject: Subject) {
        if (subjects == null) {
            subjects = ArrayList()
        }
        var totalSquare = 0
        for (s in subjects!!) {
            totalSquare += s.square
            if (totalSquare / square * PERCENT_100 > PERCENT_70) {
                throw SpaceUsageTooMuchException(" Предметы в помещении занимают более 70% площади")
            }
        }
        subjects!!.add(subject)
    }


    override fun toString(): String {
        return "Room{" +
                "number_room='" + numberRoom + '\'' +
                ", square=" + square +
                ", window=" + window +
                ", lights=" + lights +
                ", subjects=" + subjects +
                '}'
    }

    companion object {
        const val WINDOW_LIGHT_LK_700 = 700
        const val LIGHT_MIN_LK_300 = 300
        const val LIGHT_MAX_LK_4000 = 4000
        const val PERCENT_100 = 100
        const val PERCENT_70 = 70
    }
}