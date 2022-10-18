package br.com.fiap.marvelapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.marvelapp.data.MarvelCharacterDataResultModel
import br.com.fiap.marvelapp.databinding.ViewCharacterItemBinding

class CharacterListAdapter : RecyclerView.Adapter<CharacterListAdapter.CharacterItemViewHolder>() {

    inner class CharacterItemViewHolder(
        private val view: ViewCharacterItemBinding
    ): RecyclerView.ViewHolder(view.root) {

        fun bindView(character: MarvelCharacterDataResultModel) {
            view.characterNameValue.text = character.name
        }
    }

    private val characterList: MutableList<MarvelCharacterDataResultModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterItemViewHolder {
        val binding = ViewCharacterItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_character_item,
                parent,
                false
            )
        )
        return CharacterItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterItemViewHolder, position: Int) {
        holder.bindView(characterList[position])
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    fun setData(list: List<MarvelCharacterDataResultModel>) {
        characterList.clear()
        characterList.addAll(list)
        notifyDataSetChanged()
    }

}