package br.com.renner.app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.renner.app.R
import br.com.renner.app.data.Mock
import br.com.renner.app.databinding.FragmentHomeBinding
import br.com.renner.app.ui.product.ProductActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!



    private val categoryAdapter by lazy {
        CategoryAdapter {
            Toast.makeText(requireContext(), "Funciona", Toast.LENGTH_SHORT).show()
        }
    }

    private val productAdapter by lazy {
        ProductAdapter {
            val actions = HomeFragmentDirections.actionNavigationHomeToProductActivity(it)
            findNavController().navigate(actions)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvCategory.adapter = categoryAdapter
        categoryAdapter.submitList(Mock.categories)

        binding.rvProducts.adapter = productAdapter
        productAdapter.submitList(Mock.products)

        binding.carouselHoliday.setData(Mock.carrouselSlide1)
        binding.carouselHoliday.autoPlay = true

        binding.carouselAlameda.setData(Mock.carrouselSlide2)
        binding.carouselAlameda.autoPlay = true

        binding.carouselTrending.setData(Mock.carrouselSlide3)
        binding.carouselTrending.autoPlay = true

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}