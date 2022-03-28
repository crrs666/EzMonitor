package com.ez.ezmonitor;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ez.ezmonitor.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private HostListViewModel hostListViewModel;

    protected RecyclerView hostListView;

    protected RecyclerView.LayoutManager hostListLayoutManager;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(this.getClass().getName(),"main fragment onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        Log.d(this.getClass().getName(),"main fragment onCreateView");
        binding = FragmentFirstBinding.inflate(inflater, container, false);

        hostListView = binding.hostListView;

        hostListLayoutManager = new LinearLayoutManager(getActivity());
        hostListView.setLayoutManager(hostListLayoutManager);

        HostAdapter hostAdapter = new HostAdapter(new HostAdapter.HostDiff());
        hostListView.setAdapter(hostAdapter);

        hostListViewModel = new ViewModelProvider(this).get(HostListViewModel.class);
        hostListViewModel.getAllHosts().observe(getViewLifecycleOwner(), hostAdapter::submitList);

        return binding.getRoot();

    }

//    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
//            }
//        });
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}