package com.shersar.ramazon2023.ui

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.activity.MainActivity
import com.shersar.ramazon2023.data.local.entity.Zikr
import com.shersar.ramazon2023.databinding.FragmentSplashBinding
import com.shersar.ramazon2023.utils.UiStateList
import com.shersar.ramazon2023.utils.activityNavController
import com.shersar.ramazon2023.utils.navigateSafely
import com.shersar.ramazon2023.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import viewBinding

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {


    private val splashViewModel: SplashViewModel by viewModels()
    private val binding by viewBinding { FragmentSplashBinding.bind(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        splashViewModel.getAllPrayerTimesFromDb()
        splashViewModel.getAllZikr()
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun setUpObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            splashViewModel.uiState.collect { uiState ->
                when (uiState) {
                    is UiStateList.SUCCESS -> {
                        // Update UI with data
                        val data = uiState.data // list of HijriCalendarResponse objects
                        Log.d("SplashScreen", "setUpObserversSuccess: ${data} ")

                        Handler(Looper.getMainLooper()).postDelayed({
                            if (data.isEmpty()) {
                                activityNavController().navigateSafely(R.id.action_global_locationFragment)
                            } else {
                                activityNavController().navigateSafely(R.id.action_global_mainFlowFragment)
                            }
                        }, 1000)

                        Log.d("HOMESCREEN", "setUpObserversSuccess: $ ")

                    }
                    is UiStateList.ERROR -> {
                        // Handle error
                        val errorMessage = uiState.message
                        Log.d("HOMESCREEN", "setUpObserversError: $errorMessage ")
//                        Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
                    }
                    UiStateList.LOADING -> {
                        // Show loading indicator
//                        Toast.makeText(requireContext(), "LOADING", Toast.LENGTH_SHORT).show()
                    }
                    UiStateList.EMPTY -> {
                        // Handle empty state
                    }
                }
            }
        }

        //zikrObservers

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            splashViewModel.zikrListState.collect { zikrListSate ->
                when(zikrListSate){
                    is UiStateList.SUCCESS ->{
                        Log.d("SPLASHFRAGMENT", "setUpObservers: i am success ")
                        for (i in 0 until zikrList.size){
//                           splashViewModel.resetCurrentZikr(i)
                        }

                    }
                    is UiStateList.LOADING->{
                        //loading
                    }
                    is UiStateList.ERROR->{
                        // Handle error
                        val errorMessage = zikrListSate.message
                        Log.d("SPLASHFRAGMENT", "setUpObserversError: $errorMessage ")
                    }
                    UiStateList.EMPTY -> {
                        Log.d("SPLASHFRAGMENT", "setUpObservers: i am empty ")
                            splashViewModel.addZikrToDB(zikrList)
                        (requireActivity() as MainActivity).viewModel.setZikrState(zikrList[0])

                    }

                }
            }
        }

    }
    private val zikrList = mutableListOf(
        Zikr(
            1,
            "Субҳаналлоҳ",
            "سُبْحَانَ اللَّه",
            "Маьноси: Аллоҳни поклаб ёд этаман.",
            "0",
            "0",
            "0",
            ""
        ),
        Zikr(
            2,
            "Алҳамдулиллаҳ",
            "الْحَمْدُ لله",
            "Маьноси: Аллоҳга хамд бўлсин.",
            "0",
            "0",
            "0",
            ""
        ),
        Zikr(
            3,
            "Аллоҳу акбар",
            "اأَللهُ أَکْبَرُ",
            "Маьноси: Аллоҳ буюкдир.",
            "0",
            "0",
            "0",
            ""
        ),
        Zikr(
            4,
            "Астағфируллоҳ",
            "أَسْتَغْفِرُ اللَّهَ",
            "Маъноси: Аллоҳдан кечирим сўрайман.",
            "0",
            "0",
            "0",
            ""
        ),
        Zikr(
            5,
            "Астағфируллоҳ ва атувбу илайҳ",
            "أَسْتَغْفِرُ اللَّهَ وأَتُوبُ إِلَيهِ ",
            "Маъноси: Аллоҳдан кечирим сўрайман ва Унга тавба қиламан.",
            "0",
            "0",
            "0",
            ""
        ),
        Zikr(
            6,
            "Астағфируллоҳаллазий Ла илаҳа илла ҳувал ҳаййул қоййум ва атувбу илайҳ",
            "أَسْتَغْفِرُ اللَّهَ الَّذِي لَا إِلَهَ إلَّا هُوَ الْحَيُّ الْقَيُّومُ وأَتُوبُ إِلَيهِ ",
            "Маъноси: Барҳаёт, тирик Аллоҳдан авф этишини сўрайман ва Унга тавба қиламан.",
            "0",
            "0",
            "0",
            ""
        ),
        Zikr(
            7,
            "Субҳаналлоҳи ва биҳамдиҳи\n" +
                    "Субҳаналлоҳил ъзийм",
            "سُبْحَانَ اللهِ وَبِحَمْدِهِ \n" +
                    "سُبْحَانَ اللهِ الْعَظِيمِ",
            "Маъноси: Аллоҳга ҳамд айтиш билан Уни айбу нуқсонлардан поклаб ёд етаман.",
            "0",
            "0",
            "0",
            ""
        ),
        Zikr(
            8,
            "Йа муқоллибал қулуб саббит қолбий ъала дийник",
            "يَا مُقَلِّبَ الْقُلُوبِ ثَبِّتْ قَلْبِي عَلَى دِيْنِكَ ",
            "Маъноси: Эй қалбларни ўзгартирувчи, қалбимни динингда собит қил.",
            "0",
            "0",
            "0",
            ""
        ),
        Zikr(
            9,
            "Ла илаҳа илла анта субҳанака инний кунту миназ золимийн",
            "لَا إِلَهَ إلَّا أَنْتَ سُبْحَانَكَ إَنِّي كُنْتُ مِنَ الظَّالِمِينَ ",
            "Маъноси: Сендан бошқа илоҳ йўқ. Сени поклаб ёд етаман. Албатта мен золимлардан бўлдим.",
            "0",
            "0",
            "0",
            ""
        ),
        Zikr(
            10,
            "Ла илаҳа иллаллоҳ",
            "لَا إِلَٰهَ إِلَّا الله",
            "Маьноси: Аллоҳдан ўзга илоҳ йўқ.",
            "0",
            "0",
            "0",
            ""
        ),
        Zikr(
            11,
            "Ла ҳавла ва ла қуввата илла биллаҳ",
            "لَا حَولَ وَلَا قُوَّةَ إَلَّا بِاللَّهِ ",
            "Маъноси: Куч ва қувват ёлғиз Аллоҳдандир.",
            "0",
            "0",
            "0",
            ""
        ),
        Zikr(
            12,
            "Аллоҳумма мағфиротука авсаъу мин зунубий ва роҳматука аржа ъиндий мин ъамалий",
            "اللَّهُمَّ مَغْفِرَتُكَ أَوْسَعُ مِنْ ذُنُوبِي وَرَحْمَتُكَ أَرْجَى عِنْدِي مِنْ عَمَلِي",
            "Маъноси: Аллоҳим, мағфиратинг гинохимдан кенгроқдир. Раҳматинг ҳузуримдаги амалимдан умидлироқдир.",
            "0",
            "0",
            "0",
            ""
        ),
        Zikr(
            13,
            "Ла илаҳа иллаллоҳ Мухаммадур росуллоҳ",
            "لَا إِلَٰهَ إِلَّا الله مُحَمَّدٌ رَسُولُ اُللَّهِ",
            "Маьнлси: Аллоҳдан ўзга илоҳ йўқ Мухаммад унинг элчиси.",
            "0",
            "0",
            "0",
            ""
        ),
    )
}