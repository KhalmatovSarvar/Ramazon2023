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
                "Savol: qazo ro’zalarni tutayotganlar qanday niyat qilishadi?",
                "Javob: \nqazo ro’zalarni tutayotganlar subhi sodiqdan avval niyat qilib olishlari, niyatda qanday ro’zani, qaysi kunning qazosini tutayotganini tayin qilishlari shart. Iftorlik paytida “ertaga ham qazo\n" +
                        "ro’za tutaman” yoki “ertaga qazo ro’za tutishni niyat qildim” deb niyat qilish ham mumkin. Qazosi ko’payib ketsa yoki necha kunligi esida bo’lmasa, “zimmamga eng avval vojib bo’lgan Ramazonning qazosini yoki zimmamga eng oxirgi vojib bo’lgan Ramazonning qazosini tutishni niyat qildim” desa, kifoya qiladi."
            ),
            Question(
                "Savol: Kafforat ro’zasini tutuvchilar qanday niyat qilishadi?",
                "Javob: \nKafforat ro’zasini tutuvchilar subhi sodiqdan avval niyat qilib, niyatda qaysi kafforat ekanini tayin qilishlari shart. Iftorlik paytida “ertaga ham kafforat ro’zasini tutaman “ yoki “ertaga kafforat ro’zasini tutishni niyat qildim“ deb niyat qilish ham mumkin. Misol uchun “ramazon ro’zasining kafforatini“, “zihorning kafforatini“ yoki\n" +
                        "“qasamning kafforatini niyat qildim“ deyishlari kabi."
            ),
            Question(
                "Savol: qaysi amallar ro’zani buzib, qazo va kafforatni vojib qiladi?",
                "Javob: \nRo’za buzilgan har qanday holatda qazosini tutish vojib bo’ladi, lekin quyidagi holatlarda qazo bilan birga kafforat ham vojib bo’ladi:\n" +
                        "– ro’zani suratan buzish (tomoqdan biror narsa o’tishi, ikki yo’ldan biriga jimoʼ qilish). Tomoqdan boshqa yo’ldan, masalan, burun, quloq, ayolning oldi, erkagu ayolning orqasidan dori yoki shu kabi narsa kirsa, faqat qazo lozim bo’ladi, kafforat vojib bo’lmaydi.\n" +
                        "Shuningdek, old-orqadan boshqa joyga jimoʼ qilinib, maniy to’kilsa ham qazo lozim bo’lib, kafforat vojib bo’lmaydi. Agar maniy to’kilmasa, qazo ham lozim bo’lmaydi.\n" +
                        "–ro’zani maʼnan buzish (badanga manfaat beradigan,\n" +
                        "ozuqa yoki davo bo’ladigan, lazzat hosil qiladigan, inson taʼbi yeyishga moyil bo’ladigan narsalarning tomoqdan o’tishi). Ozuqa yoki davo bo’lmagan, inson taʼbi yeyishga moyil bo’lmaydigan (tosh, kesak, tish kovagidagi kabi) narsalar tomoqdan o’tsa, qazo lozim\n" +
                        "bo’lib, kafforat vojib bo’lmaydi. Zero, bu holatlar yeyish bo’lsa ham, ozuqa yeyish hisoblanmaydi (doimo kesak yeb yuradiganlar bundan mustasno);\n" +
                        "– ro’zani qasdan buzish (adashib emas). Tahorat yoki\n" +
                        "g’usl qilayotganda beixtiyor tomoqdan suv o’tib ketsa, qazo lozim bo’lib, kafforat vojib bo’lmaydi. Ro’zadorligini unutib, yeb-ichib qo’ysa, yog’ayotgan yomg’ir tomchilarini yutib yuborsa qazo ham, kafforat ham vojib bo’lmaydi.\n" +
                        "– ro’zani o’z ixtiyori bilan buzish (majburlanish bundan mustasno). Birovning majburlashi tufayli ro’za ochilsa, qazo lozim bo’lib, kafforat vojib bo’lmaydi;\n" +
                        "– ro’zani zaruratsiz buzish (zarurat yuzasidan buzish bundan mustasno). Ro’zani ochishga qattiq tashnalik, ochlik, bemorlik kabi zarurat paydo bo’lsa, qazo lozim bo’lib, kafforat vojib bo’lmaydi;\n" +
                        "– ro’za buzilgandan keyin ro’zani ochishni muboh qiladigan holat bo’lmasligi. Masalan, ro’zani qasddan ochgandan keyin hayz va nifos kelib qolishi, qattiq tashnalik, ochlik, og’ir kasallik kabi halok qiladigan\n" +
                        "yoki biror aʼzoga talafot yetkizadigan darajada holat yuzaga kelib, ro’zani ochib yuborilsa qazo lozim bo’lib, kafforat soqit bo’ladi.\n" +
                        "– ro’zani musofir yo bemor bo’lmay turib buzish. Agar musofir yo bemor bo’laturib ro’za tutsa-yu, keyin ro’zasini ochib yuborsa, qazo lozim bo’ladi, kafforat vojib bo’lmaydi.\n" +
                        "– Ramazon ro’zasini ado qilayotganda ro’zani ochib yuborish. Bundan boshqa ro’zalar buzilsa, shuningdek, Ramazonning qazo ro’zasi buzilsa ham kafforat vojib bo’lmaydi.\n" +
                        "– cubhi sodiqdan avval niyat qilingan ro’zani buzish. Subhi sodiqdan keyin niyat qilib, keyin ro’zasini ochib yuborsa, kafforat vojib bo’lmaydi.\n" +
                        "– biror shubha tufayli ro’zani ochish. Agar quyosh botdi deb o’ylab, iftorlik qilgan bo’lsa, subhi sodiq kirmadi, deb yeb-ichgan bo’lsa, qazo lozim bo’ladi, kafforat vojib bo’lmaydi."
            ),
            Question(
                "Savol: Ro’zaning kafforati qanday ado etiladi?",
                "Javob: \n1) bir qul ozod qilish; 2) qulga imkoniyati bo’lmasa, ketma-ket ikki oy ro’za tutish (alohida bir kun qazosi ham tutiladi); 3) bunga ham imkoniyati bo’lmasa, oltmish kishini ertalab va kechqurun taomlantirish;\n" +
                        "Abu Hurayra roziyallohu anhudan rivoyat qilinadi:\n" +
                        "“bir odam Nabiy sollallohu alayhi vasallamning huzurlariga kelib, “halok bo’ldim, ey Allohning Rasuli!” dedi. “seni nima halok qildi?” dedilar.\n" +
                        "“ramazonda xotiniga yaqinlik qilib chiqib qo’ydim”, dedi. “ozod qilishga qul topa olasanmi?” dedilar.\n" +
                        "“yo’q”, dedi. “ikki oy ketma-ket ro’za tuta olasanmi?” dedilar. “yo’q”, dedi. “oltmish miskinga taom berishga narsa topa olasanmi?” dedilar. “yo’q”, dedi. So’ngra kutib o’tirdi. Shu payt Payg’ambar\n" +
                        "sollallohu alayhi vasallamga bir zambil xurmo keltirildi. U zot (haligi odamga) “mana buni sadaqa qilib yubor”, dedilar. “ey Allohning Rasuli, o’zimdan ham faqirroqqami? Allohga qasamki, uning (madinaning) ikki cheti orasida bizdan ko’ra muhtojroq xonadon yo’q”, dedi. Shunda Payg’ambar sollallohu alayhi vasallam kulib yubordilar, hatto tishlarining oqi ko’rinib ketdi. So’ngra: “bor, uni ahlingga taom qilib ber”, dedilar”.\n" +
                        "Muslim rivoyat qilgan.\n"
            ),
            Question(
                "Savol: Zimmasiga kafforat lozim bo’lgan kishi ikki oy ketma-ket ro’za tutmay, oltmishta miskinni taomlantirsa ham bo’ladimi?",
                "Javob: \nRo’za tutishga qodir bo’laturib taomlantirish bilan kafforat ado bo’lmaydi. Kafforatni ado qilish uchun avvalo bir qul ozod qilish kerak. Bunga imkoni bo’lmasa, ikki oy ketma- ket ro’za tutishi kerak. Bunga ham qodir bo’lmasa oltmishta miskinni taomlantirishi kerak."
            ),
            Question(
                "Savol: Ramazonning qazosi va kafforatini tutayotgan kishi subhi sodiqqacha niyat qilishga ulgurmasa nima qiladi?",
                "Javob: \nRamazonning qazosi va kafforatini tutayotgan kishi subhi sodiq kirmasidan avval ro’za tutishni niyat qilishi shart. Agar subhi sodiqdan keyin niyat qilsa, niyati eʼtiborli bo’lmaydi. Shuning uchun saharlikka tura olmay qolishidan qo’rqqan kishi quyosh botganidan keyin “ertangi kunning qazo va kafforatini tutishni niyat qildim”, desa kifoya. “ertaga ro’za tutaman, inshaalloh”, desa niyati durust bo’ladi."
            ),
            Question(
                "Savol: Ikki oy kafforat ro’zasini tutayotgan kishi o’rtada bemor bo’lib qolsa nima qiladi?",
                "Javob: \nBemorligi tufayli kafforat ro’zani oxirigacha tuta olmay qolgan kishi sog’ayib ketgach, boshidan boshlab ikki oy ro’za tutadi. Kafforat ro’zasini tutayotgan erkak yoki ayol qaysidir uzr tufayli ikki oy ichida biror kun ro’zasini ochib yuborsa, yana qaytadan boshlaydi. Lekin ayolning hayz ko’rishi bundan mustasnodir. Nifos esa mustasno emas."
            ),
            Question(
                "Savol: qasddan bir necha ro’zasini ochib yuborgan kishiga necha marta kafforat lozim bo’ladi?",
                "Javob: \nBir Ramazon oyining bir necha kunlik ro’zasini qasddan ochgan kishiga bitta kafforat kifoya qiladi. Bir necha Ramazon oyining ro’zalarini qasddan ochgan kishiga har bir Ramazon oyi uchun alohida-alohida kafforat lozim bo’ladi. Ulamolar bir Ramazon oyining bir kunida bir necha bor yeb-ichib qo’yib, ro’zasini qasddan ochib yuborgan kishining bitta kafforat to’lashi borasida ittifoq qilishgan."
            ),
            Question(
                "Savol: Kafforat vojib bo’lishini bilmay, Ramazonning ro’zasini qasddan buzib qo’ygan kishiga ham kafforat lozim bo’ladimi?",
                "Javob: \nRamazon ro’zasini qasddan buzgan kishiga kafforat lozim bo’ladi. Buning hukmini bilmasligi uzr sanalmaydi. Kim ikki yo’lning biriga qasddan yaqinlik qilsa, ozuqa yoki davo bo’ladigan narsani yeb- ichib qo’ysa, zimmasiga qazo va kafforat lozim bo’ladi. Bunda avvalo bir qul ozod qiladi. Bunga imkoni bo’lmasa, ikki oy ketma-ket ro’za tutib beradi. Unga ham qodir bo’lmasa, oltmish miskinni to’ydiradi."
            ),
            Question(
                "Savol: Er ayolini majburlab yaqinlik qilsa, ayolga ham kafforat lozim bo’ladimi?",
                "Javob: \nAyol ham boshidan xohlab rozi bo’lsa, qazo ham, kafforat ham lozim bo’ladi. Agar avvalida rozi bo’lmay, er yaqinlikni boshlab yuborganidan keyin rozi bo’lsa, qazo lozim bo’lib, kafforat lozim bo’lmaydi."
            ),
            Question(
                "Savol: Ro’za qachon farz qilingan? ",
                "Javob: \nHijratdan 1,5 yil o’tgach"
            ),
            Question(
                "Savol: Arab tilida “sovm” (ro’za) lug’atda qanday ma’no bildiradi?",
                "Javob: \nO’zni tiyish"
            ),
            Question(
                "Savol: Ro’za qanday sobit bo’lgan? ",
                "Javob: \nQur’on va sunnat bilan"
            ),
            Question(
                "Savol: “Ey iymon keltirganlar! Sizlardan avvalgilarga farz qilinganidek,sizlarga ham ro’za farz qilindi. Shoyadki, taqvo qilsangiz”\n" +
                        "  Keltirilgan oyatning qaysi suradan ekanligni toping\n",
                "Javob: \nBaqara surasi, 183-oyat"
            ),
            Question(
                "Savol: Ro’za qanday bajariladi? ",
                "Javob: \nAlloh taologa muhabbat va ixlos belgisi sifatida"
            ),
            Question(
                "Savol: Qaysi mazhabda ramazon tugagunicha har quni niyat yabngilanib turiladi? ",
                "Javob: \nHanafiy mazhabida "
            ),
            Question(
                "Savol: Qaysi mazhabga ko’ra, Ramazon ro’zasini tutishda har kungi niyatni quyosh oqqunigacha yangilab olsa ham bo’laveradi? ",
                "Javob: \nHanafiy mazhabiga ko’ra"
            ),
            Question(
                "Savol: Banu sulaymlik bir kishidan rivoyat qilingan hadisda:\n" +
                        "“Rasululloh sollallohu alayhi vasallam: “Ro’za- … yarmidir”, dedilar”\n" +
                        " Nuqtalar o’rnini to’ldiring.\n",
                "Javob: \nSabrning yarmidir!"
            ),
            Question(
                "Savol: Agar kim ro’za tutsayu,qalbida taqvo hissi uyg’onmasa, u odam haqiqiy ro’za tutgan bo’ladimi? ",
                "Javob: \nYo’q, bo’lmaydi!"
            ),
            Question(
                "Savol: Abu Hurayra roziyallohi anhudan rivoyat qilinadi:\n" +
                        "“Rasululloh sollallohu alayhi vasallam aytadilar:\n" +
                        "“Alloh taolo dedi:Odam bolasining hamma amali o’zi uchun, faqat ro’za Men uchundir va uning mukofotini O’zim berurman”.\n" +
                        "Buxoriy va Muslim rivoyat qilishgan.\n" +
                        "Ro’zaning bunday fazlga ega bo’lishining 2 ta ma’nosidan birinchisini toping? \n",
                "Javob: \nRo’za ichki amal hisoblanadi!"
            ),
            Question(
                "Savol: Abu Hurayra roziyallohi anhudan rivoyat qilinadi:\n" +
                        "“Rasululloh sollallohu alayhi vasallam aytadilar:\n" +
                        "“Alloh taolo dedi:Odam bolasining hamma amali o’zi uchun, faqat ro’za Men uchundir va uning mukofotini O’zim berurman”.\n" +
                        "Buxoriy va Muslim rivoyat qilishgan.\n" +
                        "Ro’zaning bunday fazlga ega bo’lishining 2 ta ma’nosidan ikkinchisini toping? \n",
                "Javob: \nRo’za tutish Alloh taoloning dushmani-shaytonga qahr qilish demakdir!"
            ),
            Question(
                "Savol: Ramazon oyi ro’zasining hukmlari va hikmatlari bayon etilgan surani toping?",
                "Javob: \nBaqara surasi, 183-185 va 187-oyatlari!"
            ),
            Question(
                "Savol: Alloh taolo, Baqara surasi 183-oyatda musulmonlarga ro’zaning farzligini amr etishdan oldin ularga qanday nido qilgan?  ",
                "Javob: \nEy iymon keltirganlar!"
            ),
            Question(
                "Savol: Baqara surasi, 183-oyatning ma’nosidan kelib chiqib, ro’za qanday ibodat emasligni tushunamiz? ",
                "Javob: \nYangi ibodat emasligini!"
            ),
            Question(
                "Savol: Nasorolarda qanday amal ro’za deyiladi? ",
                "Javob: \nHayvondan chiqqan ozuqa mahsulotlarini tanovul qilmaslik."
            ),
            Question(
                "Savol: Qanday toifa insonlarga mashaqqat ustiga mashaqqat bo’lmasligi uchun ro’za tutish kunlarini “…sanog’i  boshqa kunlardan” deya yengillik berilgan? ",
                "Javob: \nBemor yoki safardagi insonlarga!"
            ),
            Question(
                "Savol: . Ulamolarimiz bemorlar safiga qanday insonlarni ham qo’shganlar? ",
                "Javob: \nHomilador va emizikli ayollarni ham"
            ),
            Question(
                "Savol: Ro’zani   qiynalib tutadiganlar zimmasida qanday amal bor?",
                "Javob: \nFidya "
            ),
            Question(
                "Savol: Fidya  bu - …?",
                "Javob: \nBir maskin taomi!"
            ),
            Question(
                "Savol:  Ro’za tutishga qiynaladigan insonlar kimlar? ",
                "Javob: \nYoshlari ulug’ bo’lib, ro’za tutishga yaramay qolgan kishilar!"
            ),
            Question(
                "Savol: Ulamolarimiz ro’za tutishda qiynaladiganlar safiga  kimlarni ham kiritgan?",
                "Javob: \nTuzalmaydigan,surunkali kasali bor kishilarni!"
            ),
            Question(
                "Savol: Ro’za tutish orqali erishiladigan yaxshiliklarni toping?",
                "Javob: \n1.Jannatga kirish\n" +
                        "2.Oliy maqomlarga erishish\n" +
                        "3.Irodaning kuchli bo’lishi\n" +
                        "4.Rahm-shavqat sifatining kuchayishi\n" +
                        "5.Taqvo hissining uyg’onishi\n" +
                        "6. Sog’lik va salomatlik \n"
            ),
            Question(
                "Savol: . Ro’za farz qilingan sanoqli kunlar qaysi? ",
                "Javob: \nRamazon oyi!"
            ),
            Question(
                "Savol: Qur’on nozil qilingan oy- …? ",
                "Javob: \nRamazon oyi!"
            ),
            Question(
                "Savol: Ramazon oyida odamlarga qanday ochiq-oydin hujjatlar bor? ",
                "Javob: \nHidoyat hamda hidoyatu furqondan iborat ochiq-oydin hujjatlar!"
            ),
            Question(
                "Savol:  Islom shariati qanday  asosga bino qilingan?",
                "Javob: \nOsonlikka!"
            ),
            Question(
                "Savol: “Yorug’likning ufqda tarqalishi” ni bildiradigan payt qanday nomlanadi?",
                "Javob: \nFajri sodiq!"
            ),
            Question(
                "Savol: Shariatda Allohga yaqinlik hosil qilish niyatida masjidda ibodatni lozim tutish nima deyiladi? ",
                "Javob: \n“E’tikof”!"
            ),
            Question(
                "Savol: . “E’tikof” so’zi qanday ma’noni  anglatadi? ",
                "Javob: \n“Bir narsani lozim tutish”!"
            ),
            Question(
                "Savol: Ro’zaning son-sanoqsiz foydalari ichida  birinchi o’rinda turadiganini toping?",
                "Javob: \nRo’zaning ro’zadorda taqvo hissini mustahkamlashi!"
            ),
            Question(
                "Savol: . Ro’za ibodatini ado etgan banda jannatga qaysi eshikdan kirish huquqini qo’lga kiritadi? ",
                "Javob: \n“Rayon” eshigidan!"
            ),
            Question(
                "Savol: Ro’zaga berilgan ta’riflar ...",
                "Javob: \n1. Alloh taologa qilinadifan toat-ibodat\n" +
                        "2. Ilkan axloq maktabi\n" +
                        "3. Nafs balosiga qarshi kurash\n" +
                        "4.Insonni man qilingan narsalarga sabr qilishga o’rgatadigan amal\n" +
                        "5.Inson hayotida keladigan mashaqqatlarga chidashga malaka hosil qildiradigan amal\n"
            ),
            Question(
                "Savol: Ro’zaning foydalari ...",
                " Javob: \n1.\tRo’za tutgan kishing taqvodorligi oshadi. \n" +
                        "2.\tRo’zador insonga sog’liq ato etiladi.\n" +
                        "3.\tRo’za havoyi nafsni sindiradi.\n" +
                        "4.\tRo’za tutish orqali shaytonga  qahr ko’rsatiladi.\n" +
                        "5.\tRo’za insonning irodasini, qat’iyatini mustahkamlaydi.\n" +
                        "6.\tRo’za insonni tartib intizomga o’rgatadi.\n"
            ),
            Question(
                "Savol: …- ro’za tutsin ",
                "Javob: \n1.\tKim qalbi musaffo bo’lishi xohlasa\n" +
                        "2.\tKim farishtakar safiga ega bo’lishni xohlasa\n" +
                        "3.\tKim sabr-bardoshl bo’lmoqchi bo’lsa\n" +
                        "4.\tKim o’zida rahm-shafqat sifatini shakllantirish va mustahkamlashni xohlasa\n"
            ),
            Question(
                "Savol: Tavba surasi 112-oyatida keltirilgan mo’minlarning sifatlari quydagilar ...",
                "Javob: \n1.\tTavba qiluvchilar\n" +
                        "2.\tIbodat qiluvchilar\n" +
                        "3.\tHamd aytuvchilar\n" +
                        "4.\tRo’za tutuvchilar\n" +
                        "5.\tRuku qiluvchilar, sajda qiluvchilar \n" +
                        "6.\tMa’rufga buyurib mukardan qaytaruvchilar\n" +
                        "7.\tAllohning chegarasida turuvchilar \n"
            ),
            Question(
                "Savol: Ro’zadorning hadisi sharifda keltirilgan ikki hursandchiligi ...",
                "Javob: \nIftor qilganida hursand bo’ladi va Robbiga ro’baro’ bo’lganida ro’zasi sababli hursand  bo’ladi."
            ),
            Question(
                "Savol: Hadisi sharifga ko’ra ro’zador o’g’zining hidi Alloh uchun qanday hiddan ham yoqimliroqdir.",
                "Javob: \nMushk hididan ham"
            ),
            Question(
                "Savol:  Qiyomat kuni faqat ro’zadorlar kiradigan Jannat eshigining nomini toping?",
                "Javob: \nRayyon"
            ),
            Question(
                "Savol: Hadisi sharifga ko’ra, ro’zador odam qanday holatda ibodatda bo’ladi? ",
                "Javob: \nBiror musulmonni g’iybat qilmasa, ozor bermasa"
            ),
            Question(
                "Savol: Abu Hurayra roziyallohu anhudan rivoyat qilingan ushbu hadisi sharifda tushurib qoldirilgan so’zlarni toping?" +
                        "“Rasululloh sollallohu alayhi vasallam:\n" +
                        "“ Kim … ni va …ni qo’ymasa, Alloh uning taoimi va ichimligini tark etishiga muhtoj emas”, deganlar” Buxoriy rivoyat qilgan.\n",
                "Javob: \nYolg’on gapirishni va unga amal qilishni  qo’ymasa"
            ),
            Question(
                "Savol: Jobir roziyallohu anhudan rivoyat qilingan ushbu hadisi sharifda tushurib qoldirilgan so’zni toping?" +
                        "“Bir odam Nabiy sollallohu alayhi vasallamga: “Ayting-chi, farz namozlarini o’qisam,Ramazon ro’zasini" +
                        " tutsam, halolni halol, haromni harom deb balsam va bunga hech narsani ziyoda qilmasam, Jannatga kiramanmi?” dedi." +
                        " U Zot: “…”,dedilar. “Allohga qasamki,unga hech narsani ziyoda qilmayman”, dedi”. Muslim rivoyat qilgan.",
                "Javob: \nHa "
            ),
            Question(
                "Savol: Ahli haqning oldida ro’zaning darajasi nechta?",
                "Javob: \n3 ta: Ommaning ro’zasi, xoslarning ro’zasi va xoslardan ham xoslarning ro’zasi "
            ),
            Question(
                "Savol: “Qorin va farjning istak-xohishlaridan tiyilish” ro’zaning qaysi darajasi? ",
                "Javob: \nOmmaning ro’zasi "
            ),
            Question(
                "Savol: “Birinchi darajadan ko’ra ziyoda o’laroq ko’z,  quloq, tilni, oyoq qo’l va boshqa narsalarni ham gunohlardan tiyish” ro’zaning qaysi darajasi?",
                "Javob: \nXoslarning ro’zasi "
            ),
            Question(
                "Savol: “Ikki darajadan ham ziyoda o’laroq, qalbni behuda qiziqishlardan, dunyoviy fikrlardan" +
                        " va Alloh taolodan boshqa narsalardan tiyishdan iborat” bo’lgan ro’za darajasini toping. ",
                "Javob: \nXoslardan ham xoslarning ro’zasi"
            ),
            Question(
                "Savol: Xoslarning ro’zasi yana qanday nom nilan ham nomlanadi? ",
                "Javob: \nSolihlar ro’zasi "
            ),
            Question(
                "Savol: Bishr ibn Horis rahmarullohi alayhdan rivoyat qilinishicha, Sufyon Savriy qanday amal ro’zani buzishi haqida ta’kidlaganlar? ",
                "Javob: \nG’iybat "
            ),
            Question(
                "Savol: Mujohid qanday  2 xislat ro’zani buzishi haqida ta’kidlaganlar?  ",
                "Javob: \nG’iybat va yolg’on"
            ),
            Question(
                "Savol: Ushbu oyat qaysi suradan olinganligni toping: \n" +
                        "“Yolg’onga ko’p quloq soluvchilar, haromni ko’p yeyuvchilardir” \n",
                "Javob: \nMoida surasi, 42-oyat"
            ),
            Question(
                "Savol: Iftordan so’ng qalb qanday holatdan bo’lishi lozim? ",
                "Javob: \nXavf  va rajo orasida bo’lishi lozim."
            ),
            Question(
                "Savol: Hasan Basriy rahmatullohi alayh kulib o’tirgan qavm oldidan o’tayotib, “Alloh azza va jalla " +
                        "Ramazon oyini O’z bandalarini chiniqtirish uchun, U Zotning toatida musobaqa qilishlari uchun" +
                        " joriy qilgan.Bir qavmlar o’zib ketib najot topishdi.Boshqalari esa ortda qolib,noumid bo’ldilar. " +
                        "O’zganlar najot topib, ahli botillar noumid bo’lgan kunda  kimlarga  hayronman”, dedi. ",
                "Javob: \nO’ynab-kulganlarga"
            ),
            Question(
                "Savol: Hadisda qanday amal ko’ngilning taqvosi dya aytilgan?",
                "Javob: \nHaromga qaramaslik"
            ),
            Question(
                "Savol: Ro’za durust bo’lishi uchun necha xil shart topilishi lozim? ",
                "Javob: \n3 xil"
            ),
            Question(
                "Savol: Ro’za lozim bo’lishing birinchi sharti qanday nomlanadi?",
                "Javob: \nZimmaga lozim bo’lish shartlari"
            ),
            Question(
                "Savol: Ro’za lozim bo’lishing ikkinchi sharti qanday nomlanadi?",
                "Javob: \nRo’zani ado etish uchun lozim shartlar"
            ),
            Question(
                "Savol: Ro’za lozim bo’lishing uchunchi sharti qanday nomlanadi?",
                "Javob: \nRo’zaning to’gri bo’lish shartlari"
            ),
            Question(
                "Savol: Zimmaga lozim bo’lish shartlari nechta va ularni sanang?",
                "Javob: \n3 ta: Islom, aql, balog’at"
            ),
            Question(
                "Savol: Ro’zani ado etish uchun lozim shartlar nechta va ular qaysilar? ",
                "Javob: \n2 ta: Sog’lom bo’lish, muqim bo’lish"
            ),
            Question(
                "Savol:  Ro’zaning to’gri bo’lish shartlari nechta ? ",
                "Javob: \n3 ta"
            ),
            Question(
                "Savol: Qilinishi lozim bo’lgan amalni shariatda belgilangan vaqtda qilish nima deyiladi? ",
                "Javob: \nAdo"
            ),
            Question(
                "Savol: Qilinishi lozim bo’lgan amalni belgilangan vaqtidan keyin bajarish nima deyiladi? ",
                "Javob: \nQazo"
            ),
            Question(
                "Savol: Ramazon ro’zasini vaqtida ado qilish qanday amal? ",
                "Javob: \nFarz"
            ),
            Question(
                "Savol: Ramazon ro’zasini vaqtida ado qilinmagan bo’lsa, qazosini tutish qanday amal? ",
                "Javob: \nFarz"
            ),
            Question(
                "Savol: Qaysi oyat  Ramazon ro’zasini vaqtida ado qilish farzligiga dalildir? ",
                "Javob: \nBaqara  surasi, 185-oyat"
            ),
            Question(
                "Savol: Qaysi suraning nechinchi oyati Ramazon ro’zasini qazosini tutish farzligiga dalildir? ",
                "Javob: \nBaqara  surasi, 185-oyat"
            ),
            Question(
                "Savol: Kafforat ro’zalari qanday amal? ",
                "Javob: \nVojib"
            ),
            Question(
                "Savol: Tong otgandan (subhi sodiqdan) boshlanib, quyosh botguncha davom etadigan kunduz qanday kunduz hisoblanadi. ",
                "Javob: \nShar’iy kunduz "
            ),
            Question(
                "Savol: Quyosh chiqqandan boshlab botguncha davom etadigan va shar’iy bo’lmagan kunduz nima deb nomlanadi?",
                "Javob: \nLug’aviy kunduz"
            ),
            Question(
                "Savol: Ro’za tutmoqchi bo’lgan kishi tong otgandan boshlab kunduzning yarmigacha niyat qilib olsa,ro’zasi to’g’ri bo’ladimi? ",
                "Javob: \nHa, to’g’ri bo’ladi."
            ),
            Question(
                "Savol: Ro’zaning turlari nechta va ularni qaysilar? ",
                "Javob: \n4 ta: Lozim ro’za, Harom ro’za, Makruh ro’za, Ixtiyoriy ro’za "
            ),
            Question(
                "Savol: Lozim ro’za necha turga bo’linadi va ular qaysilar?  ",
                "Javob: \n2 turga bo’linadi: farz va vojib"
            ),
            Question(
                "Savol: Farz ro’zaning 2 turini ayting. ",
                "Javob: \nTayin qilingan va tayin qilinmagan farz ro’za "
            ),
            Question(
                "Savol: Qaysi ro’za tayin qilingan farz ro’za hisoblanadi? ",
                "Javob: \nQur’on, sunnat va ulamolar ijmo’i bilan sobit bo’lgan Ramazon ro’zasi "
            ),
            Question(
                "Savol: Qaysi ro’za tayin qilinmagan farz ro’za hisoblanadi? ",
                "Javob: \nRamazonning qazosi va kafforati "
            ),
            Question(
                "Savol: Vojib ro’zaning 2 turini ayting. ",
                "Javob: \nTayin qilingan va tayin qilinmagan vojib ro’za"
            ),
            Question(
                "Savol: Qaysi ro’za tayin qilingan vojib ro’za hisoblanadi?",
                "Javob: \nMuayyan nazr (tayin kun) ro’za  va Ramazon oyining hilolini ko’rib, shahodati qabul qilinmagan kishining ro’zasi. "
            ),
            Question(
                "Savol: Ushbu oyat qaysi suradan olingan:\n" +
                        "“…nazrlariga vafo qilsinlar”  \n",
                "Javob: \nHaj surasi, 29-oyat"
            ),
            Question(
                "Savol:  Musulmon kishi qanday holatda ro’za tutishni o’ziga vojib qilib olgan bo’ladi? ",
                "Javob: \nRo’za tutishni nazr qilganida"
            ),
            Question(
                "Savol: Tayin qilinmagan vojib ro’za necha turlidir? ",
                "Javob: \n9 turlidir  "
            ),
            Question(
                "Savol: Kimning ro’zasi nazr ro’za yoki mutlaq ro’za deyiladi? ",
                "Javob: \nKunini tayin qilmasdan, bir kun ro’za tutishni nazr qilgan kishining ro’zasi.\n" +
                        "Masalan, “Falon ishim amalga oshsa, bir kun ro’za tutishni nazr qildim” deyilgani kabi.  \n"
            ),
            Question(
                "Savol: Muayyan kunda ro’za tutishni nazr qilib, tuta olmagan kishining qazo ro’zasi qanday ro’za hisoblanadi? ",
                "Javob: \nTayin qilinmagan vojib ro’za  "
            ),
            Question(
                "Savol: Ro’za tutishga qasam ichib, zimmasiga ro’zani vojib qilib olgan kishining ro’zasi vojib ro’zaning qanday turiga kiradi? ",
                "Javob: \nTayin qilinmagan vojib ro’za "
            ),
            Question(
                "Savol: Nafl ro’zani tutishni boshlab, oxiriga yetkazmay,ochib yuborgan kishining o’sha kuni uchun tutadigan  qazo ro’zasi qanday ro’za turiga kiradi?  ",
                "Javob: \nTayin qilinmagan vojib ro’za"
            ),
            Question(
                "Savol: Zihor, qatl, Ramazonning ro’zasini qasddan ochib yuborish va qasamni buzganining kafforati uchun tutiladigan ro’zalar vojib ro’zaning qanday turiga kiradi?",
                "Javob: \nVojib ro’zaning tayin qilinmagan turiga kiradi."
            ),
            Question(
                "Savol: Tamattu’ va qiron uchun ehromga kirib qurbonlik qila olmagan kishining 10 kunlik ro’zasi qanday ro’za turiga kiradi? ",
                "Javob: \nVojib ro’zaning tayin qilinmagan turiga kiradi "
            ),
            Question(
                "Savol: Ehromdalik chog’ida, vaqti kirmasdan oldin soch oldirgan kishining kafforat uchun tutadigan 3 kunlik ro’zasi qanday ro’za hisoblanadi?",
                "Javob: \nTayin qilinmagan vojib ro’za "
            ),
            Question(
                "Savol: Haramda ov qilishning jazosi uchun tutiladigan ro’za qanday ro’za hisoblanadi? ",
                "Javob: \nTayin qilinmagan vojib ro’za "
            ),
            Question(
                "Savol: E’tikofini buzib qo’ygan kishining qazo ro’zasi qanday ro’za hisoblanadi?  ",
                "Javob: \nTayin qilinmagan vojib ro’za"
            ),
            Question(
                "Savol: Xursandchilik kunlari bo’lganligi uchun ro’za tutish harom bo’lgan kunlar qaysi kunlar? ",
                "Javob: \nIydul fitr kuni, Iydul azho kuni va undan keyingi 3 kun   "
            ),
            Question(
                "Savol: Abu Hurayra roziyallohu anhudan rivoyat qilinadi:\n" +
                        "“Nabiy sollallohu alayhi vasallam 2 kunning - … va  …\n" +
                        "kunining ro’zasidan qaytardilar”\n" +
                        "Buxoriy, Muslim, Abu Dovud, Termiziy va Nasoiy rivoyat qilishgan.\n" +
                        "Ushbu hadisga ko’ra,  Nabiy sollallohu alayhi vasallam qaysi 2 kunning ro’zasidan qaytarganligini toping.\n",
                "Javob: \nAzho va Fitr kunining ro’zasidan qaytarganlar "
            ),
            Question(
                "Savol: Uqba ibn Omir roziyallohu anhudan rivoyat qilingan hadisda Nabiiy sollalohu alayhi vasallam qaysi kunlarni “Bu kunlar bizning-ahli Islomning bayramimizdir. Bu kunlar yeb-ichish kunlaridir”, deya  aytganligini toping.\n" +
                        " “Sunan” egalari rivoyat qilishgan\n ",
                "Javob: \nArafa kuni, qurbonlik kuni, tashriq kunlari"
            ),
            Question(
                "Savol: Ro’za tutish harom qilingan Ramazon kirishidan oldingi kun qanday kun?",
                "Javob: \nShak kuni"
            ),
            Question(
                "Savol: Ro’za tutsa halok bo’lishini bilaturib ro’za tutish mumkinmi?",
                "Javob: \nYo’q, bu harom hisoblanadi."
            ),
            Question(
                "Savol: Ro’za tutsa halok bo’lishini bilaturib ro’za tutish haromligini asoslovchi ushbu oyat qaysi suradan olingan:\n" +
                        "   “…(O’zingizni) o’z qo’lingiz bilan halokatga tashlamang…” \n",
                "Javob: \nBaqara surasi, 195-oyat"
            ),
            Question(
                "Savol: Ro’za tutish harom hisoblanib, faqat ayollarga xos bo’lgan kunlar qaysilar?",
                "Javob: \nAyollarning hayz va nifos ko’rgan kunlari"
            ),
            Question(
                "Savol: Ayol kishining erining iznisiz yoki roziligini bilmay turib nafl ro’za tutishi mumkinmi?",
                "Javob: \nYo’q bu makruh hisoblanadi."
            ),
            Question(
                "Savol: Ayol kishining erining iznisiz yoki roziligini bilmay turib nafl ro’za tutishi qanday holatlarda makruh bo’lmaydi?",
                "Javob: \nAgar er yaqinlikka ojizlik qiladigan darajada bemor bo’lsa, yoki ro’zador bo’lsa, yoxud haj yo umraga ehrom bog’lagan bo’lsa makruh bo’lmaydi."
            ),
            Question(
                "Savol: Ashuro kunining yolg’iz o’zida ro’za tutish mumkunmi?",
                "Javob: \nYo’q, makruh hisoblanadi."
            ),
            Question(
                "Savol: Juma kunini xoslab, shanba kunini ulug’lab, yakshanba kunini ulug’lab, Navro’z kuni va Mehrjon kuni.\n" +
                        "Ushbu kunlarning qaysi birida ro’za tutsa bo’ladi? \n ",
                "Javob: \nUshbu kunlarning hammasida ro’za tutish makruh hisoblanadi."
            ),
            Question(
                "Savol: Ushbu holatlarning qay birida ro’za tutish makruh hisoblanmaasligini toping:\n" +
                        "-Uzluksiz har kuni ro’za tutish; \n" +
                        "-Gapirmasdan ro’za tutish;\n" +
                        "-Ulab(saharlik qilmay) ro’za tutish;\n" +
                        "-Musofirning qiynalib ro’za tutishi.\n",
                "Javob: \nUshbu holatlarning barchasida ro’za tutish makruh hisoblanadi."
            ),
            Question(
                "Savol: Hanafiy mazhabida ixtiyoriy ro’za nechta turga bo’linadi va ular qaysilar?",
                "Javob: \n3 turga bo’linadi: Sunnat, mandub, nafl. "
            ),
            Question(
                "Savol: Sunnat ro’za qaysi ixtiyoriy ro’zalar hisoblanadi?",
                "Javob: \nRasululloh sollallohu alayhi vasallam doimiy tutib yurgan ixtiyoriy ro’zalar"
            ),
            Question(
                "Savol: Mandub yoki mustahab ro’zalar qaysi ixtiyoriy ro’zalardir?",
                "Javob: \nRasululloh sollallohu alayhi vasallam doimiy tutmagan ixtiyoriy ro’zalar"
            ),
            Question(
                "Savol: Mandub yoki mustahab ro’zalar qaysilar?",
                "Javob: \n1.\tBir kun tutib, bir kun ochib yurish.\n" +
                        "2.\tHar oyda 3 kun ro’za tutish.\n" +
                        "3.\tHaftaning dushanba va payshanba kunlari ro’za tutish.\n" +
                        "4.\tShavvol oyida 6 kun ro’za tutish.\n" +
                        "5.\tArafa kuni ro’za tutish.\n" +
                        "6.\tArafadan oldingi 8 kunda ro’za tutish.\n" +
                        "7.\tSha’bon oyida ro’za tutish.\n"
            ),
            Question(
                "Savol: Qanday ro’zaga nafl ro’za deyiladi? ",
                "Javob: \nDinimizda ularni ham tutish targ’ib qilingan, sunnat va mandub (yoki mustahab) ro’zalardan boshqa ixtiyoriy ro’zalar."
            ),
            Question(
                "Savol: “Niyat” so’zi lug’atda qanday ma’no anglatadi?",
                "Javob: \n“Qasd qilish” ma’nosini anglatadi."
            ),
            Question(
                "Savol: Tayin qilinmagan vojib ro’za necha turlidir? ",
                "Javob: \n9 turlidir  "
            )
        )
        return myList
    }

}