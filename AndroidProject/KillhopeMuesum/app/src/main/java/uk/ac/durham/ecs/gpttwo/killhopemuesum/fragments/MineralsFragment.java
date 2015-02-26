package uk.ac.durham.ecs.gpttwo.killhopemuesum.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import uk.ac.durham.ecs.gpttwo.killhopemuesum.MineralActivity;
import uk.ac.durham.ecs.gpttwo.killhopemuesum.MineralsAdapter;
import uk.ac.durham.ecs.gpttwo.killhopemuesum.R;


public class MineralsFragment extends Fragment implements AdapterView.OnItemClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_minerals, container, false);

        GridView gridView = (GridView) rootView.findViewById(R.id.minerals_gridview);

        gridView.setOnItemClickListener(this);

        MineralsAdapter adapter = new MineralsAdapter(getActivity());

        gridView.setAdapter(adapter);


        return rootView;
    }

    public static MineralsFragment newInstance(){
        return new MineralsFragment();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), MineralActivity.class);
        startActivity(intent);
    }
}
