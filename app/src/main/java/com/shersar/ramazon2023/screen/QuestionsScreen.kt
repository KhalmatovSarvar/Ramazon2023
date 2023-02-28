package com.shersar.ramazon2023.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.adapter.QuestionsAdapter
import com.shersar.ramazon2023.databinding.FragmentQuestionsScreenBinding
import com.shersar.ramazon2023.model.Question
import viewBinding


class QuestionsScreen : Fragment(R.layout.fragment_questions_screen) {
    private val binding by viewBinding {
        FragmentQuestionsScreenBinding.bind(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvQuestions.layoutManager = LinearLayoutManager(requireContext())
        binding.rvQuestions.adapter = QuestionsAdapter(getUserList())
    }

    private fun getUserList(): MutableList<Question> {
        val myList = mutableListOf(
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Eget viverra nec tristique lacinia mauris non non ultrices erat. Ornare ultrices egestas pulvinar nulla. In aliquam sed sit tristique nunc. Duis euismod sed imperdiet suscipit. Morbi dolor vel tellus id quam enim vel. In fringilla nibh hendrerit sit proin sed. Nec amet dictumst sem sapien nulla leo arcu sit. Aenean ullamcorper adipiscing nam eget eleifend congue. Aenean non donec amet amet magna. Massa massa platea non eleifend a vel facilisis ut.\n" +
                    "A nibh convallis pellentesque elit odio quam at. Praesent sed malesuada eget scelerisque lectus elementum. Non dui gravida faucibus convallis aliquam nunc id. Ornare ac est at nunc malesuada a ullamcorper urna. Vitae rutrum ultricies a mattis gravida. Sed et quis dolor amet convallis. Lorem ipsum dolor sit amet consectetur. Eget viverra nec tristique lacinia mauris non non ultrices erat. Ornare ultrices egestas pulvinar nulla. In aliquam sed sit tristique nunc. Duis euismod sed imperdiet suscipit. Morbi dolor vel tellus id quam enim vel. In fringilla nibh hendrerit sit proin sed. Nec amet dictumst sem sapien nulla leo arcu sit. Aenean ullamcorper adipiscing nam eget eleifend congue. Aenean non donec amet amet magna. Massa massa platea non eleifend a vel facilisis ut.\n" +
                    "A nibh convallis pellentesque elit odio quam at. Praesent sed malesuada eget scelerisque lectus elementum. Non dui gravida faucibus convallis aliquam nunc id. Ornare ac est at nunc malesuada a ullamcorper urna. Vitae rutrum ultricies a mattis gravida. Sed et quis dolor amet convallis.Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Eget viverra nec tristique lacinia mauris non non ultrices erat. Ornare ultrices egestas pulvinar nulla. In aliquam sed sit tristique nunc. Duis euismod sed imperdiet suscipit. Morbi dolor vel tellus id quam enim vel. In fringilla nibh hendrerit sit proin sed. Nec amet dictumst sem sapien nulla leo arcu sit. Aenean ullamcorper adipiscing nam eget eleifend congue. Aenean non donec amet amet magna. Massa massa platea non eleifend a vel facilisis ut.\n" +
                    "A nibh convallis pellentesque elit odio quam at. Praesent sed malesuada eget scelerisque lectus elementum. Non dui gravida faucibus convallis aliquam nunc id. Ornare ac est at nunc malesuada a ullamcorper urna. Vitae rutrum ultricies a mattis gravida. Sed et quis dolor amet convallis. Lorem ipsum dolor sit amet consectetur. Eget viverra nec tristique lacinia mauris non non ultrices erat. Ornare ultrices egestas pulvinar nulla. In aliquam sed sit tristique nunc. Duis euismod sed imperdiet suscipit. Morbi dolor vel tellus id quam enim vel. In fringilla nibh hendrerit sit proin sed. Nec amet dictumst sem sapien nulla leo arcu sit. Aenean ullamcorper adipiscing nam eget eleifend congue. Aenean non donec amet amet magna. Massa massa platea non eleifend a vel facilisis ut.\n" +
                    "A nibh convallis pellentesque elit odio quam at. Praesent sed malesuada eget scelerisque lectus elementum. Non dui gravida faucibus convallis aliquam nunc id. Ornare ac est at nunc malesuada a ullamcorper urna. Vitae rutrum ultricies a mattis gravida. Sed et quis dolor amet convallis.Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Eget viverra nec tristique lacinia mauris non non ultrices erat. Ornare ultrices egestas pulvinar nulla. In aliquam sed sit tristique nunc. Duis euismod sed imperdiet suscipit. Morbi dolor vel tellus id quam enim vel. In fringilla nibh hendrerit sit proin sed. Nec amet dictumst sem sapien nulla leo arcu sit. Aenean ullamcorper adipiscing nam eget eleifend congue. Aenean non donec amet amet magna. Massa massa platea non eleifend a vel facilisis ut.\n" +
                    "A nibh convallis pellentesque elit odio quam at. Praesent sed malesuada eget scelerisque lectus elementum. Non dui gravida faucibus convallis aliquam nunc id. Ornare ac est at nunc malesuada a ullamcorper urna. Vitae rutrum ultricies a mattis gravida. Sed et quis dolor amet convallis. Lorem ipsum dolor sit amet consectetur. Eget viverra nec tristique lacinia mauris non non ultrices erat. Ornare ultrices egestas pulvinar nulla. In aliquam sed sit tristique nunc. Duis euismod sed imperdiet suscipit. Morbi dolor vel tellus id quam enim vel. In fringilla nibh hendrerit sit proin sed. Nec amet dictumst sem sapien nulla leo arcu sit. Aenean ullamcorper adipiscing nam eget eleifend congue. Aenean non donec amet amet magna. Massa massa platea non eleifend a vel facilisis ut.\n" +
                    "A nibh convallis pellentesque elit odio quam at. Praesent sed malesuada eget scelerisque lectus elementum. Non dui gravida faucibus convallis aliquam nunc id. Ornare ac est at nunc malesuada a ullamcorper urna. Vitae rutrum ultricies a mattis gravida. Sed et quis dolor amet convallis.Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a."),
            Question("Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.","Lorem ipsum dolor sit amet consectetur. Sit nisi non diam ultrices a.")
        )
  return  myList
    }

}