package common

class CircularList <T>(private val inputList: ArrayList<T>):
        List<T> by inputList {

    override fun get(index: Int): T {
        return if(index == inputList.size) inputList[0]
        else inputList[index]
    }

    fun add(element: T) {
        inputList.add(element)
    }

}