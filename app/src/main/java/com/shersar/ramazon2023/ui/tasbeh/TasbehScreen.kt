package com.shersar.ramazon2023.ui.tasbeh

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.ScreenTasbehBinding
import com.shersar.ramazon2023.model.Zikr
import com.shersar.ramazon2023.model.Zikrlar
import com.shersar.ramazon2023.ui.tasbeh.viewmodel.ZikrViewModel
import com.shersar.ramazon2023.utils.CustomDialog
import com.shersar.ramazon2023.utils.UiStateObject
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import me.relex.circleindicator.CircleIndicator3
import viewBinding
import javax.inject.Inject

@AndroidEntryPoint
class TasbehScreen : Fragment(R.layout.screen_tasbeh) {

    private val binding by viewBinding { ScreenTasbehBinding.bind(it) }
    private val viewModelZikr by viewModels<ZikrViewModel>()
    private lateinit var adapterFragments: ViewPagerAdapter
    private lateinit var viewPagerr: ViewPager2
    var count = 0
//    private val categories = mutableListOf(
//        Zikrlar(
//            "Zikrlar",
//            Zikr(
//                1,
//                "Субҳаналлоҳ",
//                "سُبْحَانَ اللَّه",
//                "Маьноси: Аллоҳни поклаб ёд этаман.",
//                "0",
//                "0"
//            ),
//            Zikr(
//                2,
//                "Алҳамдулиллаҳ",
//                "الْحَمْدُ لله",
//                "Маьноси: Аллоҳга хамд бўлсин.",
//                "0",
//                "0"
//            ),
//            Zikr(
//                3,
//                "Аллоҳу акбар",
//                "اأَللهُ أَکْبَرُ",
//                "Маьноси: Аллоҳ буюкдир.",
//                "0",
//                "0"
//            ),
//            Zikr(
//                4,
//                "Астағфируллоҳ",
//                "أَسْتَغْفِرُ اللَّهَ",
//                "Маъноси:Аллоҳдан кечирим сўрайман.",
//                "0",
//                "0"
//            ),
//            Zikr(
//                5,
//                "Астағфируллоҳ ва атувбу илайҳ",
//                "أَسْتَغْفِرُ اللَّهَ وأَتُوبُ إِلَيهِ ",
//                "Маъноси:Аллоҳдан кечирим сўрайман ва Унга тавба қиламан.",
//                "0",
//                "0"
//            ),
//            Zikr(
//                6,
//                "Астағфируллоҳаллазий Ла илаҳа илла ҳувал ҳаййул қоййум ва атувбу илайҳ",
//                "أَسْتَغْفِرُ اللَّهَ الَّذِي لَا إِلَهَ إلَّا هُوَ الْحَيُّ الْقَيُّومُ وأَتُوبُ إِلَيهِ ",
//                "Маъноси: Барҳаёт, тирик Аллоҳдан авф этишини сўрайман ва Унга тавба қиламан.",
//                "0",
//                "0"
//            ),
//            Zikr(
//                6,
//                "Субҳаналлоҳи ва биҳамдиҳи\n" +
//                        "Субҳаналлоҳил ъзийм",
//                "سُبْحَانَ اللهِ وَبِحَمْدِهِ \n" +
//                        "سُبْحَانَ اللهِ الْعَظِيمِ",
//                "Маъноси: Аллоҳга ҳамд айтиш билан Уни айбу нуқсонлардан поклаб ёд етаман.",
//                "0",
//                "0"
//            ),
//            Zikr(
//                6,
//                "Йа муқоллибал қулуб саббит қолбий ъала дийник",
//                "يَا مُقَلِّبَ الْقُلُوبِ ثَبِّتْ قَلْبِي عَلَى دِيْنِكَ ",
//                "Маъноси: Эй қалбларни ўзгартирувчи, қалбимни динингда собит қил.",
//                "0",
//                "0"
//            ),
//            Zikr(
//                5,
//                "Ла илаҳа илла анта субҳанака инний кунту миназ золимийн",
//                "لَا إِلَهَ إلَّا أَنْتَ سُبْحَانَكَ إَنِّي كُنْتُ مِنَ الظَّالِمِينَ ",
//                "Маъноси: Сендан бошқа илоҳ йўқ. Сени поклаб ёд етаман. Албатта мен золимлардан бўлдим.",
//                "0",
//                "0"
//            ),
//            Zikr(
//                5,
//                "Ла илаҳа иллаллоҳ",
//                "لَا إِلَٰهَ إِلَّا الله",
//                "Маьноси: Аллоҳдан ўзга илоҳ йўқ.",
//                "0",
//                "0"
//            ),
//            Zikr(
//                5,
//                "Ла ҳавла ва ла қуввата илла биллаҳ",
//                "لَا حَولَ وَلَا قُوَّةَ إَلَّا بِاللَّهِ ",
//                "Маъноси: Куч ва қувват ёлғиз Аллоҳдандир.",
//                "0",
//                "0"
//            ),
//            Zikr(
//                5,
//                "Аллоҳумма мағфиротука авсаъу мин зунубий ва роҳматука аржа ъиндий мин ъамалий",
//                "اللَّهُمَّ مَغْفِرَتُكَ أَوْسَعُ مِنْ ذُنُوبِي وَرَحْمَتُكَ أَرْجَى عِنْدِي مِنْ عَمَلِي",
//                "\n" +
//                        "Маъноси:Аллоҳим, мағфиратинг гинохимдан кенгроқдир. Раҳматинг ҳузуримдаги амалимдан умидлироқдир.",
//                "0",
//                "0"
//            ),
//            Zikr(
//                5,
//                "Ла илаҳа иллаллоҳ Мухаммадур росуллоҳ",
//                "لَا إِلَٰهَ إِلَّا الله مُحَمَّدٌ رَسُولُ اُللَّهِ",
//                "Маьнлси: Аллоҳдан ўзга илоҳ йўқ Мухаммад унинг элчиси.",
//                "0",
//                "0"
//            ),
//        ),
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModelZikr.getZikrState()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initview()
        initViewPager()
        initCounts()
        setupZikrObservers()
    }


    private fun initCounts() {


        Log.d("@@@@", "Main tasbeh Screen ")

        binding.ivMoreVerDot.setOnClickListener {
            val customDialog = CustomDialog(requireContext())
            customDialog.setTitle("Custom Dialog Title")
            customDialog.show()

            val window: Window? = customDialog.window
            val wlp: WindowManager.LayoutParams = window!!.attributes

            wlp.gravity = Gravity.BOTTOM
            wlp.gravity = Gravity.END
            wlp.flags = wlp.flags and WindowManager.LayoutParams.FLAG_DIM_BEHIND.inv()
            window.attributes = wlp
          /** val dialogFragment = ExapleDialog()
            dialogFragment.show(parentFragmentManager, "MyDialogFragment")*/
        }
        binding.fmCount.setOnClickListener {

            viewModelZikr.incrementTodayAndAllZikr()
        }
    }

    private fun initViewPager() {
        viewPagerr = binding.viewpager2
        adapterFragments = ViewPagerAdapter(requireActivity())
        var circleIndicator: CircleIndicator3 = binding.circleIndicator


        viewPagerr.adapter = adapterFragments

        // Set the CircleIndicator with ViewPager2
        circleIndicator.setViewPager(viewPagerr)
    }

    private fun initview() {
        val header: View
        binding.ivVerMore.setOnClickListener {
            binding.drawerlayout.openDrawer(GravityCompat.END)
        }
        binding.apply {
            header = navView.getHeaderView(0)
        }
        initTabs(header, binding.drawerlayout)


    }

    private fun initTabs(header: View, drawerLayout: DrawerLayout) {

        val viewPager2: ViewPager2 = header.findViewById(R.id.viewpager2)
        val tabLayout: TabLayout = header.findViewById(R.id.tabLayout)

        viewPager2.adapter =
            FragmentAdapter(requireActivity() as AppCompatActivity, viewModelZikr, drawerLayout)
//        viewPager2.isUserInputEnabled = false
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> tab.text = "Zikrlar"
                1 -> tab.text = "Salovatlar"
                else -> tab.text = "Salovatlar"
            }
        }.attach()


    }

    private fun setupZikrObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModelZikr.zikrState.collect {
                    when (it) {
                        is UiStateObject.LOADING -> {

                        }
                        is UiStateObject.SUCCESS -> {
                            Log.d("@@@", "Home ${it.data}")

                            adapterFragments.fragments.add(Item1Screen(viewModelZikr))
                            adapterFragments.fragments.add(Item2Screen(viewModelZikr))
                            viewPagerr.adapter = adapterFragments

                            binding.tvNowCount.text = it.data.today_zikr
                            binding.tvbeforeCount.text =it.data.all_zikr
                        }
                        is UiStateObject.ERROR -> {
                        }
                        else -> Unit
                    }
                }
            }
        }
    }


    override fun onPause() {
        super.onPause()

        Log.d("@@@", "Tasbeh on pause")
    }

    override fun onResume() {
        super.onResume()

        Log.d("@@@", "Tasbeh on resume")
    }

    override fun onStart() {
        super.onStart()

        Log.d("@@@", "Tasbeh on Start")
    }

    override fun onStop() {
        super.onStop()

        Log.d("@@@", "Tasbeh on stop")
    }
}

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    val fragments = mutableListOf<Fragment>()

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}


class FragmentAdapter(
    activity: AppCompatActivity,
    private val viewModelZikr: ZikrViewModel,
    private val drawerLayout: DrawerLayout
) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ZikrScreen(viewModelZikr, drawerLayout)
            1 -> SalovatScreen(drawerLayout)
            else -> ZikrScreen(viewModelZikr, drawerLayout)
        }
    }
}
