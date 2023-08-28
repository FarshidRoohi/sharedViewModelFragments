package io.github.farshidroohi.shareviewmodelfragments.parent.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import io.github.farshidroohi.shareviewmodelfragments.fragments.FirstChildFragment
import io.github.farshidroohi.shareviewmodelfragments.fragments.SecondChildFragment
import io.github.farshidroohi.shareviewmodelfragments.fragments.ThirdChildFragment

class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private var fragments = mutableListOf<Fragment>()

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = when (position) {
            0 -> FirstChildFragment.newInstance()
            1 -> SecondChildFragment.newInstance()
            2 -> ThirdChildFragment.newInstance()
            else -> FirstChildFragment.newInstance()
        }
        fragments.add(fragment)
        return fragment
    }
}