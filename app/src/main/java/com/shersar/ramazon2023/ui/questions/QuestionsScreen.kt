package com.shersar.ramazon2023.ui.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.adapter.QuestionsAdapter
import com.shersar.ramazon2023.databinding.FragmentQuestionsScreenBinding
import com.shersar.ramazon2023.model.Question
import viewBinding


class QuestionsScreen : Fragment(R.layout.fragment_questions_screen) {
    private val binding by viewBinding {
        FragmentQuestionsScreenBinding.bind(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvQuestions.layoutManager = LinearLayoutManager(requireContext())
        binding.rvQuestions.adapter = QuestionsAdapter(getUserList())
    }

    private fun getUserList(): MutableList<Question> {
        val myList = mutableListOf(
            Question(
                "Ro’za qachon farz qilingan? ",
                "Hijratdan 1,5 yil o’tgach"
            ),
            Question(
                "Arab tilida “sovm” (ro’za) lug’atda qanday ma’no bildiradi?",
                "O’zni tiyish"
            ),
            Question(
                "Ro’za qanday sobit bo’lgan? ",
                "Qur’on va sunnat bilan"
            ),
            Question(
                "“Ey iymon keltirganlar! Sizlardan avvalgilarga farz qilinganidek,sizlarga ham ro’za farz qilindi. Shoyadki, taqvo qilsangiz”\n" +
                        "  Keltirilgan oyatning qaysi suradan ekanligni toping?\n",
                "Baqara surasi, 183-oyat"
            ),
            Question(
                "Ro’za qanday bajariladi? ",
                "Alloh taologa muhabbat va ixlos belgisi sifatida"
            ),
            Question(
                "Qaysi mazhabda ramazon tugagunicha har quni niyat yabngilanib turiladi? ",
                "Hanafiy mazhabida "
            ),
            Question(
                "Qaysi mazhabga ko’ra, Ramazon ro’zasini tutishda har kungi niyatni quyosh oqqunigacha yangilab olsa ham bo’laveradi? ",
                ":  Hanafiy mazhabiga ko’ra"
            ),
            Question(
                "Banu sulaymlik bir kishidan rivoyat qilingan hadisda:\n" +
                        "“Rasululloh sollallohu alayhi vasallam: “Ro’za- … yarmidir”, dedilar”\n" +
                        " Nuqtalar o’rnini to’ldiring.\n",
                "Sabrning yarmidir!"
            ),
            Question(
                "Agar kim ro’za tutsayu,qalbida taqvo hissi uyg’onmasa, u odam haqiqiy ro’za tutgan bo’ladimi? ",
                "Yo’q, bo’lmaydi!"
            ),
            Question(
                "Abu Hurayra roziyallohi anhudan rivoyat qilinadi:\n" +
                        "“Rasululloh sollallohu alayhi vasallam aytadilar:\n" +
                        "“Alloh taolo dedi:Odam bolasining hamma amali o’zi uchun, faqat ro’za Men uchundir va uning mukofotini O’zim berurman”.\n" +
                        "Buxoriy va Muslim rivoyat qilishgan.\n" +
                        "Ro’zaning bunday fazlga ega bo’lishining 2 ta ma’nosidan birinchisini toping? \n",
                "Ro’za ichki amal hisoblanadi!"
            ),
            Question(
                "Abu Hurayra roziyallohi anhudan rivoyat qilinadi:\n" +
                        "“Rasululloh sollallohu alayhi vasallam aytadilar:\n" +
                        "“Alloh taolo dedi:Odam bolasining hamma amali o’zi uchun, faqat ro’za Men uchundir va uning mukofotini O’zim berurman”.\n" +
                        "Buxoriy va Muslim rivoyat qilishgan.\n" +
                        "Ro’zaning bunday fazlga ega bo’lishining 2 ta ma’nosidan ikkinchisini toping? \n",
                "Ro’za tutish Alloh taoloning dushmani-shaytonga qahr qilish demakdir!"
            ),
            Question(
                "Ramazon oyi ro’zasining hukmlari va hikmatlari bayon etilgan surani toping?",
                "Baqara surasi, 183-185 va 187-oyatlari!"
            ),
            Question(
                "Alloh taolo, Baqara surasi 183-oyatda musulmonlarga ro’zaning farzligini amr etishdan oldin ularga qanday nido qilgan?  ",
                "Ey iymon keltirganlar!"
            ),
            Question(
                "Baqara surasi, 183-oyatning ma’nosidan kelib chiqib, ro’za qanday ibodat emasligni tushunamiz? ",
                "Yangi ibodat emasligini!"
            ),
            Question(
                "Nasorolarda qanday amal ro’za deyiladi? ",
                "Hayvondan chiqqan ozuqa mahsulotlarini tanovul qilmaslik."
            ),
            Question(
                "Qanday toifa insonlarga mashaqqat ustiga mashaqqat bo’lmasligi uchun ro’za tutish kunlarini “…sanog’i  boshqa kunlardan” deya yengillik berilgan? ",
                "Bemor yoki safardagi insonlarga!"
            ),
            Question(
                ". Ulamolarimiz bemorlar safiga qanday insonlarni ham qo’shganlar? ",
                "Homilador va emizikli ayollarni ham"
            ),
            Question(
                "Ro’zani   qiynalib tutadiganlar zimmasida qanday amal bor?",
                "Fidya "
            ),
            Question(
                "Fidya  bu - …?",
                "Bir maskin taomi!"
            ),
            Question(
                " Ro’za tutishga qiynaladigan insonlar kimlar? ",
                "Yoshlari ulug’ bo’lib, ro’za tutishga yaramay qolgan kishilar!"
            ),
            Question(
                "Ulamolarimiz ro’za tutishda qiynaladiganlar safiga  kimlarni ham kiritgan?",
                "Tuzalmaydigan,surunkali kasali bor kishilarni!"
            ),
            Question(
                "Ro’za tutish orqali erishiladigan yaxshiliklarni toping?",
                "1.Jannatga kirish\n" +
                        "2.Oliy maqomlarga erishish\n" +
                        "3.Irodaning kuchli bo’lishi\n" +
                        "4.Rahm-shavqat sifatining kuchayishi\n" +
                        "5.Taqvo hissining uyg’onishi\n" +
                        "6. Sog’lik va salomatlik \n"
            ),
            Question(
                ". Ro’za farz qilingan sanoqli kunlar qaysi? ",
                ": Ramazon oyi!"
            ),
            Question(
                "Qur’on nozil qilingan oy- …? ",
                "Ramazon oyi!"
            ),
            Question(
                "Ramazon oyida odamlarga qanday ochiq-oydin hujjatlar bor? ",
                "Hidoyat hamda hidoyatu furqondan iborat ochiq-oydin hujjatlar!"
            ),
            Question(
                " Islom shariati qanday  asosga bino qilingan?",
                "Osonlikka!"
            ),
            Question(
                "“Yorug’likning ufqda tarqalishi” ni bildiradigan payt qanday nomlanadi?",
                "Fajri sodiq!"
            ),
            Question(
                "Shariatda Allohga yaqinlik hosil qilish niyatida masjidda ibodatni lozim tutish nima deyiladi? ",
                " “E’tikof”!"
            ),
            Question(
                ". “E’tikof” so’zi qanday ma’noni  anglatadi? ",
                "“Bir narsani lozim tutish”!"
            ),
            Question(
                "Ro’zaning son-sanoqsiz foydalari ichida  birinchi o’rinda turadiganini toping?",
                " Ro’zaning ro’zadorda taqvo hissini mustahkamlashi!"
            ),
            Question(
                ". Ro’za ibodatini ado etgan banda jannatga qaysi eshikdan kirish huquqini qo’lga kiritadi? ",
                "“Rayon” eshigidan!"
            ),
            Question(
                "Ro’zaga berilgan ta’riflar ...",
                "1. Alloh taologa qilinadifan toat-ibodat\n" +
                        "2. Ilkan axloq maktabi\n" +
                        "3. Nafs balosiga qarshi kurash\n" +
                        "4.Insonni man qilingan narsalarga sabr qilishga o’rgatadigan amal\n" +
                        "5.Inson hayotida keladigan mashaqqatlarga chidashga malaka hosil qildiradigan amal\n"
            ),
            Question(
                "Ro’zaning foydalari ...",
                " 1.\tRo’za tutgan kishing taqvodorligi oshadi. \n" +
                        "2.\tRo’zador insonga sog’liq ato etiladi.\n" +
                        "3.\tRo’za havoyi nafsni sindiradi.\n" +
                        "4.\tRo’za tutish orqali shaytonga  qahr ko’rsatiladi.\n" +
                        "5.\tRo’za insonning irodasini, qat’iyatini mustahkamlaydi.\n" +
                        "6.\tRo’za insonni tartib intizomga o’rgatadi.\n"
            ),
            Question(
                "…- ro’za tutsin ",
                "1.\tKim qalbi musaffo bo’lishi xohlasa\n" +
                        "2.\tKim farishtakar safiga ega bo’lishni xohlasa\n" +
                        "3.\tKim sabr-bardoshl bo’lmoqchi bo’lsa\n" +
                        "4.\tKim o’zida rahm-shafqat sifatini shakllantirish va mustahkamlashni xohlasa\n"
            ),
            Question(
                "Tavba surasi 112-oyatida keltirilgan mo’minlarning sifatlari quydagilar ...",
                "1.\tTavba qiluvchilar\n" +
                        "2.\tIbodat qiluvchilar\n" +
                        "3.\tHamd aytuvchilar\n" +
                        "4.\tRo’za tutuvchilar\n" +
                        "5.\tRuku qiluvchilar, sajda qiluvchilar \n" +
                        "6.\tMa’rufga buyurib mukardan qaytaruvchilar\n" +
                        "7.\tAllohning chegarasida turuvchilar \n"
            ),
            Question(
                "Ro’zadorning hadisi sharifda keltirilgan ikki hursandchiligi ...",
                "Iftor qilganida hursand bo’ladi va Robbiga ro’baro’ bo’lganida ro’zasi sababli hursand  bo’ladi."
            ),
            Question(
                "Hadisi sharifga ko’ra ro’zador o’g’zining hidi Alloh uchun qanday hiddan ham yoqimliroqdir.",
                "Mushk hididan ham"
            ),
            Question(
                " Qiyomat kuni faqat ro’zadorlar kiradigan Jannat eshigining nomini toping?",
                "Rayyon"
            ),
            Question(
                "Hadisi sharifga ko’ra, ro’zador odam qanday holatda ibodatda bo’ladi? ",
                "Biror musulmonni g’iybat qilmasa, ozor bermasa"
            ),
            Question(
                "Abu Hurayra roziyallohu anhudan rivoyat qilingan ushbu hadisi sharifda tushurib qoldirilgan so’zlarni toping?" +
                        "“Rasululloh sollallohu alayhi vasallam:\n" +
                        "“ Kim … ni va …ni qo’ymasa, Alloh uning taoimi va ichimligini tark etishiga muhtoj emas”, deganlar” Buxoriy rivoyat qilgan.\n",
                "Yolg’on gapirishni va unga amal qilishni  qo’ymasa"
            ),
            Question(
                "Jobir roziyallohu anhudan rivoyat qilingan ushbu hadisi sharifda tushurib qoldirilgan so’zni toping?" +
                        "“Bir odam Nabiy sollallohu alayhi vasallamga: “Ayting-chi, farz namozlarini o’qisam,Ramazon ro’zasini" +
                        " tutsam, halolni halol, haromni harom deb balsam va bunga hech narsani ziyoda qilmasam, Jannatga kiramanmi?” dedi." +
                        " U Zot: “…”,dedilar. “Allohga qasamki,unga hech narsani ziyoda qilmayman”, dedi”. Muslim rivoyat qilgan.",
                "Ha "
            ),
            Question(
                "Ahli haqning oldida ro’zaning darajasi nechta?",
                "3 ta: Ommaning ro’zasi, xoslarning ro’zasi va xoslardan ham xoslarning ro’zasi "
            ),
            Question(
                "“Qorin va farjning istak-xohishlaridan tiyilish” ro’zaning qaysi darajasi? ",
                "Ommaning ro’zasi "
            ),
            Question(
                "“Birinchi darajadan ko’ra ziyoda o’laroq ko’z,  quloq, tilni, oyoq qo’l va boshqa narsalarni ham gunohlardan tiyish” ro’zaning qaysi darajasi?",
                "Xoslarning ro’zasi "
            ),
            Question(
                "“Ikki darajadan ham ziyoda o’laroq, qalbni behuda qiziqishlardan, dunyoviy fikrlardan" +
                        " va Alloh taolodan boshqa narsalardan tiyishdan iborat” bo’lgan ro’za darajasini toping. ",
                "Xoslardan ham xoslarning ro’zasi"
            ),
            Question(
                "Xoslarning ro’zasi yana qanday nom nilan ham nomlanadi? ",
                "Solihlar ro’zasi "
            ),
            Question(
                "Bishr ibn Horis rahmarullohi alayhdan rivoyat qilinishicha, Sufyon Savriy qanday amal ro’zani buzishi haqida ta’kidlaganlar? ",
                "G’iybat "
            ),
            Question(
                "Mujohid qanday  2 xislat ro’zani buzishi haqida ta’kidlaganlar?  ",
                "G’iybat va yolg’on"
            ),
            Question(
                "Ushbu oyat qaysi suradan olinganligni toping: \n" +
                        "“Yolg’onga ko’p quloq soluvchilar, haromni ko’p yeyuvchilardir” \n",
                "Moida surasi, 42-oyat"
            ),
            Question(
                "Iftordan so’ng qalb qanday holatdan bo’lishi lozim? ",
                "Xavf  va rajo orasida bo’lishi lozim."
            ),
            Question(
                "Hasan Basriy rahmatullohi alayh kulib o’tirgan qavm oldidan o’tayotib, “Alloh azza va jalla " +
                        "Ramazon oyini O’z bandalarini chiniqtirish uchun, U Zotning toatida musobaqa qilishlari uchun" +
                        " joriy qilgan.Bir qavmlar o’zib ketib najot topishdi.Boshqalari esa ortda qolib,noumid bo’ldilar. " +
                        "O’zganlar najot topib, ahli botillar noumid bo’lgan kunda  kimlarga  hayronman”, dedi. ",
                "O’ynab-kulganlarga"
            ),
            Question(
                "Hadisda qanday amal ko’ngilning taqvosi dya aytilgan?",
                "Haromga qaramaslik"
            ),
            Question(
                "Ro’za durust bo’lishi uchun necha xil shart topilishi lozim? ",
                "3 xil"
            ),
            Question(
                "Ro’za lozim bo’lishing birinchi sharti qanday nomlanadi?",
                "Zimmaga lozim bo’lish shartlari"
            ),
            Question(
                "Ro’za lozim bo’lishing ikkinchi sharti qanday nomlanadi?",
                " Ro’zani ado etish uchun lozim shartlar"
            ),
            Question(
                "Ro’za lozim bo’lishing uchunchi sharti qanday nomlanadi?",
                "Ro’zaning to’gri bo’lish shartlari"
            ),
            Question(
                "Zimmaga lozim bo’lish shartlari nechta va ularni sanang?",
                "3 ta: Islom, aql, balog’at"
            ),
            Question(
                "Ro’zani ado etish uchun lozim shartlar nechta va ular qaysilar? ",
                "2 ta: Sog’lom bo’lish, muqim bo’lish"
            ),
            Question(
                " Ro’zaning to’gri bo’lish shartlari nechta ? ",
                "3 ta"
            ),
            Question(
                "Qilinishi lozim bo’lgan amalni shariatda belgilangan vaqtda qilish nima deyiladi? ",
                "Ado"
            ),
            Question(
                "Qilinishi lozim bo’lgan amalni belgilangan vaqtidan keyin bajarish nima deyiladi? ",
                "Qazo"
            ),
            Question(
                "Ramazon ro’zasini vaqtida ado qilish qanday amal? ",
                "Farz"
            ),
            Question(
                "Ramazon ro’zasini vaqtida ado qilinmagan bo’lsa, qazosini tutish qanday amal? ",
                "Farz"
            ),
            Question(
                "Qaysi oyat  Ramazon ro’zasini vaqtida ado qilish farzligiga dalildir? ",
                "Baqara  surasi, 185-oyat"
            ),
            Question(
                "Qaysi suraning nechinchi oyati Ramazon ro’zasini qazosini tutish farzligiga dalildir? ",
                "Baqara  surasi, 185-oyat"
            ),
            Question(
                "Kafforat ro’zalari qanday amal? ",
                "Vojib"
            ),
            Question(
                "Tong otgandan (subhi sodiqdan) boshlanib, quyosh botguncha davom etadigan kunduz qanday kunduz hisoblanadi. ",
                "Shar’iy kunduz "
            ),
            Question(
                "Quyosh chiqqandan boshlab botguncha davom etadigan va shar’iy bo’lmagan kunduz nima deb nomlanadi?",
                "Lug’aviy kunduz"
            ),
            Question(
                "Ro’za tutmoqchi bo’lgan kishi tong otgandan boshlab kunduzning yarmigacha niyat qilib olsa,ro’zasi to’g’ri bo’ladimi? ",
                "Ha, to’g’ri bo’ladi."
            ),
            Question(
                "Ro’zaning turlari nechta va ularni qaysilar? ",
                "4 ta: Lozim ro’za, Harom ro’za, Makruh ro’za, Ixtiyoriy ro’za "
            ),
            Question(
                "Ro’zadorning hadisi sharifda keltirilgan ikki hursandchiligi ...",
                "Iftor qilganida hursand bo’ladi va Robbiga ro’baro’ bo’lganida ro’zasi sababli hursand  bo’ladi."
            )
        )
        return myList
    }

}