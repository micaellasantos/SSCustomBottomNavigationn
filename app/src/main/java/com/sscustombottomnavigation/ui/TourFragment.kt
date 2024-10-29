package com.sscustombottomnavigation.ui

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.sscustombottomnavigation.R

class TourFragment : Fragment(R.layout.fragment_tour) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tour, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // List of image views for grid items
        val imageViews = listOf(
            view.findViewById<ImageView>(R.id.imageView2),
            view.findViewById<ImageView>(R.id.imageView3),
            view.findViewById<ImageView>(R.id.imageView4),
            view.findViewById<ImageView>(R.id.imageView5),
            view.findViewById<ImageView>(R.id.imageView6),
            view.findViewById<ImageView>(R.id.imageView7),
            view.findViewById<ImageView>(R.id.imageView8),
            view.findViewById<ImageView>(R.id.imageView9),
            view.findViewById<ImageView>(R.id.imageView10),
            view.findViewById<ImageView>(R.id.imageView11)
        )

        // Set click listeners to each image view for zoom-in effect
        for (imageView in imageViews) {
            imageView.setOnClickListener {
                zoomImage(imageView)
            }
        }
    }

    private fun zoomImage(imageView: ImageView) {
        // Scale up animation
        ObjectAnimator.ofFloat(imageView, "scaleX", 1.2f).apply {
            duration = 200
            start()
        }
        ObjectAnimator.ofFloat(imageView, "scaleY", 1.2f).apply {
            duration = 200
            start()
        }

        // Scale down animation with delay
        imageView.postDelayed({
            ObjectAnimator.ofFloat(imageView, "scaleX", 1f).apply {
                duration = 200
                start()
            }
            ObjectAnimator.ofFloat(imageView, "scaleY", 1f).apply {
                duration = 200
                start()
            }
        }, 200)
    }
}
