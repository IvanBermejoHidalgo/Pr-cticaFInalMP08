package com.example.roomtemplate;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.example.roomtemplate.databinding.FragmentMostrarCancionesBinding;

public class MostrarCancionesFragment extends Fragment {

    private FragmentMostrarCancionesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentMostrarCancionesBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CancionesViewModel cancionesViewModel = new ViewModelProvider(requireActivity()).get(CancionesViewModel.class);

        cancionesViewModel.seleccionado().observe(getViewLifecycleOwner(), new Observer<Canciones>() {
            @Override
            public void onChanged(Canciones canciones) {
                binding.nombre2.setText(canciones.nombrecancion);
                binding.descripcion2.setText(canciones.nombreartista);

            }
        });
    }
}