package com.shersar.ramazon2023.ui.tasbeh

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.adapters.CategoriesAdapter
import com.shersar.ramazon2023.databinding.ScreenSalovatBinding
import com.shersar.ramazon2023.model.Item
import com.shersar.ramazon2023.ui.tasbeh.viewmodel.SalovatViewModel
import com.shersar.ramazon2023.ui.tasbeh.viewmodel.ZikrViewModel
import viewBinding

class SalovatScreen( private val drawerLayout: DrawerLayout) :
    Fragment(R.layout.screen_salovat) {

    private val binding by viewBinding { ScreenSalovatBinding.bind(it) }
    private lateinit var recyclerView: RecyclerView
    private val categories = mutableListOf(
        Item(
            1,
            "Субҳаналлоҳ",
            "سُبْحَانَ اللَّه",
            "Маьноси: Аллоҳни поклаб ёд этаман.",
            "0",
            "0"
        ),
        Item(
            2,
            "Алҳамдулиллаҳ",
            "الْحَمْدُ لله",
            "Маьноси: Аллоҳга хамд бўлсин.",
            "0",
            "0"
        ),
        Item(
            3,
            "Аллоҳу акбар",
            "اأَللهُ أَکْبَرُ",
            "Маьноси: Аллоҳ буюкдир.",
            "0",
            "0"
        ),
        Item(
            4,
            "Астағфируллоҳ",
            "أَسْتَغْفِرُ اللَّهَ",
            "Маъноси: Аллоҳдан кечирим сўрайман.",
            "0",
            "0"
        ),
        Item(
            5,
            "Астағфируллоҳ ва атувбу илайҳ",
            "أَسْتَغْفِرُ اللَّهَ وأَتُوبُ إِلَيهِ ",
            "Маъноси: Аллоҳдан кечирим сўрайман ва Унга тавба қиламан.",
            "0",
            "0"
        ),
        Item(
            6,
            "Астағфируллоҳаллазий Ла илаҳа илла ҳувал ҳаййул қоййум ва атувбу илайҳ",
            "أَسْتَغْفِرُ اللَّهَ الَّذِي لَا إِلَهَ إلَّا هُوَ الْحَيُّ الْقَيُّومُ وأَتُوبُ إِلَيهِ ",
            "Маъноси: Барҳаёт, тирик Аллоҳдан авф этишини сўрайман ва Унга тавба қиламан.",
            "0",
            "0"
        ),
        Item(
            7,
            "Субҳаналлоҳи ва биҳамдиҳи\n" +
                    "Субҳаналлоҳил ъзийм",
            "سُبْحَانَ اللهِ وَبِحَمْدِهِ \n" +
                    "سُبْحَانَ اللهِ الْعَظِيمِ",
            "Маъноси: Аллоҳга ҳамд айтиш билан Уни айбу нуқсонлардан поклаб ёд етаман.",
            "0",
            "0"
        ),
        Item(
            8,
            "Йа муқоллибал қулуб саббит қолбий ъала дийник",
            "يَا مُقَلِّبَ الْقُلُوبِ ثَبِّتْ قَلْبِي عَلَى دِيْنِكَ ",
            "Маъноси: Эй қалбларни ўзгартирувчи, қалбимни динингда собит қил.",
            "0",
            "0"
        ),
        Item(
            9,
            "Ла илаҳа илла анта субҳанака инний кунту миназ золимийн",
            "لَا إِلَهَ إلَّا أَنْتَ سُبْحَانَكَ إَنِّي كُنْتُ مِنَ الظَّالِمِينَ ",
            "Маъноси: Сендан бошқа илоҳ йўқ. Сени поклаб ёд етаман. Албатта мен золимлардан бўлдим.",
            "0",
            "0"
        ),
        Item(
            10,
            "Ла илаҳа иллаллоҳ",
            "لَا إِلَٰهَ إِلَّا الله",
            "Маьноси: Аллоҳдан ўзга илоҳ йўқ.",
            "0",
            "0"
        ),
        Item(
            11,
            "Ла ҳавла ва ла қуввата илла биллаҳ",
            "لَا حَولَ وَلَا قُوَّةَ إَلَّا بِاللَّهِ ",
            "Маъноси: Куч ва қувват ёлғиз Аллоҳдандир.",
            "0",
            "0"
        ),
        Item(
            12,
            "Аллоҳумма мағфиротука авсаъу мин зунубий ва роҳматука аржа ъиндий мин ъамалий",
            "اللَّهُمَّ مَغْفِرَتُكَ أَوْسَعُ مِنْ ذُنُوبِي وَرَحْمَتُكَ أَرْجَى عِنْدِي مِنْ عَمَلِي",
            "Маъноси: Аллоҳим, мағфиратинг гинохимдан кенгроқдир. Раҳматинг ҳузуримдаги амалимдан умидлироқдир.",
            "0",
            "0"
        ),
        Item(
            13,
            "Ла илаҳа иллаллоҳ Мухаммадур росуллоҳ",
            "لَا إِلَٰهَ إِلَّا الله مُحَمَّدٌ رَسُولُ اُللَّهِ",
            "Маьнлси: Аллоҳдан ўзга илоҳ йўқ Мухаммад унинг элчиси.",
            "0",
            "0"
        ),
    )
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {

    }
}