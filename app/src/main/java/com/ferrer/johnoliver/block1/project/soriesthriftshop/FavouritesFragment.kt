package com.ferrer.johnoliver.block1.project.soriesthriftshop
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.ferrer.johnoliver.block1.project.soriesthriftshop.FavouritesViewModel
import com.ferrer.johnoliver.block1.project.soriesthriftshop.R

class FavouritesFragment : Fragment() {

    private lateinit var listView: ListView
    private val favouritesViewModel: FavouritesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favourites, container, false)
        listView = view.findViewById(R.id.listView)
        setupFavouriteObserver()
        return view
    }

    private fun setupFavouriteObserver() {
        favouritesViewModel.items.observe(viewLifecycleOwner) { items ->
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, items)
            listView.adapter = adapter
        }
    }
}
