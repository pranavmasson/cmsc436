package layout

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import com.example.project3.DataActivity
import com.example.project3.R
import java.text.NumberFormat

class Travel {



    private var country: String = "null"
    private var exchangeRate: Double = -52.1
    private lateinit var radioGroup: RadioGroup
    private var amount: Double = -52.1

    constructor(){

    }

    constructor(er: Double){
        this.exchangeRate = er
    }

    constructor(exchangeRate: Double, radioGroup: RadioGroup) {
        this.exchangeRate = exchangeRate
        this.radioGroup = radioGroup
    }

    fun setRadioGroup(rg: RadioGroup) {
        radioGroup = rg
    }

    fun getCountry(): String {
        return country
    }

    fun setCountry(theCountry: String) {
        country = theCountry
    }

    fun getexchangeRate(): Double {
        return exchangeRate
    }

    fun setexchangeRate(setER: Double) {
        exchangeRate = setER
    }

    fun getAmount(): Double {
        return amount
    }

    fun setAmount(setER: Double) {
        amount = setER
    }

    fun go(): Boolean {
        if (radioGroup.checkedRadioButtonId != -1 && exchangeRate > 0.0) {
            return true
        }
        return false
    }

    fun getGoodMorning(): String {
        if (country == "India") {
            return "Shubh Prabhash"
        } else if (country == "Mexico") {
            return "Buenos Dias"
        } else if (country == "Italy") {
            return "Buongiorno"
        } else {
            return "Gunaydin"
        }
    }

    fun getPlease(): String {
        if (country == "India") {
            return "Krypya"
        } else if (country == "Mexico") {
            return "Por Favor"
        } else if (country == "Italy") {
            return "Per Favore"
        } else {
            return "Lutfen"
        }
    }

    fun getVisa(): String {
        if (country == "India") {
            return "yes"
        } else if (country == "Mexico") {
            return "no"
        } else if (country == "Italy") {
            return "no, yes if > 3 months"
        } else {
            return "yes"
        }
    }

    fun calculateExchange(): String {
        var nf : NumberFormat = NumberFormat.getCurrencyInstance()

        try {
            Log.w("hi exchangeRate", ""+exchangeRate)
            Log.w("hi amount", ""+amount)
            return nf.format(exchangeRate * amount)
        } catch (e: Exception) {
            Log.w("hi", "broken string")
        }
        return "Test val"
    }


}