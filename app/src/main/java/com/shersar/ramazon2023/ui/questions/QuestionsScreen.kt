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
                        "  Keltirilgan oyatning qaysi suradan ekanligni toping\n",
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
                "Lozim ro’za necha turga bo’linadi va ular qaysilar?  ",
                "2 turga bo’linadi: farz va vojib"
            ),
            Question(
                "Farz ro’zaning 2 turini ayting. ",
                "Tayin qilingan va tayin qilinmagan farz ro’za "
            ),
            Question(
                "Qaysi ro’za tayin qilingan farz ro’za hisoblanadi? ",
                "Qur’on, sunnat va ulamolar ijmo’i bilan sobit bo’lgan Ramazon ro’zasi "
            ),
            Question(
                "Qaysi ro’za tayin qilinmagan farz ro’za hisoblanadi? ",
                "Ramazonning qazosi va kafforati "
            ),
            Question(
                "Vojib ro’zaning 2 turini ayting. ",
                " Tayin qilingan va tayin qilinmagan vojib ro’za"
            ),
            Question(
                "Qaysi ro’za tayin qilingan vojib ro’za hisoblanadi?",
                "Muayyan nazr (tayin kun) ro’za  va Ramazon oyining hilolini ko’rib, shahodati qabul qilinmagan kishining ro’zasi. "
            ),
            Question(
                "Ushbu oyat qaysi suradan olingan:\n" +
                        "“…nazrlariga vafo qilsinlar”  \n",
                "Haj surasi, 29-oyat"
            ),
            Question(
                " Musulmon kishi qanday holatda ro’za tutishni o’ziga vojib qilib olgan bo’ladi? ",
                "Ro’za tutishni nazr qilganida"
            ),
            Question(
                "Tayin qilinmagan vojib ro’za necha turlidir? ",
                "9 turlidir  "
            ),
            Question(
                "Kimning ro’zasi nazr ro’za yoki mutlaq ro’za deyiladi? ",
                "Kunini tayin qilmasdan, bir kun ro’za tutishni nazr qilgan kishining ro’zasi.\n" +
                        "Masalan, “Falon ishim amalga oshsa, bir kun ro’za tutishni nazr qildim” deyilgani kabi.  \n"
            ),
            Question(
                "Muayyan kunda ro’za tutishni nazr qilib, tuta olmagan kishining qazo ro’zasi qanday ro’za hisoblanadi? ",
                "Tayin qilinmagan vojib ro’za  "
            ),
            Question(
                "Ro’za tutishga qasam ichib, zimmasiga ro’zani vojib qilib olgan kishining ro’zasi vojib ro’zaning qanday turiga kiradi? ",
                "Tayin qilinmagan vojib ro’za "
            ),
            Question(
                "Nafl ro’zani tutishni boshlab, oxiriga yetkazmay,ochib yuborgan kishining o’sha kuni uchun tutadigan  qazo ro’zasi qanday ro’za turiga kiradi?  ",
                "Tayin qilinmagan vojib ro’za"
            ),
            Question(
                "Zihor, qatl, Ramazonning ro’zasini qasddan ochib yuborish va qasamni buzganining kafforati uchun tutiladigan ro’zalar vojib ro’zaning qanday turiga kiradi?",
                "Vojib ro’zaning tayin qilinmagan turiga kiradi."
            ),
            Question(
                "Tamattu’ va qiron uchun ehromga kirib qurbonlik qila olmagan kishining 10 kunlik ro’zasi qanday ro’za turiga kiradi? ",
                "Vojib ro’zaning tayin qilinmagan turiga kiradi "
            ),
            Question(
                "Ehromdalik chog’ida, vaqti kirmasdan oldin soch oldirgan kishining kafforat uchun tutadigan 3 kunlik ro’zasi qanday ro’za hisoblanadi?",
                "Tayin qilinmagan vojib ro’za "
            ),
            Question(
                "Haramda ov qilishning jazosi uchun tutiladigan ro’za qanday ro’za hisoblanadi? ",
                "Tayin qilinmagan vojib ro’za "
            ),
            Question(
                "E’tikofini buzib qo’ygan kishining qazo ro’zasi qanday ro’za hisoblanadi?  ",
                "Tayin qilinmagan vojib ro’za"
            ),
            Question(
                "Xursandchilik kunlari bo’lganligi uchun ro’za tutish harom bo’lgan kunlar qaysi kunlar? ",
                "Iydul fitr kuni, Iydul azho kuni va undan keyingi 3 kun   "
            ),
            Question(
                "Abu Hurayra roziyallohu anhudan rivoyat qilinadi:\n" +
                        "“Nabiy sollallohu alayhi vasallam 2 kunning - … va  …\n" +
                        "kunining ro’zasidan qaytardilar”\n" +
                        "Buxoriy, Muslim, Abu Dovud, Termiziy va Nasoiy rivoyat qilishgan.\n" +
                        "Ushbu hadisga ko’ra,  Nabiy sollallohu alayhi vasallam qaysi 2 kunning ro’zasidan qaytarganligini toping.\n",
                "Azho va Fitr kunining ro’zasidan qaytarganlar "
            ),
            Question(
                "Uqba ibn Omir roziyallohu anhudan rivoyat qilingan hadisda Nabiiy sollalohu alayhi vasallam qaysi kunlarni “Bu kunlar bizning-ahli Islomning bayramimizdir. Bu kunlar yeb-ichish kunlaridir”, deya  aytganligini toping.\n" +
                        " “Sunan” egalari rivoyat qilishgan\n ",
                "Arafa kuni, qurbonlik kuni, tashriq kunlari"
            ),
            Question(
                "Ro’za tutish harom qilingan Ramazon kirishidan oldingi kun qanday kun?",
                "Shak kuni"
            ),
            Question(
                "Ro’za tutsa halok bo’lishini bilaturib ro’za tutish mumkinmi?",
                "Yo’q, bu harom hisoblanadi."
            ),
            Question(
                "Ro’za tutsa halok bo’lishini bilaturib ro’za tutish haromligini asoslovchi ushbu oyat qaysi suradan olingan:\n" +
                        "   “…(O’zingizni) o’z qo’lingiz bilan halokatga tashlamang…” \n",
                "Baqara surasi, 195-oyat"
            ),
            Question(
                "Ro’za tutish harom hisoblanib, faqat ayollarga xos bo’lgan kunlar qaysilar?",
                "Ayollarning hayz va nifos ko’rgan kunlari"
            ),
            Question(
                "Ayol kishining erining iznisiz yoki roziligini bilmay turib nafl ro’za tutishi mumkinmi?",
                "Yo’q bu makruh hisoblanadi."
            ),
            Question(
                "Ayol kishining erining iznisiz yoki roziligini bilmay turib nafl ro’za tutishi qanday holatlarda makruh bo’lmaydi?",
                "Agar er yaqinlikka ojizlik qiladigan darajada bemor bo’lsa, yoki ro’zador bo’lsa, yoxud haj yo umraga ehrom bog’lagan bo’lsa makruh bo’lmaydi."
            ),
            Question(
                "Ashuro kunining yolg’iz o’zida ro’za tutish mumkunmi?",
                "Yo’q, makruh hisoblanadi."
            ),
            Question(
                "Juma kunini xoslab, shanba kunini ulug’lab, yakshanba kunini ulug’lab, Navro’z kuni va Mehrjon kuni.\n" +
                        "Ushbu kunlarning qaysi birida ro’za tutsa bo’ladi? \n ",
                "Ushbu kunlarning hammasida ro’za tutish makruh hisoblanadi."
            ),
            Question(
                "Ushbu holatlarning qay birida ro’za tutish makruh hisoblanmaasligini toping:\n" +
                        "-Uzluksiz har kuni ro’za tutish; \n" +
                        "-Gapirmasdan ro’za tutish;\n" +
                        "-Ulab(saharlik qilmay) ro’za tutish;\n" +
                        "-Musofirning qiynalib ro’za tutishi.\n",
                "Ushbu holatlarning barchasida ro’za tutish makruh hisoblanadi."
            ),
            Question(
                "Hanafiy mazhabida ixtiyoriy ro’za nechta turga bo’linadi va ular qaysilar?",
                "3 turga bo’linadi: Sunnat, mandub, nafl. "
            ),
            Question(
                "Sunnat ro’za qaysi ixtiyoriy ro’zalar hisoblanadi?",
                "Rasululloh sollallohu alayhi vasallam doimiy tutib yurgan ixtiyoriy ro’zalar"
            ),
            Question(
                "Mandub yoki mustahab ro’zalar qaysi ixtiyoriy ro’zalardir?",
                "Rasululloh sollallohu alayhi vasallam doimiy tutmagan ixtiyoriy ro’zalar"
            ),
            Question(
                "Mandub yoki mustahab ro’zalar qaysilar?",
                "1.\tBir kun tutib, bir kun ochib yurish.\n" +
                        "2.\tHar oyda 3 kun ro’za tutish.\n" +
                        "3.\tHaftaning dushanba va payshanba kunlari ro’za tutish.\n" +
                        "4.\tShavvol oyida 6 kun ro’za tutish.\n" +
                        "5.\tArafa kuni ro’za tutish.\n" +
                        "6.\tArafadan oldingi 8 kunda ro’za tutish.\n" +
                        "7.\tSha’bon oyida ro’za tutish.\n"
            ),
            Question(
                "Qanday ro’zaga nafl ro’za deyiladi? ",
                " Dinimizda ularni ham tutish targ’ib qilingan, sunnat va mandub (yoki mustahab) ro’zalardan boshqa ixtiyoriy ro’zalar."
            ),
            Question(
                "“Niyat” so’zi lug’atda qanday ma’no anglatadi?",
                " “Qasd qilish” ma’nosini anglatadi."
            ),
            Question(
                "Tayin qilinmagan vojib ro’za necha turlidir? ",
                "9 turlidir  "
            ),
            Question(
                "Tayin qilinmagan vojib ro’za necha turlidir? ",
                "9 turlidir  "
            ),
            Question(
                "Tayin qilinmagan vojib ro’za necha turlidir? ",
                "9 turlidir  "
            ),
            Question(
                "Tayin qilinmagan vojib ro’za necha turlidir? ",
                "9 turlidir  "
            ),
            Question(
                "Tayin qilinmagan vojib ro’za necha turlidir? ",
                "9 turlidir  "
            )
        )
        return myList
    }

}