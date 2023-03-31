package ru.startandroid.develop.parcel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.util.Log

const val LOG_TAG = "myLogs"

class MainActivity : AppCompatActivity() {

    var p: Parcel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        writeParcel()
        readParcel()
    }
    fun writeParcel(){
        p = Parcel.obtain()

        val b: Byte = 1
        val i: Int = 2
        val l: Long = 3
        val f: Float = 4F
        val d: Double = 5.0
        val s: String = "abcdefgh"

        logWriteInfo("before writing");
        p!!.writeByte(b);
        logWriteInfo("byte");
        p!!.writeInt(i);
        logWriteInfo("int");
        p!!.writeLong(l);
        logWriteInfo("long");
        p!!.writeFloat(f);
        logWriteInfo("float");
        p!!.writeDouble(d);
        logWriteInfo("double");
        p!!.writeString(s);
        logWriteInfo("String")
    }

    fun logWriteInfo(txt: String) {
        Log.d(LOG_TAG, "$txt, dataSize = ${p!!.dataSize()}")
    }

    fun readParcel() {
        logReadInfo("befor reading")
        p!!.setDataPosition(0)
        logReadInfo("byte = ${p!!.readByte()}")
        logReadInfo("int = ${p!!.readInt()}")
        logReadInfo("long = ${p!!.readLong()}")
        logReadInfo("float = ${p!!.readFloat()}")
        logReadInfo("double = ${p!!.readDouble()}")
        logReadInfo("string = ${p!!.readString()}")

    }

    fun logReadInfo(txt: String) {
        Log.d(LOG_TAG, "$txt : dataPosotion = ${p!!.dataPosition()}")
    }
}