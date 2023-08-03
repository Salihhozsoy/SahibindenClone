package com.example.sahibinden

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.sahibinden.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    companion object {
        const val CATEGORY = "category"
    }

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: CategoryAdapter
    val categories = listOf(
        Category(
            1,
            "https://w7.pngwing.com/pngs/648/221/png-transparent-computer-icons-house-house-logo-angle-text-logo-thumbnail.png",
            "Emlak",
            "Konut, İşyeri, Arsa, Bina",
            "ÖZSOY GAYRİMENKUL'DEN DENİZ MANZARALI HAVUZLU 6 KİŞİLİK LUX VİLLA"
        ),
        Category(
            2,
            "https://w7.pngwing.com/pngs/903/411/png-transparent-car-motor-vehicle-steering-wheels-car-logo-car-vehicle.png",
            "Vasıta",
            "Otomobil, Arazi, SUV, Motor",
            "ÖZSOY GAYRİMENKUL'DEN DENİZ MANZARALI HAVUZLU 6 KİŞİLİK LUX VİLLA"
        ),
        Category(
            3,
            "https://e7.pngegg.com/pngimages/98/733/png-clipart-technical-support-computer-icons-scalable-graphics-customer-service-repairing-tools-logo-monochrome.png",
            "Yedek Parça,Aksesuar,Donanım",
            "Otomotiv Ekipmanlar",
            "ÖZSOY GAYRİMENKUL'DEN DENİZ MANZARALI HAVUZLU 6 KİŞİLİK LUX VİLLA"
        ),
        Category(
            4,
            "https://e7.pngegg.com/pngimages/932/934/png-clipart-shopping-cart-supermarket-trolley-angle-rectangle-thumbnail.png",
            "İkinci El ve Sıfır Alışveriş",
            "Bilgisayar Cep Telefonu",
            "ÖZSOY GAYRİMENKUL'DEN DENİZ MANZARALI HAVUZLU 6 KİŞİLİK LUX VİLLA"
        ),
        Category(
            5,
            "https://static.vecteezy.com/system/resources/previews/007/634/453/original/tractor-logo-icon-design-free-vector.jpg",
            "İş Makineleri ve Sanayi",
            "İş Makineleri, Tarım Makineleri",
            "ÖZSOY GAYRİMENKUL'DEN DENİZ MANZARALI HAVUZLU 6 KİŞİLİK LUX VİLLA"
        ),
        Category(
            6,
            "https://w7.pngwing.com/pngs/352/690/png-transparent-paintbrush-paintbrush-computer-icons-painting-paint-logo-silhouette-painting.png",
            "Ustalar ve Hizmetler",
            "Elektrik, Doğalgaz, Su Tamir Tadilat",
            "ÖZSOY GAYRİMENKUL'DEN DENİZ MANZARALI HAVUZLU 6 KİŞİLİK LUX VİLLA"
        ),
        Category(
            7,
            "https://e7.pngegg.com/pngimages/382/847/png-clipart-logo-brand-line-book-top-view-angle-white.png",
            "Özel Ders Verenler",
            "Lise, Üniversite, İlkokul Özel Ders",
            "ÖZSOY GAYRİMENKUL'DEN DENİZ MANZARALI HAVUZLU 6 KİŞİLİK LUX VİLLA"
        ),
        Category(
            8,
            "https://png.pngtree.com/png-vector/20190909/ourmid/pngtree-outline-user-icon-png-image_1727916.jpg",
            "İş İlanları",
            "Avukatlık, Danışmanlık",
            "ÖZSOY GAYRİMENKUL'DEN DENİZ MANZARALI HAVUZLU 6 KİŞİLİK LUX VİLLA"
        ),
        Category(
            8,
            "https://w7.pngwing.com/pngs/612/782/png-transparent-marktplaats-nl-sales-children-s-clothing-stroller.png",
            "Yardımcı Arayanlar",
            "Bebek, Çocuk Bakıcısı",
            "ÖZSOY GAYRİMENKUL'DEN DENİZ MANZARALI HAVUZLU 6 KİŞİLİK LUX VİLLA"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CategoryAdapter(this, categories) { category, position ->

            val intent = Intent(this, AdvertActivity::class.java)
            intent.putExtra(CATEGORY, category)
            startActivity(intent)
        }
        binding.rvCategories.adapter = adapter

        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                println("beforeTextChanged: $p0")
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (!s.isNullOrEmpty()) {
                    val filteredList = categories.filter {
                        it.categoryName.contains(
                            s.toString(),
                            ignoreCase = true
                        )
                    }
                    adapter.updateList(filteredList)
                } else {
                    adapter.updateList(categories)
                }
                adapter.notifyDataSetChanged()
            }

            override fun afterTextChanged(p0: Editable?) {
                println("afterTextChanged: $p0")
            }
        })
    }
}