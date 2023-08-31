package com.example.viewbindingdelegat.tab_layout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.viewbindingdelegat.R
import com.example.viewbindingdelegat.databinding.FragmentSignInBinding


class SignInFragment : Fragment(R.layout.fragment_sign_in) {
    val binding by viewBinding(FragmentSignInBinding::bind)
}