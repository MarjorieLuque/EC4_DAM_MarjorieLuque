package com.example.dam_uc4_luque;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dam_uc4_luque.databinding.FragmentItemBinding;

import java.util.List;

public class MyNotaRecyclerViewAdapter extends RecyclerView.Adapter<MyNotaRecyclerViewAdapter.ViewHolder> {

    private final List<Nota> mValues;
    private final NotasInteractionListener mListener;

    public MyNotaRecyclerViewAdapter(List<Nota> notaList, NotasInteractionListener mListener) {
        this.mValues = notaList;
        this.mListener = mListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FragmentItemBinding binding = FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.tvTitulo.setText(holder.mItem.getTitulo());
        holder.tvContenido.setText(holder.mItem.getContenido());

        if (holder.mItem.isFavorita()) {
            holder.ivFavorita.setImageResource(R.drawable.baseline_star_border_24);
        } else {
            holder.ivFavorita.setImageResource(R.drawable.baseline_star_border_24); // Cambia esto si tienes una imagen diferente para "no favorita"
        }

        holder.ivFavorita.setOnClickListener(v -> {
            if (null != mListener) {
                mListener.favoritaNotaClick(holder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvTitulo;
        public final TextView tvContenido;
        public final ImageView ivFavorita;
        public Nota mItem;

        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            tvTitulo = binding.textViewTitulo;
            tvContenido = binding.textViewContenido;
            ivFavorita = binding.imageViewFavorita;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvTitulo.getText() + "'";
        }
    }
}
