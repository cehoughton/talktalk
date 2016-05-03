package com.epicodus.talktalk.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.talktalk.R;
import com.epicodus.talktalk.models.Message;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MessageDetailFragment extends Fragment {
    @Bind(R.id.messageText)
    TextView mMessageText;

    private Message mMessage;

    public MessageDetailFragment newInstance(Message message) {
        MessageDetailFragment messageDetailFragment = new MessageDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("message", Parcels.wrap(message));
        messageDetailFragment.setArguments(args);
        return messageDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
        mMessage = Parcels.unwrap(getArguments().getParcelable("message"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message_detail, container, false);
        ButterKnife.bind(this, view);
        mMessageText.setText(mMessage.getContent());
        return view;
    }

}
