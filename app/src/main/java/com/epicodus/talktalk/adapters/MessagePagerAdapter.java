package com.epicodus.talktalk.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.epicodus.talktalk.models.Message;
import com.epicodus.talktalk.ui.MessageDetailFragment;

import java.util.ArrayList;

public class MessagePagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Message> mMessages;

    public MessagePagerAdapter(FragmentManager fm, ArrayList<Message> messages) {
        super(fm);
        mMessages = messages;
    }

    @Override
    public Fragment getItem(int position) {
        return MessageDetailFragment.newInstance(mMessages.get(position));
    }

    @Override
    public int getCount() {
        return mMessages.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mMessages.get(position).getContent();
    }
}
