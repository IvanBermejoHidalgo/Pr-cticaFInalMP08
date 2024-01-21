package com.example.roomtemplate;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.roomtemplate.databinding.FragmentNuevoCancionesBinding;

public class NuevoCancionesFragment extends Fragment {

    private FragmentNuevoCancionesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentNuevoCancionesBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CancionesViewModel cancionesViewModel = new ViewModelProvider(requireActivity()).get(CancionesViewModel.class);
        NavController navController = Navigation.findNavController(view);

        binding.crear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombrecancion = binding.nombrecancion2.getText().toString();
                String nombreartista = binding.nombreartista2.getText().toString();

                cancionesViewModel.insertar(new Canciones(nombrecancion, nombreartista));

                navController.popBackStack();
            }
        });
    }
}