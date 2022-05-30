package br.com.renner.app.ui.product

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs
import br.com.renner.app.data.Product
import br.com.renner.app.databinding.ActivityProductBinding
import com.bumptech.glide.Glide

class ProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductBinding

    private val args: ProductActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = args.product.name


        initView(args.product)
    }

    private fun initView(product: Product) = with(binding.viewProduct) {
        Glide.with(applicationContext)
            .load(product.imgUrl)
            .into(img)

        txtRef.text = "REF: ${product.id}"
        txtName.text = product.name
        txtDetails.text = product.description
        txtPrice.text = "R$ ${product.price}"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}