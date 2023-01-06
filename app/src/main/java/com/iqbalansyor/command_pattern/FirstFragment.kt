package com.iqbalansyor.command_pattern

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iqbalansyor.command_pattern.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    /// state: 1
//    private val stateText = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /// state: 2
//        binding.btSmile.setOnClickListener {
//            binding.textView.text = binding.textView.text.toString() + emojiSmile
//            stateText.push(binding.textView.text.toString())
//        }
//        binding.btThumb.setOnClickListener {
//            binding.textView.text = binding.textView.text.toString() + emojiThumb
//            stateText.push(binding.textView.text.toString())
//        }
//        binding.btUndo.setOnClickListener {
//            val text = stateText.pop()
//            binding.textView.text = text
//        }

        /// command: 4
        binding.btSmile.setOnClickListener {
            EmojinCommandInvoker.command(SmileEmojiCommand(binding.textView))
        }
        binding.btThumb.setOnClickListener {
            EmojinCommandInvoker.command(ThumbEmojiCommand(binding.textView))
        }
        binding.btLook.setOnClickListener {
            EmojinCommandInvoker.command(LookEmojiCommand(binding.textView))
        }
        binding.btFamily.setOnClickListener {
            EmojinCommandInvoker.command(FamilyEmojiCommand(binding.textView))
        }
//
        binding.btUndo.setOnClickListener {
            EmojinCommandInvoker.undo()
        }
        binding.btRedo.setOnClickListener {
            EmojinCommandInvoker.redo()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}

/**
 * client => FirstFragment
 * invoker => EmojiCommandInvoker
 * command => EmojiCommand
 * command concrete => SmileEmojiCommand
 * receiver => textView
 */