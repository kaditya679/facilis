package com.prembros.facilis.listofcards

import android.os.Bundle
import android.view.*
import com.prembros.facilis.fragment.BaseCardListChildFragment
import com.prembros.facilis.sample.R
import com.prembros.facilis.util.dynamicHeightTarget
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_list_of_cards_child.*

class ListOfCardsChildFragment : BaseCardListChildFragment() {

    private lateinit var imageUrl: String

    companion object {
        private const val IMAGE = "image"
        fun newInstance(imageUrl: String) = ListOfCardsChildFragment().apply { arguments = Bundle().apply { putString(IMAGE, imageUrl) } }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.run { imageUrl = getString(IMAGE)!! }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_list_of_cards_child, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.get().load(imageUrl).into(thumbnail.dynamicHeightTarget(activity))
    }

    /**
     * Return the Drag area that should be used for swipe gestures, return null for no drag gesture implementations
     */
    override fun getDragView(): View? = dragArea

    /**
     * Return the root view (preferably a CardView) of the fragment
     */
    override fun getRootView(): ViewGroup? = rootCard

    /**
     * Return the Drag handle resource ID to toggle visibility during transition
     */
    override fun dragHandleId(): Int = R.id.drag_handle_image
}