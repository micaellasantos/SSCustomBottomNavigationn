package com.sscustombottomnavigation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.sscustombottomnavigation.R

class TourFragment : Fragment(R.layout.fragment_tour) {

    private lateinit var floatingContainer: View
    private lateinit var floatingImageView: ImageView
    private lateinit var floatingTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tour, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the floating container and its views
        floatingContainer = view.findViewById(R.id.floatingContainer)
        floatingImageView = view.findViewById(R.id.floatingImageView)
        floatingTextView = view.findViewById(R.id.floatingTextView)

        // Set up the GridLayout containing the image tiles
        val imageGrid = view.findViewById<GridLayout>(R.id.imageGrid)

        // Image details for the grid
        val imageDetails = listOf(
            "Image 1: Daddy's Home", "Image 2: Daddy's Home", "Image 3: Daddy's Home",
            "Image 4: Daddy's Home", "Image 5: lkdlksjdklasjdlas", "Image 6: Daddy's Home",
            "Image 7: Daddy's Home", "Image 8: Daddy's Home", "Image 9: Daddy's Home",
            "Image 10: Daddy's Home", "Image 11: Daddy's Home"
        )

        // IDs of image views in the grid
        val imageIds = listOf(
            R.id.imageView2, R.id.imageView3, R.id.imageView4,
            R.id.imageView5, R.id.imageView6, R.id.imageView7,
            R.id.imageView8, R.id.imageView9, R.id.imageView10,
            R.id.imageView11
        )

        // Set click listeners for each image tile
        for ((index, imageId) in imageIds.withIndex()) {
            val imageView = view.findViewById<ImageView>(imageId)
            imageView.setOnClickListener {
                Log.d("TourFragment", "Image clicked: ${imageDetails[index]}") // Debug log
                showFloatingImage(imageView, imageDetails[index])
            }
        }

        // Close the floating image view when the container is clicked
        view.findViewById<ImageView>(R.id.closeFloating).setOnClickListener {
            hideFloatingImage()
        }
    }

    private fun showFloatingImage(imageView: ImageView, description: String) {
        // Display the selected image in the floating container
        floatingImageView.setImageDrawable(imageView.drawable)
        floatingTextView.text = description // Set the image description
        floatingContainer.visibility = View.VISIBLE
        Log.d("TourFragment", "Showing floating image with description: $description") // Debug log
    }

    private fun hideFloatingImage() {
        // Hide the floating container
        floatingContainer.visibility = View.GONE
    }
}
