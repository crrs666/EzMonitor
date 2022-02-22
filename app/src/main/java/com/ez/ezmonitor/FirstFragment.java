package com.ez.ezmonitor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ez.ezmonitor.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    private List<Host> hostList = new ArrayList<>();

    protected RecyclerView hostListView;

    protected RecyclerView.LayoutManager hostListLayoutManager;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initHostList();
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);

        hostListView = binding.hostListView;

        hostListLayoutManager = new LinearLayoutManager(getActivity());
        hostListView.setLayoutManager(hostListLayoutManager);

        HostAdapter hostAdapter = new HostAdapter(hostList);
        hostListView.setAdapter(hostAdapter);

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

    private void initHostList() {
        Host host1 = new Host("host1", "1.1.1.1", 22, "root", "123");
        hostList.add(host1);
        Host host2 = new Host("host2", "1.1.1.2", 1234, "root", "123");
        hostList.add(host2);
    }
}