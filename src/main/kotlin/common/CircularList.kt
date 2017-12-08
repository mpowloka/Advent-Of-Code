package common

class CircularList <T>: ArrayList<T>() {
    override fun get(index: Int): T {
        return if(index >= size) this[index - size]
        else super.get(index)
    }
}