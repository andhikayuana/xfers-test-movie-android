package id.yuana.movieapp.xfers.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import id.yuana.movieapp.xfers.R
import java.util.concurrent.TimeUnit

/**
 * @author andhikayuana
 */
class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            context?.let {
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            }
        }, TimeUnit.SECONDS.toMillis(2))
    }
}